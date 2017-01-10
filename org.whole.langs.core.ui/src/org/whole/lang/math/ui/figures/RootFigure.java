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
package org.whole.lang.math.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.RootLayout;

/**
 * @author Riccardo Solmi
 */
public class RootFigure extends ContentPaneFigure {
	public RootFigure() {
		super(new RootLayout().withSpacing(8));
		initContentPanes(2);

		add(createContentPane(0));
		add(createContentPane(1));
	}

	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle b0 = getLayoutManager().getBounds(0);
		Rectangle b1 = getLayoutManager().getBounds(1);
		int ascent = getAscent();
		int spacing = getLayoutManager().getSpacing()/2;

		g.setForegroundColor(FigureConstants.contentColor);
		g.drawLine(b0.right()-spacing-3, b0.y+ascent+2, b0.right()-spacing, b0.y+ascent);
		g.drawLine(b0.right()-spacing, b0.y+ascent, b0.right(), b1.bottom());
		g.drawLine(b0.right(), b1.bottom(), b1.x, b0.y);
		g.drawLine(b1.x, b0.y, b1.right(), b0.y);
	}
}
