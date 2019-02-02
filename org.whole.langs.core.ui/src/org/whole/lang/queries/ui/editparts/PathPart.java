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
package org.whole.lang.queries.ui.editparts;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.whole.lang.ui.editparts.CompositeRowWithPlaceholderPart;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.StringSeparatedCompositeRowFigure;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class PathPart extends CompositeRowWithPlaceholderPart {
    protected IFigure createFigure() {
        IFigure f = new StringSeparatedCompositeRowFigure("/", new RowLayout().withMarginLeft(8).withMarginRight(5).withSpacing(8)) {
        	@Override
        	public Color getLocalForegroundColor() {
        		return ColorConstants.gray;
        	}
        	@Override
        	protected Font getLocalFont() {
        		return FigureConstants.symbolFontLarge;
        	}
        	
        	@SuppressWarnings("unchecked")
        	protected void paintDecorations(Graphics g) {

//workaround for LabelFactory.createModule
        		g.setFont(FigureConstants.symbolFontLarge);

        		int spacing = Math.max(1, getLayoutManager().getSpacing() / 5);
                int separatorAscent = FigureUtilities.getFontMetrics(g.getFont()).getHeight()/2;//getSeparatorAscent();

                List<IEntityFigure> children = (List<IEntityFigure>) getChildren();
                if (!children.isEmpty()) {
	                for (int i=0; i<children.size()-1; i++) {
	                	IEntityFigure childFigure = children.get(i);
	                	Rectangle childBounds = childFigure.getBounds();
	                	g.drawString(separator, childBounds.right() + spacing, childBounds.y + childFigure.getAscent() - separatorAscent);
	                }
	
                	IEntityFigure childFigure = children.get(0);
                	Rectangle childBounds = childFigure.getBounds();	                
	        		g.setForegroundColor(ColorConstants.lightGray);
	            	g.drawString(separator, childBounds.x-getLayoutManager().getMarginLeft()+1, childBounds.y + childFigure.getAscent() - separatorAscent);
                }
        	}
        };
        return f;
    }
}
