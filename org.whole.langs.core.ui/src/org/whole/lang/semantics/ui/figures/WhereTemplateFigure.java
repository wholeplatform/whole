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
package org.whole.lang.semantics.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class WhereTemplateFigure extends ContentPaneFigure {
	public static final int SP = 2;
	public static final int HM = 3;
	protected boolean asStageDown;

	public WhereTemplateFigure() {
		super(new RowLayout() {
			protected boolean calculateChildrenSize(int wHint, int hHint, boolean preferred) {
				boolean result = super.calculateChildrenSize(wHint, hHint, preferred);
				int figHeight = figAscent+figDescent;
				figAscent = ascent(0);
				figDescent = figHeight-figAscent;
				return result;
			};
		}.withSpacing(2).withMinorAlignment(Alignment.LEADING));

		initContentPanes(2);
		
		add(createContentPane(0, new MarginBorder(2,HM,2,0)));
		add(createContentPane(1, new MarginBorder(1,0,1,1)));
	}

	public void showAsStageDown(boolean value) {
		if (asStageDown != value) {
			asStageDown = value;
			repaint();
		}
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		if (asStageDown) {
			g.setBackgroundColor(FigureConstants.hostLanguageColor);
			Rectangle b = getBounds();
			Rectangle b0 = getContentPane(0).getBounds();
//			g.fillRectangle(b0.right()+SP, b.y, b.width-b0.width-1-SP, b.height);
	
			g.setForegroundColor(ColorConstants.lightGray);
			g.drawRectangle(b0.right()+SP, b.y, b.width-b0.width-HM-1, b.height-1);

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
}
