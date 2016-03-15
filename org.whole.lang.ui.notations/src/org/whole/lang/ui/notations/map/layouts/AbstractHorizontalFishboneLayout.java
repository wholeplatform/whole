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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.DistanceMetric;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.FishboneRowLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;
import org.whole.lang.ui.notations.figures.DrawUtils.DrawStyle;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractHorizontalFishboneLayout extends AbstractStyledLayout {
	@Override
	protected IEntityLayout createChildrenLayoutManager() {
		ICompositeEntityLayout layout = new FishboneRowLayout()
				.withMinorSpacing(CHILDREN_GAP).withMarginLeft(4).withMarginRight(4);
		return layout.withSpacing(CHILDREN_SPACING).withMinorAlignment(getMinorAlignment());
	}
	protected Alignment getMinorAlignment() {
		return Alignment.CENTER;
	}

	protected Point getChildPoint2(int index, IFigure childFigure) {
		return index % 2 == 0 ?
				getChildRightPoint(childFigure) :
				getChildLeftPoint(childFigure);
	}

	protected DistanceMetric getDistanceMetric() {
		return DistanceMetric.Vertical;
	}

	public boolean isHorizontal() {
		return true;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		boolean v2 = childFigure[1].isVisible();
		int width2 = v2 ? childSize[1].width + CHILDREN_GAP : 0;

		figAscent = Math.max(ascent(0), v2 ? ascent(1) : 0);
		figDescent = Math.max(descent(0), v2 ? descent(1) : 0);
		figWidth = childSize[0].width + width2;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		boolean v2 = childFigure[1].isVisible();
		int deltay = v2 ? ascent(1) - ascent(0) : 0;

		y[1] = area.y + Math.max(-deltay, 0);
		y[0] = area.y + Math.max(+deltay, 0);
	}

	public void paintConnections(Graphics graphics, Point... childrenPoints) {
		DrawUtils.drawHorizontalFishbone(graphics, DrawStyle.ORTHOGONAL, getSpineSize(),
				getRootPoint(), childrenPoints);
	}

	public int getSpineSize() {
		return -10;
	}
}
