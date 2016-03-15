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
package org.whole.lang.features.ui.borders;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.whole.lang.ui.notations.map.borders.FillGradient;
import org.whole.lang.ui.notations.map.borders.RectangleStyledBorder;

/**
 * @author Riccardo Solmi
 */
public class AttributeRightStyledBorder extends RectangleStyledBorder {

	@Override
	public void paintBackground(IFigure figure, Graphics graphics, Insets insets) {
		if (getFillColor() != null) {
			updateTempRect(figure, insets);
			tempRect.resize(- ((IFigure) figure.getChildren().get(1)).getBounds().width-8, 0);

			if (getFillGradient() == FillGradient.NONE) {
				graphics.setBackgroundColor(getFillColor());
				graphics.fillRectangle(tempRect);
			} else {
				graphics.setForegroundColor(getFillColor());
				graphics.setBackgroundColor(safeGetFillColor2());
				graphics.fillGradient(tempRect, getFillGradient() == FillGradient.VERTICAL);
			}
			graphics.setForegroundColor(getLineColor());
			graphics.drawLine(tempRect.right(), tempRect.y, tempRect.right(), tempRect.bottom()-1);
		}
	}
}
