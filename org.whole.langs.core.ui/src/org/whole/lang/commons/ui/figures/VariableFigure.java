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
package org.whole.lang.commons.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class VariableFigure extends ContentPaneFigure {
	public VariableFigure() {
		super(new RowLayout().withSpacing(3).withMarginLeft(4).withMarginRight(3));
		initContentPanes(3);

		add(createFoldingToggle(0));
		add(createContentPane(0));
		add(createContentPane(1));
		add(createContentPane(2));

		clickFoldingToggle(0);
	}

	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds();
		Rectangle nameBounds = getContentPane(1).getBounds();

		setPaintStyle(graphics);
		graphics.setBackgroundColor(FigureConstants.hostLanguageColor);
		graphics.fillRectangle(nameBounds.x-1, bounds.y, nameBounds.width+2, bounds.height);
		graphics.setForegroundColor(ColorConstants.lightGray);
		graphics.drawRoundRectangle(bounds.getResized(-1, -1), 8, 8);
	}
	protected void setPaintStyle(Graphics graphics) {
	}
}
