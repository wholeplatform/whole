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

import java.util.Stack;

public class DefaultOperationProgressMonitor implements IOperationProgressMonitor {
	private Stack<TaskData> taskDataStack;
	private boolean canceled = false;

	public DefaultOperationProgressMonitor() {
		taskDataStack = new Stack<TaskData>();
		taskDataStack.push(new TaskData(TOTAL_WORK, TOTAL_WORK, 1.0f));
	}

	public <T> T getAdapter(Class<T> adapterClass) {
		return null;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
	public void beginTask(String name, int work) {
		beginTask(name, work, work);
	}
	public void beginTask(String name, int work, int taskWork) {
		assert taskDataStack.peek().work >= work;
		taskDataStack.push(new TaskData(work, taskWork, taskDataStack.peek().workFactor));
	}

	public void endTask() {
		assert taskDataStack.size() > 1;
		TaskData taskData = taskDataStack.peek();
		worked(taskData.work);
		taskDataStack.pop();
		taskDataStack.peek().work -= taskData.parentWork;
	}

	public void worked(int work) {
		TaskData taskData = taskDataStack.peek();
		taskData.work -= work;
		operationWorked(taskData.workFactor * work);
	}

	protected void operationWorked(double work) {
	}

	private static class TaskData {
		public int work;
		public final int parentWork;
		public final double workFactor;

		public TaskData(int parentWork, int work, double parentWorkFactor) {
			this.work = work;
			this.parentWork = parentWork;
			this.workFactor = ((double) parentWork)/work * parentWorkFactor;
		}
	}
}
