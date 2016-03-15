/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.reusables.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Toggle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.Alignment;

/**
 *  @generator Whole
 */
public class AdaptFigure extends ContentPaneFigure {
	protected EntityFigure adaptFigure;
	protected EntityLabel variantHeader, adaptedHeader, originalHeader, adapterHeader;

    public AdaptFigure() {
        initContentPanes(3);
        setLayoutManager(new RowLayout().withMinorAlignment(Alignment.LEADING));

        adaptFigure = new EntityFigure(new RowLayout().withMargin(0,0,0,7).withSpacing(16).withMinorAlignment(Alignment.LEADING));
		
		EntityFigure adaptableFigure = new EntityFigure(new OverLayout());
		adaptableFigure.add(createContentPane(0));
		originalHeader = LabelFactory.createRelation("ORIGINAL");
		originalHeader.setBorder(new MarginBorder(8, 2, 4, 6));
		adaptableFigure.add(originalHeader);
		adaptFigure.add(adaptableFigure);

        adaptableFigure = new EntityFigure(new OverLayout());
		adaptableFigure.add(createContentPane(2));
		adaptedHeader = LabelFactory.createRelation("ADAPTED");
		adaptedHeader.setBorder(new MarginBorder(8, 2, 4, 6));
		adaptableFigure.add(adaptedHeader);
		adaptFigure.add(adaptableFigure);

        adaptableFigure = new EntityFigure(new OverLayout());
		adaptableFigure.add(createContentPane(1));
		adapterHeader = LabelFactory.createRelation("ADAPTER");
		adapterHeader.setBorder(new MarginBorder(8, 2, 4, 6));
		adaptableFigure.add(adapterHeader);
		adaptFigure.add(adaptableFigure);

		adaptFigure.setBorder(new ReuseBorder());

        add(adaptFigure);

        Toggle toggleFigure = new EntityToggle(WholeImages.ARROW_COLLAPSE, WholeImages.ARROW_EXPAND);
		toggleFigure.setBorder(new MarginBorder(1, 2, 1, 3));
		add(createFoldingToggle(toggleFigure, 3, 1, 2));

		clickFoldingToggle(0);
    }

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 3) {
			boolean isVisible = getContentPane(1).isVisible();
			getContentPane(1).setVisible(!isVisible);
			getContentPane(2).setVisible(!isVisible);
			adaptedHeader.setVisible(!isVisible);
			originalHeader.setVisible(!isVisible);
			adapterHeader.setVisible(!isVisible);
		} else
			super.toggleVisibility(paneIndex);
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);

        Rectangle toggleBounds = getFoldingToggle(0).getBounds();

    	g.setBackgroundColor(ColorConstants.orange);
    	g.setForegroundColor(ColorConstants.lightGray);
		g.fillRoundRectangle(toggleBounds, 4, 6);
        g.drawLine(toggleBounds.x-1, toggleBounds.y+1, toggleBounds.x-1, toggleBounds.bottom()-1);
	}
}
