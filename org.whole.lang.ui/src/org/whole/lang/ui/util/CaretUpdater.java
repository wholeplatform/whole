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
package org.whole.lang.ui.util;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.EntityPartEvent;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.editparts.IdentityEntityPartListener;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/** 
 * @author Enrico Persiani
 */
public class CaretUpdater extends IdentityEntityPartListener {
	public static final CaretUpdater NULL_UPDATER = new CaretUpdater() {
		public void sheduleAsyncUpdate() {
		}
		public void sheduleSyncUpdate() {
		}
	};

	private EditPartViewer viewer;
	private IEntity selectedEntity;
	private int start;
	private int end;
	private Point location;
	private boolean deselectAll = true;

	private CaretUpdater() {
	}
	private CaretUpdater(EditPartViewer viewer, IEntity selectedEntity, int start, int end, Point location) {
		this.viewer = viewer;
		this.selectedEntity = selectedEntity;
		this.start = start;
		this.end = end;
		this.location = location;
	}

	public static CaretUpdater record(EditPartViewer viewer) {
		ITextualEntityPart focusPart = getFocusedTextualPart(viewer);
		if (focusPart == null)
			return NULL_UPDATER;

		int start,end;
		if (focusPart.hasSelectionRange()) {
			start = focusPart.getSelectionStart();
			end = focusPart.getSelectionEnd();
		} else
			start = end = focusPart.getCaretPosition();

		return createCU(viewer, focusPart.getModelEntity(), start, end);
	}
	private static ITextualEntityPart getFocusedTextualPart(EditPartViewer viewer) {
		if (viewer == null)
			return null;
		EditPart part = viewer.getFocusEditPart();
		return part instanceof ITextualEntityPart ? (ITextualEntityPart) part : null;
	}

	public static CaretUpdater createCU(EditPartViewer viewer, IEntity selectedEntity, int start, int end) {
		if (isValid(viewer, selectedEntity, start, end, null))
			return new CaretUpdater(viewer, selectedEntity, start, end, null);
		else
			return NULL_UPDATER;
	}
	public static CaretUpdater createCU(EditPartViewer viewer, IEntity selectedEntity, int position) {
		if (isValid(viewer, selectedEntity, position, position, null))
			return new CaretUpdater(viewer, selectedEntity, position, position, null);
		else
			return NULL_UPDATER;
	}
	public static CaretUpdater createCU(EditPartViewer viewer, IEntity selectedEntity, Point location) {
		if (isValid(viewer, selectedEntity, -1, -1, location))
			return new CaretUpdater(viewer, selectedEntity, -1, -1, location);
		else
			return NULL_UPDATER;
	}

	private static final boolean isValid(EditPartViewer viewer, IEntity selectedEntity, int start, int end, Point location) {
		return viewer != null && selectedEntity != null && ((start != -1 && end != -1) || location != null);
	}

	public static void sheduleSyncUpdate(EditPartViewer viewer, IEntity selectedEntity, int position, boolean deselectAll) {
		sheduleSyncUpdate(viewer, selectedEntity, position, position, null, deselectAll);
	}
	public static void sheduleSyncUpdate(EditPartViewer viewer, IEntity selectedEntity, Point location, boolean deselectAll) {
		sheduleSyncUpdate(viewer, selectedEntity, -1, -1, location, deselectAll);
	}
	public static void sheduleSyncUpdate(EditPartViewer viewer, IEntity selectedEntity, int start, int end, Point location, boolean deselectAll) {
		EditPart entityPart = (EditPart) viewer.getEditPartRegistry().get(selectedEntity);
		updateCaret(entityPart, viewer, start, end, location, deselectAll);
	}

	@SuppressWarnings("unchecked")
	public void sheduleSyncUpdate() {
		EditPart entityPart = ModelObserver.getObserver(selectedEntity, viewer.getEditPartRegistry());
		updateCaret(entityPart, viewer, start, end, location, deselectAll);
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
			((IEntityPartViewer) viewer).removeEntityPartListener(this);
			sheduleSyncUpdate();
		}
	}

	@SuppressWarnings("unchecked")
	private static void updateCaret(final EditPart entityPart, EditPartViewer viewer, int start, int end, Point location, boolean deselectAll) {
		if (entityPart instanceof ITextualEntityPart) {
			List<EditPart> selectedParts = viewer.getSelectedEditParts();
			if (deselectAll && !selectedParts.isEmpty())
				viewer.deselectAll();
			viewer.setFocus(entityPart);
			ITextualEntityPart caretPart = ((ITextualEntityPart)entityPart);
			if (start != -1 && end != -1) {
				caretPart.setCaretPosition(end);
				if (start != end) {
					caretPart.setSelectionRange(start, end);
					viewer.appendSelection(caretPart);
				}
			} else if (location != null)
				caretPart.updateCaret(location);
		}
	}
}
