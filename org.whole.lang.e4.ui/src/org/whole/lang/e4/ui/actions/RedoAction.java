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

import java.net.URL;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.ui.actions.IActionRedirection;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class RedoAction extends AbstractCommandStackAction {
	public RedoAction(IEclipseContext context, String label) {
		super(context, label);
		setId(EDIT_REDO);
		setActionDefinitionId(EDIT_REDO);
	}

	public RedoAction(IEclipseContext context, String label, String iconURI) {
		this(context, label);
		try {
			setImageDescriptor(ImageDescriptor.createFromURL(new URL(iconURI)));
		} catch (Exception e) {
		}
	}

	protected void doRun(IEntityPartViewer viewer) {
		IActionRedirection actionRedirection = getActionRedirection();
		if (actionRedirection.isActive())
			actionRedirection.performUndo();
		else
			viewer.getCommandStack().redo();
	}

	protected boolean calculateEnabled(IEntityPartViewer viewer) {
		return getActionRedirection().isActive() ? true : viewer.getCommandStack().canRedo();
	}

	protected String calculateLabel(IEntityPartViewer viewer) {
		String editLabel = label;
		if (isEnabled() && !getActionRedirection().isActive()) {
			String label = viewer.getCommandStack().getRedoCommand().getLabel();
			editLabel += " " + (label != null ? label : "unknown");
		}
		return editLabel;
	}
}
