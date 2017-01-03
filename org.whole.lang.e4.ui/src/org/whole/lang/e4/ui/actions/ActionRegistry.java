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
package org.whole.lang.e4.ui.actions;

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.bindings.EBindingService;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.gef.Disposable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swt.SWT;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.actions.IUpdatableAction;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.keys.AbstractKeyHandler;
import org.whole.lang.ui.tools.Tools;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class ActionRegistry {
	@Inject protected IEclipseContext context;
	@Inject	protected ECommandService commandService;
	@Inject	protected EBindingService bindingService;
	@Inject protected IEntityPartViewer viewer;

	protected ActionFactory actionFactory;
	protected Map<String, IUpdatableAction> baseActions = new HashMap<String, IUpdatableAction>();
	protected Map<String, IUpdatableAction> selectNotationActions = new HashMap<String, IUpdatableAction>();
	protected Map<String, Map<String, IUpdatableAction>> replaceActions = new HashMap<String, Map<String, IUpdatableAction>>();
	protected Map<String, Map<String, IUpdatableAction>> addActions = new HashMap<String, Map<String, IUpdatableAction>>();

	public ActionFactory getActionFactory() {
		return actionFactory;
	}

	@PostConstruct
	protected void registerBaseActions() {
		actionFactory = new ActionFactory(context);

		registerAction(actionFactory.createUndoAction());
		registerAction(actionFactory.createRedoAction());
		registerAction(actionFactory.createE4ActionAdapter(CUT_MENU_ID));
		registerAction(actionFactory.createE4ActionAdapter(COPY_MENU_ID));
		registerAction(actionFactory.createE4ActionAdapter(PASTE_MENU_ID));
		registerAction(actionFactory.createE4ActionAdapter(DELETE_MENU_ID));
		registerAction(actionFactory.createE4ActionAdapter(SELECT_ALL_MENU_ID));

		String copyIconURI = E4Utils.findMenu(COPY_MENU_ID, context.get(EModelService.class), context.get(MApplication.class), MHandledMenuItem.class).getIconURI();
		String pasteIconURI = E4Utils.findMenu(PASTE_MENU_ID, context.get(EModelService.class), context.get(MApplication.class), MHandledMenuItem.class).getIconURI();
		registerAction(actionFactory.createE4ActionAdapter(COPY_ENTITY_PATH_LABEL, copyIconURI, COPY_ENTITY_PATH_COMMAND_ID, Collections.<String, Object>emptyMap()));
		registerAction(actionFactory.createE4ActionAdapter(COPY_AS_IMAGE_LABEL, copyIconURI, COPY_AS_IMAGE_COMMAND_ID, Collections.<String, Object>emptyMap()));
		registerAction(actionFactory.createE4ActionAdapter(PASTE_AS_LABEL, pasteIconURI, PASTE_AS_COMMAND_ID, Collections.<String, Object>emptyMap()));
		registerAction(actionFactory.createE4ActionAdapter(DEFAULT_LABEL, REPLACE_ICON_URI, REPLACE_WITH_DEFAULT_COMMAND_ID, Collections.<String, Object>emptyMap()));
		registerAction(actionFactory.createE4ActionAdapter(IMPORT_LABEL, IMPORT_ICON_URI, IMPORT_COMMAND_ID, Collections.<String, Object>emptyMap()));
	}

	@PreDestroy
	protected void dipose() {
		for (IUpdatableAction action : baseActions.values())
			if (action instanceof Disposable)
				((Disposable) action).dispose();
	}

	protected void registerAction(IUpdatableAction action) {
		baseActions.put(action.getId(), action);
	}
	public void registerNotationKeyActions(IGEFEditorKit editorKit) {
	}
	public void registerKeyActions(AbstractKeyHandler keyHandler) {
		keyHandler.put(KeySequence.getInstance(KeyStroke.getInstance(SWT.F2)), true, actionFactory.createDirectEditAction());

		for (IEditorKit editorKit : ReflectionFactory.getEditorKits()) {
			for (ILanguageKit lk : ReflectionFactory.getLanguageKits(false)) {
				if (!editorKit.canApply(lk))
					continue;

				for (Object[] textAction : E4Utils.textActionsFor(lk, ((IGEFEditorKit) editorKit).getActionFactory().textActions())) {
					KeySequence keySequence = (KeySequence) textAction[0];
					Class<IUpdatableAction> actionClass = (Class<IUpdatableAction>) textAction[2];
					try {
						IUpdatableAction action = actionClass
								.getConstructor(IEclipseContext.class)
								.newInstance(context);
						keyHandler.put(editorKit, keySequence, true, action);
					} catch (Exception e) {
					}
				}
			}
		}
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
			Map<String, Object> parameters = Collections.singletonMap(EDITORKIT_ID_PARAMETER_ID, editorKitId);
			selectNotationActions.put(editorKitId, action = actionFactory.createE4ActionAdapter(label, null, SELECT_NOTATION_COMMAND_ID, parameters, IAction.AS_RADIO_BUTTON));
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
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put(ED_URI_PARAMETER_ID, edUri);
			parameters.put(FD_URI_PARAMETER_ID, fdUri);
			actionMap.put(edUri, action = actionFactory.createE4ActionAdapter(label, REPLACE_ICON_URI, REPLACE_COMMAND_ID, parameters));
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
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put(ED_URI_PARAMETER_ID, edUri);
			parameters.put(FD_URI_PARAMETER_ID, fdUri);
			actionMap.put(edUri, action = actionFactory.createE4ActionAdapter(label, ADD_ICON_URI, ADD_COMMAND_ID, parameters));
		}
		return action;
	}

	protected void registerWorkbenchAction(String commandId) {
		IUpdatableAction action = getAction(commandId);
		ParameterizedCommand command = commandService.createCommand(commandId, null);
		viewer.getKeyHandler().put((KeySequence) bindingService.getBestSequenceFor(command), true, action);		
	}

	public void registerUndoAction() {
		registerWorkbenchAction(EDIT_UNDO);		
	}
	public void registerRedoAction() {
		registerWorkbenchAction(EDIT_REDO);
	}
	public void registerDeleteAction() {
		registerWorkbenchAction(EDIT_DELETE);
	}
	public void registerWorkbenchActions() {
		if (!E4Utils.isLegacyApplication())
			return;

		registerUndoAction();
		registerRedoAction();
		registerDeleteAction();
	}
}
