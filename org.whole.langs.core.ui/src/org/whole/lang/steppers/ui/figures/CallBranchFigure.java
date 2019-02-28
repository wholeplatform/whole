/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.steppers.ui.figures;

import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 *  @generator Whole
 */
public class CallBranchFigure extends ContentPaneFigure {

    public CallBranchFigure() {
        initContentPanes(2);
        setLayoutManager(new RowLayout().withMinorAlignment(Alignment.MATHLINE).withSpacing(24).withMarginLeft(4).withMarginRight(4));
        add(createContentPane(0));
        add(createContentPane(1));
    }

	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	@SuppressWarnings("unchecked")
	protected void paintConnections(Graphics graphics) {
//		Rectangle toggleBounds = getFoldingToggle(0).getBounds();
//		Point rootPoint = toggleBounds.getBottom();
//		rootPoint.y -= 2;
//
//		graphics.setForegroundColor(FigureConstants.relationsColor);
//		graphics.setLineWidth(2);
//		
//		int y = toggleBounds.getLeft().y;
//		graphics.drawLine(toggleBounds.right()+1, y, bounds.right(), y);
//
//        List<IFigure> children = compositeFigure.getChildren();
//		int childrenSize = children.size();
//		if (childrenSize == 0 || !getContentPane(0).isVisible())
//			return;
//
//		ICompositeEntityLayout layoutManager = compositeFigure.getLayoutManager();
//		int x = compositeFigure.getBounds().x;
//		Point[] childrenPoints = new Point[childrenSize];
//		for (int i=0; i<childrenSize; i++) {
//			childrenPoints[i] = new Point(x, layoutManager.getBaseline(i)+1);
//
////			arrowShape.setLocation(childrenPoints[i]);
////			arrowShape.paint(graphics);
//		}
//
//		DrawUtils.drawOutline(graphics, rootPoint, childrenPoints);
	}
}
