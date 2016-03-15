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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ITabularLayoutClient;
import org.whole.lang.ui.layout.ITabularLayoutServer;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class ConditionPointFigure extends ContentPaneFigure implements ITabularLayoutClient {
	protected EntityFigure headerFigure;
	protected boolean showActive = true;

	public ConditionPointFigure() {
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
		headerFigure.add(createFoldingToggle(new EntityToggle(WholeImages.ARROW_COLLAPSE, WholeImages.ARROW_EXPAND), 2, 0, 1));
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
            else {
            	g.setAlpha(40);
                g.fillRectangle(cr);
                g.setAlpha(oldAlpha);
                g.drawRectangle(cr.x, cr.y, cr.width-1, cr.height-1);
            }
        }
	}

	public ITabularLayoutServer getTabularLayoutServer() {
		return getParent() instanceof IEntityFigure ? ((IEntityFigure) getParent()).getTabularLayoutServer() : null;
	}
	public ITabularLayoutClient getTabularLayoutClient() {
		return this;
	}
	public int getStartingCellIndex() {
		return getContentPane(1).isVisible() ? ((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getStartingCellIndex() : 0;
	}
	public void setStartingCellIndex(int cellIndex) {
		if (getContentPane(1).isVisible())
			((IEntityFigure) getContentPane(1)).getTabularLayoutClient().setStartingCellIndex(cellIndex);
	}
	public int getCells() {
		return getContentPane(1).isVisible() ? ((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getCells() : 0;
	}
	public void invalidateCells() {
		invalidateTree();
	}
	public Dimension getPreferredCellSize(int cellIndex, int wHint, int hHint) {
		int childIndex = cellIndex - getStartingCellIndex();
		int cells = getCells();
		if (childIndex >= cells)
			return IEntityFigure.PLACE_HOLDER_DIMENSION;
//		else if (childIndex == cells-1)
//			return getContentPane(0).getPreferredSize(wHint, hHint);
		else
			return ((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getPreferredCellSize(childIndex, wHint, hHint);
	}
	public Rectangle getCellBounds(int cellIndex) {
		int childIndex = cellIndex - getStartingCellIndex();
		int cells = getCells();
		if (childIndex >= cells)
			return IEntityFigure.PLACE_HOLDER_BOUNDS;
//		else if (childIndex == cells-1)
//			return getContentPane(0).getBounds();
		else
			return ((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getCellBounds(childIndex);
	}
	public int getCellSpacingBefore(int cellIndex) {
		int childIndex = cellIndex - getStartingCellIndex();
		int cells = getCells();
		if (childIndex > cells)
			return 0;
//		else if (childIndex == cells)
//			return ((IEntityFigure) getContentPane(0)).getTabularLayoutClient().getCellSpacingBefore(1);
//		else if (childIndex == cells-1)
//			return ((IEntityFigure) getContentPane(0)).getTabularLayoutClient().getCellSpacingBefore(0) +
//			 		((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getCellSpacingBefore(cells);
		else
			return ((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getCellSpacingBefore(childIndex);
	}

	public int getPreferredCellSpacingBefore(int cellIndex) {
		int childIndex = cellIndex - getStartingCellIndex();
		int cells = getCells();
		if (childIndex > cells)
			return 0;
		else
			return ((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getPreferredCellSpacingBefore(childIndex);
	}
}
