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

import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.dialogs.FindReplaceDialog;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.EntityUtils;

public class ModelFindAction extends AbstractLazySelectionAction {
	private static FindReplaceDialog findReplaceDialogInstance = null;
    
	public ModelFindAction(IWorkbenchPart part) {
		super(part);
		setId(ActionFactory.FIND.getId());
		setText("Find/Replace");
	}

	protected boolean calculateEnabled() {
		if (getWorkbenchPart() != UIUtils.getActiveEditor())
			return false;

		List<?> selectedObjects = getSelectedObjects();
		return selectedObjects.size() == 1 && selectedObjects.get(0) instanceof IEntityPart; 
	}

	public void run() {
		IEntityPart selectedPart = (IEntityPart) getSelectedObjects().get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();
		if(findReplaceDialogInstance == null)
			findReplaceDialogInstance = new FindReplaceDialog(getActiveEditorShell());
		findReplaceDialogInstance.setSelectedEntity(EntityUtils.clone(selectedEntity));
		findReplaceDialogInstance.close();
		findReplaceDialogInstance.setParentShell(getActiveEditorShell());
		findReplaceDialogInstance.open();
	}

	private Shell getActiveEditorShell() {
		IEditorPart activeEditor = UIUtils.getActiveEditor();
		return activeEditor.getSite().getShell();
	}
}
