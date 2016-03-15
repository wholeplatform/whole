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
 * 
 */
public class FlowLayout extends AbstractCompositeEntityLayout {
	protected int[] lineAscent;
	protected int[] lineDescent;
	protected int minorSpacing;

	{
		withMinorAlignment(Alignment.MATHLINE);
	}

	public boolean isHorizontal() {
		return true;
	}

	public int getMinorSpacing() {
		return minorSpacing;
	}
	public ICompositeEntityLayout withMinorSpacing(int spacing) {
		this.minorSpacing = spacing;
		return this;
	}

	@Override
	protected boolean calculateChildrenSize(int wHint, int hHint, boolean preferred) {
		super.calculateChildrenSize(wHint, hHint, preferred);//FIXME hints ?
		return true;
	}
	protected void setAscentDescentWidth(int wHint, int hHint) {
		int maxWidth = wHint >= 0 ? wHint : Integer.MAX_VALUE;
		int lines = 1;
		int lineWidth = 0;
	
		boolean isFirst = true;
		figWidth = 0;
		lineWidth = 0;
		for (int i=0; i<childSize.length; i++)
			if (isChildVisible(i)) {
				if (isFirst || lineWidth + getSpacingBefore(i) + getSpacing() + childSize[i].width <= maxWidth) {
					lineWidth += (isFirst ? 0 : getSpacingBefore(i) + getSpacing()) + childSize[i].width;
					isFirst = false;
				} else {
					figWidth = Math.max(figWidth, lineWidth);
					lineWidth = childSize[i].width;
					lines++;
				}
			}
		figWidth = Math.max(figWidth, lineWidth);

		lineAscent = new int[lines];
		lineDescent = new int[lines];

		isFirst = true;
		int line = 0;
		lineWidth = 0;
		switch (getMinorAlignment()) {
		case MATHLINE:
			for (int i=0; i<childSize.length; i++)
				if (isChildVisible(i)) {
					if (isFirst || lineWidth + getSpacingBefore(i) + getSpacing() + childSize[i].width <= maxWidth) {
						lineWidth += (isFirst ? 0 : getSpacingBefore(i) + getSpacing()) + childSize[i].width;
						isFirst = false;
					} else {
						lineWidth = childSize[i].width;
						line++;
					}

					lineAscent[line] = Math.max(lineAscent[line], ascent(i));
					lineDescent[line] = Math.max(lineDescent[line], descent(i));
				}
			break;
		case FILL:
		case LEADING:
			for (int i=0; i<childSize.length; i++)
				if (isChildVisible(i)) {
					if (isFirst || lineWidth + getSpacingBefore(i) + childSize[i].width <= maxWidth) {
						lineWidth += (isFirst ? 0 : getSpacingBefore(i)) + childSize[i].width;
						isFirst = false;
					} else {
						lineWidth = childSize[i].width;
						line++;
					}

					lineAscent[line] = 0;
					lineDescent[line] = Math.max(lineDescent[line], childSize[i].height);
				}
			break;
		case CENTER:
			int lineHeight = 0;
			for (int i=0; i<childSize.length; i++)
				if (isChildVisible(i)) {
					if (isFirst || lineWidth + getSpacingBefore(i) + childSize[i].width <= maxWidth) {
						lineWidth += (isFirst ? 0 : getSpacingBefore(i)) + childSize[i].width;
						isFirst = false;
					} else {
						lineAscent[line] = lineHeight/2;
						lineDescent[line] = lineHeight - lineAscent[line];
						lineWidth = childSize[i].width;
						lineHeight = 0;
						line++;
					}

					lineHeight = Math.max(lineHeight, childSize[i].height);
				}
			lineAscent[line] = lineHeight/2;
			lineDescent[line] = lineHeight - lineAscent[line];
			break;
		case TRAILING:
			for (int i=0; i<childSize.length; i++)
				if (isChildVisible(i)) {
					if (isFirst || lineWidth + getSpacingBefore(i) + childSize[i].width <= maxWidth) {
						lineWidth += (isFirst ? 0 : getSpacingBefore(i)) + childSize[i].width;
						isFirst = false;
					} else {
						lineWidth = childSize[i].width;
						line++;
					}

					lineAscent[line] = Math.max(lineAscent[line], childSize[i].height);
					lineDescent[line] = 0;
				}
			break;
		}
		figAscent = lineAscent[0];
		figDescent = lineDescent[0];
		for (int i=1; i<lines; i++)
			figDescent += lineAscent[i] + lineDescent[i] + minorSpacing;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		int maxWidth = area.width;
		int children = childSize.length;

//TODO
//		float stretching = 0;
//		if (getStretchingWidthFactor()>0) {
//			stretching = area.width - marginLeft - marginRight;
//			for (int i=0; i<children; i++)
//				if (figure[i].isVisible())
//					stretching -= (i>0 ? spacing : 0) + prefSize[i].width;
//		}

		int xiMax = area.x + maxWidth;
		int xi = area.x;
		int yi = area.y;
		boolean isFirst = true;
		int line = 0;
		for (int i=0; i<children; i++)
			if (isChildVisible(i)) {
				if (isFirst || xi + getSpacingBefore(i) + childSize[i].width <= xiMax) {
					x[i] = xi + (isFirst ? 0 : getSpacingBefore(i));
					xi += (isFirst ? 0 : getSpacingBefore(i)) + childSize[i].width;
					isFirst = false;
				} else {
					x[i] = xi = area.x;
					xi += childSize[i].width;
					yi += lineAscent[line] + lineDescent[line] + minorSpacing; 
					line++;
				}

				switch (getMinorAlignment()) {
				case FILL:
				case LEADING:
					y[i] = yi;
					break;
				case CENTER:
					y[i] = yi + lineAscent[line]-childSize[i].height/2;
					break;
				case MATHLINE:
					y[i] = yi + lineAscent[line]-ascent(i);
					break;
				case TRAILING:
					y[i] = yi + lineAscent[line]-ascent(i)-descent(i);
					break;
				}
//				prefSize[i].width += (int) (stretching*getStretchingWidthFactor(i));
			}
	}
}
