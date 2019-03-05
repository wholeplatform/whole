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
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.steppers.ui.layouts.StepperDeclarationLayout;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.NodeFigure;

/**
 *  @generator Whole
 */
public class StepperDeclarationFigure extends NodeFigure {

    public StepperDeclarationFigure() {
        initContentPanes(4);
        
        setLayoutManager(new StepperDeclarationLayout().withMargin(3));
		add(createContentPane(0));
		add(createContentPane(1));
		add(createContentPane(2));
		add(createContentPane(3));
    }

    @Override
    protected ConnectionAnchor[] createSourceAnchors() {
//    	return super.createSourceAnchors();
		return new ConnectionAnchor[] {
				AnchorFactory.createFixedAnchor(this, 0, 0, false, true),
				AnchorFactory.createFixedAnchor(this, 0, 0, true, false),
			};
    }

    @Override
    protected ConnectionAnchor[] createTargetAnchors() {
//    	return super.createTargetAnchors();
		return new ConnectionAnchor[] {
				AnchorFactory.createFixedAnchor(this, 8-3, StepperDeclarationLayout.SHAPE_INSETS.top, true, true),
//				AnchorFactory.createFixedAnchor(getContentPane(1), -StepperDeclarationLayout.SHAPE_INSETS.right-3, -2, false, false),
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						Rectangle r = getOwner().getBounds();
						Rectangle b0 = getContentPane(0).getBounds();
				        Rectangle b1 = getContentPane(1).getBounds();
				        Rectangle b3 = getContentPane(3).getBounds();
				        
						int x = Math.max(b0.right(), b1.right()) + StepperDeclarationLayout.SHAPE_INSETS.right +3;
						int y = b3.y - StepperDeclarationLayout.CHILDREN_SPACING.height;

						Point p = new PrecisionPoint(x, y);
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

        StepperDeclarationLayout lm = (StepperDeclarationLayout) getLayoutManager();

        Rectangle b0 = getContentPane(0).getBounds();
        Rectangle b1 = getContentPane(1).getBounds();
        Rectangle b3 = getContentPane(3).getBounds();
        int x0 = Math.min(b0.x, b1.x) - StepperDeclarationLayout.SHAPE_INSETS.left;
        int x1 = Math.max(b0.right(), b1.right()) + StepperDeclarationLayout.SHAPE_INSETS.right;
        int y0 = b0.y;
        int y1 = b3.y - StepperDeclarationLayout.CHILDREN_SPACING.height;

        int r = 2;
        int d = r*2+1;//1 = size of border line

        g.setForegroundColor(ColorConstants.lightGray);
        g.setBackgroundColor(ColorConstants.lightGray);
		int oldAlpha = g.getAlpha();
		g.setAlpha(40);
        //g.fillRectangle(x0, y0, x1-x0, y1-y0);
        g.fillRectangle(x0, y0, x1-x0, b1.y-y0);
        g.fillRectangle(x0, b1.bottom(), x1-x0, y1-b1.bottom());
        g.drawLine(x0, b1.y-1, x1, b1.y-1);
        g.drawLine(x0, b1.bottom(), x1, b1.bottom());
        g.setAlpha(oldAlpha);

        g.setForegroundColor(ColorConstants.gray);
        g.setBackgroundColor(ColorConstants.gray);
        g.drawRectangle(x0, y0, x1-x0, y1-y0);
        g.fillOval(x0-r, y0-r, d, d);
        g.fillOval(x1-r, y0-r, d, d);
        g.fillOval(x0-r, y1-r, d, d);
        g.fillOval(x1-r, y1-r, d, d);


// diamond shape
//      int ya = y0 + getAscent();
//      int ya0 = ya - 4;
//      int ya1 = ya + 4;
//        g.drawLine(x0, y0, x1, y0);
//        
//        g.drawLine(x0, y0, x0, ya0);
//        g.drawLine(x0, ya0, x0 -4, ya);
//        g.drawLine(x0, ya1, x0 -4, ya);
//        g.drawLine(x0, ya1, x0, y1);
//
//        g.drawLine(x1, y0, x1, ya0);
//        g.drawLine(x1, ya0, x1 +4, ya);
//        g.drawLine(x1, ya1, x1 +4, ya);
//        g.drawLine(x1, ya1, x1, y1);
//
//        g.drawLine(x0, y1, x1, y1);
    }
}
