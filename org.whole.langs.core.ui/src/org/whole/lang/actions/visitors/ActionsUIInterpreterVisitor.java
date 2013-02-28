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
package org.whole.lang.actions.visitors;

import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.actions.model.Action;
import org.whole.lang.actions.model.ActionKind;
import org.whole.lang.actions.model.ActionKindEnum;
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
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.actions.ActionsComparator;
import org.whole.lang.ui.actions.CompositeAddAction;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.actions.IEnablerPredicate;
import org.whole.lang.ui.actions.ReplaceChildAction;
import org.whole.lang.ui.actions.WrapChildAction;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.menu.E3FlatFillMenuStrategy;
import org.whole.lang.ui.menu.E3FullMenuNameStrategy;
import org.whole.lang.ui.menu.E3HierarchicalFillMenuStrategy;
import org.whole.lang.ui.menu.IE3FillMenuStrategy;
import org.whole.lang.ui.menu.IE3MenuNameStrategy;
import org.whole.lang.ui.menu.E3PrefixMenuNameStrategy;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.DefaultWrapInTransformer;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IEntityTransformer;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ActionsUIInterpreterVisitor extends ActionsInterpreterVisitor {
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
	public void visit(Actions entity) {
		IMenuManager manager = (IMenuManager) 
				getBindings().wGetValue("menuManager");
		IE3FillMenuStrategy strategy = (IE3FillMenuStrategy)
				getBindings().wGetValue("fillMenuStrategy");
		ISelectionProvider provider = (ISelectionProvider)
				getBindings().wGetValue("selectionProvider");

		int size=entity.wSize();
		List<IAction> contributions = new ArrayList<IAction>();

		for (int i=0; i < size; i++) {
			Action action = (Action) entity.wGet(i);
			if (Matcher.isAssignableAsIsFrom(GroupAction, action)) {

				//FIXME, add a boolean modifier to GroupAction and SubGroupAction
				if (strategy instanceof E3HierarchicalFillMenuStrategy)
					Collections.sort(contributions, ActionsComparator.instance());

				IAction[] actions = contributions.toArray(new IAction[contributions.size()]);
				strategy.fillMenu(manager, actions, 0, actions.length);
				contributions.clear();
			}

			action.accept(this);

			IEntity result = getResult();
			if (result == null)
				continue;

			IAction contribution = (IAction) result.wGetValue();
			if (contribution instanceof UpdateAction) {
				if (contribution instanceof SelectionAction)
					((SelectionAction) contribution).setSelectionProvider(provider);
				((UpdateAction) contribution).update();
			}
			if (contribution.isEnabled())
				contributions.add(contribution);
		}

		//FIXME, add a sort boolean feature to GroupAction and SubGroupAction
		if (strategy instanceof E3HierarchicalFillMenuStrategy)
			Collections.sort(contributions, ActionsComparator.instance());

		IAction[] actions = contributions.toArray(new IAction[contributions.size()]);
		strategy.fillMenu(manager, actions, 0, actions.length);
	}

	@Override
	public void visit(SeparatedAction entity) {
		entity.getAction().accept(this);
	}

	@Override
	public void visit(GroupAction entity) {
		IMenuManager menuManager = (IMenuManager) 
				getBindings().wGetValue("menuManager");
		
		entity.getText().accept(this);
		String groupName = getResult().wStringValue();

		IE3FillMenuStrategy strategy;
		FillStrategy fillStrategy = entity.getFillStrategy();
		if (Matcher.match(Hierarchical, fillStrategy))
			strategy = createHierarchicalFillMenuStrategy((Hierarchical) fillStrategy, groupName);
		else
			strategy = E3FlatFillMenuStrategy.instance(groupName);

		IContributionItem groupMarker = EntityUtils.hasParent(entity) && 
		Matcher.match(SeparatedAction, entity.wGetParent()) ?
				new Separator(groupName) : new GroupMarker(groupName);
		menuManager.add(groupMarker);
				
		getBindings().wEnterScope();
		getBindings().wDefValue("fillMenuStrategy", strategy);

		entity.getActions().accept(this);

		getBindings().wExitScope();

		setResult(null);
	}

	@Override
	public void visit(SubgroupAction entity) {
		IMenuManager menuManager = (IMenuManager) 
				getBindings().wGetValue("menuManager");

		entity.getText().accept(this);
		String groupName = getResult().wStringValue();
		
		IE3FillMenuStrategy strategy;
		FillStrategy fillStrategy = entity.getFillStrategy();
		if (Matcher.match(Hierarchical, fillStrategy))
			strategy = createHierarchicalFillMenuStrategy((Hierarchical) fillStrategy);
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

	public IEnablerPredicate createEnablerPredicate(final IEntity predicate) {
		return new IEnablerPredicate() {
			public boolean evaluate(IEntityPart selectedPart, Object userdata) {
				IBindingManager bm = BindingManagerFactory.instance.createArguments();
				bm.wDef("self", selectedPart.getModelEntity());
				return BehaviorUtils.evaluatePredicate(predicate, 0, bm);
			}
		};
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

	private IE3FillMenuStrategy createHierarchicalFillMenuStrategy(Hierarchical hierarchicalStrategy) {
		return createHierarchicalFillMenuStrategy(hierarchicalStrategy, null);
	}
	private IE3FillMenuStrategy createHierarchicalFillMenuStrategy(Hierarchical hierarchicalStrategy, String groupName) {
		IE3MenuNameStrategy nameStrategy = Matcher.match(DistinctPrefix,
				hierarchicalStrategy.getNamingStrategy()) ? 
						E3PrefixMenuNameStrategy.instance() : E3FullMenuNameStrategy.instance();

						hierarchicalStrategy.getSplitSize().accept(this);
						int splitSize = getResult().wIntValue();

						return new E3HierarchicalFillMenuStrategy(nameStrategy, splitSize, groupName);
	}

	protected IAction createAction(ActionKindEnum.Value kind, 
			IEnablerPredicate predicate, IEntityTransformer transformer,
			IEntity prototype, String text) {

		IWorkbenchPart workbenchPart = (IWorkbenchPart) getBindings()
				.wGetValue("workbenchPart");
		EnablerPredicateFactory epf = EnablerPredicateFactory.instance; 

		switch (kind.getOrdinal()) {
		case ActionKindEnum.REPLACE_ord:
			return new ReplaceChildAction(workbenchPart,
						predicate, //epf.and(epf.replaceMode(), predicate), 
					prototype, text, transformer != null ? transformer : IDENTITY_TRANSFORMER);

		case ActionKindEnum.INSERT_ord:
			return new CompositeAddAction(workbenchPart, predicate, 
					prototype, text);

		case ActionKindEnum.WRAP_ord:
			return new WrapChildAction(workbenchPart,
						epf.and(epf.replaceFeatureType(), predicate),
					transformer != null ? transformer :
						DefaultWrapInTransformer.instance, prototype, text);

		case ActionKindEnum.PERFORM_ord:
		default:
			throw new IllegalArgumentException("not implemented yet");
		}
	}

	public static final IEntityTransformer IDENTITY_TRANSFORMER = new IEntityTransformer() {
		public void transform(IEntity oldEntity, IEntity newEntity) {
		}
	};
}
