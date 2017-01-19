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
import org.whole.lang.ui.PreferenceConstants;
import org.whole.lang.ui.figures.ArrowFactory;
import org.whole.lang.ui.figures.ArrowFigure;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.ArrowFactory.ArrowKind;
import org.whole.lang.ui.figures.ArrowFactory.Direction;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class RepeatFigure extends ContentPaneFigure {
	public RepeatFigure() {
		super(new OverLayout(false, true).withSpacing(6));
		initContentPanes(4);
		
		EntityFigure row = new EntityFigure(new RowLayout().withMajorAutoresizeWeight(1f));
		row.addContentLight("[");
		row.add(createContentPane(0));
		row.addContentLight("..");
		row.add(createContentPane(1));
		row.addContentLight("]");
	    row.add(new ArrowFigure(1f, ArrowKind.NONE, ArrowKind.NONE, PreferenceConstants.RELATIONS_CATEGORY, true));
		row.add(createContentPane(2));
	    row.add(new ArrowFigure(0f, ArrowKind.TRIANGLE, ArrowKind.NONE, PreferenceConstants.RELATIONS_CATEGORY, true));

		add(createContentPane(3));
		add(row);
		
		setBorder(new MarginBorder(0, 10, 0, 8) {
			private final Shape decorationLeft, decorationRight;
			{
				decorationLeft = ArrowFactory.createArrow(Direction.SOUTH, ArrowKind.TRIANGLE_TO_BAR, true);
				decorationRight = ArrowFactory.createArrow(Direction.SOUTH, ArrowKind.BAR, true);
			}
			public void paint(IFigure f, Graphics g, Insets i) {
				Rectangle r = getPaintRectangle(f, i);
				r.width--;
				r.height--;
				int baseline = getAscent();
				int topline = getLayoutManager().getBaseline(1)+1;
				int leftline = r.x + getInsets(null).left/2;
				int rightline = r.right() - getInsets(null).right/2;

				g.setForegroundColor(getDelimiterColor());
				g.setBackgroundColor(getDelimiterColor());

				g.drawLine(leftline, topline, r.x+getInsets(null).left, topline);
				g.drawLine(leftline, topline, leftline, r.y+baseline-ArrowFactory.DEFAULT_BASE);
		    	decorationLeft.setLocation(new Point(leftline, r.y+baseline));
		    	decorationLeft.paint(g);

		    	g.drawLine(r.right()-getInsets(null).right, topline, rightline, topline);
				g.drawLine(rightline, topline, rightline, r.y+baseline-ArrowFactory.DEFAULT_BASE);
				decorationRight.setLocation(new Point(rightline, r.y+baseline));
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
        Rectangle ruleBounds = getContentPane(3).getClientArea();
        int baseline = getLayoutManager().getBaseline(0)+1;

    	g.drawLine(bounds.x-1, baseline, ruleBounds.x, baseline);
//    	g.drawLine(ruleBounds.x-1, baseline-4, ruleBounds.x-1, baseline+4);
    	g.drawLine(ruleBounds.right()-1, baseline, bounds.right(), baseline);
//    	g.drawLine(ruleBounds.right()-1, baseline-4, ruleBounds.right()-1, baseline+4);
	}

	public Color getLocalForegroundColor() {
		return FigureConstants.relationsColor;
	}
}
