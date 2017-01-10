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
package org.whole.lang.grammars.ui.figures;

import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.FlowLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;

/**
 * @author Riccardo Solmi
 */
public class ConcatenateFigure extends CompositeFigure {
	public ConcatenateFigure() {
		super(new FlowLayout().withMinorSpacing(7).withSpacing(8).withMarginLeft(5).withMarginRight(5));
	}

	@SuppressWarnings("unchecked")
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
        
        ICompositeEntityLayout lm = getLayoutManager();
        int baseline = getBounds().y+getAscent();

        int x = getBounds().x;
        int y = baseline;
        g.drawLine(x-1, baseline, x+lm.getMarginLeft()+1, baseline);
        
        List<IFigure> children = (List<IFigure>) getChildren();
        int size = children.size();
    	int interline = 0;
    	int py = 0;
        IEntityFigure childFigure;
        Rectangle childBounds = null;
        Rectangle prevBounds = null;
        if (size > 1) {
        	childFigure = (IEntityFigure) children.get(0);
        	childBounds = childFigure.getBounds();
        	y = childBounds.y + childFigure.getAscent();

	        for (int i=1; i<size; i++) {
	        	interline = Math.max(interline, childBounds.bottom()+4);
	        	prevBounds = childBounds;
	        	py = y;

	        	childFigure = (IEntityFigure) children.get(i);
	        	childBounds = childFigure.getBounds();
	        	x = childBounds.x -1;
	        	y = childBounds.y + childFigure.getAscent();

	        	if (y > py) {
		        	int px = prevBounds.right()+1;
		        	g.drawLine(px-2, py, px, py);
		        	g.drawLine(px, py, px, interline);
		        	g.drawLine(x-lm.getSpacingBefore(i)/2, interline, px, interline);
		        	g.drawLine(x-lm.getSpacingBefore(i)/2, interline, x-lm.getSpacingBefore(i)/2, y);
		        	
		        	interline = 0;
	        	}

	        	g.drawLine(x-lm.getSpacingBefore(i), y, x+1, y);
	        }
        }

        int right = getBounds().right()-1;
        int lastX = childBounds != null ? childBounds.right()-1 : right - lm.getMarginRight();
        g.drawLine(lastX, y, right, y);
        g.drawLine(right, y, right, baseline);    
	}

	@Override
	public Color getLocalForegroundColor() {
		return FigureConstants.relationsColor;
	}
}
