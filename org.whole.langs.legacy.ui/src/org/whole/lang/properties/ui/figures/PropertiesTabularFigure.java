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
package org.whole.lang.properties.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ArrowFactory;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.PaintFigureHelper;
import org.whole.lang.ui.figures.ArrowFactory.ArrowKind;
import org.whole.lang.ui.figures.ArrowFactory.Direction;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class PropertiesTabularFigure extends ContentPaneFigure {
	protected EntityFigure node;
	protected EntityFigure header;

	public PropertiesTabularFigure() {
		super(new ColumnLayout()
			.withMinorAlignment(Alignment.CENTER).withSpacing(32).withMargin(2, 4, 2, 4));
		initContentPanes(3);

		node = new EntityFigure(new ColumnLayout().withMargin(0, 2, 5, 2));
		
		header = new EntityFigure(new RowLayout().withSpacing(8).withMargin(6, 4, 4, 12));
		header.add(createFoldingToggle(2));
		header.add(createContentPane(1));

		node.add(header);
		node.add(createContentPane(2));
		
		add(createContentPane(0));
		add(node);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
	
		Rectangle bounds = new Rectangle(node.getBounds());
		Point arrowLocation = getContentPane(0).getBounds().getBottom();
		
		PaintFigureHelper.drawGradientRoundRectangle(g, bounds,
				FigureUtilities.lighter(ColorConstants.lightBlue), ColorConstants.white,
				//ColorConstants.yellow, ColorConstants.tooltipBackground,
				ColorConstants.lightGray,
				16, 16, false);
		
		g.setForegroundColor(FigureConstants.relationsColor);		
		g.drawLine(bounds.getTop(), arrowLocation);
		Shape s = ArrowFactory.createArrow(Direction.NORTH, ArrowKind.TRIANGLE, true);
		s.setLocation(arrowLocation);
		s.setBackgroundColor(ColorConstants.white);
		s.paint(g);
	}
}
