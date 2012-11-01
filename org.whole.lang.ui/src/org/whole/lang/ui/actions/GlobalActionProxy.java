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

import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;

public class GlobalActionProxy extends SelectionAction {
	IEditorActionDelegate delegate;

	public GlobalActionProxy(IWorkbenchPart editor, IEditorActionDelegate delegate) {
		super(editor);
		setLazyEnablementCalculation(false);
		delegate.setActiveEditor(this, (IEditorPart) getWorkbenchPart());
		this.delegate = delegate;
	}

	@Override
	protected boolean calculateEnabled() { 
		return super.isEnabled();
	}

	@Override
	protected void handleSelectionChanged() {
		delegate.selectionChanged(this, getSelection());
		super.handleSelectionChanged();
	}

	@Override
	public void run() {
		delegate.run(this);
	}
}
