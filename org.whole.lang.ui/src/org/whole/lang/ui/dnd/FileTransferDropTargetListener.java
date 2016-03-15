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

import static org.eclipse.gef.RequestConstants.REQ_ADD;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.dialogs.IImportAsModelDialog;
import org.whole.lang.ui.dialogs.IImportAsModelDialogFactory;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class FileTransferDropTargetListener extends AbstractTransferDropTargetListener {
	protected IImportAsModelDialogFactory factory;

	public FileTransferDropTargetListener(IEntityPartViewer viewer, IImportAsModelDialogFactory factory) {
		super(viewer, FileTransfer.getInstance());
		this.factory = factory;
	}

	@Override
	protected void handleDragOver() {
		getCurrentEvent().feedback = DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
		super.handleDragOver();
	}

	@Override
	protected Request createTargetRequest() {
		return new ChangeBoundsRequest(REQ_ADD);
	}

	@Override
	protected void updateTargetRequest() {
		ChangeBoundsRequest request = (ChangeBoundsRequest) getTargetRequest();
		request.setEditParts(Collections.EMPTY_LIST);
		request.setLocation(getDropLocation());
	}

	@Override
	protected void handleDrop() {
		super.handleDrop();
		if (getCurrentEvent().detail != DND.DROP_NONE) {
			getViewer().setSelection(StructuredSelection.EMPTY);
			getViewer().getControl().setFocus();
		}
	}

	@Override
	protected Command getCommand() {
		String[] filePaths = (String[]) getCurrentEvent().data; 
		List<EditPart> editParts = new ArrayList<EditPart>();

		Shell shell = getViewer().getControl().getShell();
		IImportAsModelDialog dialog = factory.createElementListImportAsModelDialog(shell, "DnD Import", false);
		String[] fileNames = new String[filePaths.length];
		for (int i=0; i<fileNames.length; i++)
			fileNames[i] = filePaths[i].substring(filePaths[i].lastIndexOf(File.separatorChar)+1);

		dialog.setSelection(fileNames);
		if (!dialog.show())
			return null;

		IPersistenceKit persistenceKit = dialog.getPersistenceKit();
		EntityDescriptor<?> stage = dialog.getStage();
		boolean needsCompositeTarget = filePaths.length > 1;
		for (String filePath : filePaths) {
			try {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				File file = new File(filePath);
				IFile[] files = workspace.getRoot().findFilesForLocationURI(file.toURI());

				IPersistenceProvider persistenceProvider = (files.length == 1) ?
						new IFilePersistenceProvider(files[0]) :  new FilePersistenceProvider(file);

				IEntity entity = persistenceKit.readModel(persistenceProvider);

				entity = ClipboardUtils.conditionalStageAdd(getTargetEditPart(), stage, entity, needsCompositeTarget);
				editParts.add(ClipboardUtils.createEditPart(getViewer().getEditPartFactory(), entity));
			} catch (Exception e) {
				// fail silently
			}
		}

		if (!editParts.isEmpty()) {
			ChangeBoundsRequest request = (ChangeBoundsRequest) getTargetRequest();
			request.setEditParts(editParts);
		} else
			return null;

		return super.getCommand();
	}

	@Override
	public boolean isEnabled(DropTargetEvent event) {
		for (TransferData dataType : event.dataTypes)
			if (EditPartsTransfer.instance().isSupportedType(dataType))
				return false;
		return super.isEnabled(event);
	}
}
