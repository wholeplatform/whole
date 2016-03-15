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
package org.whole.lang.workflows.visitors;

import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.StringLiteral;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.whole.lang.actions.factories.ActionsEntityFactory;
import org.whole.lang.actions.model.GroupAction;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.actions.ReplaceWithClassNameAction;
import org.whole.lang.ui.actions.ReplaceWithResourceAction;
import org.whole.lang.ui.actions.ReplaceWithResourceAndPersistenceAction;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.workflows.factories.WorkflowsEntityFactory;
import org.whole.lang.workflows.model.Expression;
import org.whole.lang.workflows.model.PersistenceActivity;
import org.whole.lang.workflows.model.ResourceKindEnum;
import org.whole.lang.workflows.model.StringLiteral;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.workflows.util.WorkflowsUtils;

/**
 * @author Enrico Persiani
 */
public class WorkflowsIDEContentAssistVisitor extends WorkflowsUIContentAssistVisitor {
	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		chooseClass(entity);
		chooseResource(entity);
		return super.visitAdapter(entity);
	}

	@Override
	public void visit(StringLiteral entity) {
		chooseClass(entity);
		chooseResource(entity);
		super.visit(entity);
	}

	protected boolean chooseResource(IEntity entity) {
		Object customAction = null;
		if (WorkflowsUtils.isResourceInPersistenceActivity(entity)) {
			PersistenceActivity parent = (PersistenceActivity) entity.wGetParent();
			Expression expression = parent.getPersistence();
			IPersistenceKit persistenceKit = Matcher.match(WorkflowsEntityDescriptorEnum.StringLiteral, expression) ?
						(ReflectionFactory.hasPersistenceKit(expression.wStringValue()) ? 
							ReflectionFactory.getPersistenceKit(expression.wStringValue()) : null) :
							ReflectionFactory.getDefaultPersistenceKit();

			customAction = new ReplaceWithResourceAndPersistenceAction(
					(IEclipseContext) getBindings().wGetValue("eclipseContext"),
					WorkflowsEntityDescriptorEnum.StringLiteral,
					entity.wStringValue(), persistenceKit,
					"Select resource...") {

				protected boolean isLoading(IEntity entity) {
					return Matcher.match(WorkflowsEntityDescriptorEnum.LoadModel, entity.wGetParent());
				}

				protected ResourceKind getResourceKind(IEntity selectedEntity) {
					switch (selectedEntity.wGetParent().wGet(WorkflowsFeatureDescriptorEnum.resourceKind).wEnumValue().getOrdinal()) {
					default:
					case ResourceKindEnum.WORKSPACE_ord:
						return ResourceKind.WORKSPACE;
					case ResourceKindEnum.FILE_SYSTEM_ord:
						return ResourceKind.FILE_SYSTEM;
					case ResourceKindEnum.CLASSPATH_ord:
						return ResourceKind.CLASSPATH;
					case ResourceKindEnum.URL_ord:
						return ResourceKind.URL;
					}
				}

				protected void performReplacePersistence(IEntity parent) {
					((PersistenceActivity) parent).setPersistence(WorkflowsEntityFactory.instance.createStringLiteral(persistenceKit.getId()));
				};
			};
		} else if (WorkflowsUtils.isResourceInArtifactsActivity(entity)) {
			customAction = new ReplaceWithResourceAction(
					(IEclipseContext) getBindings().wGetValue("eclipseContext"),
					WorkflowsEntityDescriptorEnum.StringLiteral,
					entity.wStringValue(),
					"Select resource...") {
				protected boolean isLoading(IEntity entity) {
					return Matcher.match(WorkflowsEntityDescriptorEnum.LoadArtifacts, entity.wGetParent());
				}

				protected ResourceKind getResourceKind(IEntity selectedEntity) {
					switch (selectedEntity.wGetParent().wGet(WorkflowsFeatureDescriptorEnum.rootResourceKind).wEnumValue().getOrdinal()) {
					default:
					case ResourceKindEnum.WORKSPACE_ord:
						return ResourceKind.WORKSPACE;
					case ResourceKindEnum.FILE_SYSTEM_ord:
						return ResourceKind.FILE_SYSTEM;
					case ResourceKindEnum.CLASSPATH_ord:
						return ResourceKind.CLASSPATH;
					case ResourceKindEnum.URL_ord:
						return ResourceKind.URL;
					}
				}				
			};
		} else
			return false;

		ActionsEntityFactory aef = ActionsEntityFactory.instance;
		GroupAction customGroup = aef.createGroupAction();
		customGroup.setFillStrategy(aef.createFlat());
		customGroup.getText().setValue("workflows.custom");
		customGroup.setActions(aef.createActions(aef.createCustomAction(customAction)));
		return EntityUtils.isResolver(entity) ?
				mergeResult(StringLiteral, customGroup) :
					mergeResult(customGroup);
	}

	protected boolean chooseClass(IEntity entity) {
		if (!WorkflowsUtils.isClassNameInJavaActivity(entity))
			return false;

		ReplaceWithClassNameAction action = new ReplaceWithClassNameAction(
				(IEclipseContext) getBindings().wGetValue("eclipseContext"),
				WorkflowsEntityDescriptorEnum.StringLiteral, entity.wStringValue(),
				"Select class...");
		
		ActionsEntityFactory aef = ActionsEntityFactory.instance;
		GroupAction customGroup = aef.createGroupAction();
		customGroup.setFillStrategy(aef.createFlat());
		customGroup.getText().setValue("workflows.custom");
		customGroup.setActions(aef.createActions(aef.createCustomAction(action)));
		return EntityUtils.isResolver(entity) ?
				mergeResult(StringLiteral, customGroup) :
					mergeResult(customGroup);
	}
}
