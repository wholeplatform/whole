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
package org.whole.lang.steppers.ui.layouts;

import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.layout.AbstractCompositeEntityLayout;
import org.whole.lang.ui.layout.Alignment;

/**
 * @author Riccardo Solmi
 */
public class ObliqueLayout extends AbstractCompositeEntityLayout {
	protected int[] xi;
	protected double escapeAngle = 0.4;

	public ObliqueLayout withEscapeAngle(double angle) {
		this.escapeAngle = angle;
		return this;
	}
	public double getEscapeAngle() {
		return escapeAngle;
	}

	@Override
	protected int getIndent() {
		return childSize.length > 0 ? getMinorAlignment().equals(Alignment.LEADING) ? childSize[childSize.length-1].getIndent() : childSize[0].getIndent() : 0;
	}

	@Override
	protected void setAscentDescentWidth(int wHint, int hHint) {
		figWidth = 0;
		int figHeight = 0;
		
		xi = new int[childSize.length];
		if (childSize.length > 0) {
			if (getMinorAlignment().equals(Alignment.LEADING)) {
				xi[childSize.length-1] = 0;
				figWidth = childSize[childSize.length-1].width;
				figHeight = childSize[childSize.length-1].height;
	
				for (int i=childSize.length-2; i>=0; i--) {
					int yDelta = childSize[i].height + getSpacingBefore(i+1);
					xi[i] = (int)(yDelta * escapeAngle) + xi[i+1];
					figWidth = Math.max(figWidth, xi[i] + childSize[i].width);
					figHeight += yDelta;
				}
			} else {
				xi[0] = 0;
				figWidth = childSize[0].width;
				figHeight = childSize[0].height;
	
				for (int i=1; i<childSize.length; i++) {
					int yDelta = childSize[i].height + getSpacingBefore(i);
					xi[i] = (int)(yDelta * escapeAngle) + xi[i-1];
					figWidth = Math.max(figWidth, xi[i] + childSize[i].width);
					figHeight += yDelta;
				}
			}
		}

		figAscent = figHeight / 2;
		figDescent = figHeight - figAscent;
	}

	@Override
	protected void setLocation(Rectangle area, int[] x, int[] y) {
		int yi = area.y;

		for (int i=0; i<childSize.length; i++) {
			x[i] = getMinorAlignment().equals(Alignment.LEADING) ? area.x + xi[i] : area.x + figWidth - xi[i] - childSize[i].width;
			y[i] = yi;
			yi += childSize[i].height + getSpacingBefore(i+1);
		}
	}
}

