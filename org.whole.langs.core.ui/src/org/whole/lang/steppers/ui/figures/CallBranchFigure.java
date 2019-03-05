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
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 *  @generator Whole
 */
public class CallBranchFigure extends ContentPaneFigure {

    public CallBranchFigure() {
        initContentPanes(2);
        setLayoutManager(new RowLayout().withMinorAlignment(Alignment.MATHLINE).withSpacing(24).withMarginLeft(4).withMarginRight(4).withMarginTop(4));
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
		graphics.setForegroundColor(FigureConstants.relationsColor);
		graphics.setLineWidth(2);
		
		Rectangle b0 = getContentPane(0).getBounds();
        
        IFigure c0 = (IFigure) getContentPane(0).getChildren().get(0);

		List<IFigure> children = c0.getChildren();
		int childrenSize = children.size();
		if (childrenSize == 0 || !c0.isVisible())
			return;

		Point[] childrenPoints = new Point[childrenSize];
		for (int i=0; i<childrenSize; i++) {
			IFigure f = children.get(i);
			if (f instanceof INodeFigure) {
				Point targetLocation = ((INodeFigure) f).getTargetAnchor(0).getLocation(null);
				childrenPoints[i] = targetLocation;
			} else
				childrenPoints[i] = new Point(b0.x, f.getBounds().y);
		}

		Point rootPoint = new Point(getBounds().x+4, getBounds().y);

		DrawUtils.drawOutline(graphics, rootPoint, childrenPoints);

        Rectangle b1 = getContentPane(1).getBounds();
        
        c0 = (IFigure) getContentPane(1).getChildren().get(0);

		children = c0.getChildren();
		childrenSize = children.size();
		if (childrenSize == 0 || !c0.isVisible())
			return;

		childrenPoints = new Point[childrenSize];
		for (int i=0; i<childrenSize; i++) {
			IFigure f = children.get(i);
			if (f instanceof INodeFigure) {
				Point targetLocation = ((INodeFigure) f).getTargetAnchor(1).getLocation(null);
				childrenPoints[i] = targetLocation;
			} else
				childrenPoints[i] = new Point(b1.right(), f.getBounds().bottom());
		}

		rootPoint = new Point(getBounds().right()-2, getBounds().y);

		DrawUtils.drawOutline(graphics, rootPoint, childrenPoints);

		graphics.drawLine(getBounds().x-5, getBounds().y+1, getBounds().right()-2, getBounds().y+1);
	}
}
