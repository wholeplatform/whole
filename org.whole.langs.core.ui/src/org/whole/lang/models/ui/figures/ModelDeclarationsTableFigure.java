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
package org.whole.lang.models.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class ModelDeclarationsTableFigure extends TableFigure {
	public ModelDeclarationsTableFigure() {
		super(new TableLayout(3)
				.withColumnSpacing(10).withRowSpacing(10).withMarginTop(5).withMarginBottom(5).withMarginLeft(5));

		setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);

		TableRowFigure headers = new TableRowFigure();
		Color color = ColorConstants.gray;
		EntityLabel label = new EntityLabel("Supertypes");
		label.setForegroundColor(color);
		headers.add(label);
		label = new EntityLabel(" Entity");
		label.setForegroundColor(color);
		headers.add(label);
		label = new EntityLabel("Structure");
		label.setForegroundColor(color);
		headers.add(label);
		add(headers, TableLayout.Placement.HEADER);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		TableLayout l = getLayoutManager();
		if (l.rows() == 0)
			return;

		g.setBackgroundColor(ColorConstants.gray);
		drawHeadersRowBackground(g);

		g.setBackgroundColor(FigureConstants.modulesColor);
		int oldAlpha = g.getAlpha();
		g.setAlpha(getBackgroundAlpha());
		Rectangle tb = getTableBounds();
		Rectangle cb1 = l.getColumnBounds(1);
		g.fillRectangle(cb1.x, tb.y, cb1.width, tb.height);
		g.setAlpha(oldAlpha);

		g.setForegroundColor(ColorConstants.lightGray);
		drawRowSeparators(g);
		drawHeadersRowSeparator(g);
		drawTableBottomBorder(g);
	}
}
