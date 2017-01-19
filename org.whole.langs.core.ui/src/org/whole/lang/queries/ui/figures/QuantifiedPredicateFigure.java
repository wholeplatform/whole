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
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.SquareBracketsBorder;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class QuantifiedPredicateFigure extends ContentPaneFigure {
	protected EntityFigure whereClause;
	protected boolean forceWhereClause;

	public QuantifiedPredicateFigure(String quantifier, boolean forceWhereClause) {
		super(new RowLayout().withSpacing(2));
		initContentPanes(2);

		add(LabelFactory.createSymbolRegularContent(quantifier));
		add(createContentPane(0));
		
		whereClause = new EntityFigure(new RowLayout().withSpacing(2));
		whereClause.add(LabelFactory.createSymbolRegularContent(":"));
		whereClause.add(createContentPane(1));
		add(whereClause);

		setBorder(new SquareBracketsBorder(4, 5));

		showWhereClause(this.forceWhereClause = forceWhereClause);
	}

	public void showWhereClause(boolean value) {
		whereClause.setVisible(forceWhereClause || value);
	}
}
