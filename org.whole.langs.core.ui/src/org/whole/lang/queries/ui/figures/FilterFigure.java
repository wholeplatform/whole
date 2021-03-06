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
package org.whole.lang.queries.ui.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.RoundBracketsBorder;
import org.whole.lang.ui.figures.SquareBracketsBorder;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class FilterFigure extends ContentPaneFigure {
	private Border expressionBorder;
	private Border predicateBorder;

	public FilterFigure() {
		super(new RowLayout().withSpacing(1));
		initContentPanes(2);
		
		add(createContentPane(0, expressionBorder = new RoundBracketsBorder() {
			@Override
			protected void setBracketsStyle(Graphics g) {
				g.setForegroundColor(FigureConstants.contentLightColor);
			}
		}));
		add(createContentPane(1, predicateBorder = new SquareBracketsBorder(4, 4)));
	}

	public void showExpressionClause(boolean showExpression, boolean showBorder) {
		getContentPane(0).setVisible(showExpression);
		if (showExpression)
			getContentPane(0).setBorder(showBorder ? expressionBorder : null);
	}
	public void showPredicateBorder(boolean value) {
		getContentPane(1).setBorder(value ? predicateBorder : null);
	}
}
