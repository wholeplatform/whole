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
public class DoubleRoundBracketsBorder extends MarginBorder {
	private static final int HSPACING = 3;
	private static final int HMARGIN = 3+HSPACING;
	private static final int HSIZE = HMARGIN+1;
	public static final Border PARENTHESIS = new DoubleRoundBracketsBorder() {
		@Override
		protected void setBracketsStyle(Graphics g) {
			g.setForegroundColor(FigureConstants.contentLighterColor);
		}
	};

	public DoubleRoundBracketsBorder() {
		this(true, true);
	}
	public DoubleRoundBracketsBorder(boolean left, boolean right) {
		super(0, left ? HMARGIN :  0, 0, right ? HMARGIN : 0);
	}

	public void paint(IFigure f, Graphics g, Insets i) {
		Rectangle r = getPaintRectangle(f, i);
		r.width--;
		r.height-=2;

		setBracketsStyle(g);

		if (insets.left > 0) {
			g.drawArc(r.x, r.y, HSIZE, HSIZE*2, 90, 90);
			if (r.y+HMARGIN < r.bottom()-HMARGIN)
				g.drawLine(r.x, r.y+HMARGIN, r.x, r.bottom()-HMARGIN);
			g.drawArc(r.x, r.bottom()-HSIZE*2, HSIZE, HSIZE*2, 180, 90);

			g.drawArc(r.x+HSPACING, r.y, HSIZE, HSIZE*2, 90, 90);
			if (r.y+HMARGIN < r.bottom()-HMARGIN)
				g.drawLine(r.x+HSPACING, r.y+HMARGIN, r.x+HSPACING, r.bottom()-HMARGIN);
			g.drawArc(r.x+HSPACING, r.bottom()-HSIZE*2, HSIZE, HSIZE*2, 180, 90);
		}
		if (insets.right > 0) {
			g.drawArc(r.right()-HSIZE, r.y, HSIZE, HSIZE*2, 0, 90);
			if (r.y+HMARGIN < r.bottom()-HMARGIN)
				g.drawLine(r.right(), r.y+HMARGIN, r.right(), r.bottom()-HMARGIN);
			g.drawArc(r.right()-HSIZE, r.bottom()-HSIZE*2, HSIZE, HSIZE*2, 0, -90);

			g.drawArc(r.right()-HSIZE-HSPACING, r.y, HSIZE, HSIZE*2, 0, 90);
			if (r.y+HMARGIN < r.bottom()-HMARGIN)
				g.drawLine(r.right()-HSPACING, r.y+HMARGIN, r.right()-HSPACING, r.bottom()-HMARGIN);
			g.drawArc(r.right()-HSIZE-HSPACING, r.bottom()-HSIZE*2, HSIZE, HSIZE*2, 0, -90);
		}
	}
	protected void setBracketsStyle(Graphics g) {
		g.setForegroundColor(ColorConstants.black);
	}
}
