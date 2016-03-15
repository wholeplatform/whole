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
package org.whole.lang.reusables.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/**
 * @author Riccardo Solmi
 */
public class ReuseBorder extends MarginBorder{
	public ReuseBorder() {
		super(6);
	}

	public void paint(IFigure f, Graphics g, Insets i) {
		Rectangle r = getPaintRectangle(f, i);
		r.width--;
		r.height--;

		g.pushState();

		int bandSize = 6;
		g.setLineWidth(3);
		g.setLineStyle(SWT.LINE_CUSTOM);
		g.setLineDash(new int[] {bandSize, bandSize});

		r.shrink(2, 2);
		g.setLineDashOffset(-1);
		g.setForegroundColor(ColorConstants.orange);
		g.drawLine(r.x, r.y, r.right(), r.y);
		g.drawLine(r.right(), r.y, r.right(), r.bottom());
		g.drawLine(r.right(), r.bottom(), r.x, r.bottom());
		g.drawLine(r.x, r.bottom(), r.x, r.y);
		g.setLineDashOffset(-1 + bandSize);
		g.setForegroundColor(ColorConstants.darkGray);
		g.drawLine(r.x, r.y, r.right(), r.y);
		g.drawLine(r.right(), r.y, r.right(), r.bottom());
		g.drawLine(r.right(), r.bottom(), r.x, r.bottom());
		g.drawLine(r.x, r.bottom(), r.x, r.y);

		r.shrink(2, 2);
		g.setLineDashOffset(0);
		g.setForegroundColor(ColorConstants.orange);
		g.drawLine(r.x, r.y, r.right(), r.y);
		g.drawLine(r.right(), r.y, r.right(), r.bottom());
		g.drawLine(r.right(), r.bottom(), r.x, r.bottom());
		g.drawLine(r.x, r.bottom(), r.x, r.y);
		g.setLineDashOffset(0 + bandSize);
		g.setForegroundColor(ColorConstants.darkGray);
		g.drawLine(r.x, r.y, r.right(), r.y);
		g.drawLine(r.right(), r.y, r.right(), r.bottom());
		g.drawLine(r.right(), r.bottom(), r.x, r.bottom());
		g.drawLine(r.x, r.bottom(), r.x, r.y);

//		r.shrink(3, 3);		
//		g.setLineWidth(5);
//		g.setLineStyle(SWT.LINE_CUSTOM);
//		g.setLineDash(new int[] {5,5});
//		g.setLineDashOffset(0);
//		g.setForegroundColor(ColorConstants.orange);
//		g.drawRoundRectangle(r, 3, 3);
//		g.setLineDashOffset(5);
//		g.setForegroundColor(ColorConstants.darkGray);
//		g.drawRoundRectangle(r, 3, 3);

		g.popState();
	}
}
