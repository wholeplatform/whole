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
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class VariantSelectionPointFigure extends ContentPaneFigure {
	public VariantSelectionPointFigure() {
		super(new ColumnLayout().withMinorAlignment(Alignment.TRAILING).withSpacing(1));
		initContentPanes(2);

		add(createContentPane(0));
		add(createContentPane(1));
	}

	@Override
	public void paintFigure(Graphics g) {
        super.paintFigure(g);
        
    	Rectangle hr = getContentPane(0).getBounds();

    	g.setForegroundColor(ColorConstants.orange);
    	g.setBackgroundColor(ColorConstants.orange);

    	int oldAlpha = g.getAlpha();
        g.setAlpha(100);
        g.fillRoundRectangle(hr, 4, 6);
        g.setAlpha(oldAlpha);
 
       	Rectangle cr = getContentPane(1).getBounds();
        g.setLineWidth(1);
    	g.drawRectangle(cr.x, cr.y, cr.width-1, cr.height-1);
	}
}
