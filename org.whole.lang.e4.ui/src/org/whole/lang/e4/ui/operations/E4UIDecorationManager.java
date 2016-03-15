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
package org.whole.lang.e4.ui.operations;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.ui.di.UISynchronize;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.WorkspaceDecorationManager;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class E4UIDecorationManager extends WorkspaceDecorationManager {
	protected UISynchronize synchronize;
	protected IEntityPartViewer viewer;

	public E4UIDecorationManager(UISynchronize synchronize, IBindingManager bm) {
		super((IFile) bm.wGetValue("file"), ((IOperationProgressMonitor) bm.wGetValue("progressMonitor")).getAdapter(IProgressMonitor.class));
		this.synchronize = synchronize;
		this.viewer = (IEntityPartViewer) bm.wGetValue("viewer");
	}

	public void addDecoration(final DecorationKind kind, final IEntity entity, final String message, final String location) {
		super.addDecoration(kind, entity, message, location);
		synchronize.asyncExec(new Runnable() {
			public void run() {
				final IEntityPart part = ModelObserver.getObserver(entity, viewer.getEditPartRegistry());
				if (part != null)
						part.addDecoration(kind, message);
			}
		});
	}
	public void deleteDecorations(final IEntity entity, final boolean deep) {
		super.deleteDecorations(entity, deep);
		synchronize.asyncExec(new Runnable() {
			public void run() {
				final IEntityPart part = ModelObserver.getObserver(entity, viewer.getEditPartRegistry());
				if (part != null)
						part.deleteDecorations(deep);
			}
		});
	}
}
