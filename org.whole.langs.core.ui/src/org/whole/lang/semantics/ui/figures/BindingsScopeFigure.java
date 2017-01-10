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
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.PlaceHolderFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.OverColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class BindingsScopeFigure extends ContentPaneFigure {
	private static int NESTED_SCOPE_SPACING = 6;

	public BindingsScopeFigure() {
		super(new OverColumnLayout().withMinorAlignment(Alignment.CENTER)
				.withMarginTop(1).withSpacing(1));
		initContentPanes(3);

		add(createContentPane(2, new MarginBorder(0,0,NESTED_SCOPE_SPACING,0)));
		add(createContentPane(0, new MarginBorder(1,4,0,4)));
		add(createContentPane(1));
	}

	public void showNestedScope(boolean value) {
		getContentPane(2).setVisible(value);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle bounds = getBounds();
		Rectangle cb0 = getContentPane(0).getBounds();
		Rectangle cb1 = getContentPane(1).getBounds();

		g.setBackgroundColor(FigureConstants.templateLanguageColor);
		if (getContentPane(1).getChildren().get(0) instanceof PlaceHolderFigure)
			g.fillRectangle(bounds.x, cb1.y, bounds.width, bounds.bottom()-cb1.y);

		int oldAlpha = g.getAlpha();
		g.setAlpha(FigureConstants.templateLanguageAlpha);
		g.fillRectangle(bounds.x, cb0.y, bounds.width, cb1.y-bounds.y-1);
		g.setAlpha(oldAlpha);

		g.setForegroundColor(ColorConstants.lightGray);
		g.drawLine(bounds.x, cb1.y-1, bounds.right()-1, cb1.y-1);
		g.setForegroundColor(ColorConstants.gray);
		g.drawRectangle(bounds.x, cb0.y, bounds.width-1, bounds.bottom()-cb0.y-1);

		if (getContentPane(2).isVisible()) {
			Rectangle cb2 = getContentPane(2).getBounds();

			g.setForegroundColor(ColorConstants.black);
			int x = cb2.getCenter().x;
			g.drawLine(x, cb0.y, x, cb2.bottom()-NESTED_SCOPE_SPACING);
		}
	}
}
