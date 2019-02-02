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
package org.whole.lang.queries.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.CurlyBracketsBorder;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class ChooseTableFigure extends TableFigure {
	public ChooseTableFigure(boolean withBorder) {
		super(new TableLayout(2)
				.withColumnSpacing(24).withRowSpacing(10).withMarginTop(5).withMarginBottom(5));

		if (withBorder)
			setBorder(new CurlyBracketsBorder() {
				@Override
				protected void setBracketsStyle(Graphics g) {
					g.setForegroundColor(ColorConstants.gray);
					g.setLineWidth(2);
				}
			});
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		TableLayout l = getLayoutManager();
		if (l.rows() == 0)
			return;

		g.setForegroundColor(ColorConstants.lightGray);
		drawRowSeparators(g);
	}
}
