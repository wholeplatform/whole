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
package org.whole.lang.ui.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Riccardo Solmi
 */
public class RoundBracketsBorder extends MarginBorder {
	public static final int HMARGIN = 5;
	public static final Border PARENTHESIS = new RoundBracketsBorder() {
		@Override
		protected void setBracketsStyle(Graphics g) {
			g.setForegroundColor(FigureConstants.contentLighterColor);
		}
	};

	public RoundBracketsBorder() {
		this(true, true);
	}
	public RoundBracketsBorder(boolean left, boolean right) {
		super(0, left ? HMARGIN :  0, 0, right ? HMARGIN : 0);
	}

	public void paint(IFigure f, Graphics g, Insets i) {
		setBracketsStyle(g);
		paintRoundBrackets(g, getPaintRectangle(f, i).resize(-1, -2), insets.left, insets.right);
	}
	protected void setBracketsStyle(Graphics g) {
		g.setForegroundColor(ColorConstants.black);
	}

	public static void paintRoundBrackets(Graphics g, Rectangle bounds) {
		paintRoundBrackets(g, bounds, HMARGIN, HMARGIN);
	}
	public static void paintRoundBrackets(Graphics g, Rectangle bounds, int leftMargin, int rightMargin) {
		if (leftMargin > 0) {
			final int leftSize = leftMargin + 1;
			g.drawArc(bounds.x, bounds.y, leftSize, leftSize*2, 90, 90);
			if (bounds.y+leftMargin < bounds.bottom()-leftMargin)
				g.drawLine(bounds.x, bounds.y+leftMargin, bounds.x, bounds.bottom()-leftMargin);
			g.drawArc(bounds.x, bounds.bottom()-leftSize*2, leftSize, leftSize*2, 180, 90);
		}
		if (rightMargin > 0) {
			final int rightSize = rightMargin + 1;
			g.drawArc(bounds.right()-rightSize, bounds.y, rightSize, rightSize*2, 0, 90);
			if (bounds.y+rightMargin < bounds.bottom()-rightMargin)
				g.drawLine(bounds.right(), bounds.y+rightMargin, bounds.right(), bounds.bottom()-rightMargin);
			g.drawArc(bounds.right()-rightSize, bounds.bottom()-rightSize*2, rightSize, rightSize*2, 0, -90);
		}
	}
}
