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
import org.eclipse.swt.SWT;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.figures.EntityFigure;

/**
 *  @generator Whole
 */
public class SynchFigure extends ContentPaneFigure {
	protected EntityFigure reuseFigure, originalFigure, adaptedFigure, configurationFigure;
	protected ReuseBorder reuseBorder;

    public SynchFigure() {
        initContentPanes(7);
        setLayoutManager(new RowLayout().withMinorAlignment(Alignment.LEADING));
        
        reuseFigure = new EntityFigure(new RowLayout().withMargin(0,0,0,7).withSpacing(16).withMinorAlignment(Alignment.LEADING));
		
		EntityFigure adaptableFigure = new EntityFigure(new OverLayout());
		adaptableFigure.add(createContentPane(5));
		adaptableFigure.add(createContentPane(6, new MarginBorder(8, 2, 4, 6)));
		reuseFigure.add(adaptableFigure);

		adaptedFigure = new EntityFigure(new OverLayout());
		adaptedFigure.add(createContentPane(3));
		adaptedFigure.add(createContentPane(4, new MarginBorder(8, 2, 4, 6)));
		reuseFigure.add(adaptedFigure);

		originalFigure = new EntityFigure(new OverLayout());
		originalFigure.add(createContentPane(1));
		EntityLabel originalHeader = LabelFactory.createRelation("ORIGINAL");
		originalHeader.setBorder(new MarginBorder(8, 2, 4, 6));
		originalFigure.add(originalHeader);
		reuseFigure.add(originalFigure);
        
        configurationFigure = new EntityFigure(new ColumnLayout().withSpacing(4));
        configurationFigure.add(createContentPane(0));
		adaptableFigure = new EntityFigure(new OverLayout());
		adaptableFigure.add(createContentPane(2));
		EntityLabel adapterHeader = LabelFactory.createRelation("ADAPTER");
		adapterHeader.setBorder(new MarginBorder(8, 2, 4, 6));
		adaptableFigure.add(adapterHeader);
		configurationFigure.add(adaptableFigure);
        reuseFigure.add(configurationFigure);

        reuseBorder = new ReuseBorder();

        add(reuseFigure);

        Toggle toggleFigure = new EntityToggle(WholeImages.ARROW_COLLAPSE, WholeImages.ARROW_EXPAND);
		toggleFigure.setBorder(new MarginBorder(1, 2, 1, 3));
		add(createFoldingToggle(toggleFigure, 7, 0, 1, 2, 3, 4, 6));

		clickFoldingToggle(0);
    }

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 7) {
			boolean isVisible = configurationFigure.isVisible();
			configurationFigure.setVisible(!isVisible);
			getContentPane(6).setVisible(!isVisible);
			adaptedFigure.setVisible(!isVisible);
			originalFigure.setVisible(!isVisible);
			reuseFigure.setBorder(isVisible ? null : reuseBorder);
		} else
			super.toggleVisibility(paneIndex);
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);

        Rectangle bounds = getBounds();
        Rectangle toggleBounds = getFoldingToggle(0).getBounds();

    	g.setBackgroundColor(ColorConstants.orange);
    	g.setForegroundColor(ColorConstants.lightGray);
		g.fillRoundRectangle(toggleBounds, 4, 6);
        g.drawLine(toggleBounds.x-1, toggleBounds.y+1, toggleBounds.x-1, toggleBounds.bottom()-1);

        boolean showBar = !configurationFigure.isVisible();
        if (showBar) {
            int x = toggleBounds.x -3;
            int y0 = bounds.y;
            int y1 = bounds.bottom();

			g.pushState();

			int bandSize = 6;
			g.setLineWidth(3);
			g.setLineStyle(SWT.LINE_CUSTOM);
			g.setLineDash(new int[] {bandSize, bandSize});

			g.setLineDashOffset(-1);
			g.setForegroundColor(ColorConstants.orange);
			g.drawLine(x-2, y0, x-2, y1);
			g.setLineDashOffset(-1 + bandSize);
			g.setForegroundColor(ColorConstants.darkGray);
			g.drawLine(x-2, y0, x-2, y1);

			g.setLineDashOffset(0);
			g.setForegroundColor(ColorConstants.orange);
			g.drawLine(x, y0, x, y1);
			g.setLineDashOffset(0 + bandSize);
			g.setForegroundColor(ColorConstants.darkGray);
			g.drawLine(x, y0, x, y1);

			g.popState();
        }
	}
}
