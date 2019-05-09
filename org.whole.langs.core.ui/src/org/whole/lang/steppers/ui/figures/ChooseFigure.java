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

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Point;
import org.whole.lang.steppers.ui.layouts.StepLayout;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 *  @author Riccardo Solmi
 */
public class ChooseFigure extends NodeFigure {
    public ChooseFigure() {
        initContentPanes(2);
        setLayoutManager(new ColumnLayout() {
        	//TODO getAscent
        	@Override
        	public int getIndent() {
        		return getContentPane(1).getIndent();
        	}

        	@Override
        	protected int getAscent(int height) {
        		return getContentPane(1).getAscent();
        	};
        }.withMinorAlignment(Alignment.LEADING));//.withMinorAlignment(Alignment.MATHLINE).withSpacing(64).withMarginLeft(4).withMarginRight(8).withMarginTop(8));
        add(createContentPane(0, new MarginBorder(0, 3 + StepLayout.SHAPE_MARGIN.left, 0, 0)));
        add(createContentPane(1));
    }

    @Override
    protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						Point tp = getContentPaneTargetPoint(1, 0, (r) -> r.getTop());
				        Point p = new Point(tp.x, tp.y);//getBounds().y + StepLayout.SHAPE_MARGIN.top);
						getOwner().translateToAbsolute(p);
						return p;
					}
					public Point getReferencePoint() {
						return getLocation(null);
					}
				},
//				new AbstractConnectionAnchor(this) {
//					public Point getLocation(Point reference) {
//						Point p = getBounds().getRight();
//						getOwner().translateToAbsolute(p);
//						return p;
//					}
//					public Point getReferencePoint() {
//						return getLocation(null);
//					}
//				}
			};
    }

	@Override
	public void paintClientArea(Graphics g) {
		super.paintClientArea(g);
		paintConnections(g);
		g.restoreState();
	}

	protected void paintConnections(Graphics g) {
//		g.setForegroundColor(FigureConstants.relationsColor);
//
//		int y1 = getBounds().y + StepLayout.SHAPE_MARGIN.top;
//		int x2 = getContentPane(1).getBounds().right()-1;
//
//		Point tp = getContentPaneTargetPoint(1, 1, (r) -> r.getRight());
//        g.drawLine(x2, y1, x2, tp.y);
//        g.drawLine(tp.x-1, tp.y, x2, tp.y);
//
//        tp = getContentPaneTargetPoint(0, 0, (r) -> r.getTop());
//        g.drawLine(tp.x, y1, tp.x, tp.y);
//		g.drawLine(tp.x, y1, x2, y1);
	}
}
