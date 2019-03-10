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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.layout.AbstractEntityLayout;

/**
 * @author Riccardo Solmi
 */
public class StepperDeclarationLayout extends AbstractEntityLayout {
	public static final Insets SHAPE_INSETS = new Insets(4);
	public static final Dimension TREE_SPACING = new Dimension(8, 8);
	public static final Dimension CHILDREN_SPACING = new Dimension(8, 8);

	protected int figIndent;

	@Override
	protected int getIndent() {
		return figIndent;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		figAscent = Math.max(childSize[0].height + ascent(1), ascent(2));
		figDescent = Math.max(descent(1), descent(2)) + TREE_SPACING.height + childSize[3].height;
		figIndent = Math.max(8, indent(3));
		figWidth = 8 + Math.max(Math.max(childSize[0].width, childSize[1].width) + 8 + childSize[2].width, childSize[3].width);
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		x[0] = area.x + figIndent + (Math.max(childSize[0].width, childSize[1].width) - childSize[0].width) /2;
		y[0] = area.y;
		x[1] = area.x + figIndent + (Math.max(childSize[0].width, childSize[1].width) - childSize[1].width) /2;
		y[1] = area.y + figAscent - ascent(1);
		x[2] = area.x + 8 + Math.max(childSize[0].width, childSize[1].width) + 8;
		y[2] = area.y + figAscent - ascent(2);
		x[3] = area.x + figIndent - indent(3);
		y[3] = area.y + figAscent + figDescent - childSize[3].height;
	}
}

