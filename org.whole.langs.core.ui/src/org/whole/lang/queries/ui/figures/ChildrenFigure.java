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
package org.whole.lang.queries.ui.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.FontMetrics;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;

/**
 *  @generator Whole
 */
public class ChildrenFigure extends CompositeFigure {

    public ChildrenFigure() {
        super(false);
        getLayoutManager().withMarginLeft(12).withMarginRight(2);
    }

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle b = getBounds();

		int oldAlpha = g.getAlpha();
		g.setAlpha(FigureConstants.templateLanguageAlpha);

		g.setBackgroundColor(FigureConstants.templateLanguageColor);
		g.fillRectangle(b.x, b.y, 12-3, b.height);

		g.setAlpha(oldAlpha);

		g.setForegroundColor(ColorConstants.lightGray);
		g.drawLine(b.x + 12-4, b.y, b.x + 12-4, b.bottom()-1);

		g.setForegroundColor(FigureConstants.contentLightColor);
		g.setFont(FigureConstants.sanserifFontSmall);
		FontMetrics fontMetrics = g.getFontMetrics();
		int fontAscent = fontMetrics.getAscent() + 1;
		double charWidth = fontMetrics.getAverageCharacterWidth();

		List<? extends IFigure> children = getChildren();
		int childrenSize = children.size();
		for (int i=0; i<childrenSize; i++) {
			String indexString = String.valueOf(i);
			double indexStringWidth = charWidth * indexString.length();

			IFigure childFigure = children.get(i);
			Point childPoint;
			if (childFigure instanceof IEntityFigure)
				childPoint = childFigure.getBounds().getTopLeft().translate(-6-indexStringWidth,
						((IEntityFigure) childFigure).getAscent() -fontAscent);
			else
				childPoint = childFigure.getBounds().getLeft().translate(-6-indexStringWidth, 0-fontAscent);

			g.drawString(indexString, childPoint);
		}
	}
}
