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
package org.whole.lang.tests.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Riccardo Solmi
 */
public class TestFigure extends ContentPaneFigure {
	protected IFigure descriptionFigure;
    protected EntityFigure headerFigure;

    public TestFigure(String header) {
        super(new ColumnLayout());
        initContentPanes(3);

        add(headerFigure = new EntityFigure(new RowLayout().withSpacing(4).withMargin(2,4,2,4)));
        headerFigure.add(createFoldingToggle(2));

        EntityFigure titleFigure = new EntityFigure(new OverLayout());
        titleFigure.add(createContentPane(1));
        titleFigure.addContentLighter(header);
        headerFigure.add(titleFigure);

        add(descriptionFigure = createContentPane(0, new MarginBorder(2)));
		add(createContentPane(2, new MarginBorder(4,8,6,8)));

		clickFoldingToggle(0);
    }

	public void showDescription(boolean value) {
		descriptionFigure.setVisible(value);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle bounds = getBounds();
		Rectangle headerBounds = headerFigure.getBounds();

		g.setForegroundColor(ColorConstants.lightGray);
		g.setLineWidth(1);

		g.drawLine(headerBounds.x, headerBounds.bottom()-1, headerBounds.x, bounds.bottom()-1);
		g.drawLine(bounds.right()-1, headerBounds.bottom()-1, bounds.right()-1, bounds.bottom()-1);

		g.clipRect(headerBounds);
		g.drawRoundRectangle(headerBounds.getResized(-1,8), 8,8);
		g.restoreState();

		g.setForegroundColor(ColorConstants.gray);
		g.setLineWidth(2);
		
		g.drawLine(headerBounds.x, headerBounds.bottom()-1, bounds.right(), headerBounds.bottom()-1);
		if (bounds.bottom() > headerBounds.bottom())
			g.drawLine(headerBounds.x, bounds.bottom()-1, bounds.right(), bounds.bottom()-1);
	}
}
