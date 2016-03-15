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
package org.whole.lang.semantics.ui.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.DoubleSquareBracketsBorder;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableRowLayout;

/**
 * @author Riccardo Solmi
 */
public class RuleFigure extends ContentPaneFigure {
	Border configurationBorder;

	public RuleFigure(String symbol) {
		super(new TableRowLayout());
		initContentPanes(3);

		EntityFigure row = new EntityFigure(new RowLayout().withSpacing(2).withMarginTop(1).withMarginBottom(1));
		row.add(createContentPane(0));
		row.add(createContentPane(1, configurationBorder = new DoubleSquareBracketsBorder()));
		add(row);
//		addLabel(symbol).setFont(WholeUIPlugin.getOpenSymbolMediumFont());
		if (symbol.equals("\u25b7"))
			add(createContentPane(2, new MarginBorder(4)));
		else			
			add(createContentPane(2));//, new MarginBorder(4)));
	}

	public void showName(final boolean value) {
		getContentPane(0).setVisible(value);
		getContentPane(1).setBorder(value ? configurationBorder : null);
	}
}
