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
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.UnderColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class PatternApplicationFigure extends ContentPaneFigure {
	public PatternApplicationFigure() {
		super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING)
				.withMargin(2, 4, 4, 4));
		initContentPanes(2);
		setBorder(new DoubleSquareBracketsBorder());

		add(createContentPane(0));
		add(createContentPane(1));
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		int oldAlpha = g.getAlpha();
		g.setAlpha(FigureConstants.templateLanguageAlpha);

		Rectangle cb = getBounds().getShrinked(6, 1);
		Rectangle cb0 = getContentPane(0).getBounds();
		g.setBackgroundColor(FigureConstants.templateLanguageColor);
		g.setForegroundColor(ColorConstants.lightGray);

		g.fillRectangle(cb.x, cb.y, cb.width, cb0.height+2);
		g.fillRectangle(cb.x, cb.y, 4, cb.height);
		g.fillRectangle(cb.right()-4, cb.y, 4, cb.height);
		g.fillRectangle(cb.x, cb.bottom()-4, cb.width, 4);
		g.setAlpha(oldAlpha);
		g.drawRectangle(cb.getResized(-1, -1));
	}
}
