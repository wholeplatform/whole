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
package org.whole.lang.e4.ui.actions;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class ActionRegistry {
	protected IEclipseContext context;
	protected UndoAction undoAction;
	protected RedoAction redoAction;
	protected Map<String, IUpdatableAction> baseActions = new HashMap<String, IUpdatableAction>();
	protected Map<String, IUpdatableAction> selectNotationActions = new HashMap<String, IUpdatableAction>();
	protected Map<String, IUpdatableAction> replaceActions = new HashMap<String, IUpdatableAction>();
	protected Map<String, IUpdatableAction> addActions = new HashMap<String, IUpdatableAction>();

	public ActionRegistry(IEclipseContext context) {
		this.context = context;
	}
	public ActionRegistry(IEclipseContext context, Shell shell) {
		this(context);
		registerBaseActions(shell);
	}

	public void updateActions(Collection<IUpdatableAction> actionsToUpdate) {
		for (IUpdatableAction action : actionsToUpdate)
			action.update();
	}
	public void updateBaseActions() {
		updateActions(baseActions.values());
		updateActions(selectNotationActions.values());
	}

	public IUpdatableAction getAction(String actionId) {
		return baseActions.get(actionId);
	}
	public IUpdatableAction getSelectNotationAction(IEditorKit editorKit) {
		String editorKitId = editorKit.getId();
		IUpdatableAction action = selectNotationActions.get(editorKitId);
		if (action == null) {
			String label = editorKit.getName();
			Map<String, String> parameters = Collections.singletonMap(EDITORKIT_ID_PARAMETER_ID, editorKitId);
			selectNotationActions.put(editorKitId, action = createE4ActionAdapter(label, null, SELECT_NOTATION_COMMAND_ID, parameters, IAction.AS_RADIO_BUTTON));
		}
		return action;
	}
	public IUpdatableAction getReplaceEntityAction(EntityDescriptor<?> ed) {
		String edUri = CommonsDataTypePersistenceParser.unparseEntityDescriptor(ed);
		IUpdatableAction action = replaceActions.get(edUri);
		if (action == null) {
			String label = StringUtils.camelCaseToSpacedWords(ed.getName());
			Map<String, String> parameters = Collections.singletonMap(ED_URI_PARAMETER_ID, edUri);
			replaceActions.put(edUri, action = createE4ActionAdapter(label, REPLACE_ICON_URI, REPLACE_COMMAND_ID, parameters));
		}
		return action;
	}
	public IUpdatableAction getAddEntityAction(EntityDescriptor<?> ed) {
		String edUri = CommonsDataTypePersistenceParser.unparseEntityDescriptor(ed);
		IUpdatableAction action = addActions.get(edUri);
		if (action == null) {
			String label = StringUtils.camelCaseToSpacedWords(ed.getName());
			Map<String, String> parameters = Collections.singletonMap(ED_URI_PARAMETER_ID, edUri);
			addActions.put(edUri, action = createE4ActionAdapter(label, ADD_ICON_URI, ADD_COMMAND_ID, parameters));
		}
		return action;
	}
	public IUpdatableAction createReplaceFragmentAction(String label, IEntity fragment) {
		try {
			StringPersistenceProvider spp = new StringPersistenceProvider();
			ReflectionFactory.getDefaultPersistenceKit().writeModel(fragment, spp);
			Map<String, String> parameters = Collections.singletonMap(FRAGMENT_XWL_PARAMETER_ID, spp.getStore());
			return createE4ActionAdapter(label, REPLACE_ICON_URI, REPLACE_FRAGMENT_COMMAND_ID, parameters);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	public IUpdatableAction createAddFragmentAction(String label, IEntity fragment) {
		try {
			StringPersistenceProvider spp = new StringPersistenceProvider();
			ReflectionFactory.getDefaultPersistenceKit().writeModel(fragment, spp);
			Map<String, String> parameters = Collections.singletonMap(FRAGMENT_XWL_PARAMETER_ID, spp.getStore());
			return createE4ActionAdapter(label, ADD_ICON_URI, ADD_FRAGMENT_COMMAND_ID, parameters);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	protected void registerBaseActions(Shell shell) {
		registerAction(undoAction = new UndoAction(context, UNDO_LABEL, UNDO_ICON_URI));
		registerAction(redoAction = new RedoAction(context, REDO_LABEL, REDO_ICON_URI));
		registerAction(createE4ActionAdapter(CUT_MENU_ID));
		registerAction(createE4ActionAdapter(COPY_MENU_ID));
		registerAction(createE4ActionAdapter(PASTE_MENU_ID));
		registerAction(createE4ActionAdapter(DELETE_MENU_ID));
		registerAction(createE4ActionAdapter(SELECT_ALL_MENU_ID));

		String copyIconURI = E4Utils.findMenu(COPY_MENU_ID, context.get(EModelService.class), context.get(MApplication.class), MHandledMenuItem.class).getIconURI();
		String pasteIconURI = E4Utils.findMenu(PASTE_MENU_ID, context.get(EModelService.class), context.get(MApplication.class), MHandledMenuItem.class).getIconURI();
		registerAction(createE4ActionAdapter(COPY_ENTITY_PATH_LABEL, copyIconURI, COPY_ENTITY_PATH_COMMAND_ID, Collections.<String, String>emptyMap()));
		registerAction(createE4ActionAdapter(COPY_AS_IMAGE_LABEL, copyIconURI, COPY_AS_IMAGE_COMMAND_ID, Collections.<String, String>emptyMap()));
		registerAction(createE4ActionAdapter(PASTE_AS_LABEL, pasteIconURI, PASTE_AS_COMMAND_ID, Collections.<String, String>emptyMap()));
		registerAction(createE4ActionAdapter(IMPORT_LABEL, IMPORT_ICON_URI, IMPORT_COMMAND_ID, Collections.<String, String>emptyMap()));

		shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (undoAction != null)
					undoAction.dispose();
				if (redoAction != null)
					redoAction.dispose();
			}
		});
	}
	protected void registerAction(IUpdatableAction action) {
		baseActions.put(action.getId(), action);
	}
	protected E4ActionAdapter createE4ActionAdapter(String handledMenuId) {
		return new E4ActionAdapter(context, handledMenuId);
	}
	protected E4ActionAdapter createE4ActionAdapter(String label, String iconURI, String commandId, Map<String, String> parameters) {
		return new E4ActionAdapter(context, label, iconURI, commandId, parameters);
	}
	protected E4ActionAdapter createE4ActionAdapter(String label, String iconURI, String commandId, Map<String, String> parameters, int style) {
		return new E4ActionAdapter(context, label, iconURI, commandId, parameters, style);
	}
}
