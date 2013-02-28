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
package org.whole.lang.ui.editor;

import java.util.List;
import java.util.Map;

import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public interface IActionFactory {
	// called once at editor configuration time
	public void initActions(IWorkbenchPart workbenchPart);
	public void initAddActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<EntityDescriptor<?>, SelectionAction> addActionsMap);
	public void initReplaceActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<EntityDescriptor<?>, SelectionAction> replaceActionsMap);
	public void initWrapActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<EntityDescriptor<?>, List<SelectionAction>> wrapActionsMap);
	public void initTextActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<EntityDescriptor<?>, List<SelectionAction>> textActionsMap);
	public void initKeyActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<KeyStroke, SelectionAction> keyActionsMap);

	// called at context menu configuration time
	public void fillValueMenu(IWorkbenchPart workbenchPart, IMenuManager contextMenu, ISelectionProvider provider);

	// called at context menu configuration time once per entity descriptor (they are cached)
	public SelectionAction createAddAction(IWorkbenchPart workbenchPart, EntityDescriptor<?> addEntityDescriptor);
	public SelectionAction createReplaceAction(IWorkbenchPart workbenchPart, EntityDescriptor<?> replaceEntityDescriptor);
	public List<? extends SelectionAction> createWrapActions(IWorkbenchPart workbenchPart, EntityDescriptor<?> wrapEntityDescriptor);
}
