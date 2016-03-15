/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.models.ui.editparts;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.UnderColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class TypesPart extends AbstractCompositePart {
    protected IFigure createFigure() {
    	return new CompositeFigure(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING).withSpacing(6)) {
    		@SuppressWarnings("unchecked")
    		protected void paintFigure(Graphics g) {
    			super.paintFigure(g);

    			String separator = ",";
    	        int spacing = getLayoutManager().getSpacing();
    	        int fontAscent = FigureUtilities.getFontMetrics(getFont()).getHeight()/2;

    	        int xOffset = FigureUtilities.getTextWidth(separator, getFont())/2;
    	        int yOffset = spacing*5/6 + fontAscent +1;
    	        int x = getClientArea().getCenter().x - xOffset;

    	        g.setForegroundColor(ColorConstants.lightGray);
    	        List<IFigure> children = (List<IFigure>) getChildren();
    	        for (int i=1; i<children.size(); i++) {
    	        	int y = children.get(i).getBounds().y;
    	        	g.drawString(separator, x, y-yOffset);
    	        }
    		}
    	};
//        return new StringSeparatedCompositeColumnFigure(",",
//        		new UnderColumnLayout().withMinorAlignment(Alignment.LEADING).withSpacing(8));
    }
}
