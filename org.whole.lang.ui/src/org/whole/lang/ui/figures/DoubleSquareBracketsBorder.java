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
public class DoubleSquareBracketsBorder extends MarginBorder {
	private static final int HSIZE = 5;
	private static final int HMARGIN = 6;

	public DoubleSquareBracketsBorder() {
		this(true, true);
	}
	public DoubleSquareBracketsBorder(boolean left, boolean right) {
		this(left ? HMARGIN :  0, right ? HMARGIN : 0);
	}
	public DoubleSquareBracketsBorder(int left, int right) {
		super(0, left, 0, right);
	}

	public void paint(IFigure f, Graphics g, Insets i) {
		Rectangle r = getPaintRectangle(f, i);
		r.width--;
		r.height--;

		setBracketsStyle(g);

		int hsize = HSIZE;
		if (r.height > 100) {
			g.setLineWidth(3);
			hsize += 3;
		}

		if (insets.left > 0) {
			g.drawLine(r.x, r.y, r.x+hsize, r.y);
			g.drawLine(r.x, r.y, r.x, r.bottom());
			g.drawLine(r.x, r.bottom(), r.x+hsize, r.bottom());
		}
		if (insets.right > 0) {
			g.drawLine(r.right()-hsize, r.y, r.right(), r.y);
			g.drawLine(r.right(), r.y, r.right(), r.bottom());
			g.drawLine(r.right()-hsize, r.bottom(), r.right(), r.bottom());
		}

		int lgap = 2;
		int rgap = 2;
		if (r.height > 100) {
			g.setLineWidth(2);
			lgap += 2;
			rgap += 1;
		}

		if (insets.left > 0) {
			g.drawLine(r.x+lgap, r.y, r.x+lgap, r.bottom());
		}
		if (insets.right > 0) {
			g.drawLine(r.right()-rgap, r.y, r.right()-rgap, r.bottom());
		}
	}
	protected void setBracketsStyle(Graphics g) {
		g.setForegroundColor(ColorConstants.black);
	}
}
