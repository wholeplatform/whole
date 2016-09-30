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
package org.whole.lang.e4.ui.jobs;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.exceptions.WholeRuntimeException;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationProgressMonitorAdapter;
import org.whole.lang.ui.util.SuspensionKind;
import org.whole.lang.ui.viewers.EntityEditDomain;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractRunnableWithProgress implements ISynchronizableRunnable {
	protected IEclipseContext context;
	protected IBindingManager bm;
	protected String label;

	public AbstractRunnableWithProgress(IEclipseContext context, IBindingManager bm, String label) {
		this.context = context;
		this.bm = bm.clone();
		this.label = label;
	}

	public IBindingManager getBindings() {
		return bm;
	}

	@Override
	public void run(IProgressMonitor monitor) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		try {
			final IOperationProgressMonitor pm = new OperationProgressMonitorAdapter(monitor);
			bm.wDefValue("progressMonitor", pm);
			run(pm);
		} catch (Exception e) {
			IWholeRuntimeException we = e instanceof IWholeRuntimeException ? (IWholeRuntimeException) e : new WholeRuntimeException(e);
			if (we.getSourceEntity() != null) {
				E4Utils.suspendOperation(SuspensionKind.ERROR, we);
			} else
				E4Utils.reportError(context, "Model operation error", "Error while executing "+label+" operation", e);
		} finally {
			monitor.done();
			if (isTransactional())
				context.get(UISynchronize.class).syncExec(() -> viewer.getEditDomain().setDisabled(false));
		}
		return;
	}

	public abstract void run(IOperationProgressMonitor pm) throws InvocationTargetException, InterruptedException;

	protected boolean isTransactional() {
		return true;
	}

	public void asyncExec(String message) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		EntityEditDomain editDomain = viewer.getEditDomain();

		if (isTransactional())
			editDomain.setDisabled(true);

		EntityEditDomainJob.asyncExec(message, editDomain, this);
	}

	public synchronized IBindingScope syncExec(long timeout) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		EntityEditDomain editDomain = viewer.getEditDomain();

		UISynchronize uiSynchronize = context.get(UISynchronize.class);
		try {
			context.set(UISynchronize.class, NoUISynchronize.instance);
			EntityEditDomainJob.syncExec("boh", editDomain, this);
		} finally {
			context.set(UISynchronize.class, uiSynchronize);
		}
		return bm;
	}

	private static final class NoUISynchronize extends UISynchronize {
		public static NoUISynchronize instance = new NoUISynchronize();
		@Override
		public void syncExec(Runnable runnable) {
		}
		@Override
		public void asyncExec(Runnable runnable) {
		}
	}
}
