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
package org.whole.lang.e4.ui.menu;

import static org.whole.lang.e4.ui.api.IUIConstants.CONTENT_ASSIST_LABEL;
import static org.whole.lang.e4.ui.api.IUIConstants.COPY_AS_IMAGE_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.COPY_ENTITY_PATH_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_COPY;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_CUT;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_DELETE;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_PASTE;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_REDO;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_SELECT_ALL;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_UNDO;
import static org.whole.lang.e4.ui.api.IUIConstants.ENTITY_ASSIST_LABEL;
import static org.whole.lang.e4.ui.api.IUIConstants.IMPORT_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.NOTATION_LABEL;
import static org.whole.lang.e4.ui.api.IUIConstants.PASTE_AS_COMMAND_ID;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.IUpdatableAction;
import org.whole.lang.e4.ui.api.IUIBuilder;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class JFaceMenuBuilder implements IUIBuilder<IMenuManager> {
	protected IEclipseContext context;
	protected ActionRegistry actionRegistry;
	protected Set<IUpdatableAction> actionsToUpdate;
	protected IMenuManager menuManager;

	public JFaceMenuBuilder(IEclipseContext context, ActionRegistry actionRegistry) {
		this.context = context;
		this.actionRegistry = actionRegistry;
		this.actionsToUpdate = new HashSet<IUpdatableAction>();
		this.menuManager = null;
	}

	public IMenuManager getContainer() {
		return menuManager;
	}
	public void setContainer(IMenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public void before() {
		actionRegistry.updateBaseActions();
	}
	public void after() {
		actionRegistry.updateActions(actionsToUpdate);
		actionsToUpdate.clear();
	}

	public void addSeparator() {
		menuManager.add(new Separator());
	}
	public void addSeparator(String groupName) {
		menuManager.add(new Separator(groupName));
	}
	public void addGroupMarker(String groupName) {
		menuManager.add(new GroupMarker(groupName));
	}

	public void addUndoItem() {
		menuManager.add(actionRegistry.getAction(EDIT_UNDO));
	}
	public void addRedoItem() {
		menuManager.add(actionRegistry.getAction(EDIT_REDO));
	}

	public void addCutItem() {
		menuManager.add(actionRegistry.getAction(EDIT_CUT));
	}
	public void addCopyItem() {
		menuManager.add(actionRegistry.getAction(EDIT_COPY));
	}
	public void addCopyEntityPathItem() {
		menuManager.add(actionRegistry.getAction(COPY_ENTITY_PATH_COMMAND_ID));
	}
	public void addCopyAsImageItem() {
		menuManager.add(actionRegistry.getAction(COPY_AS_IMAGE_COMMAND_ID));
	}
	public void addPasteAsItem() {
		menuManager.add(actionRegistry.getAction(PASTE_AS_COMMAND_ID));
	}
	public void addPasteItem() {
		menuManager.add(actionRegistry.getAction(EDIT_PASTE));
	}

	public void addDeleteItem() {
		menuManager.add(actionRegistry.getAction(EDIT_DELETE));
	}
	public void addSelectAllItem() {
		menuManager.add(actionRegistry.getAction(EDIT_SELECT_ALL));
	}

	@Override
	public void addContentAssistItem() {
		IBindingManager bm = getBindings();
		IBindingManager env = BindingManagerFactory.instance.createArguments();
		IEntity selectedEntity = bm.wGet("primarySelectedEntity");
		MenuManager menu = new MenuManager(CONTENT_ASSIST_LABEL);
		menu.setVisible(HandlersBehavior.isValidEntityPartSelection(bm, true) &&
				ContentAssistOperation.getContentAssist(selectedEntity, env).length > 0);
		menuManager.add(menu);

		IContributionItem ici = new ContentAssistCompositeContributionItem(context, actionRegistry);
		menu.add(ici);
	}

	@Override
	public void addEntityAssistItem() {
		MenuManager menu = new MenuManager(ENTITY_ASSIST_LABEL);
		menuManager.add(menu);

		if (!HandlersBehavior.isValidEntityPartSelection(getBindings(), true))
			return;

		IContributionItem ici = new EntityAssistCompositeContributionItem(context, actionRegistry);
		menu.add(ici);
	}

	public void addNotationsItem() {
		IBindingManager bm = getBindings();

		MenuManager menu = new MenuManager(NOTATION_LABEL);
		menuManager.add(menu);

		if (!HandlersBehavior.isValidEntityPartSelection(bm, true))
			return;

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEditorKit selectedEditorKit = primarySelectedEntity.wGetEditorKit();
		for (IEditorKit editorKit : primarySelectedEntity.wGetLanguageKit().getEditorKits()) {
			IUpdatableAction action = actionRegistry.getSelectNotationAction(editorKit);
			action.setChecked(editorKit == selectedEditorKit);
			menu.add(action);
		}
	}
	public void addImportItem() {
		menuManager.add(actionRegistry.getAction(IMPORT_COMMAND_ID));
	}

	public void addRemoveItem() {
		//TODO
	}

	public void addReplaceWithEntityItem(EntityDescriptor<?> ed) {
		IUpdatableAction action = actionRegistry.getReplaceEntityAction(ed);
		actionsToUpdate.add(action);
		menuManager.add(action);
	}

	public void addAddEntityItem(EntityDescriptor<?> ed) {
		IUpdatableAction action = actionRegistry.getAddEntityAction(ed);
		actionsToUpdate.add(action);
		menuManager.add(action);
	}

	private final IBindingManager emptyBindings = E4Utils.createSelectionBindings(Collections.<IEntityPart>emptyList(), null);
	protected IBindingManager getBindings() {
		ESelectionService selectionService = context.get(ESelectionService.class);
		return selectionService.getSelection() instanceof IBindingManager ?
				(IBindingManager) selectionService.getSelection() : emptyBindings;
	}

	public void addOpenDialog() {
	}
}
