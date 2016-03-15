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
public class FishboneRowLayout extends AbstractCompositeEntityLayout {
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
		return true;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		int[] ascentDescent = new int[2];
		int[] min = new int[2];
		int[] max = new int[2];
		min[0] = min[1] = max[0] = max[1] = 0;
		for (int i=0; i<childSize.length; i++)
			if (isChildVisible(i)) {
				ascentDescent[i%2] = Math.max(ascentDescent[i%2], childSize[i].height);
				
				min[i%2] = Math.max(max[i%2], min[(i+1)%2]) + getSpacingBefore(i);
				max[i%2] = min[i%2]+childSize[i].width;
				figWidth = Math.max(max[0], max[1]);
			}
		figAscent = ascentDescent[0]+getMinorSpacing();
		figDescent = getMinorSpacing()+ascentDescent[1];
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		int[] min = new int[2];
		int[] max = new int[2];
		min[0] = min[1] = max[0] = max[1] = calculateXLocation(area, getMajorAlignment());

		int children = childSize.length;
		//TODO
//				if (getStretchingWidthFactor()>0)
//					for (int i=0; i<children; i++)
//						if (figure[i].isVisible())
//							prefSize[i].width += (area.width-prefSize[i].width)*getStretchingWidthFactor();
		for (int i=0; i<children; i++)
			if (isChildVisible(i)) {
				switch (getMinorAlignment(i)) {
				case CENTER:
				case MATHLINE:
					y[i] = area.y + figAscent +
						(i%2 == 0 ? -childSize[i].height-getMinorSpacing() : +getMinorSpacing());
					break;
				case FILL:
				case LEADING:
				case TRAILING:
					if (i%2 == 0)
						y[i] = area.y;
					else
						y[i] = area.bottom() - childSize[i].height;
					break;
				}

				x[i] = min[i%2] = Math.max(max[i%2], min[(i+1)%2]) + getSpacingBefore(i);
				max[i%2] = min[i%2]+childSize[i].width;
			}
	}
}
