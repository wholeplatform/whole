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
package org.whole.lang.queries.ui.editparts;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.editparts.CompositeRowWithPlaceholderPart;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.StringSeparatedCompositeRowFigure;

/**
 * @author Riccardo Solmi
 */
public class PathPart extends CompositeRowWithPlaceholderPart {
    protected IFigure createFigure() {
        IFigure f = new StringSeparatedCompositeRowFigure("/", 8) {
        	@Override
        	public Color getLocalForegroundColor() {
        		return FigureConstants.contentColor;
        	}
        	
        	@SuppressWarnings("unchecked")
        	protected void paintFigure(Graphics g) {
//        		super.paintFigure(g);

//workaround for LabelFactory.createModule
        		g.setForegroundColor(ColorConstants.gray);
        		g.setFont(FigureConstants.symbolFontLarge);

        		int spacing = Math.max(1, getLayoutManager().getSpacing() / 5);
                int separatorAscent = FigureUtilities.getFontMetrics(g.getFont()).getHeight()/2;//getSeparatorAscent();

//                if (getLocalFont() != null)
//                	g.setFont(getLocalFont());

                List<IEntityFigure> children = (List<IEntityFigure>) getChildren();
                for (int i=0; i<children.size()-1; i++) {
                	IEntityFigure childFigure = children.get(i);
                	Rectangle childBounds = childFigure.getBounds();
                	g.drawString(separator, childBounds.right() + spacing, childBounds.y + childFigure.getAscent() - separatorAscent);
                }
        	}
        };
//        f.setFont(WholeUIPlugin.getOpenSymbolLargeFont());
        return f;
    }
}
