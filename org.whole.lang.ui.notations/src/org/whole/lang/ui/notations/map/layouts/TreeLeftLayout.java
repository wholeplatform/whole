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
import org.whole.lang.ui.layout.Alignment;

/**
 * @author Riccardo Solmi
 */
public class TreeLeftLayout extends AbstractHorizontalTreeLayout {
	protected Alignment getMinorAlignment() {
		return Alignment.TRAILING;
	}

	public Point getRootPoint() {
		return childFigure[0].getBounds().getLeft();
	}
	protected Point getChildPoint2(int index, IFigure childFigure) {
		return getChildRightPoint(childFigure);
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		super.setLocation(area, x, y);

		x[1] = area.x;
		x[0] = area.right() - childSize[0].width;
	}
}
