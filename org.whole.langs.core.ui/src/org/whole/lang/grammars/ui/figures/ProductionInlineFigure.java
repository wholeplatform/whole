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
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderLeftLayout;

/**
 * @author Riccardo Solmi
 */
public class ProductionInlineFigure extends ContentPaneFigure {
	public ProductionInlineFigure() {
		super(new UnderLeftLayout(false).withSpacing(5));
		initContentPanes(3);
		
		EntityFigure row = new EntityFigure(new RowLayout());
		row.add(createFoldingToggle(0));
		row.add(createContentPane(1, new MarginBorder(0,2,0,0)));
		row.addContentLight(":");
		row.add(createContentPane(2));

		add(createContentPane(0));
		add(row);

		setBorder(new MarginBorder(0, 5, 0, 5) {
			public void paint(IFigure f, Graphics g, Insets i) {
				Rectangle r = getPaintRectangle(f, i);
				r.width--;
				r.height--;

				if (!getContentPane(0).isVisible())
					return;

				int yBar = getLayoutManager().getBaseline(0) -3;
				int yRule = getLayoutManager().getBounds(0).bottom()+3;

				g.setForegroundColor(ColorConstants.gray);
				g.drawLine(r.x+2, yBar, r.x+2, yRule);
				g.drawLine(r.right()-2, yBar, r.right()-2, yRule);
			}
		});
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		if (!getContentPane(0).isVisible())
			return;

		Rectangle bounds = getBounds();
    	Rectangle ruleBounds = getContentPane(0).getBounds();
        Rectangle r = Rectangle.SINGLETON;

//      r.setLocation(bounds.x+2, nameBounds.y);
//		r.setSize(bounds.width-4, nameBounds.height);
//		g.setBackgroundColor(ColorConstants.titleInactiveGradient);
//		g.fillRectangle(r);

        r.setLocation(bounds.x+2, ruleBounds.bottom()+3);
        r.setSize(bounds.width-4-1, 1);
        g.setForegroundColor(ColorConstants.gray);
        g.drawLine(r.x, r.y, r.right(), r.y);
    	
        int baseline = getLayoutManager().getBaseline(0)+1;
//        Rectangle ruleBounds = getContentPane(0).getClientArea();

    	g.setForegroundColor(FigureConstants.relationsColor);
    	g.drawLine(bounds.x, baseline, ruleBounds.x, baseline);
    	g.drawLine(ruleBounds.right()-1, baseline, bounds.right(), baseline);
	}
}
