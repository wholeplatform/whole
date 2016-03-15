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
public class BinaryTreeLayout extends AbstractEntityLayout {
	public static final int hspacing = 4, vspacing = 8;
	
	protected void setAscentDescentWidth(int wHint, int hHint) {
		int figHeight = childSize[0].height + Math.max(childSize[1].height, childSize[2].height) + vspacing;
		figAscent = figHeight/2;
		figDescent = figHeight - figAscent;
		figWidth = Math.max(childSize[0].width,
				childSize[1].width + childSize[2].width + hspacing);
//				Math.max(prefSize[1].width, prefSize[2].width)+
//				(prefSize[1].width + prefSize[2].width)/2 + hspacing);
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
//		x[0] = area.x + Math.max(0, (prefSize[1].width + Math.max(prefSize[1].width, prefSize[2].width) + hspacing)/2 - prefSize[0].width/2);
		x[0] = area.x + Math.min(
				Math.max(0, childSize[1].width + hspacing/2 - childSize[0].width/2),
				area.width - childSize[0].width);
		y[0] = area.y;
		
		x[1] = area.x;
		x[2] = area.x + area.width - childSize[2].width;
		y[1] = y[2] = area.y+childSize[0].height + vspacing;
	}
}
