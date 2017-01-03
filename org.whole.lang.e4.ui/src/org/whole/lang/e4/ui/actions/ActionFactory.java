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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.actions.IUpdatableAction;

/**
 * @author Enrico Persiani
 */
public class ActionFactory {
	protected IEclipseContext context;

	public ActionFactory(IEclipseContext context) {
		this.context = context;
	}

	public IUpdatableAction createReplaceFragmentAction(String label, IEntity predicate, IEntity fragment) {
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
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
			Map<String, Object> parameters = new HashMap<String, Object>();
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
			Map<String, Object> parameters = new HashMap<String, Object>();
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
			Map<String, Object> parameters = new HashMap<String, Object>();
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

	public IUpdatableAction createDirectEditAction() {
		return new DirectEditAction(context);
	}

	public E4ActionAdapter createE4ActionAdapter(String handledMenuId) {
		return new E4ActionAdapter(context, handledMenuId);
	}
	public E4ActionAdapter createE4ActionAdapter(String label, String iconURI, String commandId, Map<String, Object> parameters) {
		return new E4ActionAdapter(context, label, iconURI, commandId, parameters);
	}
	public E4ActionAdapter createE4ActionAdapter(String label, String iconURI, String commandId, Map<String, Object> parameters, int style) {
		return new E4ActionAdapter(context, label, iconURI, commandId, parameters, style);
	}
	public RedoAction createRedoAction() {
		return new RedoAction(context, REDO_LABEL, REDO_ICON_URI);
	}
	public UndoAction createUndoAction() {
		return new UndoAction(context, UNDO_LABEL, UNDO_ICON_URI);
	}
}
