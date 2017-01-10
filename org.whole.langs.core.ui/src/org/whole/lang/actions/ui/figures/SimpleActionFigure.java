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
package org.whole.lang.actions.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public class SimpleActionFigure extends ContentPaneFigure {
	private IFigure[] fig = new IFigure[2];
	private EntityFigure row2;


	public SimpleActionFigure() {
		super(new ColumnLayout().withSpacing(2));
		initContentPanes(2);

		EntityFigure row1 = new EntityFigure(new RowLayout().withSpacing(5).withMarginLeft(2));
		row1.add(fig[0] = createFoldingToggle(1));
		row1.add(createContentPane(0));

		row2 = new EntityFigure(new RowLayout().withSpacing(8).withMarginLeft(16));
		fig[1] = row2.addKeyword(":");
		row2.add(createContentPane(1));

		add(row1);
		add(row2);
		
		clickFoldingToggle(0);
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 1)
			row2.setVisible(!row2.isVisible());
		else
			super.toggleVisibility(paneIndex);
	}

	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		if (row2.isVisible()) {
			g.setForegroundColor(FigureConstants.contentLighterColor);
			g.setLineStyle(SWT.LINE_CUSTOM);
			g.setLineDash(new int[] {1,1});
	
			DrawUtils.drawOutline(g,
					fig[0].getBounds().getBottom().translate(0, -2),
					fig[1].getBounds().getLeft().translate(-1, 0));
		}
	}
}
