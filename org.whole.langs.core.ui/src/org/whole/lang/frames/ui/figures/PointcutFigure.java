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
package org.whole.lang.frames.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.PipeBracketsBorder;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class PointcutFigure extends ContentPaneFigure {
	EntityFigure headerFigure;
	IFigure keywordFigure;

	public PointcutFigure() {
		super(new ColumnLayout().withMinorAlignment(Alignment.LEADING)
				.withSpacing(4).withMarginTop(1).withMarginBottom(4));
		initContentPanes(2);

		add(createContentPane(0));

		headerFigure = new EntityFigure(new RowLayout()
				.withMinorAlignment(Alignment.MATHLINE)
				.withMarginTop(1).withMarginBottom(3).withSpacing(4));
		
		keywordFigure = headerFigure.addKeyword("@");
		keywordFigure.setBorder(new MarginBorder(0,5,0,5));
		headerFigure.add(createContentPane(1));
		add(headerFigure);
		
		setBorder(new PipeBracketsBorder(0, 6, 0, 0) {
			@Override
			protected void setBracketsStyle(Graphics g) {
				g.setForegroundColor(ColorConstants.lightGray);
				g.setLineWidth(3);
			}
		});
	}

	@Override
	public void paint(Graphics graphics) {
		Rectangle bounds = getBounds();
		Rectangle fillBounds = headerFigure.getBounds().getCopy();
		fillBounds.width = keywordFigure.getBounds().width + fillBounds.x - bounds.x;
		fillBounds.x = bounds.x;
		fillBounds.height = bounds.y + bounds.height - fillBounds.y - 1;

		graphics.setBackgroundColor(ColorConstants.lightGray);
		graphics.fillRectangle(fillBounds);
		
		super.paint(graphics);
	}
}
