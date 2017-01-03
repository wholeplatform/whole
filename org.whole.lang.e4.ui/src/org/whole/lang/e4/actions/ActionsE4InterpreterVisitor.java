/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.actions.model.Action;
import org.whole.lang.actions.model.ActionKindEnum;
import org.whole.lang.actions.model.ActionKindEnum.Value;
import org.whole.lang.actions.model.ActionKind;
import org.whole.lang.actions.model.Actions;
import org.whole.lang.actions.model.CustomAction;
import org.whole.lang.actions.model.FillStrategy;
import org.whole.lang.actions.model.GroupAction;
import org.whole.lang.actions.model.Hierarchical;
import org.whole.lang.actions.model.Icon;
import org.whole.lang.actions.model.PerformAction;
import org.whole.lang.actions.model.Predicate;
import org.whole.lang.actions.model.SeparatedAction;
import org.whole.lang.actions.model.Size;
import org.whole.lang.actions.model.SubgroupAction;
import org.whole.lang.actions.model.TemplateAction;
import org.whole.lang.actions.model.Text;
import org.whole.lang.actions.visitors.ActionsInterpreterVisitor;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.e4.ui.actions.ActionFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.ui.actions.ActionsComparator;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.actions.IUpdatableAction;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.enablerpredicate.IEnablerPredicate;
import org.whole.lang.ui.menu.ActionSet;
import org.whole.lang.ui.menu.FlatFillMenuStrategy;
import org.whole.lang.ui.menu.FullMenuNameStrategy;
import org.whole.lang.ui.menu.HierarchicalFillMenuStrategy;
import org.whole.lang.ui.menu.IFillMenuStrategy;
import org.whole.lang.ui.menu.IItemContainer;
import org.whole.lang.ui.menu.IMenuNameStrategy;
import org.whole.lang.ui.menu.PrefixMenuNameStrategy;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IEntityTransformer;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("unchecked")
public class ActionsE4InterpreterVisitor extends ActionsInterpreterVisitor {

	@Override
	public void visit(Text entity) {
		setResult(entity);
	}

	@Override
	public void visit(Icon entity) {
		setResult(entity);
	}

	@Override
	public void visit(ActionKind entity) {
		setResult(entity);
	}

	@Override
	public void visit(Size entity) {
		setResult(entity);
	}

	@Override
	public void visit(SeparatedAction entity) {
		entity.getAction().accept(this);
	}

	@Override
	public void visit(PerformAction entity) {
		entity.getKind().accept(this);
		ActionKindEnum.Value kind = ((ActionKind) getResult()).getValue();

		entity.getText().accept(this);
		String text = getResult().wStringValue();

		Predicate enablerPredicate = entity.getEnablerPredicate();
		IEnablerPredicate predicate = null;
		if (EntityUtils.isResolver(enablerPredicate))
			predicate = EnablerPredicateFactory.instance.alwaysTrue();
		else {
			enablerPredicate.accept(this);
			predicate = createEnablerPredicate(getResult());
		}

//TODO!	entity.getConfiguration()

		entity.getTransformation().accept(this);
		IAction action = createAction(kind, predicate, null, getResult(), text);

		Icon icon = entity.getIcon();
		if (DataTypeUtils.getDataKind(icon).isObject())
			action.setImageDescriptor((ImageDescriptor) icon.wGetValue());

		setResult(BindingManagerFactory.instance.createValue(action));
	}

	@Override
	public void visit(TemplateAction entity) {
		entity.getKind().accept(this);
		ActionKindEnum.Value kind = ((ActionKind) getResult()).getValue();

		entity.getText().accept(this);
		String text = getResult().wStringValue();

		Predicate enablerPredicate = entity.getEnablerPredicate();
		IEnablerPredicate predicate = null;
		if (EntityUtils.isResolver(enablerPredicate))
			predicate = EnablerPredicateFactory.instance.alwaysTrue();
		else {
			enablerPredicate.accept(this);
			predicate = createEnablerPredicate(getResult());
		}

//TODO?	entity.getConfiguration()

		//TODO use custom IEntityTransformer if available
		entity.getTransformation().accept(this);
		IAction action = createAction(kind, predicate, null, getResult(), text);


		Icon icon = entity.getIcon();
		if (DataTypeUtils.getDataKind(icon).isObject())
			action.setImageDescriptor((ImageDescriptor) icon.wGetValue());

		setResult(BindingManagerFactory.instance.createValue(action));
	}

	@Override
	public void visit(CustomAction entity) {
		setResult(entity);
	}

	@Override
	public void visit(Actions entity) {
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
			container.addSeparator(groupName);
		else
			container.addGroupMarker(groupName);
				
		getBindings().wEnterScope();
		getBindings().wDefValue("fillMenuStrategy", strategy);

		entity.getActions().accept(this);

		getBindings().wExitScope();

		setResult(null);
	}

	@Override
	public void visit(SubgroupAction entity) {
		IItemContainer<IAction, ImageDescriptor> container = (IItemContainer<IAction, ImageDescriptor>) 
				getBindings().wGetValue("itemContainer");
		
		entity.getText().accept(this);
		String groupName = getResult().wStringValue();
		
		IFillMenuStrategy strategy;
		FillStrategy fillStrategy = entity.getFillStrategy();
		if (Matcher.match(Hierarchical, fillStrategy))
			strategy = createFillMenuStrategy((Hierarchical) fillStrategy);
		else
			strategy = FlatFillMenuStrategy.instance();

		IItemContainer<IAction, ImageDescriptor> subContainer = container.addIntoSubContainer(groupName, null);

		getBindings().wEnterScope();
		getBindings().wDefValue("itemContainer", subContainer);
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

	protected IAction createAction(Value kind,
			IEnablerPredicate enablerPredicate, IEntityTransformer transformer,
			IEntity prototype, String text) {

		//FIXME transformer always passed as null
		IEclipseContext context = (IEclipseContext) getBindings().wGetValue("context");
		ActionFactory actionRegistry = new ActionFactory(context);

		QueriesEntityFactory qf = QueriesEntityFactory.instance;
		IEntity predicate = enablerPredicate instanceof OpaqueEnablerPredicate ?
				((OpaqueEnablerPredicate) enablerPredicate).value :
					qf.createBooleanLiteral(true);
		
		switch (kind.getOrdinal()) {
		case ActionKindEnum.REPLACE_ord:
			return actionRegistry.createReplaceFragmentAction(text, predicate, prototype);

		case ActionKindEnum.INSERT_ord:
			return actionRegistry.createAddFragmentAction(text, predicate, prototype);

		case ActionKindEnum.WRAP_ord:
			IEntity behavior = qf.createPointwiseUpdate(qf.createVariableRefStep("focusEntity"),
					CommonsEntityAdapterFactory.createStageUpFragment(QueriesEntityDescriptorEnum.PathExpression, prototype));
			return actionRegistry.createPerformAction(text, WRAP_ICON_URI, predicate, behavior);

		case ActionKindEnum.PERFORM_ord:
			return actionRegistry.createPerformAction(text, WRAP_ICON_URI, predicate, prototype);

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

	private IEnablerPredicate createEnablerPredicate(IEntity predicate) {
		return new OpaqueEnablerPredicate(predicate);
	}
}
