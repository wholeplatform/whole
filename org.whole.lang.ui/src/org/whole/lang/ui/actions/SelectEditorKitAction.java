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
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.views.WholeGraphicalViewer;

/**
 * @author Riccardo Solmi
 */
public class SelectEditorKitAction extends SelectionAction {
	public final IEditorKit editorKit;

	public SelectEditorKitAction(IWorkbenchPart part, IEditorKit editorKit) {
		super(part, IAction.AS_RADIO_BUTTON);

		this.editorKit = editorKit;
		setId(editorKit.getId());
		setText(editorKit.getName());
	}

	@SuppressWarnings("unchecked")
	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.isEmpty() || !(selectedObjects.get(0) instanceof IEntityPart))
			return false;
		IEntityPart selectedPart = (IEntityPart) selectedObjects.get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();

		IEntity fragmentRoot = selectedEntity.wGetModel().getFragment();
		if (fragmentRoot == null)
			return false;

		GraphicalViewer viewer = (GraphicalViewer) getWorkbenchPart().getAdapter(GraphicalViewer.class);
		return ModelObserver.getObserver(fragmentRoot, viewer.getEditPartRegistry()) != null;
	}

	@SuppressWarnings("unchecked")
	public void run() {
		if (!isChecked())
			return;

		IStructuredSelection selection = (IStructuredSelection) getSelection();
		IEntityPart selectedPart = (IEntityPart) selection.getFirstElement();
		IEntity selectedEntity = selectedPart.getModelEntity();
		selectedEntity.wGetModel().setEditorKit(editorKit);

		final WholeGraphicalViewer viewer = (WholeGraphicalViewer) selectedPart.getViewer();
		Map<IEntity, IEntityPart> editPartRegistry = viewer.getEditPartRegistry();
		IEntity fragmentRoot = selectedEntity.wGetModel().getFragment();
		IEntityPart fragmentPart = ModelObserver.getObserver(fragmentRoot, editPartRegistry);
		fragmentPart.rebuild();

		final EditPart newSelectedPart = (EditPart) editPartRegistry.get(selectedEntity);
		if (newSelectedPart != null) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {
					viewer.reveal(newSelectedPart);
					viewer.select(newSelectedPart);					
				}				
			});
		}
	}
}
