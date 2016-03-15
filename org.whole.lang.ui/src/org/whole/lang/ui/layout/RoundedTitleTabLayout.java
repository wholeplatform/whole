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
package org.whole.lang.ui.layout;

import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Riccardo Solmi
 */
public class RoundedTitleTabLayout extends AbstractEntityLayout {
	private boolean rightToLeft;
	
	public boolean isRightToLeft() {
		return rightToLeft;
	}
	public RoundedTitleTabLayout withRightToLeft(boolean value) {
		rightToLeft = value;
		return this;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		boolean v0 = childFigure[0].isVisible();
		boolean v1 = childFigure[1].isVisible();
		boolean v2 = childFigure[2].isVisible();

		int maxHeight = Math.max(
				v1 ? childSize[1].height : 0,
				v2 ? childSize[2].height : 0);
		figAscent = (v0 ? childSize[0].height : 0) + maxHeight/2;
		figDescent = maxHeight - maxHeight/2;
		figWidth = (v1 ? childSize[1].width : 0) + Math.max(
				v0 ? childSize[0].width : 0, 
				v2 ? childSize[2].width : 0);
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		boolean v1 = childFigure[1].isVisible();
		boolean v2 = childFigure[2].isVisible();

		if (isRightToLeft()) {
			x[0] = area.x + (v1 ? childSize[1].width : 0);
			y[0] = area.y;
			x[1] = area.right() - (v1 ? childSize[1].width : 0);
			y[1] = area.y + figAscent-(v1 ? childSize[1].height/2 : 0);
			x[2] = area.x;
			y[2] = area.y + figAscent-(v2 ? childSize[2].height/2 : 0);
		} else {
			x[0] = area.x + (v1 ? childSize[1].width : 0);
			y[0] = area.y;
			x[1] = area.x;
			y[1] = area.y + figAscent-(v1 ? childSize[1].height/2 : 0);
			x[2] = area.right() - (v2 ? childSize[2].width : 0);
			y[2] = area.y + figAscent-(v2 ? childSize[2].height/2 : 0);
		}
	}
}
