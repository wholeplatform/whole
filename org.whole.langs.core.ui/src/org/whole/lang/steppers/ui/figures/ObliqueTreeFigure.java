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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.steppers.ui.layouts.ObliqueLayout;
import org.whole.lang.steppers.ui.layouts.StepperDeclarationLayout;
import org.whole.lang.ui.figures.CompositeNodeFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;

/**
 *  @author Riccardo Solmi
 */
public class ObliqueTreeFigure extends CompositeNodeFigure {
    public ObliqueTreeFigure(boolean trailing) {
        super(new ObliqueLayout()
        		.withMinorAlignment(trailing ? Alignment.TRAILING : Alignment.LEADING)
        		.withSpacing(StepperDeclarationLayout.CHILDREN_SPACING.height));
    }

    @Override
    protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						int size = getChildren().size();
						Point p;
						if (size > 1) {
							Point t1 = getChildTargetPoint(0, 0, (r) -> r.getLeft());
							Point t2 = getChildTargetPoint(size-1, 0, (r) -> r.getLeft());

							p = new Point(t2.x, t1.y + (t2.y-t1.y)/2);
						} else if (size == 1)
							p = getChildTargetPoint(0, 0, (r) -> r.getLeft());
						else
							p = getBounds().getLeft();

						getOwner().translateToAbsolute(p);
						return p;
					}
					public Point getReferencePoint() {
						return getLocation(null);
					}
				},
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						int size = getChildren().size();
						Point p;
						if (size > 1) {
							Point t1 = getChildTargetPoint(0, 1, (r) -> r.getRight());
							Point t2 = getChildTargetPoint(size-1, 1, (r) -> r.getRight());

							p = new Point(getBounds().right(), t1.y + (t2.y-t1.y)/2);
						} else if (size == 1)
							p = getChildTargetPoint(0, 1, (r) -> r.getRight());
						else
							p = getBounds().getRight();

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
        int size = getChildren().size();
        if (size > 1) {
       		g.setForegroundColor(FigureConstants.relationsColor);

       		ObliqueLayout layout = (ObliqueLayout) getLayoutManager();
       		double escapeAngle = layout.getEscapeAngle();
       		Rectangle[] childrenBounds = getChildrenBounds();
       		Point[] targetPoints;
       		if (layout.getMinorAlignment().equals(Alignment.LEADING)) {
        		targetPoints = getChildrenTargetPoints(0, (r) -> r.getLeft());

            	int x1 = childrenBounds[0].x;
            	int y1 = targetPoints[0].y;
            	int x2 = childrenBounds[size-1].x;
            	int y2 = targetPoints[size-1].y;
            	int xm = (x2-x1)/2 + x1;
            	int ym = y1 + (y2-y1)/2;
        		
        		g.drawLine(targetPoints[size-1].x, ym, xm, ym);
        		g.drawLine(x1, y1, x2, y2);
        		for (int i=0; i<targetPoints.length; i++) {
        			int xi = (int)(-escapeAngle*(targetPoints[i].y - y1)) + x1;
        			g.drawLine(xi, targetPoints[i].y, targetPoints[i].x, targetPoints[i].y);
        		}
        	} else {
        		targetPoints = getChildrenTargetPoints(1, (r) -> r.getRight());
        		int x1 = childrenBounds[0].right() -1;
        		int y1 = targetPoints[0].y;
        		int x2 = childrenBounds[size-1].right() -1;
        		int y2 = targetPoints[size-1].y;
        		int xm = (x2-x1)/2 + x1;
        		int ym = y1 + (y2-y1)/2;

        		g.drawLine(xm, ym, getBounds().right(), ym);
        		g.drawLine(x1, y1, x2, y2);
        		for (int i=0; i<targetPoints.length; i++) {
        			int xi = (int)(-escapeAngle*(targetPoints[i].y - y1)) + x1;
        			g.drawLine(xi+1, targetPoints[i].y, targetPoints[i].x, targetPoints[i].y);
        		}
        	}
        }
    }
}
