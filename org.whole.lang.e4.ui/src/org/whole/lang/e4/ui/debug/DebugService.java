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

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osgi.service.prefs.BackingStoreException;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.jobs.ExecutionState;
import org.whole.lang.e4.ui.jobs.IExecutionListener;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.util.SuspensionKind;

/**
 * @author Enrico Persiani
 */
@Singleton
public class DebugService implements IDebugService {
	protected static final String BREAKPOINTS_ENABLED = "breakpointsEnabled";
	protected static final String INSTRUMENTATION_ENABLED = "instrumentationEnabled";
	protected ListenerList<IExecutionListener> listeners = new ListenerList<>();
	protected Deque<ExecutionState> executions;
	protected boolean breakpointsEnabled;
	protected boolean instrumentationEnabled;
	@Inject
	protected IEclipseContext context;

	public DebugService() {
		this.listeners = new ListenerList<>();
		this.executions = new ConcurrentLinkedDeque<>();
		this.breakpointsEnabled = Boolean.valueOf(getPreferences().get(BREAKPOINTS_ENABLED, Boolean.TRUE.toString()));
		this.instrumentationEnabled = Boolean.valueOf(getPreferences().get(INSTRUMENTATION_ENABLED, Boolean.TRUE.toString()));
	}

	protected IEclipsePreferences getPreferences() {
		return ConfigurationScope.INSTANCE.getNode(IE4UIConstants.BUNDLE_ID);
	}

	protected void fireExecutionAboutToPush(ExecutionState execution) {
		Object[] listenersArray = listeners.getListeners(); 
		for (int i = 0; i < listenersArray.length; i++)
			((IExecutionListener) listenersArray[i]).executionAboutToPush(execution); 
	}
	protected void fireExecutionPushed(ExecutionState execution) {
		Object[] listenersArray = listeners.getListeners(); 
		for (int i = 0; i < listenersArray.length; i++)
			((IExecutionListener) listenersArray[i]).executionPushed(execution); 
	}
	protected void fireExecutionAboutToPop(ExecutionState execution) {
		Object[] listenersArray = listeners.getListeners(); 
		for (int i = 0; i < listenersArray.length; i++)
			((IExecutionListener) listenersArray[i]).executionAboutToPop(execution); 
	}
	protected void fireExecutionPopped(ExecutionState execution) {
		Object[] listenersArray = listeners.getListeners(); 
		for (int i = 0; i < listenersArray.length; i++)
			((IExecutionListener) listenersArray[i]).executionPopped(execution); 
	}
	
	public void addExecutionListener(IExecutionListener listener) {
		listeners.add(listener);
	}

	public void removeExecutionListener(IExecutionListener listener) {
		listeners.remove(listener);
	}

	public boolean isSuspended() {
		return executions.peek() != null;
	}
	public boolean isBreakpointsEnabled() {
		return breakpointsEnabled;
	}
	public void setBreakpointsEnabled(boolean enabled) {
		this.breakpointsEnabled = enabled;
		getPreferences().put(BREAKPOINTS_ENABLED, Boolean.toString(enabled));
		try {
			getPreferences().flush();
		} catch (BackingStoreException e) {
			E4Utils.reportError(context, "preferences save error", "unable to store preferences", e);
		}
	}
	public boolean isInstrumentationEnabled() {
		return instrumentationEnabled;
	}
	public void setInstrumentationEnabled(boolean enabled) {
		this.instrumentationEnabled = enabled;
		getPreferences().put(INSTRUMENTATION_ENABLED, Boolean.toString(enabled));
		try {
			getPreferences().flush();
		} catch (BackingStoreException e) {
			E4Utils.reportError(context, "preferences save error", "unable to store preferences", e);
		}
	}

	public SuspensionKind peekSuspensionKind() {
		ExecutionState execution = executions.peek();
		return execution != null ? execution.getSuspensionKind() : SuspensionKind.NONE;
	}
	public IEntity peekSourceEntity() {
		return executions.peek().getSourceEntity();
	}
	public Throwable peekThrowable() {
		return executions.peek().getThrowable();
	}
	public IEntity peekVariablesModel() {
		return executions.peek().getVariablesModel();
	}

	public synchronized void pushExecution(ExecutionState execution) {
		fireExecutionAboutToPush(execution);
		executions.push(execution);
		fireExecutionPushed(execution);
	}
	public synchronized ExecutionState popExecution() {
		ExecutionState execution = executions.peek();
		fireExecutionAboutToPop(execution);
		try {
			return executions.removeFirst();
		} finally {
			fireExecutionPopped(execution);
		}
	}
}
