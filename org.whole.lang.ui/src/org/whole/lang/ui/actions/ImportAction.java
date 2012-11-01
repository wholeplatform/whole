/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.dialogs.IImportAsModelDialog;
import org.whole.lang.ui.dialogs.ImportAsModelDialogFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.ClipboardUtils;

/**
 * @author Enrico Persiani
 */
public class ImportAction extends PerformAction {
	public ImportAction(IWorkbenchPart part) {
		super(part, EnablerPredicateFactory.instance.alwaysTrue(), null, "Import...", IMPORT_FRAGMENT_ICON);
	}

	public void run() {
		IImportAsModelDialog dialog = ImportAsModelDialogFactory.instance().createImportAsModelDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "Import model");
		if (!dialog.show())
			return;

		IEntityPart targetEntityPart = (IEntityPart) getSelectedObjects().get(0);
		IEntity targetEntity = targetEntityPart.getModelEntity();

		Object[] files = dialog.getSelection();
		IPersistenceKit persistenceKit = dialog.getPersistenceKit();
		EntityDescriptor<?> stage = dialog.getStage();

		CompoundCommand importCmd = new CompoundCommand();
		importCmd.setLabel(getText());

		List<EditPart> editParts = new ArrayList<EditPart>();
		EditPartFactory factory = ((GraphicalViewer) getWorkbenchPart().getAdapter(GraphicalViewer.class)).getEditPartFactory();

		boolean needsCompositeTarget = files.length > 1;
		for (Object file : files) {
			try {
				IPersistenceProvider persistenceProvider =  new IFilePersistenceProvider((IFile) file);
				IEntity entity = persistenceKit.readModel(persistenceProvider);
				entity = ClipboardUtils.conditionalStageAdd(targetEntity, stage, entity, needsCompositeTarget);
				editParts.add(ClipboardUtils.createEditPart(factory, entity));
			} catch (Exception e) {
				// fail silently
			}
		}

		if (editParts.isEmpty())
			return;

		ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_ADD);
		request.setEditParts(editParts);
		request.setLocation(calculateTargetLocation(targetEntityPart));

		importCmd.add(targetEntityPart.getCommand(request));
		execute(importCmd);
	}
}
