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
public class OutlineUpRightLayout extends AbstractOutlineUpLayout {
	public Point getRootPoint() {
		return childFigure[0].getBounds().getTopLeft().translate(TOGGLE_INDENT, 0);
	}

	protected Point getChildPoint2(int index, IFigure childFigure) {
		return getChildLeftPoint(childFigure);
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		super.setLocation(area, x, y);

		final int areaX = area.x;
		x[0] = areaX;
		x[1] = areaX + CHILDREN_INDENT;
	}
}
