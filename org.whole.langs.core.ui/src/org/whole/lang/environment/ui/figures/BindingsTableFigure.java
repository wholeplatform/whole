/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.environment.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class BindingsTableFigure extends TableFigure {
	public BindingsTableFigure(boolean withHeader) {
		super(4);
		getLayoutManager().withRowSpacing(0).withColumnSpacing(8).withMargin(0);

		if (withHeader) {
			TableRowFigure headers = new TableRowFigure();
			headers.getLayoutManager().withMargin(16,4,4,4);
			headers.addContentLight("Id");
			headers.addContentLight("Type");
			headers.addContentLight("Name");
			headers.addContentLight("  Value");
			add(headers, TableLayout.Placement.HEADER);
		}
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		g.setBackgroundColor(ColorConstants.darkGray);
		drawHeadersRowBackground(g);

		g.setBackgroundColor(ColorConstants.white);
		drawAlternateRowsBackground(g, 0, 255);
		drawAlternateRowsBackground(g, 1, 255);

		g.setForegroundColor(ColorConstants.lightGray);
		drawColumnSeparators(g);
		drawRowSeparators(g);
		drawHeadersRowSeparator(g);

		TableLayout l = getLayoutManager();
		if (l.rows()>0) {
			g.setBackgroundColor(ColorConstants.darkGray);
			int oldAlpha = g.getAlpha();
			g.setAlpha(getBackgroundAlpha()/2);
			Rectangle tb = getTableBounds();
			Rectangle cb = l.getColumnBounds(3);
			g.fillRectangle(cb.x, tb.y, 16, tb.height);
			g.setAlpha(oldAlpha);
		}

		g.setForegroundColor(ColorConstants.gray);
		drawTableBorder(g);
	}
}
