/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.actions;

import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.util.CaretUpdater;

/**
 * @author Enrico Persiani
 */
public class RemoveTextualSelectionAction extends SelectionAction {
	private static final String ID = RemoveTextualSelectionAction.class.getName();
	private int direction;

	public RemoveTextualSelectionAction(IWorkbenchPart part, int direction) {
		super(part);
		setId(calculateId(this.direction = direction));
	}

	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() != 1)
			return false;

		Object selectedObject = selectedObjects.get(0);
		if (!(selectedObject instanceof ITextualEntityPart))
			return false;

		ITextualEntityPart targetPart = (ITextualEntityPart) selectedObject;
		return targetPart.hasSelectionRange();
	}

	@Override
	public void run() {
		ITextualEntityPart targetPart = (ITextualEntityPart) getSelectedObjects().get(0);
		EditPartViewer viewer = targetPart.getViewer();
		int newPosition = direction == SWT.LEFT ? targetPart.getSelectionStart() : targetPart.getSelectionEnd();
		CaretUpdater.sheduleSyncUpdate(viewer, targetPart.getModelEntity(), newPosition, true);
	}

	public static String calculateId(int direction) {
		return ID+'.'+direction;
	}
}
