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
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.ChoiceBracketsBorder;
import org.whole.lang.ui.figures.CurlyBracketsBorder;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class SelectionPointFigure extends TableFigure {
	protected boolean asStageDown;

	public SelectionPointFigure() {
		super(new TableLayout(3)
				.withColumnSpacing(5).withRowSpacing(12).withMargin(5,3,5,3));
		
		setBorder(new CurlyBracketsBorder(true, false) {
			@Override
			protected void setBracketsStyle(Graphics g) {
				g.setForegroundColor(ColorConstants.gray);
				g.setLineWidth(2);
			}
		});
	}

	public void showAsStageDown(boolean value) {
		if (asStageDown != value) {
			asStageDown = value;
			getBorder().getInsets(this).left = asStageDown ? 0 : ChoiceBracketsBorder.HMARGIN;
			revalidate();
			repaint();
		}
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		TableLayout l = getLayoutManager();
		if (l.rows() == 0)
			return;

		if (asStageDown) {
			final int SP = 2, HM = 3;
			g.setBackgroundColor(FigureConstants.hostLanguageColor);
			Rectangle b = getTableBounds();
			Rectangle b0 = l.getColumnBounds(0);
			g.fillRectangle(b0.right()-1, b.y, b.width-b0.width-1, b.height);
	
			g.setForegroundColor(ColorConstants.lightGray);
			g.drawRectangle(b0.right()-1, b.y, b.width-b0.width-1, b.height-1);

			g.setLineStyle(SWT.LINE_CUSTOM);
			g.setLineDash(new int[] {1,3});
			g.setForegroundColor(ColorConstants.gray);
			Rectangle.SINGLETON.setLocation(b.x, b.y);
			Rectangle.SINGLETON.setSize(b0.width+HM+SP, b.height);
			g.setClip(Rectangle.SINGLETON);
			g.drawRectangle(b.x, b.y, b0.width+HM+SP, b.height-1);
			g.setClip(b);
			g.setLineStyle(SWT.LINE_SOLID);
			g.setLineDash((int[]) null);
		}

		g.setForegroundColor(ColorConstants.lightGray);
		drawRowSeparators(g);

//		g.setForegroundColor(ColorConstants.gray);
//
//		g.setLineStyle(SWT.LINE_CUSTOM);
//		g.setLineDash(new int[] {1,3});
//		drawRowSeparators(g);
//		g.setLineStyle(SWT.LINE_SOLID);
//		g.setLineDash((int[]) null);
	}

	protected int getBackgroundAlpha() {
		return 30;
	}
}
