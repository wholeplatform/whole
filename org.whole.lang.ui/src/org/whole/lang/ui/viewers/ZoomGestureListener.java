/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.viewers;

import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.GestureEvent;
import org.eclipse.swt.events.GestureListener;

/**
 * @author Enrico Persiani
 */
public class ZoomGestureListener implements GestureListener {
	private static final double NEIGHBOURHOOD = 0.1;

	protected ZoomManager zoomManager;
	protected double initialZoomLevel;

	public ZoomGestureListener(ZoomManager zoomManager) {
		this.zoomManager = zoomManager;
		this.initialZoomLevel = Double.NaN;
	}

	public void gesture(GestureEvent e) {
		switch (e.detail) {
		case SWT.GESTURE_BEGIN:
			initialZoomLevel = zoomManager.getZoom();
			break;

		case SWT.GESTURE_MAGNIFY:
			double targetZoomLevel = initialZoomLevel * e.magnification;

			for (double zoomLevel : zoomManager.getZoomLevels())
				if (Math.abs(targetZoomLevel-zoomLevel) <= NEIGHBOURHOOD)
					targetZoomLevel = zoomLevel;

			zoomManager.setZoom(targetZoomLevel);
			break;
		}
	}
}
