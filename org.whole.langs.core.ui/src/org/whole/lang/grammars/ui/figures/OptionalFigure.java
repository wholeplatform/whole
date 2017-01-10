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
package org.whole.lang.grammars.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.ArrowFactory;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.ArrowFactory.ArrowKind;
import org.whole.lang.ui.figures.ArrowFactory.Direction;
import org.whole.lang.ui.layout.MonoLayout;

/**
 * @author Riccardo Solmi
 */
public class OptionalFigure extends EntityFigure {
	public OptionalFigure() {
		super(new MonoLayout());

		setBorder(new MarginBorder(9, 8, 0, 10) {
			private final Shape decorationRight;
			{
				decorationRight = ArrowFactory.createArrow(Direction.SOUTH, ArrowKind.TRIANGLE_TO_BAR, true);
			}
			public void paint(IFigure f, Graphics g, Insets i) {
				Rectangle r = getPaintRectangle(f, i);
				r.width--;
				r.height--;
				int baseline = getAscent()+1;
				int topline = r.y;
				int leftline = r.x + getInsets(null).left/2;
				int rightline = r.right() - getInsets(null).right/2;

				g.setForegroundColor(getDelimiterColor());
				g.setBackgroundColor(getDelimiterColor());

				g.drawLine(leftline, topline, leftline, r.y+baseline-1);
				g.drawLine(leftline, topline, rightline, topline);
		    	g.drawLine(rightline, topline, rightline, r.y+baseline-1);
				decorationRight.setLocation(new Point(rightline, r.y+baseline-1));
				decorationRight.paint(g);
			}

			protected Color getDelimiterColor() {
				return FigureConstants.relationsColor;
			}
		});
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle bounds = getBounds();
        int baseline = bounds.y + getAscent();

    	g.drawLine(bounds.x, baseline, bounds.x+8, baseline);
    	g.drawLine(bounds.right()-8, baseline, bounds.right(), baseline);
	}


	public Color getLocalForegroundColor() {
		return FigureConstants.relationsColor;
	}
}