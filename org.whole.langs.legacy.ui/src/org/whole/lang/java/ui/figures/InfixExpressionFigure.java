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
package org.whole.lang.java.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.RoundBracketsBorder;
import org.whole.lang.ui.layout.RowLayout;

public class InfixExpressionFigure extends ContentPaneFigure {
	private IFigure operand;
	private IFigure extendedOperands;
	private boolean showLeftParentheses;
	private boolean showRightParentheses;

	public InfixExpressionFigure() {
		super(new RowLayout().withSpacing(4));
		initContentPanes(4);

		add(createContentPane(0));

		operand = createContentPane(1);
		add(operand);

		add(createContentPane(2));

		extendedOperands = createContentPane(3);
		add(extendedOperands);
	}

	public void showExtendedOperands(boolean visible) {
		extendedOperands.setVisible(visible);
	}

	public void showLeftParentheses(boolean showLeftParentheses) {
		int margin = showLeftParentheses ? RoundBracketsBorder.HMARGIN+1 : 0;
		getContentPane(0).getLayoutManager()
			.withMarginLeft(margin).withMarginRight(margin);
		this.showLeftParentheses = showLeftParentheses;
	}

	public void showRightParentheses(boolean showRightParentheses) {
		int margin = showRightParentheses ? RoundBracketsBorder.HMARGIN+1 : 0;
		getContentPane(2).getLayoutManager()
			.withMarginLeft(margin).withMarginRight(margin);
		this.showRightParentheses = showRightParentheses;
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		int spacing = Math.max(1, getLayoutManager().getSpacing()/2);

		Color color = g.getForegroundColor();
		g.setForegroundColor(FigureConstants.contentLighterColor);

		if (showLeftParentheses)
			RoundBracketsBorder.paintRoundBrackets(g, getContentPane(0)
					.getBounds().getShrinked(spacing, 0));

		if (showRightParentheses)
			RoundBracketsBorder.paintRoundBrackets(g, getContentPane(2)
					.getBounds().getShrinked(spacing, 0));
		
		g.setForegroundColor(color);
	}
}
