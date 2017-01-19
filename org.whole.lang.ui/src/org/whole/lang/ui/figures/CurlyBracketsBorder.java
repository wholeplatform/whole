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
package org.whole.lang.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Riccardo Solmi
 */
public class CurlyBracketsBorder extends MarginBorder {
	private static final int HMARGIN = 8;
	private static final int HPIPE = 3;	
	private static final int HSIZE = 5;
	private static final int HSIZE1 = HSIZE+1;

	public CurlyBracketsBorder() {
		this(true, true);
	}
	public CurlyBracketsBorder(boolean left, boolean right) {
		super(0, left ? HMARGIN :  0, 0, right ? HMARGIN : 0);
	}

	public void paint(IFigure f, Graphics g, Insets i) {
		Rectangle r = getPaintRectangle(f, i);
		r.width--;
		r.height--;
		int leftX = r.x + HPIPE;
		int rightX = r.right() - HPIPE;
		int centerY = r.y + r.height/2;

		setBracketsStyle(g);

		if (insets.left > 0) {
			if (r.height < HSIZE1*4) {
				g.setFont(FigureConstants.symbolFontMedium);
				g.drawText("{", leftX, r.y-1);
			} else {
				g.drawArc(leftX, r.y, HSIZE1, HSIZE1*2, 90, 90);
				if (r.height > HSIZE) {
					g.drawLine(leftX, r.y+HSIZE, leftX, centerY-HSIZE);
					g.drawArc(leftX-HSIZE1, centerY-HSIZE1*2, HSIZE1, HSIZE1*2, 270, 90);
					g.drawArc(leftX-HSIZE1, centerY, HSIZE1, HSIZE1*2, 0, 90);				
					g.drawLine(leftX, centerY+HSIZE, leftX, r.bottom()-HSIZE);
				}
				g.drawArc(leftX, r.bottom()-HSIZE1*2, HSIZE1, HSIZE1*2, 180, 90);
			}
		}
		if (insets.right > 0) {
			if (r.height < HSIZE1*4) {
				g.setFont(FigureConstants.symbolFontMedium);
				g.drawText("}", rightX-HSIZE1+2, r.y-1);
			} else {
				g.drawArc(rightX-HSIZE1, r.y, HSIZE1, HSIZE1*2, 0, 90);
				if (r.height > HSIZE) {
					g.drawLine(rightX, r.y+HSIZE, rightX, centerY-HSIZE);
					g.drawArc(rightX, centerY-HSIZE1*2, HSIZE1, HSIZE1*2, 180, 90);
					g.drawArc(rightX, centerY, HSIZE1, HSIZE1*2, 90, 90);				
					g.drawLine(rightX, centerY+HSIZE, rightX, r.bottom()-HSIZE);
				}
				g.drawArc(rightX-HSIZE1, r.bottom()-HSIZE1*2, HSIZE1, HSIZE1*2, 0, -90);
			}
		}
	}
	protected void setBracketsStyle(Graphics g) {
		g.setForegroundColor(ColorConstants.black);
	}
}
