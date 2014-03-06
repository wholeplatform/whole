/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.workflows.util;

import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.ArtifactsActivity;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.CreateEntity;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.CreateJavaClassInstance;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.PersistenceActivity;
import static org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum.className;
import static org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum.constructor;
import static org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum.entityName;
import static org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum.method;
import static org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum.persistence;
import static org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum.resource;
import static org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum.rootResource;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.java.util.JavaReflectUtils.JavaSignature;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.workflows.factories.WorkflowsEntityFactory;
import org.whole.lang.workflows.model.ArtifactsActivity;
import org.whole.lang.workflows.model.Assignments;
import org.whole.lang.workflows.model.PersistenceActivity;
import org.whole.lang.workflows.model.Variables;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;

/**
 * @author Enrico Persiani
 */
public class WorkflowsUtils {
	public static boolean isFeatureInActivity(IEntity entity, FeatureDescriptor fd, EntityDescriptor<?>... eds) {
		if (!EntityUtils.hasParent(entity))
			return false;

		IEntity parent = entity.wGetParent();
		EntityDescriptor<?> parentEd = parent.wGetEntityDescriptor();
		boolean assignable = false;
		for (int i = 0; i < eds.length; i++)
			if (eds[i].isLanguageSupertypeOf(parentEd)) {
				assignable = true;
				break;
			}
		return assignable && parent.wGet(fd).equals(entity.wGetAdaptee(false));
	}

	public static boolean isPersistenceInPersistenceActivity(IEntity entity) {
		return isFeatureInActivity(entity, persistence, PersistenceActivity);
	}
	public static boolean isResourceInArtifactsActivity(IEntity entity) {
		return isFeatureInActivity(entity, rootResource, ArtifactsActivity) &&
				EntityUtils.isImpl(((ArtifactsActivity) entity.wGetParent()).getRootResourceKind());
	}
	public static boolean isResourceInPersistenceActivity(IEntity entity) {
		return isFeatureInActivity(entity, resource, PersistenceActivity) &&
				EntityUtils.isNotResolver(((PersistenceActivity) entity.wGetParent()).getResourceKind());
	}
	public static boolean isSignatureInJavaActivity(IEntity entity) {
		return isFeatureInActivity(entity, method, InvokeJavaClassMethod,
				InvokeJavaInstanceMethod) || isFeatureInActivity(entity,
				constructor, CreateJavaClassInstance);
	}
	public static boolean isClassNameInJavaActivity(IEntity entity) {
		return isFeatureInActivity(entity, className, InvokeJavaClassMethod,
				InvokeJavaInstanceMethod, CreateJavaClassInstance);
	}
	public static boolean isEntityTypeInCreateEntity(IEntity entity) {
		return isFeatureInActivity(entity, entityName, CreateEntity);
	}

	public static String unparseCompact(JavaSignature signature) {
		StringBuilder sb = new StringBuilder();
		sb.append(signature.name);
		sb.append('(');
		int length = signature.types.length - (signature.isVarArgs ? 1 : 0);
		for (int i = 0; i < length; i++) {
			if (i>0)
				sb.append(", ");
			sb.append(signature.types[i].getSimpleName());
		}
		if (signature.isVarArgs) {
			if (length>0)
				sb.append(", ");
			Class<?> type = signature.types[length];
			sb.append(type.getComponentType().getSimpleName());
			sb.append("...");
		}
		sb.append(')');
		return sb.toString();
	}

	public static IEntity calculateVariables(IOperation operation) {
		return calculateVariables(operation, null);
	}
	public static IEntity calculateVariables(IOperation operation, Variables variables) {
		IBindingManager bindings = operation.getOperationEnvironment();

		WorkflowsEntityFactory ef = WorkflowsEntityFactory.instance;
		Assignments assignments = ef.createAssignments(0);
		List<Integer> voidVars = new ArrayList<Integer>();
		IEntity expression;
		int index = 0;
		if (variables != null && Matcher.matchImpl(WorkflowsEntityDescriptorEnum.Variables, variables))
			for (int size=variables.size(); index<size; index++) {
				String name = variables.get(index).getValue();
				if (bindings.wIsSet(name)) {
					if (BindingManagerFactory.instance.isVoid(bindings.wGet(name)))
						voidVars.add(index);

					expression = CommonsEntityFactory.instance.createStageDownFragment(
							ef.createVariable(name).wGetAdapter(CommonsEntityDescriptorEnum.Any));
				} else
					expression = CommonsEntityFactory.instance.createResolver();
				
				assignments.add(ef.createAssign(ef.createVariable(name), expression.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression)));
			}
		else
			for (String name : new TreeSet<String>(bindings.wNames())) {
				if (BindingManagerFactory.instance.isVoid(bindings.wGet(name)))
					voidVars.add(index);

				expression = CommonsEntityFactory.instance.createStageDownFragment(
						ef.createVariable(name).wGetAdapter(CommonsEntityDescriptorEnum.Any));

				assignments.add(ef.createAssign(ef.createVariable(name), expression.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression)));
				index++;
			}

		operation.stagedVisit(assignments, 1);	
		final IEntity variablesModel = bindings.getResult();

		//FIXME add workaround for missing GenericTemplateInterpreter strategy preserving Voids
		for (int i : voidVars)
			variablesModel.wGet(i).wSet(WorkflowsFeatureDescriptorEnum.expression, BindingManagerFactory.instance.createVoid().wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
		return variablesModel;
	}
}
