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
package org.whole.lang.flowchart.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.PaintFigureHelper;
import org.whole.lang.ui.figures.TextualNodeFigure;

/**
 * @author Riccardo Solmi
 */
public class ChoiceFigure extends TextualNodeFigure {
	protected ConnectionAnchor[] createSourceAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createBottomMiddleAnchor(this),
				AnchorFactory.createLeftOrRightMiddleAnchor(this)
		};
	}
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createTopMiddleAnchor(this)
		};
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);

        Rectangle r = getBounds();
        int xMid = r.x + r.width/2;
        int yMid = r.y + r.height/2;

        PointList pList = new PointList();
    	pList.addPoint(new Point(xMid, r.y));
    	pList.addPoint(new Point(r.right()-1, yMid));
    	pList.addPoint(new Point(xMid, r.bottom()-1));
    	pList.addPoint(new Point(r.x, yMid));

    	PaintFigureHelper.drawFilledPolygon(g, pList,
        		ColorConstants.darkBlue, ColorConstants.lightBlue);
	}
}
