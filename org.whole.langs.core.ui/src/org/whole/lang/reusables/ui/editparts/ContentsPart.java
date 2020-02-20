/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.reusables.ui.editparts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.UnderColumnLayout;

/**
* @author Riccardo Solmi
*/
public class ContentsPart extends AbstractCompositePart {
    protected IFigure createFigure() {
        return new CompositeFigure(new UnderColumnLayout().withMinorAlignment(Alignment.MATHLINE)
        		.withMarginTop(3).withMarginBottom(3).withSpacing(3), true) {
        	
        	protected void paintFigure(Graphics g) {
        		super.paintFigure(g);

        		Rectangle b = getBounds();
        		int indent = getLayoutManager().getIndent(this)-2;

        		int oldAlpha = g.getAlpha();
        		g.setAlpha(FigureConstants.templateLanguageAlpha);

        		g.setBackgroundColor(FigureConstants.lightGray);
        		g.fillRectangle(b.x, b.y, indent, b.height);

        		g.setForegroundColor(ColorConstants.lightGray);
                drawFixedSizeChildrenSeparators(g);
        		g.setAlpha(oldAlpha);
        	}
        };
    }
}
