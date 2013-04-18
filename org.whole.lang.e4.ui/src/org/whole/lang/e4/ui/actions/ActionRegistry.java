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
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Widget;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.actions.IUpdatableAction;
import org.whole.lang.ui.tools.Tools;
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
	protected Map<String, Map<String, IUpdatableAction>> replaceActions = new HashMap<String, Map<String, IUpdatableAction>>();
	protected Map<String, Map<String, IUpdatableAction>> addActions = new HashMap<String, Map<String, IUpdatableAction>>();

	public ActionRegistry(IEclipseContext context) {
		this.context = context;
	}
	public ActionRegistry(IEclipseContext context, Widget widget) {
		this(context);
		registerBaseActions(widget);
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
		return getReplaceEntityAction(ed, null);
	}
	public IUpdatableAction getReplaceEntityAction(EntityDescriptor<?> ed, FeatureDescriptor fd) {
		String edUri = CommonsDataTypePersistenceParser.unparseEntityDescriptor(ed);
		String fdUri = fd != null ? CommonsDataTypePersistenceParser.unparseFeatureDescriptor(fd) : null;

		Map<String, IUpdatableAction> actionMap = replaceActions.get(edUri);
		if (actionMap == null)
			replaceActions.put(edUri, actionMap = new HashMap<String, IUpdatableAction>());

		IUpdatableAction action = actionMap.get(fdUri);
		if (action == null) {
			String label = StringUtils.camelCaseToSpacedWords(ed.getName());
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put(ED_URI_PARAMETER_ID, edUri);
			parameters.put(FD_URI_PARAMETER_ID, fdUri);
			actionMap.put(edUri, action = createE4ActionAdapter(label, REPLACE_ICON_URI, REPLACE_COMMAND_ID, parameters));
		}
		return action;
	}
	public IUpdatableAction getAddEntityAction(EntityDescriptor<?> ed) {
		return getAddEntityAction(ed, null);
	}
	public IUpdatableAction getAddEntityAction(EntityDescriptor<?> ed, FeatureDescriptor fd) {
		String edUri = CommonsDataTypePersistenceParser.unparseEntityDescriptor(ed);
		String fdUri = fd != null ? CommonsDataTypePersistenceParser.unparseFeatureDescriptor(fd) : null;

		Map<String, IUpdatableAction> actionMap = addActions.get(edUri);
		if (actionMap == null)
			addActions.put(edUri, actionMap = new HashMap<String, IUpdatableAction>());

		IUpdatableAction action = actionMap.get(fdUri);
		if (action == null) {
			String label = StringUtils.camelCaseToSpacedWords(ed.getName());
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put(ED_URI_PARAMETER_ID, edUri);
			parameters.put(FD_URI_PARAMETER_ID, fdUri);
			actionMap.put(edUri, action = createE4ActionAdapter(label, ADD_ICON_URI, ADD_COMMAND_ID, parameters));
		}
		return action;
	}

	public IUpdatableAction createReplaceFragmentAction(String label, IEntity predicate, IEntity fragment) {
		try {
			Map<String, String> parameters = new HashMap<String, String>();
			StringPersistenceProvider spp = new StringPersistenceProvider();
			ReflectionFactory.getDefaultPersistenceKit().writeModel(fragment, spp);
			parameters.put(FRAGMENT_XWL_PARAMETER_ID, spp.getStore());
			spp = new StringPersistenceProvider();
			ReflectionFactory.getDefaultPersistenceKit().writeModel(predicate, spp);
			parameters.put(PREDICATE_XWL_PARAMETER_ID, spp.getStore());
			return createE4ActionAdapter(label, REPLACE_ICON_URI, REPLACE_FRAGMENT_COMMAND_ID, parameters);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	public IUpdatableAction createAddFragmentAction(String label, IEntity predicate, IEntity fragment) {
		try {
			Map<String, String> parameters = new HashMap<String, String>();
			StringPersistenceProvider spp = new StringPersistenceProvider();
			ReflectionFactory.getDefaultPersistenceKit().writeModel(fragment, spp);
			parameters.put(FRAGMENT_XWL_PARAMETER_ID, spp.getStore());
			spp = new StringPersistenceProvider();
			ReflectionFactory.getDefaultPersistenceKit().writeModel(predicate, spp);
			parameters.put(PREDICATE_XWL_PARAMETER_ID, spp.getStore());
			return createE4ActionAdapter(label, ADD_ICON_URI, ADD_FRAGMENT_COMMAND_ID, parameters);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	public IUpdatableAction createPerformAction(String label, String iconUri, IEntity predicate, IEntity behavior) {
		try {
			Map<String, String> parameters = new HashMap<String, String>();
			StringPersistenceProvider spp = new StringPersistenceProvider();
			ReflectionFactory.getDefaultPersistenceKit().writeModel(behavior, spp);
			parameters.put(BEHAVIOR_XWL_PARAMETER_ID, spp.getStore());
			spp = new StringPersistenceProvider();
			ReflectionFactory.getDefaultPersistenceKit().writeModel(predicate, spp);
			parameters.put(PREDICATE_XWL_PARAMETER_ID, spp.getStore());
			parameters.put(DESCRIPTION_PARAMETER_ID, label);
			return createE4ActionAdapter(label, iconUri, PERFORM_COMMAND_ID, parameters);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public IUpdatableAction createActionCallAction(String label, boolean analyzing, IEntity predicate, String functionUri) {
		try {
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put(FUNCTION_URI_PARAMETER_ID, functionUri);
			StringPersistenceProvider spp = new StringPersistenceProvider();
			ReflectionFactory.getDefaultPersistenceKit().writeModel(predicate, spp);
			parameters.put(PREDICATE_XWL_PARAMETER_ID, spp.getStore());
			parameters.put(DESCRIPTION_PARAMETER_ID, label);
			parameters.put(ANALYSING_PARAMETER_ID, Boolean.valueOf(analyzing).toString());
			return createE4ActionAdapter(label, null, ACTION_CALL_COMMAND_ID, parameters);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public IUpdatableAction createClearTextSelection(int direction) {
		return new ClearTextSelectionAction(context, direction);
	}
	public IUpdatableAction createActivateToolAction(Tools tool) {
		return new ActivateToolAction(context, tool);
	}
	public IUpdatableAction createDirectEditAction() {
		return new DirectEditAction(context);
	}

	public void registerKeyActions(E4KeyHandler keyHandler) {
		keyHandler.put(KeySequence.getInstance(KeyStroke.getInstance(SWT.F2)), true, createDirectEditAction());

		keyHandler.put(KeySequence.getInstance(KeyStroke.getInstance(SWT.ARROW_LEFT)), true, createClearTextSelection(SWT.LEFT));
		keyHandler.put(KeySequence.getInstance(KeyStroke.getInstance(SWT.ARROW_RIGHT)), true, createClearTextSelection(SWT.RIGHT));

		IUpdatableAction activatePanningToolAction = createActivateToolAction(Tools.PANNING);
		keyHandler.put(KeySequence.getInstance(KeyStroke.getInstance(SWT.CR)), true, activatePanningToolAction);
		keyHandler.put(KeySequence.getInstance(KeyStroke.getInstance(SWT.LF)), true, activatePanningToolAction);
		keyHandler.put(KeySequence.getInstance(KeyStroke.getInstance(SWT.ESC)), true, activatePanningToolAction);
	}

	protected void registerBaseActions(Widget widget) {
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
		registerAction(createE4ActionAdapter(DEFAULT_LABEL, REPLACE_ICON_URI, REPLACE_WITH_DEFAULT_COMMAND_ID, Collections.<String, String>emptyMap()));
		registerAction(createE4ActionAdapter(IMPORT_LABEL, IMPORT_ICON_URI, IMPORT_COMMAND_ID, Collections.<String, String>emptyMap()));

		widget.addDisposeListener(new DisposeListener() {
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
