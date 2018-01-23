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
package org.whole.lang.queries.ui.editparts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.FigureConstants;

/**
 * @author Riccardo Solmi
 */
public class ScopeNamesBorder extends MarginBorder {
	private static final int HMARGIN = 6;
	private static final int ARROW_SIZE = 4;

	public ScopeNamesBorder() {
		super(0, 1, HMARGIN, 1);
	}

	public void paint(IFigure f, Graphics g, Insets i) {
		Rectangle r = getPaintRectangle(f, i);
		r.width--;
		r.height--;

		setBracketsStyle(g);

		int cx = r.getCenter().x;
		int aw = 16;

		if (r.width < aw*2) {
			g.drawLine(cx, r.bottom(), r.x+1, r.bottom()-ARROW_SIZE);
			g.drawLine(cx, r.bottom(), r.right()-1, r.bottom()-ARROW_SIZE);
		} else {
			g.drawLine(cx-aw, r.bottom()-ARROW_SIZE, r.x+4, r.bottom()-ARROW_SIZE);
			g.drawLine(cx, r.bottom(), cx-aw, r.bottom()-ARROW_SIZE);
			g.drawLine(cx, r.bottom(), cx+aw, r.bottom()-ARROW_SIZE);
			g.drawLine(cx+aw, r.bottom()-ARROW_SIZE, r.right()-4, r.bottom()-ARROW_SIZE);
		}
	}
	protected void setBracketsStyle(Graphics g) {
		g.setForegroundColor(FigureConstants.identifiersColor);
	}
}
