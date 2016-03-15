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
package org.whole.lang.xsd.codebase;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Enrico Persiani
 */
public enum XsdDeployStrategies {
	NONE, MISSING, ALL;

	public static final String DEPLOY_STRATEGY_VARIABLE = "deployStrategy";

	public static XsdDeployStrategies getDefault() {
		return MISSING;
	}

	private boolean shouldDeploy(IBindingManager bm) {
		return this == getDeployStrategy(bm);
	}

	public static boolean deployNone(IBindingManager bm) {
		return NONE.shouldDeploy(bm);
	}
	public static boolean deployMissing(IBindingManager bm) {
		return getDefault().shouldDeploy(bm);
	}
	public static boolean deployAll(IBindingManager bm) {
		return ALL.shouldDeploy(bm);
	}
	public static boolean shouldDeploy(IBindingManager bm, String targetNamespace) {
		return XsdDeployStrategies.deployAll(bm) ||
		(XsdDeployStrategies.deployMissing(bm) &&
				!ReflectionFactory.hasLanguageKit(targetNamespace, false, null));
	}

	public static XsdDeployStrategies getDeployStrategy(IBindingManager bm) {
		return bm.wIsSet(DEPLOY_STRATEGY_VARIABLE) ?
				(XsdDeployStrategies) bm.wGetValue(DEPLOY_STRATEGY_VARIABLE) : getDefault();
	}

	public static void setDeployStrategy(IBindingManager bm, XsdDeployStrategies strategy) {
		bm.wDefValue(DEPLOY_STRATEGY_VARIABLE, strategy);
	}
}
