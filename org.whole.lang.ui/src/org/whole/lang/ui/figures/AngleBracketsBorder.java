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
public class AngleBracketsBorder extends MarginBorder {
	private static final int HSIZE = 4;
	private static final int HMARGIN = 5;

	public AngleBracketsBorder() {
		this(true, true);
	}
	public AngleBracketsBorder(boolean left, boolean right) {
		super(0, left ? HMARGIN :  0, 0, right ? HMARGIN : 0);
	}

	public void paint(IFigure f, Graphics g, Insets i) {
		Rectangle r = getPaintRectangle(f, i);
		r.width--;
		r.height--;
		int centerY = r.y + r.height/2;

		setBracketsStyle(g);

		if (insets.left > 0) {
			g.drawLine(r.x, centerY, r.x+HSIZE, r.y);
			g.drawLine(r.x, centerY, r.x+HSIZE, r.bottom());
		}
		if (insets.right > 0) {
			g.drawLine(r.right()-HSIZE, r.y, r.right(), centerY);
			g.drawLine(r.right()-HSIZE, r.bottom(), r.right(), centerY);
		}
	}
	protected void setBracketsStyle(Graphics g) {
		g.setForegroundColor(ColorConstants.black);
	}
}
