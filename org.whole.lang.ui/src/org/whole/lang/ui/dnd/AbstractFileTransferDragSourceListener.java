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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.requests.CommandFactory;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractFileTransferDragSourceListener extends AbstractSelectionTransferDragSourceListener {
	protected boolean scheduleDelete;
	protected File[] files;

	public AbstractFileTransferDragSourceListener(EditPartViewer viewer) {
		super(viewer, FileTransfer.getInstance());
	}

	public void dragSetData(DragSourceEvent event) {
		if (scheduleDelete && files != null) {
			for (File file : files)
				try {
					file.delete();
				} catch (Exception e) {
				}
			files = null;
			scheduleDelete = false;
		}

		try {
			if (files == null)
				files = createFiles();
			
			String[] paths = new String[files.length];
			for (int i=0; i<files.length; i++)
				paths[i] = files[i].getAbsolutePath();

			event.data = paths;
		} catch (Exception e) {
			event.data = "";
		}
	}

	protected File[] createFiles() throws Exception {
		List<EditPart> selectedEditParts = getSelectedEditParts();
		List<File> files = new ArrayList<File>();

		for (EditPart editPart: selectedEditParts) {
			IEntityPart entityPart = (IEntityPart) editPart;
			files.add(createFile(entityPart));
		}
		return files.toArray(new File[0]);
	}

	protected abstract File createFile(IEntityPart entityPart) throws Exception;

	@SuppressWarnings("unchecked")
	public void dragStart(DragSourceEvent event) {
		List<EditPart> selectedEditParts = getViewer().getSelectedEditParts();

		if (selectedEditParts.isEmpty() ||
				!(selectedEditParts.get(0) instanceof IGraphicalEntityPart))
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

		// workaround for wrong dnd package explorer behavior
		scheduleDelete = true;

		// ensure file deletion on exit
		if (files != null)
			for (File file : files)
				file.deleteOnExit();
	}
}
