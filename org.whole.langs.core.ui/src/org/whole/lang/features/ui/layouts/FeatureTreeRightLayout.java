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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.whole.lang.ui.notations.map.layouts.TreeRightLayout;

/**
 * @author Riccardo Solmi
 */
public class FeatureTreeRightLayout extends TreeRightLayout {
	{
		CHILDREN_GAP = 20;
	}

	@Override
	public void paintConnections(Graphics graphics, Point... childrenPoints) {
		Point root = getRootPoint();

		boolean useLineStrategy;
		if (childrenPoints.length > 2) {
			int min = Integer.MAX_VALUE;
			int max = Math.min(childrenPoints[0].x-root.x, childrenPoints[childrenPoints.length-1].x-root.x);
			for (int i=1; i<childrenPoints.length-1; i++) {
				int h = childrenPoints[i].x-root.x;
				min = Math.min(min, h);
				max = Math.max(max, h);
			}

			useLineStrategy = max - min < CHILDREN_GAP;
		} else
			useLineStrategy = true;

		if (useLineStrategy && false) {//FIXME
//TODO extract DirectLine strategy
			for (int i=0; i<childrenPoints.length; i++)
				graphics.drawLine(root, childrenPoints[i]);
		} else {
//TODO extract Arc strategy
			for (int i=0; i<childrenPoints.length; i++) {
				int w = (childrenPoints[i].x-root.x)*2;
				int h = Math.abs(childrenPoints[i].y-root.y)*2;
				
				if (h == 0)
					graphics.drawLine(root, childrenPoints[i]);
				else if (root.y < childrenPoints[i].y)
					graphics.drawArc(root.x, root.y-h/2, w, h,
							180, 90);
				else
					graphics.drawArc(root.x, childrenPoints[i].y, w, h,
							90, 90);
			}
		}
	}
}
