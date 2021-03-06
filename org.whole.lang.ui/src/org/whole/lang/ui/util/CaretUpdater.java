/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.util;

import org.eclipse.draw2d.geometry.Point;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.EntityPartEvent;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.editparts.IdentityEntityPartListener;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.viewers.IEntityGraphicalViewer;

/** 
 * @author Enrico Persiani
 */
public class CaretUpdater extends IdentityEntityPartListener {
	private IEntityGraphicalViewer viewer;
	private IEntity selectedEntity;
	private int start;
	private int end;
	private Point location;
	private boolean deselectAll = true;

	private CaretUpdater() {
	}
	private CaretUpdater(IEntityGraphicalViewer viewer, IEntity selectedEntity, int start, int end, Point location) {
		this.viewer = viewer;
		this.selectedEntity = selectedEntity;
		this.start = start;
		this.end = end;
		this.location = location;
	}

	public void sheduleSyncUpdate() {
		IEntityPart entityPart = ModelObserver.getObserver(selectedEntity, viewer.getEditPartRegistry());
		CaretUtils.updateCaret(entityPart, viewer, start, end, location, deselectAll);
	}
	public void sheduleAsyncUpdate() {
		viewer.getControl().getDisplay().asyncExec(new Runnable() {
			public void run() {
				sheduleSyncUpdate();
			}
		});
	}
	public void afterUpdate(EntityPartEvent event) {
		if (Matcher.find(selectedEntity, event.getEntityPart().getModelEntity(), false) != null) {
			viewer.removeEntityPartListener(this);
			sheduleSyncUpdate();
		}
	}

	public static CaretUpdater record(IEntityGraphicalViewer viewer) {
		IEntityPart part = viewer.getFocusEntityPart();
		ITextualEntityPart focusPart = part instanceof ITextualEntityPart ? (ITextualEntityPart) part : null;

		int start,end;
		if (focusPart.hasSelectionRange()) {
			start = focusPart.getSelectionStart();
			end = focusPart.getSelectionEnd();
		} else
			start = end = focusPart.getCaretPosition();

		return createCU(viewer, focusPart.getModelEntity(), start, end);
	}
	public static CaretUpdater createCU(IEntityGraphicalViewer viewer, IEntity selectedEntity, int start, int end) {
		return createCU(viewer, selectedEntity, start, end, null);
	}
	public static CaretUpdater createCU(IEntityGraphicalViewer viewer, IEntity selectedEntity, int position) {
		return createCU(viewer, selectedEntity, position, position, null);
	}
	public static CaretUpdater createCU(IEntityGraphicalViewer viewer, IEntity selectedEntity, Point location) {
		return createCU(viewer, selectedEntity, -1, -1, location);
	}
	public static CaretUpdater createCU(IEntityGraphicalViewer viewer, IEntity selectedEntity, int start, int end, Point location) {
		return new CaretUpdater(viewer, selectedEntity, start, end, location);
	}
}
