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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.whole.lang.steppers.ui.layouts.StepperDeclarationLayout;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Riccardo Solmi
 */
public class GoalsWithArgumentsFigure extends NodeFigure {
    public GoalsWithArgumentsFigure() {
        initContentPanes(2);
        setLayoutManager(new RowLayout() {
        	@Override
        	public int getIndent() {
        		return getContentPane(0).getIndent();
        	}
        }.withMinorAlignment(Alignment.MATHLINE).withSpacing(64).withMarginLeft(4).withMarginRight(8).withMarginTop(8));
        add(createContentPane(0));
        add(createContentPane(1));
    }

    @Override
    protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						IFigure c0 = (IFigure) getContentPane(0).getChildren().get(0);
				        Point tp = getTargetPoint(c0, 0, (r) -> r.getTopLeft());
				        Point p = new Point(tp.x, getBounds().y + StepperDeclarationLayout.SHAPE_MARGIN.top);
						getOwner().translateToAbsolute(p);
						return p;
					}
					public Point getReferencePoint() {
						return getLocation(null);
					}
				},
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						Point p = getBounds().getBottomRight();
						getOwner().translateToAbsolute(p);
						return p;
					}
					public Point getReferencePoint() {
						return getLocation(null);
					}
				}
			};
    }

	@Override
	public void paintClientArea(Graphics g) {
		super.paintClientArea(g);
		paintConnections(g);
		g.restoreState();
	}

	protected void paintConnections(Graphics g) {
		g.setForegroundColor(FigureConstants.relationsColor);

		int y1 = getBounds().y + StepperDeclarationLayout.SHAPE_MARGIN.top;
		int x2 = getBounds().right()-1;

		IFigure c0 = (IFigure) getContentPane(1).getChildren().get(0);
		Point tp = getTargetPoint(c0, 1, (r) -> r.getRight());
        g.drawLine(x2, y1, x2, tp.y);
        g.drawLine(tp.x-1, tp.y, x2, tp.y);

        c0 = (IFigure) getContentPane(0).getChildren().get(0);
        tp = getTargetPoint(c0, 0, (r) -> r.getTop());
        g.drawLine(tp.x, y1, tp.x, tp.y);

		g.drawLine(tp.x, y1, x2, y1);
	}
}
