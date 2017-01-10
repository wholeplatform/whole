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

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.DoubleSquareBracketsBorder;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class TypeCastFigure extends ContentPaneFigure {
//	protected boolean asStageDown;

	public TypeCastFigure() {
		super(new RowLayout().withSpacing(2).withMargin(2));
		initContentPanes(2);

		add(createContentPane(0));
		add(createContentPane(1, new DoubleSquareBracketsBorder()));
	}

	public void showName(final boolean value) {
		getContentPane(0).setVisible(value);
	}
	
//	public void showAsStageDown(boolean value) {
//		if (asStageDown != value) {
//			asStageDown = value;
//			repaint();
//		}
//	}

//	protected void paintFigure(Graphics g) {
//		super.paintFigure(g);
//
//		if (asStageDown) {
//			Rectangle b = getBounds();
//
//			g.setBackgroundColor(FigureConstants.hostLanguageColor);
//			g.setForegroundColor(ColorConstants.lightGray);
//			g.fillRectangle(b.x, b.y, b.width, b.height);
//			g.drawRectangle(b.x, b.y, b.width-1, b.height-1);
//		}
//	}
}
