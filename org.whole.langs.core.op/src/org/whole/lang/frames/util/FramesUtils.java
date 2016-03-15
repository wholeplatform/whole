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
package org.whole.lang.frames.util;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.frames.model.VariationPoint;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.BehaviorUtils;

/**
 * @author Riccardo Solmi
 */
public class FramesUtils {
	public static void updateSubset(IEntity entity) {
		BehaviorUtils.apply("whole:org.whole.lang.frames:FramesSemantics#updateSubset", entity);
	}

	public static IEntity getActiveVariationPoint(VariationPoint entity) {
		return BehaviorUtils.applyFirstResult("whole:org.whole.lang.frames:FramesSemantics#activeVariationPoint", entity);
	}

	public static IEntity getActiveVariant(VariationPoint entity, IBindingManager bm) {
		return BehaviorUtils.applyFirstResult("whole:org.whole.lang.frames:FramesSemantics#evaluateAsTemplate", entity, bm);
	}

	public static IBindingManager createFeatureSetBindings() {
		return BindingManagerFactory.instance.createBindingManager();
	}
	public static void selectFeatures(IBindingManager bindings, String... names) {
		for (String name : names)
			if (!bindings.wIsSet(name))
				bindings.wDefValue(name, true);
	}
	public static boolean isSelected(IBindingManager bindings, String name) {
		return bindings.wIsSet(name);
	}
}
