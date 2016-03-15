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

import org.whole.lang.java.util.JavaReflectUtils.JavaSignature;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.workflows.model.ArtifactsActivity;
import org.whole.lang.workflows.model.PersistenceActivity;

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
}
