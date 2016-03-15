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
public class FilterFamilyFigure extends ContentPaneFigure {
	protected IFigure descriptionFigure;
    protected EntityFigure headerFigure;

    public FilterFamilyFigure() {
        super(new ColumnLayout());
        initContentPanes(4);
        
        add(headerFigure = new EntityFigure(new RowLayout().withSpacing(6).withMargin(6,8,4,8)));

        EntityFigure overFigure;
        overFigure = new EntityFigure(new OverLayout());
        overFigure.addContentLighter("family");
        overFigure.addContentLighter("Filter");
        headerFigure.add(overFigure);
        overFigure = new EntityFigure(new OverLayout());
        overFigure.add(createContentPane(2));
        overFigure.add(createContentPane(1));
        headerFigure.add(overFigure);

        add(descriptionFigure = createContentPane(0, new MarginBorder(2,4,2,4)));
		add(createContentPane(3, new MarginBorder(4,8,4,8)));
    }

	public void showDescription(boolean value) {
		descriptionFigure.setVisible(value);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle bounds = getBounds();
		Rectangle headerBounds = headerFigure.getBounds();

		g.setForegroundColor(ColorConstants.gray);
		g.setLineWidth(2);

		g.drawLine(bounds.x+1, headerBounds.bottom()-1, bounds.right()-1, headerBounds.bottom()-1);
		g.drawRoundRectangle(bounds.getExpanded(-1, -1), 16,16);
	}
}
