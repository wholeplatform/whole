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

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.layout.AbstractEntityLayout;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.notations.map.borders.UnderlineStyledBorder;
import org.whole.lang.ui.notations.map.figures.IStyledFigure;

/**
 * @author Riccardo Solmi
 */
public class LeafLayout extends AbstractEntityLayout implements IStyledLayout {
	protected void setAscentDescentWidth(int wHint, int hHint) {
		figAscent = ascent(0);
		figDescent = descent(0);
		figWidth = childSize[0].width;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		y[0] = area.y;
		x[0] = area.x;
	}

	public void paintConnections(Graphics graphics) {
	}

	
	private ConnectionAnchor[] targetAnchors;
	public ConnectionAnchor[] getTargetAnchors(IStyledFigure styledFigure) {
		if (targetAnchors == null)
			targetAnchors = createRootTargetAnchors(styledFigure);
		return targetAnchors;
	}
	protected ConnectionAnchor[] createRootTargetAnchors(IStyledFigure styledFigure) {
		if (styledFigure.getShape() instanceof UnderlineStyledBorder)
			return new ConnectionAnchor[] {
				AnchorFactory.createLeftOrRightBottomAnchor(childFigure[0]),
				AnchorFactory.createBottomMiddleAnchor(childFigure[0])
			};
		else
			return new ConnectionAnchor[] {
					AnchorFactory.createLeftOrRightMiddleAnchor(childFigure[0]),
					AnchorFactory.createTopOrBottomMiddleAnchor(childFigure[0])
			};
	}
	public void invalidateTargetAnchors() {
		targetAnchors = null;
	}

	public IEntityLayout getChildrenLayoutManager() {
		throw new UnsupportedOperationException("getChildrenLayoutManager()");
	}

}
