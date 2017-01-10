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
package org.whole.lang.patterns.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.DoubleSquareBracketsBorder;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class SlotFigure extends ContentPaneFigure {
	protected EntityFigure baseFigure;

	public SlotFigure() {
		initContentPanes(5);
		setLayoutManager(new RowLayout().withSpacing(3).withMargin(2, 3, 2, 3));

		add(createFoldingToggle(5, 0, 1, 4));
		add(createContentPane(0));
		baseFigure = new EntityFigure(new RowLayout().withSpacing(3));
		baseFigure.setBorder(new DoubleSquareBracketsBorder());
		baseFigure.add(createContentPane(1));
		EntityFigure f2 = new EntityFigure(new OverLayout());
		f2.add(createContentPane(2));
		f2.addContentLight("slot");
		baseFigure.add(f2);
		baseFigure.add(createContentPane(3));
		baseFigure.add(createContentPane(4));
		add(baseFigure);

		clickFoldingToggle(0);
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 5) {
			IFigure contentPane0 = getContentPane(0);
			boolean isVisible0 = !contentPane0.isVisible();
			contentPane0.setVisible(isVisible0);
			getContentPane(1).setVisible(isVisible0);
			getContentPane(4).setVisible(isVisible0);
		} else
			super.toggleVisibility(paneIndex);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle b = getBounds();
		Rectangle baseBounds = baseFigure.getBounds();

		g.setBackgroundColor(FigureConstants.hostLanguageColor);
		g.fillRectangle(baseBounds.x-1, bounds.y, baseBounds.width+2, bounds.height);
		g.setForegroundColor(ColorConstants.lightGray);
		g.drawRectangle(b.x, b.y, b.width-1, b.height-1);
	}
}
