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
package org.whole.lang.queries.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public class SelectFigure extends ContentPaneFigure {
	private IFigure[] fig = new IFigure[4];

	public SelectFigure() {
		super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING).withSpacing(12));
		initContentPanes(4);

		EntityFigure row1 = new EntityFigure(new RowLayout().withSpacing(8));
		fig[0] = row1.addKeyword("select");
		row1.add(createContentPane(0));

		EntityFigure row2 = new EntityFigure(new RowLayout().withSpacing(18));
		fig[1] = row2.addKeyword("for");
		row2.add(createContentPane(1));

		EntityFigure row3 = new EntityFigure(new RowLayout().withSpacing(4));
		fig[2] = row3.addKeyword("where");
		row3.add(createFoldingToggle(2));
		row3.add(createContentPane(2));

		EntityFigure row4 = new EntityFigure(new RowLayout().withSpacing(6));
		fig[3] = row4.addKeyword("clear");
		row4.add(createContentPane(3));

		EntityFigure col = new EntityFigure(new ColumnLayout().withMarginLeft(11).withSpacing(4));
		col.add(row2);
		col.add(row3);
		col.add(row4);

		add(row1);
		add(col);
	}
	
	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	protected void paintConnections(Graphics graphics) {
		graphics.setForegroundColor(FigureConstants.contentLighterColor);
		
		Point selectPoint = fig[0].getBounds().getBottom();
		Point[] childrenPoints = new Point[] {
				fig[1].getBounds().getLeft().translate(-2, 0),
				fig[2].getBounds().getLeft().translate(-2, 0),
				fig[3].getBounds().getLeft().translate(-2, 0)
		};
		selectPoint.x = childrenPoints[0].x - 6;
		
		graphics.setLineStyle(SWT.LINE_CUSTOM);
		graphics.setLineDash(new int[] {1,1});
		DrawUtils.drawOutline(graphics, selectPoint, childrenPoints);
		graphics.setLineStyle(SWT.LINE_SOLID);
		graphics.setLineDash((int[]) null);
	}
}
