/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.Icon;
import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.SubgroupAction;
import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.CreateJavaClassInstance;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.StringLiteral;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.Variable;
import static org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum.className;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.actions.factories.ActionsEntityFactory;
import org.whole.lang.actions.model.Action;
import org.whole.lang.actions.model.ActionKindEnum;
import org.whole.lang.actions.model.Actions;
import org.whole.lang.actions.model.GroupAction;
import org.whole.lang.actions.ui.factories.ActionsUIEntityFactory;
import org.whole.lang.java.util.JavaReflectUtils;
import org.whole.lang.java.util.JavaReflectUtils.JavaSignature;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.workflows.factories.WorkflowsEntityFactory;
import org.whole.lang.workflows.model.StringLiteral;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.model.Variables;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.util.WorkflowsUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class WorkflowsUIContentAssistVisitor extends WorkflowsIdentityVisitor {
	protected static final ImageDescriptor INSTANCE_METHOD_ICON = UIUtils.getImageDescriptor("icons/actions/public_method.png");
	protected static final Image BASE_IMAGE = INSTANCE_METHOD_ICON.createImage();
	protected static final ImageDescriptor CLASS_METHOD_ICON = new DecorationOverlayIcon(BASE_IMAGE, UIUtils.getImageDescriptor("icons/actions/decoration/static_decoration.png"), IDecoration.TOP_RIGHT);
	protected static final ImageDescriptor CONSTRUCTOR_ICON = new DecorationOverlayIcon(BASE_IMAGE, UIUtils.getImageDescriptor("icons/actions/decoration/constructor_decoration.png"), IDecoration.TOP_RIGHT);
	protected static ImageDescriptor calculateImageDescriptor(IEntity entity) {
		if (Matcher.match(CreateJavaClassInstance, entity))
			return CONSTRUCTOR_ICON;
		else if (Matcher.match(InvokeJavaClassMethod, entity))
			return CLASS_METHOD_ICON;
		else
			return INSTANCE_METHOD_ICON;
	}

	public ContentAssistOperation getOperation() {
		return (ContentAssistOperation) super.getOperation();
	}

	protected ClassLoader getClassLoader() {
		return ReflectionFactory.getClassLoader(getBindings());
	}
	protected boolean mergeResult(EntityDescriptor<?> subgroupED, Action action) {
		ActionsEntityFactory aef = ActionsEntityFactory.instance;
		return mergeResult(aef.createSubgroupAction(createResolver(Icon),
				aef.createText(subgroupED.getName()), aef.createFlat(),
				aef.createActions(action)));
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

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		allSignatures(entity);
		allPersistences(entity);
		allVariables(entity, ActionKindEnum.REPLACE); 
		return false;
	}

	@Override
	public void visit(Variables entity) {
		allVariables(entity, ActionKindEnum.INSERT);
	}

	@Override
	public void visit(Variable entity) {
		allVariables(entity, ActionKindEnum.REPLACE);
	}

	@Override
	public void visit(StringLiteral entity) {
		allSignatures(entity);
		allPersistences(entity);
	}

	protected boolean allPersistences(IEntity entity) {
		if (!WorkflowsUtils.isPersistenceInPersistenceActivity(entity))
			return false;

		GroupAction persistencesGroup = ActionsUIEntityFactory.instance.createPersistencesGroupAction(
				ActionKindEnum.REPLACE,
				Collections.<String>emptySet(),
				WorkflowsEntityDescriptorEnum.StringLiteral);

		return EntityUtils.isResolver(entity) ?
				mergeResult(StringLiteral, persistencesGroup) :
					mergeResult(persistencesGroup);
	}

	protected boolean allSignatures(IEntity entity) {
		if (!WorkflowsUtils.isSignatureInJavaActivity(entity))
			return false;

		IEntity parent = entity.wGetParent();
		boolean isMethod = !Matcher.match(CreateJavaClassInstance, parent);
		boolean isStatic = Matcher.match(InvokeJavaClassMethod, parent);

		IEntity classNameEntity = parent.wGet(className);
		if (!Matcher.matchImpl(StringLiteral, classNameEntity))
			return false;
		String className = classNameEntity.wStringValue();

		Class<?> declaringClass = null;
		try {
			declaringClass = JavaReflectUtils.forName(className, getClassLoader());
		} catch (IllegalArgumentException e) {
			return false;
		}

		ActionsUIEntityFactory aef = ActionsUIEntityFactory.instance;
		GroupAction signaturesGroup = aef.createGroupAction();
		signaturesGroup.setFillStrategy(aef.createHierarchical(aef.createDistinctPrefix(), aef.createSize(20)));
		signaturesGroup.getText().setValue("workflows.signatures");

		Actions actions = aef.createActions(0);
		WorkflowsEntityFactory wef = WorkflowsEntityFactory.instance;
		if (isMethod) {
			for (Method method : declaringClass.getMethods())
				if (isStatic == Modifier.isStatic(method.getModifiers())) {
					JavaSignature signature = JavaReflectUtils.fromMethod(method);
					StringLiteral literal = wef.createStringLiteral(
							JavaReflectUtils.unparse(signature));
					actions.wAdd(aef.createReplaceDifferentTemplateAction(
							literal, WorkflowsUtils.unparseCompact(signature),
							calculateImageDescriptor(parent)));
				}
		} else {
			for (Constructor<?> constructor : declaringClass.getConstructors()) {
				JavaSignature signature = JavaReflectUtils.fromConstructor(constructor);
				StringLiteral literal = wef.createStringLiteral(
						JavaReflectUtils.unparse(signature));
				actions.wAdd(aef.createReplaceDifferentTemplateAction(
						literal, WorkflowsUtils.unparseCompact(signature),
						calculateImageDescriptor(parent)));
			}
		}
		signaturesGroup.setActions(actions);
		return EntityUtils.isResolver(entity) ?
				mergeResult(StringLiteral, signaturesGroup) :
					mergeResult(signaturesGroup);
	}

	protected boolean allVariables(IEntity entity, ActionKindEnum.Value kind) {
		if (kind == ActionKindEnum.REPLACE && (!EntityUtils.hasParent(entity) ||
				!entity.wGetParent().wGetEntityDescriptor(entity)
				.isPlatformSupertypeOf(Variable)))
			return false;

		GroupAction variablesGroup = ActionsUIEntityFactory.instance.createAllVariablesGroupAction(kind,
				Collections.<String>emptySet(), Variable, entity);

		return EntityUtils.isResolver(entity) ?
				mergeResult(Variable, variablesGroup) : mergeResult(variablesGroup);
	}
}
