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
package org.whole.lang.rdb.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Enrico Persiani
 */
public class ForeignKeysTableFigure extends TableFigure {
	public ForeignKeysTableFigure() {
		super(6);
		getLayoutManager().withColumnAlignment(4, Alignment.TRAILING);
		add(createTableHeadersRow(), TableLayout.Placement.HEADER);
	}

	protected TableRowFigure createTableHeadersRow() {
		TableRowFigure tableHeaderFigure = new TableRowFigure();
		tableHeaderFigure.addLabel("Name");
		tableHeaderFigure.addLabel("Target Table");
		tableHeaderFigure.addLabel("Update Action");
		tableHeaderFigure.addLabel("Delete Action");
		tableHeaderFigure.addLabel("Deferrability");
		tableHeaderFigure.addLabel("Column references");
		return tableHeaderFigure;
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		g.setBackgroundColor(ColorConstants.darkGreen);
		drawAlternateRowsBackground(g, 0);
		drawAlternateColumnsBackground(g, 1);

		g.setForegroundColor(ColorConstants.darkGreen);
		drawColumnSeparators(g);
//		drawRowSeparators(g);

		g.setLineWidth(getBorderLineWidth());
		drawTableColumnsBorder(g);
		drawTableRowsBorder(g);
	}

	protected int getBorderLineWidth() {
		return 2;
	}
}