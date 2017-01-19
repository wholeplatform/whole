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
import org.whole.lang.ui.figures.RoundBracketsBorder;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.SubLayout;

/**
 * @author Riccardo Solmi
 */
public class CollectByExpressionFigure extends ContentPaneFigure {
	public CollectByExpressionFigure(String label) {
		super(new RowLayout().withSpacing(2));
		initContentPanes(2);

		EntityFigure collectFigure = new EntityFigure(new SubLayout());
		collectFigure.add(LabelFactory.createSymbolLargeContent(label));
		EntityFigure subFigure = new EntityFigure(new RowLayout().withSpacing(2));
		subFigure.add(createFoldingToggle(0));
		subFigure.add(createContentPane(0));
		collectFigure.add(subFigure);
		add(collectFigure);
		add(createContentPane(1, new RoundBracketsBorder()));

		clickFoldingToggle(0);
	}
}
