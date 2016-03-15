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

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.requests.CommandFactory;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class TextTransferDragSourceListener extends AbstractSelectionTransferDragSourceListener {
	protected List<Object> modelSelection;

	public TextTransferDragSourceListener(EditPartViewer viewer) {
		super(viewer, TextTransfer.getInstance());
	}

	public void dragSetData(DragSourceEvent event) {
		EditPartViewer viewer = getViewer();
		List<EditPart> selectedEditParts = getSelectedEditParts();
		IStructuredSelection selection = new StructuredSelection(selectedEditParts);
		if (ClipboardUtils.hasTextSeletion(viewer, selection))
			event.data = ClipboardUtils.getTextSelection(viewer, selection);
		else
			try {
				int length = selectedEditParts.size();
				IEntity[] values = new IEntity[length];
				for (int i=0; i<length; i++)
					values[i] = EntityUtils.clone(((IEntityPart) selectedEditParts.get(i)).getModelEntity());
				event.data = ClipboardUtils.unparseEntity(BindingManagerFactory.instance.createTuple(true, values));
			} catch (Exception e) {
				event.data = "";
			}
	}

	@SuppressWarnings("unchecked")
	public void dragStart(DragSourceEvent event) {
		List<EditPart> selectedEditParts = getViewer().getSelectedEditParts();

		if (selectedEditParts.isEmpty())
			event.doit = false;

		storeSelection(selectedEditParts);
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		if (event.detail == DND.DROP_MOVE) {
			Command deleteCmd = CommandFactory.createDeleteCommand(getSelectedEditParts());
			getViewer().getEditDomain().getCommandStack().execute(deleteCmd);
		}
		restoreSelection();
	}
}
