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
public class FractionLayout extends AbstractEntityLayout {
	protected int placeholderMargin = 8;
	protected int spacing = 1;

	public int getPlaceholderMargin() {
		return placeholderMargin;
	}
	public FractionLayout withPlaceholderMargin(int margin) {
		this.placeholderMargin = margin;
		return this;
	}

	public int getSpacing() {
		return spacing;
	}
	public FractionLayout withSpacing(int spacing) {
		this.spacing = spacing;
		return this;
	}
	@Override
	protected int getSpacedSpacing(int spacing) {
		return 3;
	}


	protected int getDividendIndex() {
		return 0;
	}
	protected int getDivisorIndex() {
		return 1;
	}
	protected int getFractionIndex() {
		return 2;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		boolean isDividendVisible = childFigure[getDividendIndex()].isVisible();
		boolean isDivisorVisible = childFigure[getDivisorIndex()].isVisible();
		boolean isFractionVisible = childFigure[getFractionIndex()].isVisible();
		
		if (isFractionVisible || (isDividendVisible && isDivisorVisible)) {
			figAscent = getSpacingBefore(1) + (isDividendVisible ? childSize[getDividendIndex()].height : placeholderMargin);
			figDescent = getSpacingBefore(1) + (isDivisorVisible ? childSize[getDivisorIndex()].height : placeholderMargin);
			if (isFractionVisible)
				figDescent += 1;
		} else if (isDividendVisible) {//&& !isDivisorVisible
			figAscent = (int) Math.floor(childSize[getDividendIndex()].height/2);
			figDescent = (int) Math.ceil(childSize[getDividendIndex()].height/2) + getSpacingBefore(1) + placeholderMargin;
		} else { //if (isDivisorVisible) {//&& !isDividendVisible
			figAscent = (int) Math.floor(childSize[getDivisorIndex()].height/2) + getSpacingBefore(1) + placeholderMargin;
			figDescent = (int) Math.ceil(childSize[getDivisorIndex()].height/2);
		}

		figWidth = Math.max(
				isDividendVisible ? childSize[getDividendIndex()].width : 0,
				isDivisorVisible ? childSize[getDivisorIndex()].width : 0);
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		boolean isDividendVisible = childFigure[getDividendIndex()].isVisible();
		boolean isDivisorVisible = childFigure[getDivisorIndex()].isVisible();
		boolean isFractionVisible = childFigure[getFractionIndex()].isVisible();

		if (isDividendVisible) {
			x[getDividendIndex()] = area.x+(area.width - childSize[getDividendIndex()].width)/2;
			y[getDividendIndex()] = area.y;
		}

		if (isDivisorVisible) {
			x[getDivisorIndex()] = area.x + (area.width - childSize[getDivisorIndex()].width)/2;
			y[getDivisorIndex()] = area.y + getSpacingBefore(1) + (isFractionVisible ? getSpacingBefore(1) + 1 : 0) +
				(isDividendVisible ? childSize[getDividendIndex()].height : placeholderMargin);
		}

		if (isFractionVisible) {
			x[getFractionIndex()] = area.x;
			y[getFractionIndex()] = area.y + getSpacingBefore(1) +
				(isDividendVisible ? childSize[getDividendIndex()].height : placeholderMargin);

			childSize[getFractionIndex()].width = area.width;
			childSize[getFractionIndex()].height = 1;
		}
	}
}
