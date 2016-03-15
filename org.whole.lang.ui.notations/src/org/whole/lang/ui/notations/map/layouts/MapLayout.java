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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;
import org.whole.lang.ui.notations.figures.DrawUtils.DrawStyle;

/**
 * @author Riccardo Solmi
 */
public class MapLayout extends AbstractStyledLayout {
	@Override
	protected IEntityLayout createChildrenLayoutManager() {
		ICompositeEntityLayout layout = new MapChildrenLayout().withMapLayout(this)
				.withMinorSpacing(CHILDREN_GAP).withMarginTop(5).withMarginBottom(5);
		return layout.withSpacing(CHILDREN_SPACING).withMinorAlignment(getMinorAlignment());
	}
	public MapChildrenLayout getChildrenLayoutManager() {
		return (MapChildrenLayout) super.getChildrenLayoutManager();
	}
	public Dimension getCenterSize() {
		return childSize[0];
	}

	protected Alignment getMinorAlignment() {
		return Alignment.CENTER;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		boolean v2 = childFigure[1].isVisible();
		int height2 = v2 ? childSize[1].height : 0;
		int width2 = v2 ? childSize[1].width : 0;

		int deltaY = Math.max(height2 - childSize[0].height, 0)/2;
		figAscent = ascent(0) + deltaY;
		figDescent = descent(0) + deltaY;
		figWidth = Math.max(childSize[0].width, width2);
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		MapChildrenLayout cl = getChildrenLayoutManager();
		boolean v2 = childFigure[1].isVisible();
		int deltax = v2 ? cl.getMarginLeft()+cl.leftWidth+cl.getMinorSpacing() : 0;
		int deltay = v2 ? (childSize[1].height - childSize[0].height)/2 : 0;
//		int deltax = v2 ? (prefSize[1].width - prefSize[0].width)/2 : 0;
//		int deltay = v2 ? (prefSize[1].height - prefSize[0].height)/2 : 0;

		y[1] = area.y + Math.max(-deltay, 0);
		y[0] = area.y + Math.max(+deltay, 0);
		
		x[1] = area.x + Math.max(-deltax, 0);
		x[0] = area.x + Math.max(+deltax, 0);
	}

	public Point getRootPoint() {
		return childFigure[0].getBounds().getCenter();
	}

	protected Point getChildPoint2(int index, IFigure childFigure) {
		return index % 2 == 0 ?
				getChildLeftPoint(childFigure) :
				getChildRightPoint(childFigure);
	}

	public void paintConnections(Graphics graphics, Point... childrenPoints) {
		DrawUtils.drawRadialMap(graphics, DrawStyle.ORTHOGONAL, childFigure[0].getBounds(), childrenPoints);
	}
}
