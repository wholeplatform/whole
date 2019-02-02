/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class VariantsFigure extends TableFigure {
	public VariantsFigure() {
		super(2);
		getLayoutManager().withRowSpacing(8);
		setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);
	}

	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		TableLayout l = getLayoutManager();
		if (l.rows() == 0)
			return;

		g.setBackgroundColor(ColorConstants.orange);
		g.setBackgroundColor(ColorConstants.orange);
		
		int oldAlpha = g.getAlpha();
		g.setAlpha(100);
		Rectangle tb = getTableBounds();
		Rectangle cb = l.getColumnBounds(1);
		g.fillRectangle(cb.x, tb.y, cb.width+1, tb.height);
		g.setAlpha(oldAlpha);

		g.setForegroundColor(ColorConstants.orange);
		drawRowSeparators(g);
	}
}
