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
package org.whole.lang.ui.util;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;

/** 
 * @author Enrico Persiani
 */
public class FigureUtils {
	public static int getPositionOf(IFigure figure, IFigure relativeTo) {
		return getApproximatePositionOf(figure, relativeTo, 0.0);
	}
	public static int getApproximatePositionOf(IFigure figure, IFigure relativeTo, double approx) {
		Rectangle bounds = figure.getBounds();
		Rectangle relativeToBounds = relativeTo.getBounds();
		
		int hApprox = (int) Math.round(bounds.width * approx);
		int vApprox = (int) Math.round(bounds.height * approx);

		if (bounds.x + hApprox > relativeToBounds.right())
			return PositionConstants.EAST;
		else if (bounds.right() - hApprox < relativeToBounds.x)
			return PositionConstants.WEST;
		else if (bounds.y + vApprox > relativeToBounds.bottom())
			return PositionConstants.SOUTH;
		else if (bounds.bottom() - vApprox < relativeToBounds.y)
			return PositionConstants.NORTH;
		else
			return PositionConstants.NONE;
	}
}
