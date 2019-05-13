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
package org.whole.lang.steppers.ui.layouts;

import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.layout.AbstractEntityLayout;

/**
 * @author Riccardo Solmi
 */
public class ChooseLayout extends AbstractEntityLayout {
	public static final int NAME_LEFT_MARGIN = 3 + StepLayout.SHAPE_MARGIN.left;

	protected void setAscentDescentWidth(int wHint, int hHint) {
		figAscent = childSize[0].height + ascent(1);
		figDescent = descent(1);

		figWidth = Math.max(NAME_LEFT_MARGIN + childSize[0].width, indent(1)) + childSize[1].width - indent(1);
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		x[0] = area.x + NAME_LEFT_MARGIN;
		x[1] = area.x + Math.max(NAME_LEFT_MARGIN + childSize[0].width, indent(1)) - indent(1);
		
		y[0] = area.y;
		y[1] = y[0] + childSize[0].height;
	}
}
