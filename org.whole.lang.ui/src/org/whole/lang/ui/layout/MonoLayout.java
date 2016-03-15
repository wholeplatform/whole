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
public class MonoLayout extends AbstractCompositeEntityLayout {
	{
		withMajorAlignment(Alignment.MATHLINE);
	}

	public MonoLayout withInheritedAlignment() {
//		withMajorAlignment(null).withMinorAlignment(null);
		return this;
	}

	@Override
	public Alignment getMinorAlignment() {
		if (super.getMinorAlignment() == null)
			return isChild0Visible() && childFigure[0].getLayoutManager() instanceof ICompositeEntityLayout ?
					((ICompositeEntityLayout) childFigure[0].getLayoutManager()).getMinorAlignment() : Alignment.LEADING;

		return super.getMinorAlignment();
	}
	@Override
	public Alignment getMajorAlignment() {
		if (super.getMajorAlignment() == null)
			return isChild0Visible() && childFigure[0].getLayoutManager() instanceof ICompositeEntityLayout ?
					((ICompositeEntityLayout) childFigure[0].getLayoutManager()).getMajorAlignment() : Alignment.LEADING;

		return super.getMajorAlignment();
	}

	@Override
	protected int getIndent() {
		return isChild0Visible() ? indent(0) : 0;
	}

	public boolean isHorizontal() {
		return false;
	}

	@Override
	protected int getSpacedSpacing(int spacing) {
		return 3;
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		assert childFigure.length <= 1;

		figAscent = 0;
		figDescent = 0;
		figWidth = 0;
		if (isChild0Visible()) {
			figAscent += ascent(0);
			figDescent += descent(0);
			figWidth += childSize[0].width;
		}
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		if (isChild0Visible()) {
			x[0] = calculateXLocation(area, getMinorAlignment());
			y[0] = calculateYLocation(area, getMajorAlignment());
		}
	}

	protected boolean isChild0Visible() {
		return childFigure!=null && childFigure.length>0 && childFigure[0].isVisible();
	}
}
