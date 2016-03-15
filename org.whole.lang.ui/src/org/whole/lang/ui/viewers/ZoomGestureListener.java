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
package org.whole.lang.ui.viewers;

import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.GestureEvent;
import org.eclipse.swt.events.GestureListener;

/**
 * @author Enrico Persiani
 */
public class ZoomGestureListener implements GestureListener {
	protected ZoomManager zoomManager;
	protected double initialZoomLevel;
	protected long initialTime;
	protected boolean magnifying;

	public ZoomGestureListener(ZoomManager zoomManager) {
		this.zoomManager = zoomManager;
	}

	public void gesture(GestureEvent e) {
		switch (e.detail) {
		case SWT.GESTURE_BEGIN:
			initialZoomLevel = zoomManager.getZoom();
			initialTime = e.time & 0xFFFFFFFFL;
			magnifying = false;
			break;

		case SWT.GESTURE_MAGNIFY:
			double targetZoomLevel = initialZoomLevel * e.magnification;
			zoomManager.setZoom(targetZoomLevel);
			magnifying = true;
			break;

		case SWT.GESTURE_END:
			if (magnifying && (e.time & 0xFFFFFFFFL) - initialTime < 200) {
				double[] zoomLevels = zoomManager.getZoomLevels();

				if (zoomManager.getZoom() > initialZoomLevel) {
					for (double zoomLevel : zoomLevels)
						if (zoomLevel > initialZoomLevel) {
							zoomManager.setZoom(zoomLevel);
							break;
						}
				} else {
					for (int i=zoomLevels.length-1; i>=0; i--)
						if (zoomLevels[i] < initialZoomLevel) {
							zoomManager.setZoom(zoomLevels[i]);
							break;
						}
				}
			}
			break;
		}
	}
}
