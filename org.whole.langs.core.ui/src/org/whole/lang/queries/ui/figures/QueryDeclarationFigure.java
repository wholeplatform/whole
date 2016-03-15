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
package org.whole.lang.queries.ui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class QueryDeclarationFigure extends ContentPaneFigure {
	public QueryDeclarationFigure() {
		super(new UnderColumnLayout().withMarginTop(4).withMarginBottom(12).withMinorAlignment(Alignment.LEADING));
		initContentPanes(3);

		EntityFigure row1 = new EntityFigure(new RowLayout().withSpacing(2));
		row1.add(createFoldingToggle(2));
		row1.addKeyword("query ");
		row1.add(createContentPane(0));

		EntityFigure col1 = new EntityFigure(new ColumnLayout().withSpacing(4)
				.withMargin(4, 0, 4, 0).withMinorAlignment(Alignment.LEADING));
		col1.add(createContentPane(1));
		col1.add(createContentPane(2));
		col1.setBorder(new ScopeBracketsBorder(2,1,2,1));

		add(row1);
		add(col1);

		clickFoldingToggle(0);
	}
}
