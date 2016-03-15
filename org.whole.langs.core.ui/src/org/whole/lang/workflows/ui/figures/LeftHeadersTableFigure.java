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
package org.whole.lang.workflows.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.ICompositeEntityLayout;

/**
 * @author Riccardo Solmi
 */
public class LeftHeadersTableFigure extends TableFigure {
	public LeftHeadersTableFigure(ICompositeEntityLayout layout) {
		super(layout);
	}
	public LeftHeadersTableFigure(int columns) {
		super(columns);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		g.setBackgroundColor(ColorConstants.darkGray);
		drawAlternateColumnsBackground(g, 0);

		g.setBackgroundColor(ColorConstants.white);
		drawAlternateColumnsBackground(g, 1, 255);

		g.setForegroundColor(ColorConstants.lightGray);
		drawRowSeparators(g);
		g.setForegroundColor(ColorConstants.gray);
		drawColumnSeparators(g);

		g.setForegroundColor(ColorConstants.gray);
		drawHeadersRowSeparator(g);
		drawTableBorder(g);
	}
}
