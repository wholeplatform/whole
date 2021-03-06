/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.debug;

import org.whole.lang.e4.ui.jobs.ExecutionState;
import org.whole.lang.e4.ui.jobs.IExecutionListener;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.util.SuspensionKind;

/**
 * @author Enrico Persiani
 */
public interface IDebugService {
	public void addExecutionListener(IExecutionListener listener);
	public void removeExecutionListener(IExecutionListener listener);

	public boolean isSuspended();
	public boolean isBreakpointsEnabled();
	public void setBreakpointsEnabled(boolean enabled);
	public boolean isInstrumentationEnabled();
	public void setInstrumentationEnabled(boolean enabled);

	public SuspensionKind peekSuspensionKind();
	public IEntity peekSourceEntity();
	public Throwable peekThrowable();
	public IEntity peekVariablesModel();

	public boolean containsExecution(ExecutionState execution);
	public ExecutionState peekExecution();
	public void pushExecution(ExecutionState execution);
	public void removeExecution(ExecutionState execution);

	public default void doResume() {
		peekExecution().resume();
	}
	public default void doTerminate() {
		peekExecution().terminate();
	}
}
