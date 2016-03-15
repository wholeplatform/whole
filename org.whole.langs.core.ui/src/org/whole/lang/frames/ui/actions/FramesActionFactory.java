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
package org.whole.lang.frames.ui.actions;

import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/**
 * @author Riccardo Solmi
 */
public class FramesActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final FramesActionFactory instance = new FramesActionFactory();
	}
	public static FramesActionFactory instance() {
		return SingletonHolder.instance;
	}
	private FramesActionFactory() {}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.assignableTo(FramesEntityDescriptorEnum.URI), FramesEntityDescriptorEnum.Resource, "Resource", wrapIn0},
				{ pf.assignableTo(FramesEntityDescriptorEnum.Subfeature), FramesEntityDescriptorEnum.Feature, "Feature", wrapWithin(FramesFeatureDescriptorEnum.features)},
				{ pf.assignableTo(FramesEntityDescriptorEnum.SolitaryFeature), FramesEntityDescriptorEnum.VariableFeature, "Variable Feature", wrapIn(FramesFeatureDescriptorEnum.feature)},
				{ pf.assignableTo(FramesEntityDescriptorEnum.FeatureName), FramesEntityDescriptorEnum.FeatureRename, "Feature Rename", wrapIn(FramesFeatureDescriptorEnum.name)},
				{ pf.assignableTo(FramesEntityDescriptorEnum.SolitaryFeature), FramesEntityDescriptorEnum.CloneGroup, "Clone Group", wrapWithin(FramesFeatureDescriptorEnum.features)},
				{ pf.assignableTo(FramesEntityDescriptorEnum.VariableFeature), FramesEntityDescriptorEnum.SubsetGroup, "Subset Group", wrapWithin(FramesFeatureDescriptorEnum.features)},
		};
	};
}
