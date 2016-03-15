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
public class StackLayout extends AbstractCompositeEntityLayout {
	int figIndent;

	@Override
	protected int getIndent() {
		return figIndent;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		figAscent = 0;
		figDescent = 0;
		figIndent = 0;
		int figRightIndent = 0;
		for (int i=0; i<childSize.length; i++)
			if (isChildVisible(i)) {
				figAscent = Math.max(figAscent, ascent(i));
				figDescent = Math.max(figDescent, descent(i));
				int wai = indent(i);
				figIndent = Math.max(figIndent, wai);
				figRightIndent = Math.max(figRightIndent, childSize[i].width - wai);
			}
		figWidth = figIndent + figRightIndent;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		int xi = calculateXLocation(area, getMinorAlignment());
		int yi = calculateYLocation(area, getMajorAlignment());
		for (int i=0; i<childSize.length; i++)
			if (isChildVisible(i)) {
				x[i] = xi + figIndent-indent(i);
				y[i] = yi + figAscent-ascent(i);
			}
	}
}
