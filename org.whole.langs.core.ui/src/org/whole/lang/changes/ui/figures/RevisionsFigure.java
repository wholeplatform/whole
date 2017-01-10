/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.changes.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.TableLayout;

/**
 *  @author  Riccardo Solmi
 */
public class RevisionsFigure extends TableFigure {

    public RevisionsFigure() {
        super(new TableLayout(4)
        .withColumnAlignment(0, Alignment.CENTER)
        .withColumnAlignment(2, Alignment.TRAILING)
        .withColumnAlignment(3, Alignment.TRAILING)
		.withRowSpacing(5).withColumnSpacing(10)
		.withMargin(5, 5, 4, 5));

		setBorder(CompositePlaceHolderBorder.MANDATORY_VERTICAL);

		TableRowFigure headers = new TableRowFigure();
		Color color = ColorConstants.gray;
		EntityLabel label = new EntityLabel(" # ");
		label.setForegroundColor(color);
		headers.add(label);
		label = new EntityLabel("Revision                       ");
		label.setForegroundColor(color);
		headers.add(label);
		label = new EntityLabel("     +");
		label.setForegroundColor(color);
		headers.add(label);
		label = new EntityLabel("     -");
		label.setForegroundColor(color);
		headers.add(label);
		add(headers, TableLayout.Placement.HEADER);
    }

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		TableLayout l = getLayoutManager();
		if (l.rows() == 0)
			return;

		Rectangle tb = getTableBounds();
		Rectangle cb1 = l.getColumnBounds(1);
		Rectangle cb2 = l.getColumnBounds(2);
		Rectangle cb3 = l.getColumnBounds(3);
		g.setBackgroundColor(FigureConstants.hostLanguageColor);
		g.fillRectangle(cb1.x, tb.y, cb1.width+1, tb.height);
		g.setBackgroundColor(FigureConstants.addBackgroundColor);
		g.fillRectangle(cb2.x, tb.y, cb2.width+1, tb.height);
		g.setBackgroundColor(FigureConstants.deleteBackgroundColor);
		g.fillRectangle(cb3.x, tb.y, cb3.width+1, tb.height);

		g.setBackgroundColor(ColorConstants.gray);
		drawHeadersRowBackground(g);

		g.setForegroundColor(ColorConstants.lightGray);
		drawHeadersRowSeparator(g);
		drawRowSeparators(g);
		drawTableBorder(g);
	}
}
