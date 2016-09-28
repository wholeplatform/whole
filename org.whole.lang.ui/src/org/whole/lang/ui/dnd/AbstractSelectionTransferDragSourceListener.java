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
package org.whole.lang.ui.dnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.dnd.AbstractTransferDragSourceListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractSelectionTransferDragSourceListener extends AbstractTransferDragSourceListener {
	public AbstractSelectionTransferDragSourceListener(EditPartViewer viewer, Transfer xfer) {
		super(viewer, xfer);
	}

	public AbstractSelectionTransferDragSourceListener(EditPartViewer viewer) {
		super(viewer);
	}

	protected List<IEntity> modelSelection;

	protected void storeSelection(List<EditPart> selectedEditParts) {
		modelSelection = new ArrayList<IEntity>(selectedEditParts.size());
		for (EditPart editPart : selectedEditParts)
			modelSelection.add((IEntity) editPart.getModel());
	}
	
	protected void restoreSelection() {
		getViewer().setSelection(new StructuredSelection(getSelectedEditParts()));
	}

	@SuppressWarnings("unchecked")
	protected List<EditPart> getSelectedEditParts() {
		List<EditPart> selectedParts = new ArrayList<EditPart>(modelSelection.size());
		Map<IEntity, EditPart> editPartRegistry = getViewer().getEditPartRegistry();
		for (IEntity model : modelSelection) {
			EditPart editPart = editPartRegistry.get(model);
			if (editPart != null)
				selectedParts.add(editPart);
		}
		return selectedParts;
	}

	protected Point getDropLocation(DragSourceEvent event) {
		org.eclipse.swt.graphics.Point swt;
		swt = new org.eclipse.swt.graphics.Point(event.x, event.y);
		return new Point(swt.x, swt.y);
	}
}
