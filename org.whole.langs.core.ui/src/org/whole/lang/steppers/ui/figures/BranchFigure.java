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
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 *  @author Riccardo Solmi
 */
public class BranchFigure extends NodeFigure {
    public BranchFigure() {
        initContentPanes(2);
        setLayoutManager(new RowLayout() {
        	@Override
        	public int getIndent() {
        		return getContentPane(0).getIndent();
        	}
        }.withMinorAlignment(Alignment.MATHLINE).withSpacing(24).withMarginLeft(4).withMarginRight(4).withMarginTop(4));
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
				        Point p = new Point(tp.x, getBounds().y);
						//Point p = new Point(getBounds().x+getIndent()-4, getBounds().y);
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

        IFigure c0 = (IFigure) getContentPane(0).getChildren().get(0);
        Point tp = getTargetPoint(c0, 0, (r) -> r.getTopLeft());
        g.drawLine(tp.x, getBounds().y, tp.x, tp.y);//c0.getBounds().y);

//		DrawUtils.drawOutline(g, new Point(getBounds().x+4, getBounds().y),
//				getTargetPoints(c0, 0, (r) -> r.getTopLeft()));	        	

        c0 = (IFigure) getContentPane(1).getChildren().get(0);
		DrawUtils.drawOutline(g, new Point(getBounds().right()-2, getBounds().y),
				getTargetPoints(c0, 1, (r) -> r.getBottomRight()));

		g.drawLine(tp.x, getBounds().y, getBounds().right()-2, getBounds().y);
//		g.drawLine(getBounds().x-5, getBounds().y, getBounds().right()-2, getBounds().y);
	}
}
