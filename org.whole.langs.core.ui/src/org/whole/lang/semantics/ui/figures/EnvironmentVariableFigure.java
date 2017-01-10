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
package org.whole.lang.semantics.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.OverLayout;

/**
 * @author Riccardo Solmi
 */
public class EnvironmentVariableFigure extends ContentPaneFigure {
	public EnvironmentVariableFigure() {
		super(new OverLayout().withMarginLeft(5).withMarginRight(3));
		initContentPanes(2);

		add(createContentPane(1));
		add(createContentPane(0));

		setBorder(new LineBorder(ColorConstants.gray, 1));
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle bounds = getBounds();
		Rectangle cb1 = getContentPane(1).getBounds();

		g.setBackgroundColor(FigureConstants.templateLanguageColor);
		int oldAlpha = g.getAlpha();
		g.setAlpha(FigureConstants.templateLanguageAlpha);
		g.fillRectangle(bounds);
		g.setAlpha(oldAlpha);

		g.setForegroundColor(ColorConstants.lightGray);
		g.drawLine(bounds.x, cb1.y-1, bounds.right()-1, cb1.y-1);
	}
}
