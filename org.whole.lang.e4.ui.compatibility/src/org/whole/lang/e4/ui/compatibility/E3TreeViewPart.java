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
package org.whole.lang.e4.ui.compatibility;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import org.eclipse.e4.tools.compat.parts.DIViewPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.actions.ActionFactory;
import org.whole.lang.e4.ui.actions.RedoAction;
import org.whole.lang.e4.ui.actions.UndoAction;
import org.whole.lang.e4.ui.parts.E4TreePart;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class E3TreeViewPart extends DIViewPart<E4TreePart> {
	protected UndoAction undoAction;
	protected RedoAction redoAction;

	public E3TreeViewPart() {
		super(E4TreePart.class);
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		
		undoAction = new UndoAction(getContext().getParent(), UNDO_LABEL);
		undoAction.update();

		redoAction = new RedoAction(getContext().getParent(), REDO_LABEL);
		redoAction.update();
	}

	@Override
	public void setFocus() {
		IActionBars actionBars = getViewSite().getActionBars();
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		undoAction.update();
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
		redoAction.update();
		super.setFocus();
	}

	@Override
	public void saveState(IMemento memento) {
		getComponent().saveState();
	}

	@Override
	public void dispose() {
		if (undoAction != null)
			undoAction.dispose();
		if (redoAction != null)
			redoAction.dispose();
		super.dispose();
	}
}