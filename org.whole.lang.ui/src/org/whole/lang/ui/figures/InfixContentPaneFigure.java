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
package org.whole.lang.ui.figures;

import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class InfixContentPaneFigure extends ContentPaneFigure {
	public InfixContentPaneFigure(String operator) {
		this(operator, 4);
	}
	public InfixContentPaneFigure(String operator, int spacing) {
		this(LabelFactory.createContentLight(operator), spacing);
	}
	public InfixContentPaneFigure(IEntityFigure operator, int spacing) {
		super(new RowLayout().withSpacing(spacing));
		initContentPanes(2);

		add(createContentPane(0));
		add(operator);
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
