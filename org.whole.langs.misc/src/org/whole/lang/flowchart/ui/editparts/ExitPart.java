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
package org.whole.lang.flowchart.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.flowchart.reflect.FlowchartFeatureDescriptorEnum;
import org.whole.lang.flowchart.ui.figures.ExitFigure;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.editparts.AbstractFreeformNodePart;

/**
 * @author Riccardo Solmi
 */
public class ExitPart extends AbstractFreeformNodePart {
	protected IFigure createFigure() {
		return new ExitFigure();
	}

	protected FeatureDescriptor[] initTargetFeatures() {
		return new FeatureDescriptor[] {
				FlowchartFeatureDescriptorEnum.targetTransition
		};
	}
}
