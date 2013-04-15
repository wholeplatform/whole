/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigurePrefs;
import org.whole.lang.ui.layout.RowLayout;


/**
 * @author Riccardo Solmi
 */
public class ResultPointFigure extends ContentPaneFigure {
	public static final int SP = 2;
	public static final int HM = 3;

	public ResultPointFigure() {
		super(new RowLayout().withSpacing(12).withMargin(2,HM,2,2));
		initContentPanes(2);
		
		add(createContentPane(0));
		add(createContentPane(1));
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		g.setBackgroundColor(FigurePrefs.hostLanguageColor);
		Rectangle b = getBounds();
		Rectangle b0 = getContentPane(0).getBounds();
		g.fillRectangle(b0.right()+SP, b.y, b.width-b0.width-1-SP, b.height);

    	int oldAlpha = g.getAlpha();
		g.setAlpha(100);
    	g.setBackgroundColor(FigurePrefs.relationsColor);
        g.fillRectangle(b0.right()+SP, b.y, 8, b.height-1);
        g.setAlpha(oldAlpha);

		g.setForegroundColor(ColorConstants.lightGray);
		g.drawRectangle(b0.right()+SP, b.y, b.width-b0.width-HM-1-SP, b.height-1);

		g.setLineStyle(SWT.LINE_CUSTOM);
		g.setLineDash(new int[] {1,3});
		g.setForegroundColor(ColorConstants.gray);
		Rectangle.SINGLETON.setLocation(b.x, b.y);
		Rectangle.SINGLETON.setSize(b0.width+HM+SP, b.height);
		g.setClip(Rectangle.SINGLETON);
		g.drawRectangle(b.x, b.y, b0.width+HM+SP, b.height-1);
		g.setClip(b);
	}
}