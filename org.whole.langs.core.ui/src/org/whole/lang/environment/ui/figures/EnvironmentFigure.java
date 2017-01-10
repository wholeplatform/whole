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
package org.whole.lang.environment.ui.figures;

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class EnvironmentFigure extends ContentPaneFigure {
//	protected EntityFigure node;
//	protected EntityFigure header;

	public EnvironmentFigure(ActionListener action, boolean scoped) {
		super(new ColumnLayout().withMinorAlignment(Alignment.LEADING)
				.withSpacing(4).withMargin(4));
		initContentPanes(3);

		add(createContentPane(0));
		add(createActionableFoldingToggle(new EntityToggle("Flat", "Deep", action) {
			protected EntityLabel createLabel(String text) {
				return LabelFactory.createIdentifier(text);
			}
		}));
		add(createContentPane(1));
		add(createContentPane(2));
		
		if (!scoped)
			clickFoldingToggle(0);
//		node = new EntityFigure(new ColumnLayout().withMargin(0, 2, 5, 2));
//		
//		header = new EntityFigure(new RowLayout().withSpacing(8).withMargin(6, 4, 4, 12));
//		header.add(createFoldingToggle(2));
//		header.add(createContentPane(1));
//
//		node.add(header);
//		node.add(createContentPane(2));
//		
//		add(createContentPane(0));
//		add(node);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
	
//		Point arrowStart = getFoldingToggle(0).getBounds().getTop();
//		Point arrowEnd = getContentPane(0).getBounds().getBottom();
//		arrowEnd.translate(0, -16);
//		arrowEnd.setX(arrowStart.x);
//		
////		PaintFigureHelper.drawGradientRoundRectangle(g, bounds,
////				FigureUtilities.lighter(ColorConstants.lightBlue), ColorConstants.white,
////				//ColorConstants.yellow, ColorConstants.tooltipBackground,
////				ColorConstants.lightGray,
////				16, 16, false);
//
//		g.setForegroundColor(FigureConstants.relationsColor);		
//		g.drawLine(arrowStart, arrowEnd);
//		Shape s = ArrowFactory.createArrow(Direction.NORTH, ArrowKind.TRIANGLE, true);
//		s.setLocation(arrowEnd);
//		s.setBackgroundColor(FigureConstants.relationsColor);
//		s.paint(g);
	}
}
