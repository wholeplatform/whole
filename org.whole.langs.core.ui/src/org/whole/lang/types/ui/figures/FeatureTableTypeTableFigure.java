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
package org.whole.lang.types.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class FeatureTableTypeTableFigure extends TableFigure {
	public FeatureTableTypeTableFigure() {
		super(new TableLayout()
		.withRowSpacing(4).withColumnSpacing(8)
		.withMargin(1, 5, 2, 5));
	
		setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		TableLayout l = getLayoutManager();
		if (l.rows() == 0)
			return;

		g.setForegroundColor(ColorConstants.lightGray);
		
		drawColumnSeparators(g);
//		drawColumnSeparatorBefore(g, 1);
		
		Rectangle ca = getTableBounds();
		Rectangle c = l.getColumnBounds(1);
		Rectangle r = l.getRowBounds(1);
		g.drawLine(c.x, r.y, ca.right()-1, r.y);
	}
}
