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
package org.whole.lang.ui.notations.flowchart.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.MonoLayout;

/**
 * @author Riccardo Solmi
 */
public class ConditionFigure extends EntityFigure {
	public ConditionFigure() {
		setLayoutManager(new MonoLayout().withMargin(20).withMinorAlignment(Alignment.CENTER).withMajorAlignment(Alignment.CENTER));
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

    	g.setBackgroundColor(FigureConstants.lightGray);
    	g.fillPolygon(pList);
    	g.setForegroundColor(ColorConstants.black); 
    	g.drawPolygon(pList);
	}
}
