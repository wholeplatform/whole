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
package org.whole.lang.actions.ui.factories;

import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.Icon;
import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.Predicate;
import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.Transformation;
import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;
import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createStageUpFragment;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.PathExpression;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.actions.factories.ActionsEntityFactory;
import org.whole.lang.actions.model.Action;
import org.whole.lang.actions.model.ActionKindEnum;
import org.whole.lang.actions.model.Actions;
import org.whole.lang.actions.model.GroupAction;
import org.whole.lang.actions.model.SubgroupAction;
import org.whole.lang.actions.model.TemplateAction;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.MatcherIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.ui.actions.IActionConstants;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class ActionsUIEntityFactory extends ActionsEntityFactory {
	public static final ActionsUIEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static ActionsUIEntityFactory instance(IEntityRegistryProvider provider) {
		return new ActionsUIEntityFactory(provider);
	}

	protected ActionsUIEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public SubgroupAction createSubgroupAction(EntityDescriptor<?> subgroupED, Action action) {
		ActionsEntityFactory aef = ActionsEntityFactory.instance;
		return aef.createSubgroupAction(
				createResolver(Icon),
				aef.createText(subgroupED.getName()),
				aef.createFlat(),
				aef.createActions(action));
	}

	public GroupAction createHierarchicalGroupAction(String text) {
		GroupAction groupAction = createGroupAction();
		groupAction.setFillStrategy(createHierarchical(createDistinctPrefix(), createSize(10)));
		groupAction.getText().setValue(text);
		return groupAction;
	}

	public GroupAction createPersistencesGroupAction(ActionKindEnum.Value kind, Set<String> excludeSet, EntityDescriptor<?> resultEd) {
		GroupAction groupAction = createHierarchicalGroupAction(resultEd.getLanguageKit().getName()+".persistences");

		Actions actions = createActions(0);
		for (IPersistenceKit persistenceKit : ReflectionFactory.getPersistenceKits())
			actions.wAdd(createTemplateAction(kind, create(resultEd, persistenceKit.getId()),
					persistenceKit.getDescription(),
					IActionConstants.SELECT_PERSISTENCE_ICON,
					kind == ActionKindEnum.REPLACE));
		groupAction.setActions(actions);

		return groupAction;
	}

	public GroupAction createLanguagesGroupAction(ActionKindEnum.Value kind, Set<String> excludeSet, EntityDescriptor<?> resultEd) {
		GroupAction groupAction = createHierarchicalGroupAction(resultEd.getLanguageKit().getName()+".languages");
		
		Actions actions = createActions(0);
		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		for (ILanguageKit languageKit : registry.getResources(false, ResourceUtils.SIMPLE_COMPARATOR)) {
			String uri = languageKit.getURI();
			if (excludeSet.contains(uri))
				continue;

			actions.wAdd(createTemplateAction(kind, create(resultEd, uri),
					ResourceUtils.SIMPLE_NAME_PROVIDER.toString(registry, languageKit),
					IActionConstants.SELECT_LANGUAGE_ICON,
					kind == ActionKindEnum.REPLACE));
		}
		groupAction.setActions(actions);

		return groupAction;
	}

	public GroupAction createAllVariablesGroupAction(ActionKindEnum.Value kind, Set<String> excludeSet, EntityDescriptor<?> resultEd, IEntity model) {
		MatcherIterator<IEntity> i = IteratorFactory.<IEntity>descendantOrSelfMatcherIterator();
		i.reset(EntityUtils.safeGetRootEntity(model));
		return createVariablesGroupAction(kind, excludeSet, resultEd, i
				.withPattern(new GenericIdentityVisitor() {
					public void visit(IEntity entity) {
						if (!isVariable(entity.wGetAdaptee(false).wGetEntityDescriptor()))
							throw new VisitException();
					}
				}));
	}
	protected boolean isVariable(EntityDescriptor<?> ed) {
		return ed.getEntityKind().isData() &&
				(ed.equals(CommonsEntityDescriptorEnum.VarName) ||
				ed.equals(QueriesEntityDescriptorEnum.VariableRefStep) ||
				ed.equals(QueriesEntityDescriptorEnum.VariableTest) ||
				ed.equals(QueriesEntityDescriptorEnum.Name) ||
				ed.equals(WorkflowsEntityDescriptorEnum.Variable));
	}

	public GroupAction createVariablesGroupAction(ActionKindEnum.Value kind, Set<String> excludeSet, EntityDescriptor<?> resultEd, IEntityIterator<IEntity> variableIterator) {
		GroupAction groupAction = createHierarchicalGroupAction(resultEd.getLanguageKit().getName()+".languages");

		Actions actions = createActions(0);
		SortedSet<String> names = new TreeSet<String>();
		for (IEntity variable : variableIterator) {
			String name = variable.wStringValue();
			if (!excludeSet.contains(name))
				names.add(name);
		}
		for (String name : names)
			actions.wAdd(createTemplateAction(kind, create(resultEd, name), name, kind == ActionKindEnum.REPLACE));
		groupAction.setActions(actions);

		return groupAction;
	}

	public TemplateAction createReplaceDifferentTemplateAction(IEntity prototype, String label) {
		return createTemplateAction(ActionKindEnum.REPLACE, prototype, label, true);
	}
	public TemplateAction createReplaceDifferentTemplateAction(IEntity prototype, String label, ImageDescriptor icon) {
		return createTemplateAction(ActionKindEnum.REPLACE, prototype, label, icon, true);
	}
	public TemplateAction createTemplateAction(ActionKindEnum.Value kind, IEntity prototype, String label, boolean differentPredicate) {
		return createTemplateAction(kind, prototype, label, kind == ActionKindEnum.INSERT ?
				IActionConstants.INSERT_ICON : IActionConstants.REPLACE_ICON, differentPredicate);
	}
	public TemplateAction createTemplateAction(ActionKindEnum.Value kind, IEntity prototype, String label, ImageDescriptor icon, boolean differentPredicate) {
		ActionsEntityFactory aef = ActionsEntityFactory.instance;
		TemplateAction action = aef.createTemplateAction();
		action.getKind().setValue(kind);
		action.getText().setValue(label);
		if (icon != null)
			action.getIcon().setValue(icon);
		if (differentPredicate && kind == ActionKindEnum.REPLACE)
			action.setEnablerPredicate(createStageUpFragment(Predicate, createNotEqualsPredicate(prototype)));
		action.setTransformation(createStageUpFragment(Transformation, EntityUtils.cloneIfParented(prototype)));
		return action;
	}
	protected IEntity createNotEqualsPredicate(IEntity prototype) {
		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		return qef.createNot(qef.createExpressionTest(qef.createPointwiseEquals(qef.createSelfStep(),
				createStageUpFragment(PathExpression, EntityUtils.clone(prototype)))));
	}
}
