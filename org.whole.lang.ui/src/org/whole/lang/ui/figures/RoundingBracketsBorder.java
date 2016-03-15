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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Riccardo Solmi
 */
public class RoundingBracketsBorder  extends MarginBorder {
	private static final int HSIZE = 4;
	private static final int HMARGIN = 5;

	private boolean left, right;

	public RoundingBracketsBorder(boolean left, boolean right) {
		super(0, HMARGIN, 0, HMARGIN);
		this.left = left;
		this.right = right;
	}

	public void paint(IFigure f, Graphics g, Insets i) {
		Rectangle r = getPaintRectangle(f, i);
		r.width--;
		r.height--;

		setBracketsStyle(g);

		g.drawLine(r.x, r.y, r.x, r.bottom());
		g.drawLine(r.right(), r.y, r.right(), r.bottom());

		if (left)
			g.drawLine(r.x, r.y, r.x+HSIZE, r.y);
		else
			g.drawLine(r.x, r.bottom(), r.x+HSIZE, r.bottom());

		if (right)
			g.drawLine(r.right()-HSIZE, r.y, r.right(), r.y);
		else
			g.drawLine(r.right()-HSIZE, r.bottom(), r.right(), r.bottom());
	}
	protected void setBracketsStyle(Graphics g) {
		g.setForegroundColor(ColorConstants.black);
	}
}
