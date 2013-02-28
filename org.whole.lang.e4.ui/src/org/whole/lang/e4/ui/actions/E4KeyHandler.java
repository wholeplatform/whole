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

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.SWTKeySupport;
import org.eclipse.swt.events.KeyEvent;

/**
 * @author Enrico Persiani
 */
public class E4KeyHandler extends KeyHandler {
	protected Map<KeySequence, IAction> pressActions;
	protected Map<KeySequence, IAction> releaseActions;
	protected KeyHandler parent;

	protected Map<KeySequence, IAction> getPressActions() {
		if (pressActions == null)
			pressActions = new TreeMap<KeySequence, IAction>();
		return pressActions;
	}
	protected Map<KeySequence, IAction> getReleaseActions() {
		if (releaseActions == null)
			releaseActions = new TreeMap<KeySequence, IAction>();
		return releaseActions;
	}
	
	protected KeySequence convertKeyEvent(KeyEvent event) {
		int accelerator = SWTKeySupport.convertEventToUnmodifiedAccelerator(event);
		return KeySequence.getInstance(SWTKeySupport.convertAcceleratorToKeyStroke(accelerator));
	}
	
	protected boolean handleEvent(KeyEvent event, IAction action) {
		if (action != null && action.isEnabled()) {
			action.run();
			return true;
		} else
			return false;
	}
	
	public void put(KeySequence keySequence, boolean pressed, IAction action) {
		(pressed ? getPressActions() : getReleaseActions()).put(keySequence, action);
	}
	public IAction remove(KeySequence keySequence, boolean pressed) {
		return (pressed ? getPressActions() : getReleaseActions()).remove(keySequence);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		if (handleEvent(event, getPressActions().get(convertKeyEvent(event))))
			return true;
		return parent != null && parent.keyPressed(event);
	}

	@Override
	public boolean keyReleased(KeyEvent event) {
		if (handleEvent(event, getReleaseActions().get(convertKeyEvent(event))))
			return true;
		return parent != null && parent.keyReleased(event);
	}

	@Override
	public void put(KeyStroke keystroke, IAction action) {
		throw new UnsupportedOperationException();
	}
	@Override
	public void remove(KeyStroke keystroke) {
		throw new UnsupportedOperationException();
	}
	@Override
	public KeyHandler setParent(KeyHandler parent) {
		return super.setParent(parent);
	}
}
