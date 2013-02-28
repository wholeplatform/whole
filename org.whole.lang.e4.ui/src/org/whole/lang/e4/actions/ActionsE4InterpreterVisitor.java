/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.e4.actions;

import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.actions.model.Action;
import org.whole.lang.actions.model.ActionKindEnum;
import org.whole.lang.actions.model.ActionKindEnum.Value;
import org.whole.lang.actions.model.Actions;
import org.whole.lang.actions.model.FillStrategy;
import org.whole.lang.actions.model.GroupAction;
import org.whole.lang.actions.model.Hierarchical;
import org.whole.lang.actions.model.SubgroupAction;
import org.whole.lang.actions.visitors.ActionsUIInterpreterVisitor;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.IUpdatableAction;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.ui.actions.ActionsComparator;
import org.whole.lang.ui.actions.IEnablerPredicate;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.menu.ActionSet;
import org.whole.lang.ui.menu.E3FlatFillMenuStrategy;
import org.whole.lang.ui.menu.FlatFillMenuStrategy;
import org.whole.lang.ui.menu.FullMenuNameStrategy;
import org.whole.lang.ui.menu.HierarchicalFillMenuStrategy;
import org.whole.lang.ui.menu.IFillMenuStrategy;
import org.whole.lang.ui.menu.IItemContainer;
import org.whole.lang.ui.menu.IMenuNameStrategy;
import org.whole.lang.ui.menu.PrefixMenuNameStrategy;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IEntityTransformer;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings({"restriction", "unchecked"})
public class ActionsE4InterpreterVisitor extends ActionsUIInterpreterVisitor {

	@Override
	public void visit(Actions entity) {
		if (getBindings().wIsSet("selectionProvider")) {
			super.visit(entity);
			return;
		}

		IItemContainer<IAction, ImageDescriptor> container = (IItemContainer<IAction, ImageDescriptor>) 
				getBindings().wGetValue("itemContainer");
		IFillMenuStrategy strategy = (IFillMenuStrategy)
				getBindings().wGetValue("fillMenuStrategy");

		int size=entity.wSize();
		List<IAction> contributions = new ArrayList<IAction>();

		for (int i=0; i < size; i++) {
			Action action = (Action) entity.wGet(i);
			if (Matcher.isAssignableAsIsFrom(GroupAction, action)) {

				//FIXME, add a boolean modifier to GroupAction and SubGroupAction
				if (strategy instanceof HierarchicalFillMenuStrategy)
					Collections.sort(contributions, ActionsComparator.instance());

				IAction[] actions = contributions.toArray(new IAction[contributions.size()]);
				strategy.fillMenu(container, ActionSet.create(actions), 0, actions.length);
				contributions.clear();
			}

			action.accept(this);

			IEntity result = getResult();
			if (result == null)
				continue;

			IUpdatableAction updatableAction = (IUpdatableAction) result.wGetValue();
			updatableAction.update();

			if (updatableAction.isEnabled())
				contributions.add(updatableAction);
		}

		//FIXME, add a sort boolean feature to GroupAction and SubGroupAction
		if (strategy instanceof HierarchicalFillMenuStrategy)
			Collections.sort(contributions, ActionsComparator.instance());

		IAction[] actions = contributions.toArray(new IAction[contributions.size()]);
		strategy.fillMenu(container, ActionSet.create(actions), 0, actions.length);
	}

	@Override
	public void visit(GroupAction entity) {
		if (getBindings().wIsSet("selectionProvider")) {
			super.visit(entity);
			return;
		}

		IItemContainer<IAction, ImageDescriptor> container = (IItemContainer<IAction, ImageDescriptor>) 
				getBindings().wGetValue("itemContainer");
		
		entity.getText().accept(this);
		String groupName = getResult().wStringValue();

		IFillMenuStrategy strategy;
		FillStrategy fillStrategy = entity.getFillStrategy();
		if (Matcher.match(Hierarchical, fillStrategy))
			strategy = createFillMenuStrategy((Hierarchical) fillStrategy, groupName);
		else
			strategy = FlatFillMenuStrategy.instance(groupName);

		if (EntityUtils.hasParent(entity) && 
				Matcher.match(SeparatedAction, entity.wGetParent()))
			container.addSeparator(groupName, false);
		else
			container.addGroupMarker(groupName, false);
				
		getBindings().wEnterScope();
		getBindings().wDefValue("fillMenuStrategy", strategy);

		entity.getActions().accept(this);

		getBindings().wExitScope();

		setResult(null);
	}

	@Override
	public void visit(SubgroupAction entity) {
		if (getBindings().wIsSet("selectionProvider")) {
			super.visit(entity);
			return;
		}

		IMenuManager menuManager = (IMenuManager) 
				getBindings().wGetValue("menuManager");

		entity.getText().accept(this);
		String groupName = getResult().wStringValue();
		
		IFillMenuStrategy strategy;
		FillStrategy fillStrategy = entity.getFillStrategy();
		if (Matcher.match(Hierarchical, fillStrategy))
			strategy = createFillMenuStrategy((Hierarchical) fillStrategy);
		else
			strategy = E3FlatFillMenuStrategy.instance();

		IMenuManager subMenuManager = new MenuManager(groupName);
		menuManager.add(subMenuManager);

		getBindings().wEnterScope();
		getBindings().wDefValue("menuManager", subMenuManager);
		getBindings().wDefValue("fillMenuStrategy", strategy);

		entity.getActions().accept(this);
		
		getBindings().wExitScope();

		setResult(null);
	}

	private static class OpaqueEnablerPredicate implements IEnablerPredicate {
		private final IEntity value;
		public OpaqueEnablerPredicate(IEntity value) {
			this.value = value;
		}

		@Override
		public boolean evaluate(IEntityPart selectedPart, Object userdata) {
			throw new UnsupportedOperationException("cannot evaluate expression");
		}
	}
	@Override
	public IEnablerPredicate createEnablerPredicate(IEntity predicate) {
		if (getBindings().wIsSet("selectionProvider"))
			return super.createEnablerPredicate(predicate);

		return new OpaqueEnablerPredicate(predicate);
	}

	@Override
	protected IAction createAction(Value kind,
			IEnablerPredicate enablerPredicate, IEntityTransformer transformer,
			IEntity prototype, String text) {
		if (getBindings().wIsSet("selectionProvider"))
			return super.createAction(kind, enablerPredicate, transformer, prototype, text);

		//FIXME transformer always passed as null
		IEclipseContext context = (IEclipseContext) getBindings().wGetValue("context");
		ActionRegistry actionRegistry = new ActionRegistry(context);

		IEntity predicate = enablerPredicate instanceof OpaqueEnablerPredicate ?
				((OpaqueEnablerPredicate) enablerPredicate).value :
					QueriesEntityFactory.instance.createBooleanLiteral(true);

		switch (kind.getOrdinal()) {
		case ActionKindEnum.REPLACE_ord:
			return actionRegistry.createReplaceFragmentAction(text, prototype, predicate);

		case ActionKindEnum.INSERT_ord:
			return actionRegistry.createAddFragmentAction(text, prototype, predicate);

		case ActionKindEnum.WRAP_ord:
			return actionRegistry.createWrapFragmentAction(text, prototype, predicate);

		case ActionKindEnum.PERFORM_ord:
		default:
			throw new IllegalArgumentException("not implemented yet");
		}
	}

	private IFillMenuStrategy createFillMenuStrategy(Hierarchical hierarchicalStrategy) {
		return createFillMenuStrategy(hierarchicalStrategy, null);
	}
	private IFillMenuStrategy createFillMenuStrategy(Hierarchical hierarchicalStrategy, String groupName) {
		IMenuNameStrategy nameStrategy = Matcher.match(DistinctPrefix,
				hierarchicalStrategy.getNamingStrategy()) ? 
						PrefixMenuNameStrategy.instance() : FullMenuNameStrategy.instance();

						hierarchicalStrategy.getSplitSize().accept(this);
						int splitSize = getResult().wIntValue();

						return new HierarchicalFillMenuStrategy(nameStrategy, splitSize, groupName);
	}
}
