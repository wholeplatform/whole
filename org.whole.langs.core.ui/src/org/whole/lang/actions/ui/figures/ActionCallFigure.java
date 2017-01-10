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
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public class ActionCallFigure extends ContentPaneFigure {
	private EntityFigure labelRow;

	public ActionCallFigure() {
		super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING).withSpacing(3));
		initContentPanes(2);

		labelRow = new EntityFigure(new RowLayout().withSpacing(5).withMarginLeft(2));
		labelRow.add(createFoldingToggle(1));
		labelRow.add(createContentPane(0));
		add(labelRow);
		add(createContentPane(1, new MarginBorder(0,16,0,0)));

		setBorder(new MarginBorder(6, 10, 9, 20) {
			public void paint(IFigure f, Graphics g, Insets i) {
				g.pushState();
				Rectangle r = getPaintRectangle(f, i);
				DrawUtils.drawShadowBorder(g, r, false);
				g.popState();
			}
    	});

		clickFoldingToggle(0);
	}

	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		Rectangle bounds = getBounds();
		Rectangle labelBounds = labelRow.getBounds();
		g.setBackgroundColor(FigureConstants.brightBlueColor);
		g.fillRectangle(bounds.x, labelBounds.y-1, bounds.width-3, labelBounds.height+2);
	}
}
