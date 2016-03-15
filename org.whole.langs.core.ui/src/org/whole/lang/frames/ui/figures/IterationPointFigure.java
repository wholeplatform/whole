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
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.notations.NotationImages;

/**
 * @author Riccardo Solmi
 */
public class IterationPointFigure extends ContentPaneFigure {
	protected EntityFigure headerFigure;

	public IterationPointFigure() {
		super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING));
		initContentPanes(2);

		headerFigure = new EntityFigure(new RowLayout()
			.withSpacing(8).withMargin(6, 8, 4, 8));
		headerFigure.addLabel(NotationImages.PACKAGE_OBJ);
		headerFigure.add(createContentPane(0));
		headerFigure.add(createFoldingToggle(1));

		add(headerFigure);
		add(createContentPane(1, new MarginBorder(8)));
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);
        
    	Rectangle hr = headerFigure.getBounds();
       	Rectangle cr = getContentPane(1).getBounds();

    	g.setForegroundColor(ColorConstants.orange);
    	g.setBackgroundColor(ColorConstants.white);

    	g.setAlpha(100);
       	g.fillRectangle(cr);
       	g.setAlpha(255);

        g.fillGradient(hr, true);
        g.drawRectangle(hr.x, hr.y, hr.width-1, hr.height-1);
    	g.drawRectangle(cr.x, cr.y-1, cr.width-1, cr.height);
	}
}
