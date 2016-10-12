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
package org.whole.lang.ui.layout;

import org.eclipse.draw2d.geometry.Rectangle;


/**
 * @author Riccardo Solmi
 */
public class SubLayout extends AbstractEntityLayout {
	protected int shift = 3;
	public SubLayout withVerticalShift(int shift) {
		this.shift = shift;
		return this;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		figAscent = Math.max(ascent(0), ascent(1)+shift-descent(0));
		figDescent = descent(0)+descent(1);
		figWidth = childSize[0].width + childSize[1].width;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		x[0] = area.x;
		y[0] = area.y+Math.max(figAscent-ascent(0), 0);
		
		x[1] = area.x+childSize[0].width;
		y[1] = area.y+figAscent-(ascent(1)+shift-descent(0));
	}
}
