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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.ui.viewers.EntityEditDomain;

/**
 * @author Enrico Persiani
 */
public class EntityEditDomainJob extends Job {
	protected IRunnableWithProgress runnable;

	public EntityEditDomainJob(String name, IRunnableWithProgress runnable) {
		super(name);
		this.runnable = runnable; 
	}

	@Override
	public IStatus run(IProgressMonitor monitor) {
		try {
			runnable.run(monitor);
		} catch (OperationCanceledException e) {
			// do nothing
			e.printStackTrace();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			return new Status(Status.ERROR, IE4UIConstants.BUNDLE_ID, 0, "An exception occurred while executing the job "+getName(), e);
		} finally {
			monitor.done();
		}

		return Status.OK_STATUS;
	}

	public static void asyncExec(String name, EntityEditDomain editDomain, IRunnableWithProgress runnable) {
		EntityEditDomainJob job = new EntityEditDomainJob(name, runnable);
		job.setRule(editDomain);
		job.setUser(false);
		job.setPriority(Job.INTERACTIVE);
		job.schedule();
	}
	
	public static void syncExec(String name, EntityEditDomain editDomain, IRunnableWithProgress runnable) {
		EntityEditDomainJob job = new EntityEditDomainJob(name, runnable);
		job.setRule(editDomain);
		job.setUser(false);
		job.setPriority(Job.INTERACTIVE);
		job.schedule();
		try {
			job.join(3000, null);
		} catch (OperationCanceledException e) {
			// terminate gracefully
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
