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
package org.whole.lang.features.ui.layouts;

import org.whole.lang.ui.notations.map.layouts.TreeDownLayout;

/**
 * @author Riccardo Solmi
 */
public abstract class FeatureGroupTreeDownLayout extends TreeDownLayout {
	@Override
	protected void setAscentDescentWidth(int wHint, int hHint) {
		boolean v2 = childFigure[1].isVisible();
		int width2 = v2 ? childSize[1].width : 0;

		figAscent = childSize[0].height + (v2 ? CHILDREN_GAP + ascent(1) : 0);
		figDescent = v2 ? descent(1) : 0;
		figWidth = Math.max(childSize[0].width, width2);
	}

	protected boolean useDefaultLayout = true;
	public void useDefaultLayout(boolean value) {
		useDefaultLayout = value;
	}
}
