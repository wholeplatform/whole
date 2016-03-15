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
import org.eclipse.draw2d.Toggle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.StackLayout;

/**
 * @author Riccardo Solmi
 */
public class IncludePointFigure extends ContentPaneFigure {
	protected IFigure stackFigure;
	protected IFigure configFigure;
	protected IFigure contentFigure;

	public IncludePointFigure() {
		super(new RowLayout().withMinorAlignment(Alignment.LEADING).withSpacing(1));
		initContentPanes(2);

		stackFigure = new EntityFigure(new StackLayout());

		configFigure = new EntityFigure(
				new ColumnLayout().withSpacing(6).withMargin(2, 4, 2, 4));
		configFigure.add(createContentPane(0));
		stackFigure.add(configFigure);

		contentFigure = createContentPane(1);
		contentFigure.setVisible(false);
		stackFigure.add(contentFigure);

		add(stackFigure);
		Toggle toggleFigure = new EntityToggle(WholeImages.ARROW_COLLAPSE, WholeImages.ARROW_EXPAND);
		toggleFigure.setBorder(new MarginBorder(1, 2, 1, 3));
		add(createFoldingToggle(toggleFigure, 2, 0));

		clickFoldingToggle(0);
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 2) {
			boolean isVisible = configFigure.isVisible();
			getContentPane(1).setVisible(isVisible);
			configFigure.setVisible(!isVisible);
		} else
			super.toggleVisibility(paneIndex);
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);

    	Rectangle toggleBounds = getFoldingToggle(0).getBounds();

    	g.setForegroundColor(ColorConstants.gray);
    	g.setBackgroundColor(ColorConstants.gray);

    	int oldAlpha = g.getAlpha();
        g.setAlpha(100);
        g.fillRoundRectangle(toggleBounds, 4, 6);
        g.setAlpha(oldAlpha);
 
       	Rectangle stackBounds = stackFigure.getBounds();
        if (configFigure.isVisible()) {
        	g.setLineWidth(3);
            g.drawRectangle(stackBounds.x+1, stackBounds.y+1, stackBounds.width-1, stackBounds.height-3);
        } else
           	g.drawLine(toggleBounds.x, toggleBounds.y, toggleBounds.x, toggleBounds.y+Math.max(toggleBounds.height, stackBounds.height));

	}
}
