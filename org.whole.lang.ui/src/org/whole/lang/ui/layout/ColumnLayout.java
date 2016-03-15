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
public class ColumnLayout extends AbstractCompositeEntityLayout {
	int figIndent;

	{
		withMinorAlignment(Alignment.LEADING);
	}
	
	public boolean isHorizontal() {
		return false;
	}

	@Override
	protected int getIndent() {
		return figIndent;
	}

	@Override
	protected boolean calculateChildrenSize(int wHint, int hHint, boolean preferred) {
		int figHeight = 0;

		boolean hintsSensitive = false;
		boolean isFirst = true;
		int size = childFigure.length;
		childSize = new BaselinedDimension[size];
		for (int i=0; i<size; i++)
			if (childFigure[i].isVisible()) {
				childSize[i] = getChildSize(childFigure[i], wHint,
						hHint < 0 ? hHint : Math.max(0, hHint-figHeight), preferred);
				hintsSensitive |= childSize[i].hintsSensitive;
				figHeight += (isFirst ? 0 : getSpacingBefore(i)) + childSize[i].height;
				isFirst = false;
			}

		figAscent = getAscent(figHeight);
		figDescent = figHeight - figAscent;

		switch (getMinorAlignment()) {
		case MATHLINE:
			figIndent = 0;
			int figRightIndent = 0;
			for (int i=0; i<childSize.length; i++)
				if (isChildVisible(i)) {
					int wai = indent(i);
					figIndent = Math.max(figIndent, wai);
					figRightIndent = Math.max(figRightIndent, childSize[i].width - wai);
				}
			figWidth = figIndent + figRightIndent;
			break;
		default:
			figWidth = 0;
			for (int i=0; i<childSize.length; i++)
				if (isChildVisible(i))
					figWidth = Math.max(figWidth, childSize[i].width);
		}

		if (hHint >= 0 && figHeight > hHint)
			calculateChildrenSize(wHint, figHeight, preferred);		

		return hintsSensitive;
	}
	@Override
	protected void setAscentDescentWidth(int wHint, int hHint) {}

	protected int getAscent(int height) {
		return height/2;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		int yi = calculateYLocation(area, getMajorAlignment());
	
		int children = childSize.length;
		float stretching = 0;
		if (getMajorAutoresizeWeight()>0) {
			boolean isFirst = true;
			stretching = area.height;
			for (int i=0; i<children; i++)
				if (isChildVisible(i)) {
					stretching -= (isFirst ? 0 : getSpacingBefore(i)) + childSize[i].height;
					isFirst = false;
				}
		}
		for (int i=0; i<children; i++)
			if (isChildVisible(i)) {
				int widthStretching = (int) ((figWidth - childSize[i].width) * getMinorAutoresizeWeight(i));

				switch (getMinorAlignment()) {
				case FILL:
					childSize[i].width = area.width;
				case LEADING:
					x[i] = area.x;
					break;
				case MATHLINE:
					x[i] = area.x + figIndent-indent(i);
					break;
				case CENTER:
					x[i] = area.x + (area.width - childSize[i].width)/2-widthStretching/2;
					break;
				case TRAILING:
					x[i] = area.right() - childSize[i].width-widthStretching;
					break;
				}
				y[i] = yi;

				if (widthStretching > 0) {
					childFigure[i].getLayoutManager().getViewportTrackingStrategy().setIndent(
							getMinorAlignment().equals(Alignment.MATHLINE) ? x[i] - area.x : 0);
					x[i] = area.x;
				} else if (childFigure[i].getLayoutManager() != null)
					childFigure[i].getLayoutManager().getViewportTrackingStrategy().setIndent(0);

				childSize[i].height += (int) (stretching*getMajorAutoresizeWeight(i));
				childSize[i].width += widthStretching;

				yi += childSize[i].height + getSpacingBefore(i+1);
			}
	}
}
