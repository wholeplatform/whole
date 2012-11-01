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
package org.whole.lang.operations;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;

/**
 * @author Riccardo Solmi
 */
public class GraphicalDecorationManager extends WorkspaceDecorationManager {
	private Display display;
	private GraphicalViewer viewer;

	public GraphicalDecorationManager(IEditorPart editor, GraphicalViewer viewer, IProgressMonitor monitor) {
		super(monitor);
		this.viewer = viewer;

		display = editor.getEditorSite().getShell().getDisplay();

		IEditorInput editorInput = editor.getEditorInput();
		resource = (IResource) editorInput.getAdapter(IResource.class);
		if (resource == null)
			resource = (IFile) editorInput.getAdapter(IFile.class);
		if (resource == null)
			resource = ResourcesPlugin.getWorkspace().getRoot();
	}

	@SuppressWarnings("unchecked")
	public void addDecoration(final DecorationKind kind, final IEntity entity, final String message, final String location) {
		super.addDecoration(kind, entity, message, location);
		display.asyncExec(new Runnable() {
			public void run() {
				final IEntityPart part = ModelObserver.getObserver(entity, viewer.getEditPartRegistry());
				if (part != null)
						part.addDecoration(kind, message);
			}
		});
	}
	@SuppressWarnings("unchecked")
	public void deleteDecorations(final IEntity entity, final boolean deep) {
		super.deleteDecorations(entity, deep);
		display.asyncExec(new Runnable() {
			public void run() {
				final IEntityPart part = ModelObserver.getObserver(entity, viewer.getEditPartRegistry());
				if (part != null)
						part.deleteDecorations(deep);
			}
		});
	}
}
