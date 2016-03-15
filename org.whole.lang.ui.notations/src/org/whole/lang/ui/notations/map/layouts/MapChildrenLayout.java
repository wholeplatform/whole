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
package org.whole.lang.ui.notations.map.layouts;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.layout.AbstractCompositeEntityLayout;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ICompositeEntityLayout;

/**
 * @author Riccardo Solmi
 */
public class MapChildrenLayout extends AbstractCompositeEntityLayout {
	{
		withMinorAlignment(Alignment.CENTER);
	}

	private int minorSpacing;
	public int getMinorSpacing() {
		return minorSpacing;
	}
	public ICompositeEntityLayout withMinorSpacing(int minorSpacing) {
		this.minorSpacing = minorSpacing;
		return this;
	}

	public Alignment getMinorAlignment(int childIndex) {
		return getMinorAlignment();
	}

	public boolean isHorizontal() {
		return false;
	}

	private MapLayout mapLayout;
	public MapChildrenLayout withMapLayout(MapLayout layout) {
		mapLayout = layout;
		return this;
	}
	public Dimension getCenterSize() {
		return mapLayout.getCenterSize();
	}

	protected int leftWidth;
	protected int rightWidth;
	protected int leftHeight;
	protected int rightHeight;
	protected int rightSize;

	protected void setAscentDescentWidth(int wHint, int hHint) {
		int totalHeight = 0;
		for (int i=0; i<childSize.length; i++)
			if (isChildVisible(i))
				totalHeight += childSize[i].height;
		final int midHeight = (totalHeight+1)/2;

		leftWidth = 0;
		rightWidth = 0;
		leftHeight = 0;
		rightHeight = 0;

		boolean isFirst = true;
		for (int i=0; i<childSize.length; i++)
			if (isChildVisible(i)) {
				if (midHeight-rightHeight >= Math.abs(midHeight-(rightHeight+childSize[i].height))) {
					rightWidth = Math.max(rightWidth, childSize[i].width);
					rightHeight += childSize[i].height + (isFirst ? 0 : getSpacingBefore(i));
					isFirst = false;
				} else {
					rightSize = i;
					for (; i<childSize.length; i++)
						if (isChildVisible(i)) {
							leftWidth = Math.max(leftWidth, childSize[i].width);
							leftHeight += childSize[i].height + (isFirst ? 0 : getSpacingBefore(i));
							isFirst = false;
						}
				}
			}

		int figHeight = Math.max(Math.max(leftHeight, rightHeight), getCenterSize().height);
		figAscent = figHeight/2;
		figDescent = figHeight - figAscent;
		figWidth = leftWidth + getMinorSpacing()*2 + getCenterSize().width + rightWidth;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
//TODO
//		if (getStretchingWidthFactor()>0)
//			for (int i=0; i<children; i++)
//				if (figure[i].isVisible())
//					prefSize[i].width += (area.width-prefSize[i].width)*getStretchingWidthFactor();

		int deltaY = (leftHeight - rightHeight)/2;

		int i=0;
		int yi = calculateYLocation(area, getMajorAlignment()) + Math.max(deltaY, 0);

		for (; i<rightSize; i++)
			if (isChildVisible(i)) {
				switch (getMinorAlignment(i)) {
				case CENTER:
				case MATHLINE:
					x[i] = area.x + leftWidth + getMinorSpacing()*2 + getCenterSize().width;
					break;
				case FILL:
				case LEADING:
				case TRAILING:
					x[i] = area.right() - childSize[i].width;
					break;
				}

				y[i] = yi;
				yi += childSize[i].height + getSpacingBefore(i);
			}

		yi = area.y + Math.max(-deltaY, 0);

		for (int children = childSize.length; i<children; i++)
			if (isChildVisible(i)) {
				switch (getMinorAlignment(i)) {
				case CENTER:
				case MATHLINE:
					x[i] = area.x + leftWidth - childSize[i].width;
					break;
				case FILL:
				case LEADING:
				case TRAILING:
					x[i] = area.x;
					break;
				}

				y[i] = yi;
				yi += childSize[i].height + getSpacingBefore(i);
			}			
	}
}
