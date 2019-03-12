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
	public static final Insets SHAPE_MARGIN = new Insets(4);
	public static final Insets SHAPE_PADDING = new Insets(4);
	public static final Dimension TREE_SPACING = new Dimension(8, 8);
	public static final Dimension CHILDREN_SPACING = new Dimension(8, 8);

	protected int shapeWidth;
	protected int figIndent;

	@Override
	protected int getIndent() {
		return figIndent;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		shapeWidth = Math.max(childSize[1].width, childSize[2].width);
		int shapeDescent = Math.max(descent(2) + SHAPE_PADDING.bottom, descent(3) + childSize[4].height);

		figAscent = Math.max(SHAPE_MARGIN.top + SHAPE_PADDING.top + childSize[1].height + ascent(2), ascent(3));
		figDescent = shapeDescent + SHAPE_MARGIN.bottom + TREE_SPACING.height + childSize[5].height;
		figIndent = Math.max(SHAPE_MARGIN.left + SHAPE_PADDING.left, indent(5));
		figWidth = Math.max(SHAPE_MARGIN.getWidth() + SHAPE_PADDING.getWidth() + shapeWidth + Math.max(TREE_SPACING.width + childSize[3].width, childSize[4].width), childSize[5].width);

		childSize[0].width = shapeWidth + SHAPE_PADDING.getWidth();
		childSize[0].height = figAscent - SHAPE_MARGIN.top + shapeDescent;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		x[0] = area.x + figIndent - SHAPE_PADDING.left;
		y[0] = area.y + SHAPE_MARGIN.top;
		x[1] = area.x + figIndent + (shapeWidth - childSize[1].width)/2;
		y[1] = y[0] + SHAPE_PADDING.top;
		x[2] = area.x + figIndent + (shapeWidth - childSize[2].width)/2;
		y[2] = area.y + figAscent - ascent(2);
		x[3] = area.x + SHAPE_MARGIN.getWidth() + SHAPE_PADDING.getWidth() + shapeWidth + TREE_SPACING.width;
		y[3] = area.y + figAscent - ascent(3);
		x[4] = area.x + SHAPE_MARGIN.getWidth() + SHAPE_PADDING.getWidth() + shapeWidth;
		y[4] = area.y + SHAPE_MARGIN.top + childSize[0].height - childSize[4].height;
		x[5] = area.x + figIndent - indent(5);
		y[5] = area.y + figAscent + figDescent - childSize[5].height;
	}
}

