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
package org.whole.lang.sql.ui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Riccardo Solmi
 */
public class SelectStatementFigure extends ContentPaneFigure {
	private EntityFigure row2, row3, row4, row5, row6;

	public SelectStatementFigure() {
		super(new ColumnLayout());
		initContentPanes(7);
		EntityFigure row;
		add(row = new EntityFigure(new RowLayout().withSpacing(4)));
		row.add(createFoldingToggle(7, 2, 3, 4, 5, 6));
		row.addKeyword("SELECT");
		row.add(createContentPane(0));
		row.add(createContentPane(1));
		add(row2 = new EntityFigure(new RowLayout().withSpacing(4)));
		row2.add(new EntityLabel("    "));
		row2.addKeyword("FROM");
		row2.add(createContentPane(2));
		add(row3 = new EntityFigure(new RowLayout().withSpacing(4)));
		row3.add(new EntityLabel("    "));
		row3.addKeyword("WHERE");
		row3.add(createContentPane(3));
		add(row4 = new EntityFigure(new RowLayout().withSpacing(4)));
		row4.add(new EntityLabel("    "));
		row4.addKeyword("GROUP BY");
		row4.add(createContentPane(4));
		add(row5 = new EntityFigure(new RowLayout().withSpacing(4)));
		row5.add(new EntityLabel("    "));
		row5.addKeyword("HAVING");
		row5.add(createContentPane(5));
		add(row6 = new EntityFigure(new RowLayout().withSpacing(4)));
		row6.add(new EntityLabel("    "));
		row6.addKeyword("ORDER BY");
		row6.add(createContentPane(6));
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 7) {
			boolean visible = !row2.isVisible();
			row2.setVisible(visible);
			row3.setVisible(visible);
			row4.setVisible(visible);
			row5.setVisible(visible);
			row6.setVisible(visible);
		} else
			super.toggleVisibility(paneIndex);
	}
}
