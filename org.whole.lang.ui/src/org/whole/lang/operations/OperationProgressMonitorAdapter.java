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
package org.whole.lang.operations;

import org.eclipse.core.runtime.IProgressMonitor;

public class OperationProgressMonitorAdapter extends DefaultOperationProgressMonitor implements IOperationProgressMonitor {
	private IProgressMonitor progressMonitor;
	private int intWork;
	private double doubleWork;

	public OperationProgressMonitorAdapter(IProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
	} 

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> adapterClass) {
		if (IProgressMonitor.class.equals(adapterClass))
			return (T) progressMonitor;
		
		return super.getAdapter(adapterClass);
	}
	
	@Override
	public void beginTask(String name, int work, int taskWork) {
		super.beginTask(name, work, taskWork);
		progressMonitor.subTask(name);
	}

	@Override
	public void endTask() {
		super.endTask();
		progressMonitor.subTask("");
	}

	@Override
	protected void operationWorked(double work) {
		doubleWork += work;
		int deltaWork = (int) (doubleWork - intWork);
		if (deltaWork > 0) {
			intWork += deltaWork;
			progressMonitor.worked(deltaWork);
		}
	}

	@Override
	public boolean isCanceled() {
		return progressMonitor.isCanceled();
	}

	@Override
	public void setCanceled(boolean value) {
		progressMonitor.setCanceled(value);
	}
}
