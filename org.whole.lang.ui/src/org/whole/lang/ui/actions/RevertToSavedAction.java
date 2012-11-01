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
package org.whole.lang.ui.actions;

import org.eclipse.gef.ui.actions.EditorPartAction;
import org.eclipse.ui.actions.ActionFactory;
import org.whole.lang.ui.editors.WholeGraphicalEditor;

/**
 * @author Enrico Persiani
 */
public class RevertToSavedAction extends EditorPartAction {
	public RevertToSavedAction(WholeGraphicalEditor editor, int style) {
		super(editor, style);
	}

	public RevertToSavedAction(WholeGraphicalEditor editor) {
		super(editor);
	}

	@Override
	protected void init() {
		setId(ActionFactory.REVERT.getId());
	}

	protected boolean calculateEnabled() {
		return getEditorPart().isDirty();
	}

	@Override
	protected WholeGraphicalEditor getEditorPart() {
		return (WholeGraphicalEditor) getWorkbenchPart();
	}
	@Override
	public void run() {
		getEditorPart().doRevertToSaved();
	}
}
