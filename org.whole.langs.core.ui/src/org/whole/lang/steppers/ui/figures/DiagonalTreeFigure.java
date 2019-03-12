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
import java.util.function.Function;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.steppers.ui.layouts.DiagonalColumnLayout;
import org.whole.lang.steppers.ui.layouts.StepperDeclarationLayout;
import org.whole.lang.ui.figures.CompositeNodeFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.layout.ICompositeEntityLayout;

/**
 *  @author Riccardo Solmi
 */
public class DiagonalTreeFigure extends CompositeNodeFigure {

    public DiagonalTreeFigure() {
        super(new DiagonalColumnLayout().withSpacing(StepperDeclarationLayout.CHILDREN_SPACING.height));
    }

    @Override
    protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						int size = getChildren().size();
						Point p;
						if (size > 1) {
							IFigure f1 = (IFigure) getChildren().get(0);
							IFigure f2 = (IFigure) getChildren().get(size-1);
				        	int x1 = f1.getBounds().x;
				        	int x2 = f2.getBounds().x;
				        	Point t1 = getTargetPoint(f1, 0, (r) -> r.getTopLeft());
							Point t2 = getTargetPoint(f2, 0, (r) -> r.getTopLeft());
							int y1 = t1.y;
				        	int y2 = t2.y;
				        	int xm = (x2-x1)/2 + x1;
				        	int ym = y1 + (y2-y1)/2;
				        	p = new Point(t2.x, ym);
						} else //FIXME size =1
							p = new Point(size > 0 ? getTargetPoint(((IFigure) getChildren().get(size-1)), 0, (r) -> r.getTopLeft()).x: getBounds().x, getBounds().y);
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
        int size = getChildren().size();
        if (size > 1) {
    		Point[] targetPoints = getTargetPoints((IFigure) this, 0, (r) -> r.getTopLeft());

        	int x1 = ((IFigure) getChildren().get(0)).getBounds().x;
        	int x2 = ((IFigure) getChildren().get(size-1)).getBounds().x;
        	int y1 = targetPoints[0].y;
        	int y2 = targetPoints[size-1].y;
        	int xm = (x2-x1)/2 + x1;
        	int ym = y1 + (y2-y1)/2;
//        	float d = (x2-x1)/(y2-y1);
        	int indent = targetPoints[size-1].x;
        	
    		g.setForegroundColor(FigureConstants.relationsColor);

//    		g.drawLine(indent, getBounds().y, indent, ym);
    		g.drawLine(indent, ym, xm, ym);
    		
    		g.drawLine(x1, y1, x2, y2);

    		for (int i=0; i<targetPoints.length; i++) {
    			int xi = ((IFigure) getChildren().get(i)).getBounds().x;
    			g.drawLine(xi, targetPoints[i].y, targetPoints[i].x, targetPoints[i].y);
    		}
        }
    }
    

	@SuppressWarnings("unchecked")
	public Point[] getTargetPoints(IFigure f, int anchorIndex, Function<Rectangle, Point> target) {
		Point[] childrenPoints;

        LayoutManager layout = f.getLayoutManager();
		List<IFigure> children = f.getChildren();
    	int childrenSize = children.size();
		if (layout instanceof ICompositeEntityLayout && childrenSize > 0) {
			childrenPoints = new Point[childrenSize];
			for (int i=0; i<childrenSize; i++)
				childrenPoints[i] = getTargetPoint(children.get(i), anchorIndex, target);
        } else
        	childrenPoints = new Point[] { getTargetPoint(f, anchorIndex, target) };

		return childrenPoints;
	}

	public Point getTargetPoint(IFigure f, int anchorIndex, Function<Rectangle, Point> target) {
		if (f instanceof INodeFigure) {
			Point targetLocation = ((INodeFigure) f).getTargetAnchor(anchorIndex).getLocation(null);
			translateToRelative(targetLocation);
			return targetLocation;
		} else
			return target.apply(f.getBounds());
	}
}
