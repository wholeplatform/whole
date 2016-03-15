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
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class EnumValuesFigure extends TableFigure {
	public EnumValuesFigure() {
		super(new TableLayout(2) {
			@Override
			protected int getAscent(int height) {
				return childSize.length > 0 ? ascent(0)+1 : super.getAscent(height);
			}
		}
		.withRowSpacing(4).withColumnSpacing(8)
		.withMargin(1, 5, 2, 5));
	
		setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);

		TableRowFigure headers = new TableRowFigure();
		Color color = ColorConstants.gray;
		EntityLabel label = new EntityLabel("Value");
		label.setForegroundColor(color);
		headers.add(label);
		label = new EntityLabel("Result");
		label.setForegroundColor(color);
		headers.add(label);
		add(headers, TableLayout.Placement.HEADER);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		TableLayout l = getLayoutManager();
		if (l.rows() == 0)
			return;

		g.setForegroundColor(ColorConstants.lightGray);
		drawHeadersRowSeparator(g);
		drawColumnSeparators(g);
	}
}
