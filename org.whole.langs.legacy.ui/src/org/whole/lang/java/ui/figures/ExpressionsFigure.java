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

import java.util.BitSet;

import org.eclipse.draw2d.Graphics;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.ParenthesizedStringSeparatedCompositeRowFigure;
import org.whole.lang.ui.figures.RoundBracketsBorder;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Enrico Persiani
 */
public class ExpressionsFigure extends ContentPaneFigure {
	private ParenthesizedStringSeparatedCompositeRowFigure compositeFigure;
	private IEntityFigure openParenthesis;
	private EntityLabel firstOperator;
	private IEntityFigure closeParenthesis;
	private Color color = FigureConstants.contentLightColor;
	private Font font = FigureConstants.contentLightFont;

	public ExpressionsFigure() {
		super(new RowLayout().withSpacing(RoundBracketsBorder.HMARGIN+2));
		initContentPanes(1);
		openParenthesis = addContentLighter("[");
		firstOperator = addContent("+");
		compositeFigure = new ParenthesizedStringSeparatedCompositeRowFigure("-", 16) {
			@Override
			public Color getLocalForegroundColor() {
				return color;
			}
			@Override
			protected void paintFigure(Graphics g) {
				g.setFont(ExpressionsFigure.this.font);
				super.paintFigure(g);
			}
		};
		add(createContentPane(0, compositeFigure));
		closeParenthesis = addContentLighter("]");
	}

	public void setShowParentheses(BitSet showParentheses) {
		compositeFigure.setShowParentheses(showParentheses);
	}

	public static enum DecorationEnum {
		UNKNOWN, SEPARATORS, PARENTHESIS, PLUS_OPERATORS, TIMES_OPERATORS
	}

	public void setDecoration(DecorationEnum decoration) {
		openParenthesis.setVisible(false);
		firstOperator.setVisible(false);
		closeParenthesis.setVisible(false);

		switch (decoration) {
		case SEPARATORS:
			compositeFigure.setSeparator(",");
			compositeFigure.getLayoutManager().withSpacing(16);
			color = FigureConstants.contentLightColor;
			font = FigureConstants.contentLightFont;
			break;

		case PARENTHESIS:
			compositeFigure.setSeparator("][");
			compositeFigure.getLayoutManager().withSpacing(24);
			openParenthesis.setVisible(true);
			closeParenthesis.setVisible(true);
			color = FigureConstants.contentLighterColor;
			font = FigureConstants.contentLighterFont;
			break;

		case PLUS_OPERATORS:
			firstOperator.setVisible(true);
			firstOperator.setText("+");
			compositeFigure.setSeparator("+");
			compositeFigure.getLayoutManager().withSpacing(16);
			color = FigureConstants.contentColor;
			font = FigureConstants.contentFont;
			break;

		case TIMES_OPERATORS:
			firstOperator.setVisible(true);
			firstOperator.setText("*");
			compositeFigure.setSeparator("*");
			compositeFigure.getLayoutManager().withSpacing(16);
			color = FigureConstants.contentColor;
			font = FigureConstants.contentFont;
			break;

		case UNKNOWN:
			compositeFigure.setSeparator("-");
			compositeFigure.getLayoutManager().withSpacing(16);
			color = FigureConstants.contentLightColor;
			font = FigureConstants.contentLightFont;
			break;
		}
	}
}
