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
package org.whole.lang.e4.ui.compatibility;

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.tools.compat.parts.DIViewPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.actions.ActionFactory;
import org.whole.lang.e4.ui.actions.RedoAction;
import org.whole.lang.e4.ui.actions.UndoAction;
import org.whole.lang.e4.ui.parts.AbstractE4Part;
import org.whole.lang.ui.dialogs.IImportAsModelDialogFactory;
import org.whole.lang.ui.dialogs.ImportAsModelDialogFactory;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class ViewPart<C extends AbstractE4Part> extends DIViewPart<C> {
	protected String partId;
	protected UndoAction undoAction;
	protected RedoAction redoAction;

	public ViewPart(String partId, Class<C> partClass) {
		super(partClass);
		this.partId = partId;
	}

	@Override
	public void createPartControl(Composite parent) {
		IImportAsModelDialogFactory factory = ContextInjectionFactory.make(ImportAsModelDialogFactory.class, getContext());

		getContext().set(IImportAsModelDialogFactory.class, factory);

		super.createPartControl(parent);

		getContext().get(MPart.class).setElementId(partId);

		undoAction = new UndoAction(getContext(), UNDO_LABEL);
		undoAction.update();

		redoAction = new RedoAction(getContext(), REDO_LABEL);
		redoAction.update();
	}

	@Override
	public void setFocus() {
		IActionBars actionBars = getViewSite().getActionBars();
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
		super.setFocus();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		IEntityPartViewer viewer = getComponent().getViewer();
		if (adapter == GraphicalViewer.class) {
			return viewer instanceof GraphicalViewer ? viewer : null;
		} else if (adapter == ZoomManager.class)
			return viewer.getProperty(ZoomManager.class.toString());
		else if (adapter == CommandStack.class)
			return viewer.getCommandStack();
		else
			return super.getAdapter(adapter);
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
