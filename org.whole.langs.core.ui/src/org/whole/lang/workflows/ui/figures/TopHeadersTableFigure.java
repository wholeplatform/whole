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
package org.whole.lang.workflows.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.ICompositeEntityLayout;

/**
 * @author Riccardo Solmi
 */
public class TopHeadersTableFigure extends TableFigure {
	public TopHeadersTableFigure(ICompositeEntityLayout layout) {
		super(layout);
	}
	public TopHeadersTableFigure(int columns) {
		super(columns);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		g.setBackgroundColor(ColorConstants.darkGray);
		drawHeadersRowBackground(g);

		g.setBackgroundColor(ColorConstants.white);
		drawAlternateRowsBackground(g, 0, 255);
		drawAlternateRowsBackground(g, 1, 255);

		g.setForegroundColor(ColorConstants.lightGray);
		drawColumnSeparators(g);
		drawRowSeparators(g);

		g.setForegroundColor(ColorConstants.gray);
		drawHeadersRowSeparator(g);
		drawTableBorder(g);
	}
}
