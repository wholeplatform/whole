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
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.steppers.ui.layouts.StepLayout;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.StackLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 *  @author Riccardo Solmi
 */
public class StepFigure extends NodeFigure {
	protected IEntityFigure shapeBorder;

    public StepFigure() {
        initContentPanes(5);
        
        setLayoutManager(new StepLayout().withMargin(3).withMarginTop(0));
		add(shapeBorder = new EntityFigure(new StackLayout()));
		shapeBorder.setOpaque(false);
		add(createContentPane(0, new MarginBorder(0, 0, 1, 0)));
		add(createContentPane(1, new MarginBorder(1, 0, 1, 0)));
		add(createContentPane(2));
		add(createContentPane(3));
		add(createContentPane(4));
    }

    @Override
    protected ConnectionAnchor[] createSourceAnchors() {
		return new ConnectionAnchor[] {
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						Point p = shapeBorder.getBounds().getTopRight();
						getOwner().translateToAbsolute(p);
						return p;
					}
					public Point getReferencePoint() {
						return getLocation(null);
					}
				},
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						Point p = shapeBorder.getBounds().getBottomLeft();
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
    protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						Point p = shapeBorder.getBounds().getTopLeft();
						getOwner().translateToAbsolute(p);
						return p;
					}
					public Point getReferencePoint() {
						return getLocation(null);
					}
				},
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						Point p = shapeBorder.getBounds().getBottomRight();
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
	public void paintFigure(Graphics g) {
        super.paintFigure(g);

        Rectangle shapeBounds = shapeBorder.getBounds();
        Rectangle expressionBounds = getContentPane(1).getBounds();

        g.setForegroundColor(FigureConstants.contentLighterColor);
        g.setBackgroundColor(FigureConstants.contentLighterColor);
		int oldAlpha = g.getAlpha();
		g.setAlpha(40);

		g.fillRectangle(shapeBounds.x, shapeBounds.y, shapeBounds.width, expressionBounds.y-shapeBounds.y);
        g.fillRectangle(shapeBounds.x, expressionBounds.bottom(), shapeBounds.width, shapeBounds.bottom()-expressionBounds.bottom());
        g.drawLine(shapeBounds.x, expressionBounds.y-1, shapeBounds.right(), expressionBounds.y-1);
        g.drawLine(shapeBounds.x, expressionBounds.bottom(), shapeBounds.right(), expressionBounds.bottom());

        g.drawLine(shapeBounds.x+3, shapeBounds.y-3, shapeBounds.right()+3, shapeBounds.y-3);
        g.drawLine(shapeBounds.x+2, shapeBounds.y-2, shapeBounds.right()+2, shapeBounds.y-2);
        g.drawLine(shapeBounds.right()+2, shapeBounds.y-2, shapeBounds.right()+2, shapeBounds.bottom()-2);
		g.drawLine(shapeBounds.x+1, shapeBounds.y-1, shapeBounds.right()+1, shapeBounds.y-1);
        g.drawLine(shapeBounds.right()+1, shapeBounds.y-1, shapeBounds.right()+1, shapeBounds.bottom()-1);
       
        g.setForegroundColor(FigureConstants.contentColor);
        g.drawLine(shapeBounds.x+3, shapeBounds.y-4, shapeBounds.x, shapeBounds.y);
        g.drawLine(shapeBounds.x+3, shapeBounds.y-4, shapeBounds.right()+3, shapeBounds.y-4);
        g.drawLine(shapeBounds.right()+3, shapeBounds.y-4, shapeBounds.right()+3, shapeBounds.bottom()-7);
        g.drawLine(shapeBounds.right()+3, shapeBounds.y-4, shapeBounds.right(), shapeBounds.y);
        g.drawLine(shapeBounds.right(), shapeBounds.bottom(), shapeBounds.right()+3, shapeBounds.bottom()-7);
        g.setForegroundColor(FigureConstants.contentLighterColor);
 
        g.setAlpha(oldAlpha);
        
        g.drawRectangle(shapeBounds);

		g.setForegroundColor(FigureConstants.relationsColor);

        DrawUtils.drawHorizontalEdge(g, getContentPaneTargetPoint(2, 0, (r) -> r.getTop()), shapeBounds.getTopRight(), 0);
        DrawUtils.drawHorizontalEdge(g, shapeBounds.getBottomRight(), getContentPaneTargetPoint(3, 0, (r) -> r.getBottom()), 0);
        DrawUtils.drawHorizontalEdge(g, shapeBounds.getBottomLeft(), getContentPaneTargetPoint(4, 0, (r) -> r.getLeft()), 0);
    }
}
