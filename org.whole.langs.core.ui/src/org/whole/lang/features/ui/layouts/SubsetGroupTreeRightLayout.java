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
package org.whole.lang.features.ui.layouts;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.notations.map.figures.IStyledFigure;

/**
 * @author Riccardo Solmi
 */
public class SubsetGroupTreeRightLayout extends FeatureGroupTreeRightLayout {
	{
		CHILDREN_GAP = 10;
	}

	protected ConnectionAnchor[] createRootTargetAnchors(IStyledFigure styledFigure) {
		return new ConnectionAnchor[] {
				AnchorFactory.createLeftMiddleAnchor(childFigure[0])
		};
	}

	@Override
	public Point getRootPoint() {
		return childFigure[0].getBounds().getLeft();
	}

	@Override
	public void paintConnections(Graphics graphics, Point... children) {
		Point root = getRootPoint();
		for (int i=0; i<children.length; i++)
			graphics.drawLine(root, children[i]);
		if (children.length > 1) {
			final int ARC_SIZE = 30;
			
			double b0 = Math.abs(children[children.length-1].y - root.y);
			double h0 = Math.abs(children[children.length-1].x - root.x);
			int arc0 = (int) Math.toDegrees(Math.atan2(h0, b0));

			double b1 = Math.abs(children[0].y - root.y);
			double h1 = Math.abs(children[0].x - root.x);
			int arc1 = (int) Math.toDegrees(Math.atan2(h1, b1));

			if (useDefaultLayout) {
				graphics.drawArc(
						root.x-ARC_SIZE/2, root.y-ARC_SIZE/2, ARC_SIZE, ARC_SIZE,
						270 + arc0, 180 - arc0 - arc1);
			} else {
				Color bgc = graphics.getBackgroundColor();
				graphics.setBackgroundColor(graphics.getForegroundColor());
				graphics.fillArc(
						root.x-ARC_SIZE/2, root.y-ARC_SIZE/2, ARC_SIZE, ARC_SIZE,
						270 + arc0, 180 - arc0 - arc1);
				graphics.setBackgroundColor(bgc);
			}
		}
	}
}
