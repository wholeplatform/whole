/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
public class SetClauseFigure extends ContentPaneFigure {
	private EntityFigure row2, row3, row4;

    public SetClauseFigure() {
        super(new ColumnLayout());
        initContentPanes(2);
        EntityFigure row;
        add(row = new EntityFigure(new RowLayout().withSpacing(4)));
        row.add(createFoldingToggle(2));
        row.addKeyword("SET");
        row.addContentLight("(");
        add(row2 = new EntityFigure(new RowLayout().withSpacing(4)));
        row2.add(new EntityLabel("    "));
        row2.add(createContentPane(0));
        add(row3 = new EntityFigure(new RowLayout().withSpacing(4)));
        row3.add(new EntityLabel("    "));
        row3.add(createContentPane(1));
        add(row4 = new EntityFigure(new RowLayout().withSpacing(4)));
        row4.add(new EntityLabel("    "));
        row4.addContentLight(")");
    }


	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 2) {
			boolean visible = !row2.isVisible();
			row2.setVisible(visible);
			row3.setVisible(visible);
			row4.setVisible(visible);
		} else
			super.toggleVisibility(paneIndex);
	}
}
