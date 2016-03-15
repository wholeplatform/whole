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
package org.whole.lang.frames.ui.figures;

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class SelectionPointFigure extends ContentPaneFigure {
	protected EntityFigure headerFigure;
	protected boolean showActive = false;

	public SelectionPointFigure(ActionListener toggleListener) {
		super(new RowLayout() {
			@Override
			protected boolean calculateChildrenSize(int wHint, int hHint, boolean preferred) {
				boolean result = super.calculateChildrenSize(wHint, hHint, preferred);
				if (childFigure[0].isVisible()) {
					int figHeight = figAscent+figDescent;
					figAscent = ascent(0);
					figDescent = figHeight - figAscent;
				}
				return result;
			};
		}.withMinorAlignment(Alignment.LEADING).withSpacing(1));
		initContentPanes(2);

		headerFigure = new EntityFigure(new RowLayout() {
			@Override
			protected boolean calculateChildrenSize(int wHint, int hHint, boolean preferred) {
				boolean result = super.calculateChildrenSize(wHint, hHint, preferred);
				int figHeight = figAscent+figDescent;
				figAscent = ascent(0);
				figDescent = figHeight - figAscent;
				return result;
			};
		}.withMinorAlignment(Alignment.LEADING).withSpacing(2).withMarginTop(2).withMarginBottom(2).withMarginRight(2));
		headerFigure.add(createFoldingToggle(new EntityToggle(WholeImages.ARROW_COLLAPSE, WholeImages.ARROW_EXPAND, toggleListener), 2, 0, 1));
		headerFigure.add(createContentPane(0));

		add(createContentPane(1));
		add(headerFigure);

		clickFoldingToggle(0);
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 2) {
			IFigure contentPane0 = getContentPane(0);
			boolean isVisible0 = !contentPane0.isVisible();
			contentPane0.setVisible(isVisible0);
			getContentPane(1).setVisible(showActive ? true : isVisible0);
		} else
			super.toggleVisibility(paneIndex);
	}

	public void showActive(boolean value) {
		if (showActive != value) {
			showActive = value;
			getContentPane(1).setVisible(showActive ? true : getContentPane(0).isVisible());
			revalidate();
			repaint();
		}
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);
        
    	Rectangle hr = headerFigure.getBounds();

    	g.setForegroundColor(ColorConstants.orange);
    	g.setBackgroundColor(ColorConstants.orange);

    	int oldAlpha = g.getAlpha();
        g.setAlpha(100);
        g.fillRoundRectangle(hr, 4, 6);
        g.setAlpha(oldAlpha);
 
        if (getContentPane(1).isVisible()) {
           	Rectangle cr = getContentPane(1).getBounds();
            if (showActive)
                g.drawLine(hr.x, hr.y, hr.x, hr.y+Math.max(hr.height, cr.height));
            else if (getContentPane(0).isVisible()) {
    	        g.setLineWidth(2);
    	    	g.drawRectangle(cr.x+1, cr.y+1, cr.width-1, cr.height-1);
            }
        }
	}
}
