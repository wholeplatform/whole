/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigurePrefs;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.StringSeparatedCompositeRowFigure;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Enrico Persiani
 */
public class ExpressionsFigure extends ContentPaneFigure {
	private StringSeparatedCompositeRowFigure compositeFigure;
	private IEntityFigure openParenthesis;
	private IEntityFigure firstOperator;
	private IEntityFigure closeParenthesis;
	private Color color = FigurePrefs.contentLightColor;
	private Font font = FigurePrefs.contentLightFont;

	public ExpressionsFigure() {
		super(new RowLayout().withSpacing(0));
		initContentPanes(1);
		openParenthesis = addContentLighter("[");
		firstOperator = addContentLight("+");
		compositeFigure = new StringSeparatedCompositeRowFigure("-", 16) {
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

	public static enum DecorationEnum {
		UNKNOWN, SEPARATORS, PARENTHESIS, OPERATORS
	}

	public void setDecoration(DecorationEnum decoration) {
		openParenthesis.setVisible(false);
		firstOperator.setVisible(false);
		closeParenthesis.setVisible(false);

		switch (decoration) {
		case SEPARATORS:
			compositeFigure.setSeparator(",");
			compositeFigure.getLayoutManager().withSpacing(16);
			color = FigurePrefs.contentLightColor;
			font = FigurePrefs.contentLightFont;
			break;

		case PARENTHESIS:
			compositeFigure.setSeparator("][");
			compositeFigure.getLayoutManager().withSpacing(24);
			openParenthesis.setVisible(true);
			closeParenthesis.setVisible(true);
			color = FigurePrefs.contentLighterColor;
			font = FigurePrefs.contentLighterFont;
			break;

		case OPERATORS:
			compositeFigure.setSeparator("+");
			compositeFigure.getLayoutManager().withSpacing(16);
			firstOperator.setVisible(true);
			color = FigurePrefs.contentLightColor;
			font = FigurePrefs.contentLightFont;
			break;

		case UNKNOWN:
			compositeFigure.setSeparator("-");
			compositeFigure.getLayoutManager().withSpacing(16);
			color = FigurePrefs.contentLightColor;
			font = FigurePrefs.contentLightFont;
			break;
		}
	}
}
