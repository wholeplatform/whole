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
public class UnderOverLayout extends AbstractEntityLayout {
	public boolean stretch;

	public UnderOverLayout() {
	}
	public UnderOverLayout(boolean stretch) {
		this.stretch = stretch;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		figAscent = ascent(0) + childSize[2].height;
		figDescent = descent(0) + childSize[1].height;
		figWidth = Math.max(childSize[0].width, Math.max(childSize[1].width, childSize[2].width));
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		if (stretch)
			childSize[0].width = childSize[1].width = childSize[2].width = area.width;

		x[0] = area.x+(area.width - childSize[0].width)/2;
		y[0] = area.y+childSize[2].height;

		x[1] = area.x+(area.width - childSize[1].width)/2;
		y[1] = area.y+childSize[2].height+childSize[0].height;

		x[2] = area.x+(area.width - childSize[2].width)/2;
		y[2] = area.y;
	}
}
