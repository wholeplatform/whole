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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 *  @author Riccardo Solmi
 */
public class AndArgumentFigure extends CompositeFigure {
    public AndArgumentFigure() {
        super(new RowLayout().withMarginBottom(5).withMarginLeft(4).withMarginRight(4).withSpacing(5));
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

        	Point[] targetPoints = getChildrenTargetPoints(0, (r) -> r.getBottom()); //TODO SourcePoints
        	DrawUtils.drawVerticalTree(g, getBounds().getBottom(), 3, targetPoints);
        }
	}
}
