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
package org.whole.lang.ui.notations.map.layouts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Riccardo Solmi
 */
public class TreeDownLayout extends AbstractVerticalTreeLayout {
	public Point getRootPoint() {
		return childFigure[0].getBounds().getBottom();
	}
	protected Point getChildPoint2(int index, IFigure childFigure) {
		return getChildUpPoint(childFigure);
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		boolean v2 = childFigure[1].isVisible();
		int height2 = v2 ? CHILDREN_GAP + childSize[1].height : 0;
		int width2 = v2 ? childSize[1].width : 0;

		figAscent = ascent(0);
		figDescent = descent(0) + height2;
		figWidth = Math.max(childSize[0].width, width2);
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		y[0] = area.y;
		x[0] = area.x + (area.width - childSize[0].width)/2;
		if (childFigure[1].isVisible()) {
			y[1] = area.bottom() - childSize[1].height;
			x[1] = area.x + (area.width - childSize[1].width)/2;
		}
	}
}
