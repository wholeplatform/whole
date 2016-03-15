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
package org.whole.lang.patterns.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.PipeBracketsBorder;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class CutFigure extends ContentPaneFigure {
	public CutFigure() {
		super(new OverLayout().withMinorAlignment(Alignment.LEADING)
				.withSpacing(4));
		initContentPanes(1);
//		setBorder(new PipeBracketsBorder(0, 1, 0, 1) {
//			@Override
//			protected void setBracketsStyle(Graphics g) {
//				g.setForegroundColor(ColorConstants.gray);
//				g.setLineWidth(1);
//			}
//		});

		EntityFigure headerFigure = new EntityFigure(new RowLayout()
				.withMinorAlignment(Alignment.MATHLINE)
				.withMargin(1));
		
		headerFigure.addKeyword("cut");

		add(createContentPane(0, new MarginBorder(0,1,0,1)));
		add(headerFigure);
	}
}
