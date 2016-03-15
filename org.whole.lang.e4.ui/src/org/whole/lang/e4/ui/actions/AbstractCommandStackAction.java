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

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.Disposable;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.ui.actions.IActionRedirection;
import org.whole.lang.ui.actions.NullActionRedirection;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractCommandStackAction extends AbstractE4Action implements Disposable {
	protected IEntityPartViewer viewer;
	protected CommandStackEventListener listener;
	protected String label;

	public AbstractCommandStackAction(IEclipseContext context, String label) {
		super(context, label);
		this.label = label;
		this.viewer = context.get(IEntityPartViewer.class);
		this.viewer.getCommandStack().addCommandStackEventListener(this.listener = new PostChangeUpdater());
	}
	public void dispose() {
		if (viewer != null)
			viewer.getCommandStack().removeCommandStackEventListener(listener);
	}

	public void redirect(IEntityPartViewer viewer) {
		this.viewer.getCommandStack().removeCommandStackEventListener(listener);
		(this.viewer = viewer).getCommandStack().addCommandStackEventListener(listener);
	}

	@Override
	public void run() {
		doRun(viewer);
	}

	public void update() {
		setEnabled(calculateEnabled(viewer));
		setText(calculateLabel(viewer));
	}

	protected IActionRedirection getActionRedirection() {
		Object selection = getContext().get(IServiceConstants.ACTIVE_SELECTION);

		if (!(selection instanceof IBindingManager))
			return NullActionRedirection.instance();

		IBindingManager bm = (IBindingManager) selection;
		return IActionRedirection.getActionRedirection(bm);
	}
	protected abstract void doRun(IEntityPartViewer viewer);
	protected abstract boolean calculateEnabled(IEntityPartViewer viewer);
	protected abstract String calculateLabel(IEntityPartViewer viewer);

	private class PostChangeUpdater implements CommandStackEventListener {
		public void stackChanged(CommandStackEvent event) {
			if (event.isPostChangeEvent())
				update();
		}
	}
}
