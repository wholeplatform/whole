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
public class RowLayout extends AbstractCompositeEntityLayout {
	{
		withMinorAlignment(Alignment.MATHLINE);
	}

	public boolean isHorizontal() {
		return true;
	}

	@Override
	protected boolean calculateChildrenSize(int wHint, int hHint, boolean preferred) {
		figWidth = 0;

		boolean isFirst = true;
		int hintsSensitiveCount = 0;
		int size = childFigure.length;
		childSize = new BaselinedDimension[size];
		for (int i=0; i<size; i++)
			if (childFigure[i].isVisible()) {
				childSize[i] = getChildSize(childFigure[i],
						wHint < 0 ? wHint : Math.max(0, wHint-figWidth), hHint, preferred);
				if (childSize[i].hintsSensitive) {
					hintsSensitiveCount++;
					figWidth += (isFirst ? 0 : getSpacingBefore(i));
				} else
					figWidth += (isFirst ? 0 : getSpacingBefore(i)) + childSize[i].width;
				isFirst = false;
			}
		if (hintsSensitiveCount > 0) {
			int wHint2 = Math.max(0, wHint-figWidth) / hintsSensitiveCount;
			for (int i=0; i<size; i++)
				if (childSize[i] != null && childSize[i].hintsSensitive) {
					childSize[i] = getChildSize(childFigure[i], wHint2, hHint, preferred);
					figWidth += childSize[i].width;
				}
		}

		figAscent = 0;
		figDescent = 0;

		switch (getMinorAlignment()) {
		case MATHLINE:
			for (int i=0; i<childSize.length; i++)
				if (isChildVisible(i)) {
					figAscent = Math.max(figAscent, ascent(i));
					figDescent = Math.max(figDescent, descent(i));
				}			
			break;
		case FILL:
		case LEADING:
			for (int i=0; i<childSize.length; i++)
				if (isChildVisible(i))
					figDescent = Math.max(figDescent, childSize[i].height);
			break;
		case CENTER:
			int figHeight = 0;
			for (int i=0; i<childSize.length; i++)
				if (isChildVisible(i))
					figHeight = Math.max(figHeight, childSize[i].height);
			figAscent = figHeight/2;
			figDescent = figHeight - figAscent;
			break;
		case TRAILING:
			for (int i=0; i<childSize.length; i++)
				if (isChildVisible(i))
					figAscent = Math.max(figAscent, childSize[i].height);
			break;
		}

//		if (wHint >= 0 && figWidth > wHint)
//			calculateChildrenSize(figWidth, hHint, preferred);

		return hintsSensitiveCount > 0;
	}
	@Override
	protected void setAscentDescentWidth(int wHint, int hHint) {}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		int xi = calculateXLocation(area, getMajorAlignment());

		int children = childSize.length;
		float stretching = 0;
		if (getMajorAutoresizeWeight()>0) {
			boolean isFirst = true;
			stretching = area.width;
			for (int i=0; i<children; i++)
				if (isChildVisible(i)) {
					stretching -= (isFirst ? 0 : getSpacingBefore(i)) + childSize[i].width;
					isFirst = false;
				}
		}
		for (int i=0; i<children; i++)
			if (isChildVisible(i)) {
				int heightStretching = (int) ((figAscent+figDescent - childSize[i].height) * getMinorAutoresizeWeight(i));

				x[i] = xi;
				switch (getMinorAlignment()) {
				case FILL:
				case LEADING:
					y[i] = area.y;
					break;
				case CENTER:
					y[i] = area.y + figAscent-childSize[i].height/2-heightStretching/2;
					break;
				case MATHLINE:
					y[i] = area.y + figAscent-ascent(i);
					break;
				case TRAILING:
					y[i] = area.y + figAscent-ascent(i)-descent(i)-heightStretching;
					break;
				}
				if (heightStretching > 0) {
					childFigure[i].getLayoutManager().getViewportTrackingStrategy().setAscent(
							getMinorAlignment().equals(Alignment.MATHLINE) ? y[i] - area.y : 0);
					y[i] = area.y;
				} else if (childFigure[i].getLayoutManager() != null)
					childFigure[i].getLayoutManager().getViewportTrackingStrategy().setAscent(0);

				childSize[i].width += (int) (stretching*getMajorAutoresizeWeight(i));
				childSize[i].height += heightStretching;

				xi += childSize[i].width + getSpacingBefore(i+1);
			}
	}
}
