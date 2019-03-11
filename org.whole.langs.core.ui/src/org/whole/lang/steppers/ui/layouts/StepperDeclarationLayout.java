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

	public int shapeBorderBounds_x;
	public int shapeBorderBounds_y;
	public int shapeBorderBounds_width;
	public int shapeBorderBounds_height;
	protected int shapeWidth;
	protected int figIndent;

	@Override
	protected int getIndent() {
		return figIndent;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		shapeWidth = Math.max(childSize[0].width, childSize[1].width);
		int shapeDescent = Math.max(descent(1) + SHAPE_PADDING.bottom, descent(2) + childSize[3].height);

		figAscent = Math.max(SHAPE_MARGIN.top + SHAPE_PADDING.top + childSize[0].height + ascent(1), ascent(2));
		figDescent = shapeDescent + SHAPE_MARGIN.bottom + TREE_SPACING.height + childSize[4].height;
		figIndent = Math.max(SHAPE_MARGIN.left + SHAPE_PADDING.left, indent(4));
		figWidth = Math.max(SHAPE_MARGIN.getWidth() + SHAPE_PADDING.getWidth() + shapeWidth + Math.max(TREE_SPACING.width + childSize[2].width, childSize[3].width), childSize[4].width);

		shapeBorderBounds_width = shapeWidth + SHAPE_PADDING.getWidth();
		shapeBorderBounds_height = figAscent - SHAPE_MARGIN.top + shapeDescent;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		shapeBorderBounds_x = area.x + figIndent - SHAPE_PADDING.left;
		shapeBorderBounds_y = area.y + SHAPE_MARGIN.top;
		x[0] = area.x + figIndent + (shapeWidth - childSize[0].width)/2;
		y[0] = shapeBorderBounds_y + SHAPE_PADDING.top;
		x[1] = area.x + figIndent + (shapeWidth - childSize[1].width)/2;
		y[1] = area.y + figAscent - ascent(1);
		x[2] = area.x + SHAPE_MARGIN.getWidth() + SHAPE_PADDING.getWidth() + shapeWidth + TREE_SPACING.width;
		y[2] = area.y + figAscent - ascent(2);
		x[3] = area.x + SHAPE_MARGIN.getWidth() + SHAPE_PADDING.getWidth() + shapeWidth;
		y[3] = area.y + SHAPE_MARGIN.top + shapeBorderBounds_height - childSize[3].height;
		x[4] = area.x + figIndent - indent(4);
		y[4] = area.y + figAscent + figDescent - childSize[4].height;
	}
}

