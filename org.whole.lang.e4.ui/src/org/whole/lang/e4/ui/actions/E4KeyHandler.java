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

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.SWTKeySupport;
import org.eclipse.swt.events.KeyEvent;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.reflect.IEditorKit;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class E4KeyHandler extends KeyHandler {
	protected IEclipseContext context;
	protected KeyHandler parent;
	protected Map<KeySequence, IUpdatableAction> pressActions;
	protected Map<KeySequence, IUpdatableAction> releaseActions;
	protected Map<IEditorKit, Map<KeySequence, IUpdatableAction>> editorKitPressedActions;
	protected Map<IEditorKit, Map<KeySequence, IUpdatableAction>> editorKitReleasedActions;
	
	public E4KeyHandler(IEclipseContext context) {
		this.context = context;
	}

	protected Map<IEditorKit, Map<KeySequence, IUpdatableAction>> getEditorKitActionsMap(boolean pressed) {
		if (pressed) {
			if (editorKitPressedActions == null)
				editorKitPressedActions = new HashMap<IEditorKit, Map<KeySequence, IUpdatableAction>>();
			return editorKitPressedActions;
		} else {
			if (editorKitReleasedActions == null)
				editorKitReleasedActions = new HashMap<IEditorKit, Map<KeySequence, IUpdatableAction>>();
			return editorKitReleasedActions;
		}
	}
	protected Map<KeySequence, IUpdatableAction> getEditorKitActions(IEditorKit editorKit, boolean pressed) {
		Map<IEditorKit, Map<KeySequence, IUpdatableAction>> editorKitActions = getEditorKitActionsMap(pressed);
		Map<KeySequence, IUpdatableAction> actionMap = editorKitActions.get(editorKit);
		if (actionMap == null)
			editorKitActions.put(editorKit, actionMap = new HashMap<KeySequence, IUpdatableAction>());
		return actionMap;
	}
	protected IUpdatableAction getEditorKitAction(KeySequence keySequence, boolean pressed) {
		ESelectionService selectionService = context.get(ESelectionService.class);
		if (selectionService.getSelection() instanceof IBindingManager) {
			IBindingManager bm = (IBindingManager) selectionService.getSelection();
			if (bm.wIsSet("primarySelectedEntity")) {
				return getEditorKitActions(bm.wGet("primarySelectedEntity").wGetEditorKit(),
						pressed).get(keySequence);
			}
		}
		return null;
	}

	protected Map<KeySequence, IUpdatableAction> getPressActions() {
		if (pressActions == null)
			pressActions = new TreeMap<KeySequence, IUpdatableAction>();
		return pressActions;
	}
	protected Map<KeySequence, IUpdatableAction> getReleaseActions() {
		if (releaseActions == null)
			releaseActions = new TreeMap<KeySequence, IUpdatableAction>();
		return releaseActions;
	}

	protected IUpdatableAction getPressAction(KeySequence keySequence) {
		IUpdatableAction editorKitAction = getEditorKitAction(keySequence, true);
		return editorKitAction != null ? editorKitAction : getPressActions().get(keySequence);
	}
	protected IUpdatableAction getReleaseAction(KeySequence keySequence) {
		IUpdatableAction editorKitAction = getEditorKitAction(keySequence, false);
		return editorKitAction != null ? editorKitAction : getReleaseActions().get(keySequence);
	}

	protected KeySequence convertKeyEvent(KeyEvent event) {
		int accelerator = SWTKeySupport.convertEventToUnmodifiedAccelerator(event);
		return KeySequence.getInstance(SWTKeySupport.convertAcceleratorToKeyStroke(accelerator));
	}

	protected boolean handleEvent(KeyEvent event, IUpdatableAction action) {
		if (action == null)
			return false;
		else
			action.update();

		if (action.isEnabled()) {
			action.run();
			event.doit = false;
			return true;
		} else
			return false;
	}
	
	public void put(KeySequence keySequence, boolean pressed, IUpdatableAction action) {
		(pressed ? getPressActions() : getReleaseActions()).put(keySequence, action);
	}
	public IAction remove(KeySequence keySequence, boolean pressed) {
		return (pressed ? getPressActions() : getReleaseActions()).remove(keySequence);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		if (handleEvent(event, getPressAction(convertKeyEvent(event))))
			return true;
		return parent != null && parent.keyPressed(event);
	}

	@Override
	public boolean keyReleased(KeyEvent event) {
		if (handleEvent(event, getReleaseAction(convertKeyEvent(event))))
			return true;
		return parent != null && parent.keyReleased(event);
	}

	@Deprecated
	public void put(KeyStroke keystroke, IAction action) {
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public void remove(KeyStroke keystroke) {
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public KeyHandler setParent(KeyHandler parent) {
		throw new UnsupportedOperationException();
	}
}
