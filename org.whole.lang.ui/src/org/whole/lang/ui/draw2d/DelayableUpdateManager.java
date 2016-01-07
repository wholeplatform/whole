/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.draw2d;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.DeferredUpdateManager;
import org.eclipse.swt.widgets.Display;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class DelayableUpdateManager extends DeferredUpdateManager {
	public static final String PROPERTY_DELAY_UPDATES = "DelayUpdates";

	private final IEntityPartViewer viewer;
	private boolean hasDelayedUpdates;

	public DelayableUpdateManager(IEntityPartViewer e4GraphicalViewer) {
		this.viewer = e4GraphicalViewer;

		hasDelayedUpdates = false;
		this.viewer.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (!PROPERTY_DELAY_UPDATES.equals(evt.getPropertyName()))
					return;

				boolean oldValue = evt.getOldValue() != null ? ((Boolean) evt.getOldValue()).booleanValue() : false;
				boolean newValue = evt.getNewValue() != null ? ((Boolean) evt.getNewValue()).booleanValue() : false;
				if (hasDelayedUpdates && newValue != oldValue) {
					hasDelayedUpdates = false;
					executeDelayedUpdates();
				}
			}
		});
	}
	protected void executeDelayedUpdates() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				DelayableUpdateManager.super.queueWork();
			}
		});
	}
	protected void queueWork() {
		Boolean value = (Boolean) this.viewer.getProperty(PROPERTY_DELAY_UPDATES);
		if (value != null && value.booleanValue())
			hasDelayedUpdates = true;
		else
			super.queueWork();
	}
}
