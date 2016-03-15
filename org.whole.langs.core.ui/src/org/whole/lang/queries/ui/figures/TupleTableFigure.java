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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.RoundBracketsBorder;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class TupleTableFigure extends TableFigure {
	public TupleTableFigure() {
		super(new TableLayout(2)
				.withColumnSpacing(6).withRowSpacing(10).withMarginTop(5).withMarginBottom(5));

		setBorder(new RoundBracketsBorder());
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		TableLayout l = getLayoutManager();
		if (l.rows() == 0)
			return;

		String separator = ",";
		g.setForegroundColor(ColorConstants.gray);

        int spacing = getLayoutManager().getSpacing();
        int fontAscent = FigureUtilities.getFontMetrics(getFont()).getHeight()/2;

        int xOffset = FigureUtilities.getTextWidth(separator, getFont())/2;
        int yOffset = spacing/2 + fontAscent +1;
        int x = getClientArea().getCenter().x - xOffset;

		int firstRow = l.hasHeaderRow() ? 2 : 1;
		for (int i=firstRow; i<l.rows(); i++) {
			Rectangle r = l.getRowBounds(i);
        	g.drawString(separator, x, r.y-yOffset);
		}
	}
}
