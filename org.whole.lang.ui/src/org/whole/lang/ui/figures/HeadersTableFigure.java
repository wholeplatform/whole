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
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Riccardo Solmi
 */
public class HeadersTableFigure extends TableFigure {
	public HeadersTableFigure() {
		this(2);
	}
	public HeadersTableFigure(int columns) {
		super(columns);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		final int SIZE = 12;
		g.setForegroundColor(ColorConstants.lightGray);
		Rectangle r = getTableBounds();
		g.drawLine(r.x, r.y, r.x, r.bottom()-1);
		g.drawLine(r.right()-1, r.y, r.right()-1, r.bottom()-1-SIZE);
		g.drawLine(r.x, r.y, r.right()-1, r.y);
		g.drawLine(r.x, r.bottom()-1, r.right()-1-SIZE, r.bottom()-1);
		g.drawLine(r.right()-1, r.bottom()-1-SIZE, r.right()-1-SIZE, r.bottom()-1);
	}
}
