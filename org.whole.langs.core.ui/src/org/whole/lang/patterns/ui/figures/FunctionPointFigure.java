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
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.DoubleSquareBracketsBorder;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class FunctionPointFigure extends ContentPaneFigure {
	public FunctionPointFigure() {
		initContentPanes(3);
		setLayoutManager(new RowLayout().withSpacing(3).withMargin(2, 3, 2, 3));

		add(createFoldingToggle(0));
		add(createContentPane(0));
		add(createContentPane(1));
		add(createContentPane(2, new DoubleSquareBracketsBorder()));

		clickFoldingToggle(0);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle bounds = getBounds();
		Rectangle nameBounds = getContentPane(1).getBounds();
		
		g.setBackgroundColor(FigureConstants.hostLanguageColor);
		g.fillRectangle(nameBounds.x-1, bounds.y, bounds.width - nameBounds.x + bounds.x, bounds.height);
		g.setForegroundColor(ColorConstants.lightGray);
		g.drawRectangle(bounds.x, bounds.y, bounds.width-1, bounds.height-1);
	}
}
