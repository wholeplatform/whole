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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.FigureConstants;

/**
 * @author Riccardo Solmi
 */
public class ChooseFigure extends CompositeFigure {
	public ChooseFigure() {
		super(false);
		getLayoutManager().withSpacing(7);

		final Insets INSETS = new Insets(0,9,0,9);
		setBorder(new CompositePlaceHolderBorder(true) {
			public Insets getInsets(IFigure figure) {
				return INSETS;
			}
			public void paint(IFigure f, Graphics g, Insets i) {
				Rectangle r = getPaintRectangle(f, i);
				r.width--;
				r.height--;
	
				g.setForegroundColor(FigureConstants.relationsColor);
	
				int ya = r.y + getAscent();
				g.drawLine(r.x-1, ya, r.x+3, ya);
				g.drawLine(r.right()-3, ya, r.right()+1, ya);
				
				int size = getChildren().size();
				if (size > 0) {

					int yMin = Math.min(ya, getLayoutManager().getBaseline(0))+1;
					int yMax = Math.max(ya, getLayoutManager().getBaseline(size-1))+1;
					
					g.drawLine(r.x+3, yMin, r.x+3, yMax);
					g.drawLine(r.right()-3, yMin, r.right()-3, yMax);
	
					for (int c=0; c<size; c++) {
						int yc = getLayoutManager().getBaseline(c)+1;
						g.drawLine(r.x+3, yc, r.x+3+6, yc);
//						g.drawLine(r.x+3+5, yc-4, r.x+3+5, yc+4);
						
						int xc = ((IFigure) getChildren().get(c)).getBounds().right();
						g.drawLine(xc-1, yc, r.right()-3, yc);        						
//						g.drawLine(xc, yc-4, xc, yc+4);
					}
				} else
					super.paint(f, g, i);
			}
		});
	}
}