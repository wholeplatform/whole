/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.e4.ui.draw2d.DelayableUpdateManager;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.exceptions.WholeRuntimeException;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationProgressMonitorAdapter;
import org.whole.lang.ui.editpolicies.DisabledFeedbackEditPolicy;
import org.whole.lang.ui.util.AnimableRunnable;
import org.whole.lang.ui.util.SuspensionKind;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractRunnableWithProgress implements ISynchronizableRunnable {
	protected IEclipseContext context;
	protected IBindingManager bm;
	protected String label;
	protected boolean delayUpdates;

	public AbstractRunnableWithProgress(IEclipseContext context, IBindingManager bm, String label, boolean delayUpdates) {
		this.context = context;
		this.bm = bm.clone();
		this.label = label;
		this.delayUpdates = delayUpdates;
	}

	public IBindingManager getBindings() {
		return bm;
	}

	@Override
	public void run(IProgressMonitor monitor) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		DisabledFeedbackEditPolicy.markDisabled(true, viewer);
		boolean delayUpdates = delayUpdates(viewer, this.delayUpdates);
		boolean enableAnimation = AnimableRunnable.enableAnimation(!this.delayUpdates);
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
			AnimableRunnable.enableAnimation(enableAnimation);
			delayUpdates(viewer, delayUpdates);
			DisabledFeedbackEditPolicy.markDisabled(false, viewer);
		}
	}

	protected boolean delayUpdates(IEntityPartViewer viewer, boolean enable) {
		Boolean oldDelayUpdates = (Boolean) viewer.getProperty(DelayableUpdateManager.PROPERTY_DELAY_UPDATES);
		viewer.setProperty(DelayableUpdateManager.PROPERTY_DELAY_UPDATES, enable);
		return oldDelayUpdates != null && oldDelayUpdates;
	}

	public abstract void run(IOperationProgressMonitor pm) throws InvocationTargetException, InterruptedException;

	public void asyncExec(String message) {
		RunnableJob job = new RunnableJob(message, this);
		job.setUser(false);
		job.setPriority(Job.INTERACTIVE);
		job.schedule();
	}

	public synchronized IBindingScope syncExec(long timeout) {
		new Thread(() -> {
			run(new NullProgressMonitor());
			// ensure notify doesn't get called before wait
			synchronized (this) {
				notifyAll();
			}
		}, getClass().getSimpleName()+".syncExec(...)").start();

		// wait for a notification
		try {
			wait(timeout);
		} catch (InterruptedException e) {
		}

		return bm;
	}
}
