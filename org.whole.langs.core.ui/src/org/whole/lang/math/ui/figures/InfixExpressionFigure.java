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
package org.whole.lang.math.ui.figures;

import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.RoundBracketsBorder;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class InfixExpressionFigure extends ContentPaneFigure {
	public InfixExpressionFigure(String operatorSymbol) {
		this(LabelFactory.createSymbolRegularContent(operatorSymbol));
	}
	public InfixExpressionFigure(IEntityFigure operatorSymbol) {
		super(new RowLayout().withSpacing(1));
		initContentPanes(2);

		add(createContentPane(0));
		add(operatorSymbol);
		add(createContentPane(1));

    	showLeftParen(false);
    	showRightParen(false);
	}

    public void showLeftParen(boolean val) {
    	getContentPane(0).setBorder(
    			val ? RoundBracketsBorder.PARENTHESIS : CompositePlaceHolderBorder.OPTIONAL_HORIZONTAL);
    }

    public void showRightParen(boolean val) {
    	getContentPane(1).setBorder(
    			val ? RoundBracketsBorder.PARENTHESIS : CompositePlaceHolderBorder.OPTIONAL_HORIZONTAL);
    }
}
