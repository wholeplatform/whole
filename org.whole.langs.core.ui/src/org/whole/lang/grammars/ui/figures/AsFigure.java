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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.UnderLeftLayout;

/**
 * @author Riccardo Solmi
 */
public class AsFigure extends ContentPaneFigure {
	public AsFigure() {
		super(new UnderLeftLayout(false).withSpacing(3));
		initContentPanes(2);
		
		add(createContentPane(0));
		add(createContentPane(1));
		
		setBorder(new MarginBorder(0, 5, 0, 5) {
			public void paint(IFigure f, Graphics g, Insets i) {
				Rectangle r = getPaintRectangle(f, i);
				r.width--;
				r.height--;

				int yBar = getLayoutManager().getBaseline(0) -3;
				int yName = getLayoutManager().getBounds(1).bottom();

				g.setForegroundColor(ColorConstants.lightGray);
				g.drawLine(r.x+2, yBar, r.x+2, yName);
				g.drawLine(r.right()-2, yBar, r.right()-2, yName);
			}
		});
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle bounds = getBounds();
    	Rectangle nameBounds = getContentPane(1).getBounds();
        Rectangle r = Rectangle.SINGLETON;

        r.setLocation(nameBounds.x-3, nameBounds.y);
        r.setSize(bounds.width-4, nameBounds.height);
    	g.setBackgroundColor(FigureConstants.lightBlueColor);
    	g.fillRectangle(r);

        int baseline = getLayoutManager().getBaseline(0)+1;
        Rectangle ruleBounds = getContentPane(0).getClientArea();

    	g.setForegroundColor(FigureConstants.relationsColor);
    	g.drawLine(bounds.x, baseline, ruleBounds.x, baseline);
    	g.drawLine(ruleBounds.right()-1, baseline, bounds.right(), baseline);
	}
}
