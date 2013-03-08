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
package org.whole.lang.e4.ui.menu;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.IUpdatableAction;
import org.whole.lang.e4.ui.api.AbstractUIBuilder;
import org.whole.lang.e4.ui.expressions.VisibilityExpression;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class JFaceMenuBuilder extends AbstractUIBuilder<IContributionItem, IMenuManager> {
	protected Set<IUpdatableAction> actionsToUpdate;
	protected IMenuManager menuManager;

	public JFaceMenuBuilder(IEclipseContext context, ActionRegistry actionRegistry) {
		super(context, actionRegistry);
		this.actionsToUpdate = new HashSet<IUpdatableAction>();
		this.menuManager = null;
	}

	public IMenuManager getContainer() {
		return menuManager;
	}
	public IMenuManager setContainer(IMenuManager menuManager) {
		IMenuManager previous = this.menuManager;
		this.menuManager = menuManager;
		return previous;
	}

	public void before() {
		actionRegistry.updateBaseActions();
	}
	public void after() {
		actionRegistry.updateActions(actionsToUpdate);
		actionsToUpdate.clear();
	}

	public void addSeparator() {
		addItem(new Separator());
	}
	public void addSeparator(String groupName) {
		addItem(new Separator(groupName));
	}
	public void addGroupMarker(String groupName) {
		addItem(new GroupMarker(groupName));
	}

	public void addUndoItem() {
		addItem(actionRegistry.getAction(EDIT_UNDO));
	}
	public void addRedoItem() {
		addItem(actionRegistry.getAction(EDIT_REDO));
	}

	public void addCutItem() {
		addItem(actionRegistry.getAction(EDIT_CUT));
	}
	public void addCopyItem() {
		addItem(actionRegistry.getAction(EDIT_COPY));
	}
	public void addCopyEntityPathItem() {
		addItem(actionRegistry.getAction(COPY_ENTITY_PATH_COMMAND_ID));
	}
	public void addCopyAsImageItem() {
		addItem(actionRegistry.getAction(COPY_AS_IMAGE_COMMAND_ID));
	}
	public void addPasteAsItem() {
		addItem(actionRegistry.getAction(PASTE_AS_COMMAND_ID));
	}
	public void addPasteItem() {
		addItem(actionRegistry.getAction(EDIT_PASTE));
	}

	public void addDeleteItem() {
		addItem(actionRegistry.getAction(EDIT_DELETE));
	}
	public void addSelectAllItem() {
		addItem(actionRegistry.getAction(EDIT_SELECT_ALL));
	}

	@Override
	public void addContentAssistItem() {
		IBindingManager bm = getBindings();
		IMenuManager menu = createMenu(CONTENT_ASSIST_LABEL);
		menu.setVisible(contentAssistVisibleWhen.isVisible(bm));
		addItem(menu);

		IContributionItem ici = new ContentAssistCompositeContributionItem(context, actionRegistry);
		menu.add(ici);
	}

	@Override
	public void addEntityAssistItem() {
		IMenuManager menu = createMenu(ENTITY_ASSIST_LABEL);
		addItem(menu);

		if (!HandlersBehavior.isValidEntityPartSelection(getBindings(), true))
			return;

		IContributionItem ici = new EntityAssistCompositeContributionItem(context, actionRegistry);
		menu.add(ici);
	}
	@Override
	public void addFeatureAssistItem() {
		IBindingManager bm = getBindings();
		IEntity selectedEntity = bm.wGet("primarySelectedEntity");
		IMenuManager menu = createMenu(FEATURE_ASSIST_LABEL);
		menu.setVisible(HandlersBehavior.isValidEntityPartSelection(bm, true) &&
				EntityUtils.isSimple(selectedEntity));
		addItem(menu);

		IContributionItem ici = new FeatureAssistCompositeContributionItem(context, actionRegistry);
		menu.add(ici);
	}

	protected void addActionsItem(String menuLabel, VisibilityExpression expression, IContributionItem ici) {
		IMenuManager menu = createMenu(menuLabel);
		menu.setVisible(expression.isVisible(getBindings()));
		addItem(menu);
		menu.add(ici);
	}

	public void addNotationsItem() {
		IBindingManager bm = getBindings();

		IMenuManager menu = createMenu(NOTATION_LABEL);
		addItem(menu);

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
		addItem(actionRegistry.getAction(IMPORT_COMMAND_ID));
	}

	public void addRemoveItem() {
		IMenuManager menu = createMenu(REMOVE_LABEL);
		IMenuManager previous = setContainer(menu);

		addDeleteItem();
		addDefaultItem();

		setContainer(previous);
		addItem(menu);
	}
	@Override
	public void addDefaultItem() {
		addItem(actionRegistry.getAction(REPLACE_WITH_DEFAULT_COMMAND_ID));
	}

	public void addReplaceEntityItem(EntityDescriptor<?> ed) {
		IUpdatableAction action = actionRegistry.getReplaceEntityAction(ed);
		actionsToUpdate.add(action);
		addItem(action);
	}

	public void addAddEntityItem(EntityDescriptor<?> ed) {
		IUpdatableAction action = actionRegistry.getAddEntityAction(ed);
		actionsToUpdate.add(action);
		addItem(action);
	}

	public void addOpenDialog() {
	}

	protected IMenuManager createMenu(String name) {
		return new MenuManager(name);
	}
	protected void addItem(IAction action) {
		addItem(new ActionContributionItem(action));
	}
	protected void addItem(IContributionItem menu) {
		menuManager.add(menu);
	}
}
