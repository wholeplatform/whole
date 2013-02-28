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
package org.whole.lang.e4.ui.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.ui.WholeUIPlugin;

public class RunnableJob extends Job {
	protected IRunnableWithProgress runnable;

	public RunnableJob(String name, IRunnableWithProgress runnable) {
		super(name);
		this.runnable = runnable; 
	}

	@Override
	public IStatus run(IProgressMonitor monitor) {
		try {
			runnable.run(monitor);
		} catch (OperationCanceledException e) {
			// do nothing
		} catch (InterruptedException e) {
			// do nothing
		} catch (Exception e) {
			return new Status(Status.ERROR, WholeUIPlugin.PLUGIN_ID, 0, "An exception occurred while executing the job "+getName(), e);
		} finally {
			monitor.done();
		}
		return Status.OK_STATUS;
	}
}
