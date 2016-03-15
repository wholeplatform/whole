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
package org.whole.lang.environment.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.EyeFigure;
import org.whole.lang.ui.figures.TableRowFigure;

/**
 * @author Riccardo Solmi
 */
public class ScopeFigure extends TableRowFigure {
	public ScopeFigure() {//ActionListener action) {
		getLayoutManager().withMargin(16,4,4,4);

		addContentLight("Id");
		addContentLight("Type");
		addContentLight("Name");
		add(new EyeFigure());
		addContentLight("Value");
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		Rectangle rowBounds = getBounds();
		g.setBackgroundColor(ColorConstants.darkGray);
		int oldAlpha = g.getAlpha();
		g.setAlpha(40);
		g.fillRectangle(rowBounds.x, rowBounds.y, rowBounds.width, rowBounds.height);
		g.setAlpha(oldAlpha);

		g.setForegroundColor(ColorConstants.gray);
		g.drawLine(rowBounds.x, rowBounds.y, rowBounds.right(), rowBounds.y);
	}
}
