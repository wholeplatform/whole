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

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.IEntityFigure;

/**
 * @author Riccardo Solmi
 */
public class BlockBracketsBorder extends MarginBorder {
	private static final int HMARGIN = 8;
	private static final int HPIPE = 3;	
	private static final int HSIZE = 5;
	private static final int HSIZE1 = HSIZE+1;

	public BlockBracketsBorder() {
		this(true, true);
	}
	public BlockBracketsBorder(boolean left, boolean right) {
		super(0, left ? HMARGIN :  0, 0, right ? HMARGIN : 0);
	}

	@SuppressWarnings("unchecked")
	public void paint(IFigure f, Graphics g, Insets i) {
		List<IFigure> children = (List<IFigure>) f.getChildren();
		int yLast = 0;
		int baselineLast = 0;
		int size = children.size();
		if (size>1) {
			IFigure lastChildFigure = children.get(size-1);
			Rectangle boundsLast = lastChildFigure.getBounds();
			yLast = boundsLast.y;
			if (lastChildFigure instanceof IEntityFigure)
				baselineLast = ((IEntityFigure) lastChildFigure).getAscent();
			else
				baselineLast = boundsLast.height/2;
		}

		Rectangle r = getPaintRectangle(f, i);
		r.width--;
		r.height--;
		int leftX = r.x + HPIPE;
		int rightX = r.right() - HPIPE;
		int centerY = yLast == 0 ? r.y + r.height/2 : yLast + baselineLast;

		g.setForegroundColor(getDelimiterColor());

		if (insets.left > 0) {
			g.drawArc(leftX, r.y, HSIZE1, HSIZE1*2, 90, 90);
			if (r.height > HSIZE) {
				if (yLast == 0)
					g.drawLine(leftX, r.y+HSIZE, leftX, centerY-HSIZE);
				else
					g.drawLine(leftX, yLast-HSIZE1, leftX, centerY-HSIZE);

				g.drawArc(leftX-HSIZE1, centerY-HSIZE1*2, HSIZE1, HSIZE1*2, 270, 90);
				g.drawArc(leftX-HSIZE1, centerY, HSIZE1, HSIZE1*2, 0, 90);				
				g.drawLine(leftX, centerY+HSIZE, leftX, r.bottom()-HSIZE);
			}
			g.drawArc(leftX, r.bottom()-HSIZE1*2, HSIZE1, HSIZE1*2, 180, 90);
		}
		if (insets.right > 0) {
			g.drawArc(rightX-HSIZE1, r.y, HSIZE1, HSIZE1*2, 0, 90);
			if (r.height > HSIZE) {
				if (yLast == 0)
					g.drawLine(rightX, r.y+HSIZE, rightX, centerY-HSIZE);
				else
					g.drawLine(rightX, yLast-HSIZE1, rightX, centerY-HSIZE);
				
				g.drawArc(rightX, centerY-HSIZE1*2, HSIZE1, HSIZE1*2, 180, 90);
				g.drawArc(rightX, centerY, HSIZE1, HSIZE1*2, 90, 90);				
				g.drawLine(rightX, centerY+HSIZE, rightX, r.bottom()-HSIZE);
			}
			g.drawArc(rightX-HSIZE1, r.bottom()-HSIZE1*2, HSIZE1, HSIZE1*2, 0, -90);
		}

		if (yLast > 0) {
			g.setLineStyle(SWT.LINE_CUSTOM);
			g.setLineDash(new int[] {5,2});

			if (insets.left > 0 && r.height > HSIZE)
				g.drawLine(leftX, r.y+HSIZE, leftX, yLast-HSIZE1-1);

			if (insets.right > 0 && r.height > HSIZE)
				g.drawLine(rightX, r.y+HSIZE, rightX, yLast);
			
			g.setLineStyle(SWT.LINE_SOLID);
			g.setLineDash((int[]) null);
		}
	}
	protected Color getDelimiterColor() {
		return ColorConstants.black;
	}
}
