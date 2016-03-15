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
package org.whole.lang.ui.notations.map.borders;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.PaintFigureHelper;

/**
 * @author Riccardo Solmi
 */
public class RoundRectangleStyledBorder extends AbstractStyledBorder {
	public RoundRectangleStyledBorder() {
		super();
	}
	public RoundRectangleStyledBorder(IStyledBorder styledBorder) {
		super(styledBorder);
	}
	public RoundRectangleStyledBorder(Color lineColor, int lineStyle, int lineWidth) {
		super(lineColor, lineStyle, lineWidth);
	}

	public void paintBackground(IFigure figure, Graphics graphics, Insets insets) {
		if (getFillColor() != null) {
			updateTempRect(figure, insets);

			if (getFillGradient() == FillGradient.NONE) {
				graphics.setBackgroundColor(getFillColor());
				graphics.fillRoundRectangle(tempRect, getArcWidth(), getArcHeight());
			} else {
				PaintFigureHelper.fillGradientRoundRectangle(graphics,
						getFillColor(), safeGetFillColor2(),
						tempRect, getArcWidth(), getArcHeight(), getFillGradient() == FillGradient.VERTICAL);
			}
		}
	}
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		updateTempRect(figure, insets);

		graphics.setLineWidth(getLineWidth());
		graphics.setLineStyle(getLineStyle());
		graphics.setForegroundColor(getLineColor());

		graphics.drawRoundRectangle(tempRect, getArcWidth(), getArcHeight());
	}
	protected void updateTempRect(IFigure figure, Insets insets) {
		/*tempRect =*/ getPaintRectangle(figure, insets);

		int lineWidth = getLineWidth();
		if (lineWidth % 2 == 1) {
			tempRect.width--;
			tempRect.height--;
		}
		tempRect.shrink(lineWidth / 2, lineWidth / 2);
	}

	protected int getArcWidth() {
		return 24;
	}
	protected int getArcHeight() {
		return 16;
	}
}