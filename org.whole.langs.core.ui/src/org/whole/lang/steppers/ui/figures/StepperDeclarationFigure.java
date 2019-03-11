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

import java.util.function.Function;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.steppers.ui.layouts.StepperDeclarationLayout;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 *  @author Riccardo Solmi
 */
public class StepperDeclarationFigure extends NodeFigure {

    public StepperDeclarationFigure() {
        initContentPanes(5);
        
        setLayoutManager(new StepperDeclarationLayout().withMargin(3));
		add(createContentPane(0));
		add(createContentPane(1));
		add(createContentPane(2));
		add(createContentPane(3));
		add(createContentPane(4));
    }

    @Override
    protected ConnectionAnchor[] createSourceAnchors() {
		return new ConnectionAnchor[] {
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						StepperDeclarationLayout l = (StepperDeclarationLayout) getOwner().getLayoutManager();
						
						Point p = new Point(l.shapeBorderBounds_x+l.shapeBorderBounds_width, l.shapeBorderBounds_y);
						getOwner().translateToAbsolute(p);
						return p;
					}
					public Point getReferencePoint() {
						return getLocation(null);
					}
				},
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						StepperDeclarationLayout l = (StepperDeclarationLayout) getOwner().getLayoutManager();
						
						Point p = new Point(l.shapeBorderBounds_x, l.shapeBorderBounds_y+l.shapeBorderBounds_height);
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
						StepperDeclarationLayout l = (StepperDeclarationLayout) getOwner().getLayoutManager();
						
						Point p = new Point(l.shapeBorderBounds_x, l.shapeBorderBounds_y);
						getOwner().translateToAbsolute(p);
						return p;
					}
					public Point getReferencePoint() {
						return getLocation(null);
					}
				},
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						StepperDeclarationLayout l = (StepperDeclarationLayout) getOwner().getLayoutManager();
						
						Point p = new Point(l.shapeBorderBounds_x+l.shapeBorderBounds_width, l.shapeBorderBounds_y+l.shapeBorderBounds_height);//.translate(getContentPane(3).getBounds().width, 0);
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

        StepperDeclarationLayout l = (StepperDeclarationLayout) getLayoutManager();
        Rectangle shapeBounds = new Rectangle(l.shapeBorderBounds_x, l.shapeBorderBounds_y, l.shapeBorderBounds_width, l.shapeBorderBounds_height);
        Rectangle expressionBounds = getContentPane(1).getBounds();

        g.setForegroundColor(ColorConstants.lightGray);
        g.setBackgroundColor(ColorConstants.lightGray);
		int oldAlpha = g.getAlpha();
		g.setAlpha(40);
        g.fillRectangle(shapeBounds.x, shapeBounds.y, shapeBounds.width, expressionBounds.y-shapeBounds.y);
        g.fillRectangle(shapeBounds.x, expressionBounds.bottom(), shapeBounds.width, shapeBounds.bottom()-expressionBounds.bottom());
        g.drawLine(shapeBounds.x, expressionBounds.y-1, shapeBounds.right(), expressionBounds.y-1);
        g.drawLine(shapeBounds.x, expressionBounds.bottom(), shapeBounds.right(), expressionBounds.bottom());
        g.setAlpha(oldAlpha);

        g.drawRectangle(shapeBounds);

		g.setForegroundColor(FigureConstants.relationsColor);

        IFigure callsFigure = (IFigure) getContentPane(2).getChildren().get(0);
		DrawUtils.drawHorizontalEdge(g, shapeBounds.getTopRight(), getTargetPoint(callsFigure, 0, (r) -> r.getTopLeft()), StepperDeclarationLayout.SHAPE_MARGIN.right+StepperDeclarationLayout.TREE_SPACING.width);

        IFigure actionsFigure = (IFigure) getContentPane(4).getChildren().get(0);
		DrawUtils.drawHorizontalEdge(g, shapeBounds.getBottomLeft(), getTargetPoint(actionsFigure, 0, (r) -> r.getTopLeft()), 0);
    }
}
