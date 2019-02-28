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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.steppers.ui.layouts.StepperDeclarationLayout;
import org.whole.lang.ui.figures.ContentPaneFigure;

/**
 *  @generator Whole
 */
public class StepperDeclarationFigure extends ContentPaneFigure {

    public StepperDeclarationFigure() {
        initContentPanes(4);
        
        setLayoutManager(new StepperDeclarationLayout().withMargin(3));
		add(createContentPane(0));
		add(createContentPane(1));
		add(createContentPane(2));
		add(createContentPane(3));
    }

    @Override
	public void paintFigure(Graphics g) {
        super.paintFigure(g);

        StepperDeclarationLayout lm = (StepperDeclarationLayout) getLayoutManager();

        Rectangle b0 = getContentPane(0).getBounds();
        Rectangle b1 = getContentPane(1).getBounds();
        Rectangle b3 = getContentPane(3).getBounds();
        int x0 = Math.min(b0.x, b1.x);
        int x1 = Math.min(b0.right(), b1.right());
        int y0 = b0.y;
        int ya = y0 + getAscent();
        int ya0 = ya - 4;
        int ya1 = ya + 4;
        int y1 = b3.y -8;

        g.setForegroundColor(ColorConstants.lightGray);

//        g.drawLine(x0 -4, y0, x1 +4, y0);
        
        g.drawLine(x0 -4, y0, x0 -4, ya0);
        g.drawLine(x0 -4, ya0, x0 -8, ya);
        g.drawLine(x0 -4, ya1, x0 -8, ya);
        g.drawLine(x0 -4, ya1, x0 -4, y1);

        g.drawLine(x1 +4, y0, x1 +4, ya0);
        g.drawLine(x1 +4, ya0, x1 +8, ya);
        g.drawLine(x1 +4, ya1, x1 +8, ya);
        g.drawLine(x1 +4, ya1, x1 +4, y1);

//        g.drawLine(x0 -4, y1, x1 +4, y1);
    }
}
