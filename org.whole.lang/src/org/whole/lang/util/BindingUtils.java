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
package org.whole.lang.util;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class BindingUtils {
	public static final String ENVIRONMENT_URI_PREFIX = "whole:environment:";

	public static final String createQualifiedVariable(String envName, String varName) {
		return ENVIRONMENT_URI_PREFIX+envName+"#"+varName;
	}

	public static final boolean hasEnvironmentPart(String variable) {
		return variable.startsWith(ENVIRONMENT_URI_PREFIX);
	}
	public static final String getEnvironmentPart(String variable) {
		int index = variable.indexOf('#');
		return index > 0 ? variable.substring(
				hasEnvironmentPart(variable) ? ENVIRONMENT_URI_PREFIX.length() : 0, index) : null;
	}
	public static final String getEnvironmentName(String variable) {
		if (hasEnvironmentPart(variable)) {
			int index = variable.indexOf('#');
			if (index > 0)
				return variable.substring(ENVIRONMENT_URI_PREFIX.length(), index);
		}
		return null; 
	}
	public static final String getVariableName(String variable) {
		int index = variable.indexOf('#');
		return index > 0 ? variable.substring(index+1) : variable;
	}

	public static IBindingManager getEnvironment(IBindingManager bm, String variable) {
		if (hasEnvironmentPart(variable)) {
			int index = variable.indexOf('#');
			bm = bm.wGetEnvironmentManager().getEnvironment(
					variable.substring(ENVIRONMENT_URI_PREFIX.length(), index));
		}
		return bm;
	}
	public static boolean wIsSet(IBindingManager bm, String variable) {
		if (hasEnvironmentPart(variable)) {
			int index = variable.indexOf('#');
			bm = bm.wGetEnvironmentManager().getEnvironment(
					variable.substring(ENVIRONMENT_URI_PREFIX.length(), index));
			variable = variable.substring(index+1);
		}
		return bm.wIsSet(variable);
	}
	public static IEntity wGet(IBindingManager bm, String variable) {
		if (hasEnvironmentPart(variable)) {
			int index = variable.indexOf('#');
			bm = bm.wGetEnvironmentManager().getEnvironment(
					variable.substring(ENVIRONMENT_URI_PREFIX.length(), index));
			variable = variable.substring(index+1);
		}
		return bm.wGet(variable);
	}
	public static void wSet(IBindingManager bm, String variable, IEntity value) {
		if (hasEnvironmentPart(variable)) {
			int index = variable.indexOf('#');
			bm = bm.wGetEnvironmentManager().getEnvironment(
					variable.substring(ENVIRONMENT_URI_PREFIX.length(), index));
			variable = variable.substring(index+1);
		}
		bm.wSet(variable, value);
	}
	public static void wDef(IBindingManager bm, String variable, IEntity value) {
		if (hasEnvironmentPart(variable)) {
			int index = variable.indexOf('#');
			bm = bm.wGetEnvironmentManager().getEnvironment(
					variable.substring(ENVIRONMENT_URI_PREFIX.length(), index));
			variable = variable.substring(index+1);
		}
		bm.wDef(variable, value);
	}

//	public static IBindingManager getEnvironment(IBindingManager bm, String variable) {
//		String environmentName = getEnvironmentName(variable);
//		if (environmentName != null) {
//			if (!bm.wIsSet(environmentName)) {
//				IBindingManager environment = bm.wGetEnvironmentManager().getEnvironment(environmentName);
//				bm.wDefValue(environmentName, environment);
//			}
//			bm = (IBindingManager) bm.wGetValue(environmentName);
//		}
//		return bm;
//	}
//
//	public static boolean wIsSet(IBindingManager bm, String variable) {
//		return getEnvironment(bm, variable).wIsSet(getVariableName(variable));
//	}
//	public static IEntity wGet(IBindingManager bm, String variable) {
//		return getEnvironment(bm, variable).wGet(getVariableName(variable));
//	}
//	public static void wSet(IBindingManager bm, String variable, IEntity value) {
//		getEnvironment(bm, variable).wSet(getVariableName(variable), value);
//	}
//	public static void wDef(IBindingManager bm, String variable, IEntity value) {
//		getEnvironment(bm, variable).wDef(getVariableName(variable), value);
//	}

	public static IBindingScope wOuterScope(IBindingScope scope, boolean preceding) {
		IBindingScope precedingScope = scope;
		switch (scope.getKind()) {
		case OUTER_GROUP_ADAPTER:
			return wOuterScope(scope.wTargetScope(), preceding);
		case OUTER_SCOPE_ADAPTER:
			do {
				precedingScope = scope;
				scope = scope.wEnclosingScope();
			} while (scope.getKind().equals(IBindingScope.Kind.OUTER_SCOPE_ADAPTER));
			if (scope == NullScope.instance)
				break;
		case SCOPE:
		case INNER_SCOPE_ADAPTER:
			do {
				precedingScope = scope;
				scope = scope.wEnclosingScope();
			} while (scope.getKind().equals(IBindingScope.Kind.INNER_SCOPE_ADAPTER));
			break;
		}

		return preceding ? precedingScope : scope;
	}
}
