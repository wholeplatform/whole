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
public class SubSupLayout extends AbstractEntityLayout {
	protected int placeholderMargin = 4;

	public int getPlaceholderMargin() {
		return placeholderMargin;
	}
	public SubSupLayout withPlaceholderMargin(int margin) {
		this.placeholderMargin = margin;
		return this;
	}

	//TODO gestione sovrapposizione sub sup
	protected void setAscentDescentWidth(int wHint, int hHint) {
		boolean isSubVisible = childFigure[1].isVisible();
		boolean isSupVisible = childFigure[2].isVisible();

		figAscent = ascent(0) + (isSupVisible ? ascent(2) : 0);//placeholderMargin);
		figDescent = descent(0) + (isSubVisible ? descent(1) : 0);//placeholderMargin);
		figWidth = childSize[0].width + Math.max(
				isSubVisible ? childSize[1].width : placeholderMargin,
				isSupVisible ? childSize[2].width : placeholderMargin);
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		boolean isSubVisible = childFigure[1].isVisible();
		boolean isSupVisible = childFigure[2].isVisible();

		x[0] = area.x;
		y[0] = area.y+ (isSupVisible ? ascent(2) : 0);//placeholderMargin);

		int sx = area.x+childSize[0].width;
		if (isSubVisible) {
			x[1] = sx;
			y[1] = area.y+figAscent+descent(0)-ascent(1);
		}
		if (isSupVisible) {
			x[2] = sx;
			y[2] = area.y;
		}
	}
}
