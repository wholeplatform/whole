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
import org.whole.lang.ui.figures.DistanceMetric;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.FishboneColumnLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;
import org.whole.lang.ui.notations.figures.DrawUtils.DrawStyle;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractVerticalFishboneLayout extends AbstractStyledLayout {
	@Override
	protected IEntityLayout createChildrenLayoutManager() {
		ICompositeEntityLayout layout = new FishboneColumnLayout()
			.withMinorSpacing(CHILDREN_GAP).withMarginTop(5).withMarginBottom(5);
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
		return DistanceMetric.Orizontal;
	}

	public void paintConnections(Graphics graphics, Point... childrenPoints) {
		DrawUtils.drawVerticalFishbone(graphics, DrawStyle.ORTHOGONAL, getSpineSize(),
				getRootPoint(), childrenPoints);
	}

	public int getSpineSize() {
		return -10;
	}
}
