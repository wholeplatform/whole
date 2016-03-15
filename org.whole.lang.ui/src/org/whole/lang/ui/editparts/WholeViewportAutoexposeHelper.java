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
package org.whole.lang.ui.editparts;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RangeModel;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.ViewportAutoexposeHelper;
import org.eclipse.swt.widgets.Display;

public class WholeViewportAutoexposeHelper extends ViewportAutoexposeHelper {
	public static final Insets DEFAULT_INSETS = new Insets(18);

	protected Insets threshold;
	protected long lastStepTime = 0;

	public WholeViewportAutoexposeHelper(GraphicalEditPart owner, Insets threshold) {
		super(owner, threshold);
		this.threshold = threshold;
	}
	public WholeViewportAutoexposeHelper(GraphicalEditPart owner) {
		this(owner, DEFAULT_INSETS);
	}

	@Override
	public boolean detect(Point where) {
		lastStepTime = 0;
		return super.detect(where);
	}

	@Override
	public boolean step(Point where) {
		Viewport port = findViewport(owner);

		Rectangle rect = Rectangle.SINGLETON;
		port.getClientArea(rect);
		port.translateToParent(rect);
		port.translateToAbsolute(rect);
		if (!rect.contains(where)
				|| rect.shrink(threshold).contains(where))
			return false;

		// set scroll offset (speed factor)
		int scrollOffset = 0;

		// calculate time based scroll offset
		if (lastStepTime == 0)
			lastStepTime = System.currentTimeMillis();

		long difference = System.currentTimeMillis() - lastStepTime;

		if (difference > 0) {
			scrollOffset = ((int) difference / 3);
			lastStepTime = System.currentTimeMillis();
		}

		if (scrollOffset == 0)
			return true;

		rect.shrink(threshold);

		int region = rect.getPosition(where);

		RangeModel hm = port.getHorizontalRangeModel();
		RangeModel vm = port.getVerticalRangeModel();
		final Point loc = port.getViewLocation();

		if ((region & PositionConstants.SOUTH) != 0)
			loc.y = Math.min(loc.y+scrollOffset, vm.getMaximum() - vm.getExtent());
		else if ((region & PositionConstants.NORTH) != 0)
			loc.y = Math.max(loc.y-scrollOffset, 0);

		if ((region & PositionConstants.EAST) != 0)
			loc.x = Math.min(loc.x+scrollOffset, hm.getMaximum() - hm.getExtent());
		else if ((region & PositionConstants.WEST) != 0)
			loc.x = Math.max(loc.x-scrollOffset, 0);

		if (loc.x != hm.getValue() || loc.y != vm.getValue())
			Display.getCurrent().asyncExec(new Runnable() {
				public void run() {
					exposeLocation(loc);
				}

			});

		return true;
	}

	protected void exposeLocation(Point location) {
		((FigureCanvas) owner.getViewer().getControl()).scrollSmoothTo(location.x, location.y);
	}
}
