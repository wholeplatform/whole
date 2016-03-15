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
package org.whole.lang.workflows.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class ScopeFigure extends NodeFigure {
	protected IFigure togglesFigure;

	public ScopeFigure() {
		setLayoutManager(new RowLayout().withSpacing(4).withMinorAlignment(Alignment.LEADING));
		initContentPanes(5);		

		IFigure normalFlowFigure = new EntityFigure(new ColumnLayout());
		normalFlowFigure.add(createContentPane(0));
		normalFlowFigure.add(createContentPane(1, new MarginBorder(4)));

		togglesFigure = new EntityFigure(new ColumnLayout());
		togglesFigure.add(createFoldingToggle(2));
		togglesFigure.add(createFoldingToggle(3));
		togglesFigure.add(createFoldingToggle(4));

		add(normalFlowFigure);
		add(togglesFigure);
		add(createContentPane(2, new MarginBorder(4)));
		add(createContentPane(3, new MarginBorder(4)));
		add(createContentPane(4, new MarginBorder(4)));
		setBorder(new MarginBorder(4,8,4,8));
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
        Rectangle bounds = getBounds();
        
        int scopeTop = bounds.y;
        int scopeBottom = bounds.y+bounds.height-1;

        Rectangle r = Rectangle.SINGLETON;
        r.setLocation(bounds.x, bounds.y);
        r.setSize(bounds.width, bounds.height);
        
    	g.setBackgroundColor(ColorConstants.white);
    	g.setForegroundColor(ColorConstants.gray);
//    	g.drawLine(bounds.x+bounds.width-4, scopeTop, bounds.x+bounds.width-4, scopeBottom);
        g.drawRectangle(bounds.x, bounds.y, bounds.width-1, bounds.height-1);
        
        bounds = togglesFigure.getBounds();
        int togglesMid = bounds.x + bounds.width/2;
    	g.drawLine(togglesMid-2, scopeTop, togglesMid-2, scopeBottom);
    	g.drawLine(togglesMid+2, scopeTop, togglesMid+2, scopeBottom);

    	showSeparator(g, getContentPane(2), scopeTop, scopeBottom);
    	showSeparator(g, getContentPane(3), scopeTop, scopeBottom);
//    	showSeparator(g, getContentPane(4), scopeTop, scopeBottom);
	}

	protected void showSeparator(Graphics g, IFigure contentPane, int top, int bottom) {
    	if (contentPane.isVisible()) {
    		Rectangle bounds = contentPane.getBounds();
    		int separatorX = bounds.x+bounds.width-1;
    		g.drawLine(separatorX, top, separatorX, bottom);
    	}
	}
}
