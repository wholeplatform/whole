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
package org.whole.lang.environment.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.EyeFigure;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class BindingsTableFigure extends TableFigure {
	public BindingsTableFigure(boolean withHeader) {
		super(5);
		getLayoutManager().withRowSpacing(0).withColumnSpacing(8).withMargin(0);

		if (withHeader) {
			TableRowFigure headers = new TableRowFigure();
			headers.getLayoutManager().withMargin(16,4,4,4);
			headers.addContentLight("Id");
			headers.addContentLight("Type");
			headers.addContentLight("Name");
			headers.add(new EyeFigure());
			headers.addContentLight("Value");
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

		g.setBackgroundColor(ColorConstants.lightGray);
		drawAlternateColumnsBackground(g, 3);

		g.setForegroundColor(ColorConstants.lightGray);
		for (int i = 1; i < 4; i++)
			drawColumnSeparatorBefore(g, i);
		drawRowSeparators(g);
		drawHeadersRowSeparator(g);

		g.setForegroundColor(ColorConstants.gray);
		drawTableBorder(g);
	}
}
