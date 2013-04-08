/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigurePrefs;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class FunctionApplicationPointFigure extends ContentPaneFigure {
	public FunctionApplicationPointFigure() {
		initContentPanes(2);
		setLayoutManager(new RowLayout().withSpacing(3).withMargin(2, 3, 2, 3));

		add(createContentPane(0));
		add(createContentPane(1));
		EntityLabel brackets = LabelFactory.createKeyword();
		brackets.setBorder(new DoubleSquareBracketsBorder());
		add(brackets);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle b = getBounds();
		
		g.setBackgroundColor(FigurePrefs.hostLanguageColor);
		g.setForegroundColor(ColorConstants.lightGray);
		g.fillRectangle(b.x, b.y, b.width, b.height);
		g.drawRectangle(b.x, b.y, b.width-1, b.height-1);
	}
}
