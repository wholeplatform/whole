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
package org.whole.lang.ui.menu;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.actions.ActionFactory;
import org.whole.lang.ui.actions.ImmutableSelectionProvider;
import org.whole.lang.ui.actions.WholeActionFactory;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WholeContextMenuProvider extends ContextMenuProvider {
	private WholeActionFactory actionFactory;

	public WholeContextMenuProvider(EditPartViewer viewer, WholeActionFactory actionFactory) {
		super(viewer);
		this.actionFactory = actionFactory;
	}

	public void buildContextMenu(IMenuManager menu) {
		GEFActionConstants.addStandardActionGroups(menu);
		IAction action;

		action = actionFactory.getActionRegistry().getAction(ActionFactory.UNDO.getId());
		if (action != null)
			menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
		action = actionFactory.getActionRegistry().getAction(ActionFactory.REDO.getId());
		if (action != null)
			menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);

		EditPartViewer viewer = getViewer();
		ISelectionProvider provider = viewer;
		if (viewer.getSelectedEditParts().isEmpty() &&
				viewer instanceof GraphicalViewer &&
				viewer.getFocusEditPart() != null) {
			EditPart focusPart = viewer.getFocusEditPart();
			provider = new ImmutableSelectionProvider(new StructuredSelection(focusPart));
		}
		actionFactory.fillContextMenu(menu, provider);
	}
}
