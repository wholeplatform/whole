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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractHorizontalTreeLayout extends AbstractStyledLayout {
	protected void setAscentDescentWidth(int wHint, int hHint) {
		boolean v2 = childFigure[1].isVisible();
		int height2 = v2 ? childSize[1].height : 0;
		int width2 = v2 ? childSize[1].width + CHILDREN_GAP : 0;

		int deltaY = Math.max(height2 - childSize[0].height, 0)/2;
		figAscent = ascent(0) + deltaY;
		figDescent = descent(0) + deltaY;
		figWidth = childSize[0].width + width2;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		boolean v2 = childFigure[1].isVisible();
		int height2 = v2 ? childSize[1].height : 0;

		y[1] = area.y;
//		y[0] = area.y + Math.max(height2 - childSize[0].height, 0)/2;

		int heightStretching = (int) ((figAscent+figDescent - childSize[0].height) * getMinorAutoresizeWeight(0));

		y[0] = area.y + Math.max(height2 - childSize[0].height, 0)/2-heightStretching/2;
		if (heightStretching > 0) {
			childFigure[0].getLayoutManager().getViewportTrackingStrategy().setAscent(
					getMinorAlignment().equals(Alignment.MATHLINE) ? y[0] - area.y : 0);
			y[0] = area.y;
		} else if (childFigure[0].getLayoutManager() != null)
			childFigure[0].getLayoutManager().getViewportTrackingStrategy().setAscent(0);

		childSize[0].height += heightStretching;
	}

	public void paintConnections(Graphics graphics, Point... childrenPoints) {
		DrawUtils.drawHorizontalTree(graphics, getRootPoint(), CHILDREN_GAP/2, childrenPoints);
	}
}
