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
public class UnderLeftLayout extends AbstractCompositeEntityLayout {
	public boolean stretch;

	public UnderLeftLayout() {
	}
	public UnderLeftLayout(boolean stretch) {
		this.stretch = stretch;
	}

	public boolean isHorizontal() {
		return false;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		boolean v0 = childFigure[0].isVisible();
		boolean v1 = childFigure[1].isVisible();

		if (v0 && v1) {
			figAscent = ascent(0);
			figDescent = descent(0) + childSize[1].height + getSpacingBefore(1);
			figWidth = Math.max(childSize[0].width, childSize[1].width);
		} else if (v0 && !v1) {
			figAscent = ascent(0);
			figDescent = descent(0);
			figWidth = childSize[0].width;
		} else if (v1 && !v0) {
			figAscent = ascent(1);
			figDescent = childSize[1].height;
			figWidth = childSize[1].width;
		} //else {}
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		boolean v0 = childFigure[0].isVisible();
		boolean v1 = childFigure[1].isVisible();

		if (v0) {
			if (stretch)
				childSize[0].width = area.width;
			
			x[0] = area.x+(area.width - childSize[0].width)/2;
			y[0] = area.y;
		}

		if (v1) {
			x[1] = area.x;
			y[1] = area.y + (v0 ? childSize[0].height + getSpacingBefore(1) : 0);
		}
	}
}
