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
package org.whole.lang.actions.visitors;

import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.Predicate;
import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.SubgroupAction;
import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.Transformation;
import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createStageUpFragment;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.PathExpression;

import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.actions.factories.ActionsEntityFactory;
import org.whole.lang.actions.model.Action;
import org.whole.lang.actions.model.ActionKindEnum;
import org.whole.lang.actions.model.Actions;
import org.whole.lang.actions.model.GroupAction;
import org.whole.lang.actions.model.TemplateAction;
import org.whole.lang.actions.model.URI;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.ui.actions.IActionConstants;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Enrico Persiani
 */
public class ActionsUIContentAssistVisitor extends ActionsIdentityVisitor {
	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		allLanguages(entity);
		return false;
	}

	@Override
	public void visit(URI entity) {
		allLanguages(entity);
	}

	public ContentAssistOperation getOperation() {
		return (ContentAssistOperation) super.getOperation();
	}
	protected boolean mergeResult(Action action) {
		IEntity[] result = getOperation().getResult();
		if (result == null || result.length == 0)
			result = new IEntity[] { ActionsEntityFactory.instance.createActions(0)};
		
		result[0].wAdd(Matcher.match(SubgroupAction, action) ? action :
			ActionsEntityFactory.instance.createSeparatedAction(action));

		getOperation().setResult(result);
		return true;
	}
	protected IEntity createNotEqualsQuery(IEntity prototype) {
		PathExpression pathExpression = createStageUpFragment(
				PathExpression, EntityUtils.clone(prototype));
		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		return qef.createNot(qef.createExpressionTest(
				qef.createPointwiseEquals(qef.createSelfStep(), pathExpression)));
	}
	protected TemplateAction createReplaceTemplateAction(IEntity prototype, String label) {
		return createReplaceTemplateAction(prototype, label, null);
	}
	protected TemplateAction createReplaceTemplateAction(IEntity prototype, String label, ImageDescriptor icon) {
		ActionsEntityFactory aef = ActionsEntityFactory.instance;
		TemplateAction action = aef.createTemplateAction();
		action.getKind().setValue(ActionKindEnum.REPLACE);
		action.getText().setValue(label);
		if (icon != null)
			action.getIcon().setValue(icon);
		action.setEnablerPredicate(createStageUpFragment(
						Predicate, createNotEqualsQuery(prototype)));
		action.setTransformation(createStageUpFragment(
						Transformation, EntityUtils.clone(prototype)));
		return action;
	}

	protected boolean allLanguages(IEntity entity) {
		if (!Matcher.match(ActionsEntityDescriptorEnum.URI, entity))
			return false;

		ActionsEntityFactory aef = ActionsEntityFactory.instance;

		GroupAction languagesGroup = aef.createGroupAction();
		Actions actions = aef.createActions(0);
		String actualLanguageURI = DataTypeUtils.getAsPersistenceString(entity);

		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		for (ILanguageKit languageKit : registry.getResources(false, ResourceUtils.SIMPLE_COMPARATOR)) {
			String uri = languageKit.getURI();
			if (uri.equals(actualLanguageURI))
				continue;

			URI prototype = aef.createURI(uri);
			actions.wAdd(createReplaceTemplateAction(prototype,
					ResourceUtils.SIMPLE_NAME_PROVIDER.toString(registry, languageKit),
					IActionConstants.SELECT_LANGUAGE_ICON));
		}

		languagesGroup.setActions(actions);
		return mergeResult(languagesGroup);
	}

}
