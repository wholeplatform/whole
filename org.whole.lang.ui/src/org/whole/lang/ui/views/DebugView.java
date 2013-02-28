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
package org.whole.lang.ui.views;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.Page;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.ui.WholeUIPlugin;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class DebugView extends WholeGraphicalView {
	protected final CyclicBarrier barrier = new CyclicBarrier(2);
	protected IBindingManager debugEnv;

	public static String ID = DebugView.class.getName();
	@Override
	public String getViewId() {
		return ID;
	}

	public void setInteractiveMode(WholeGraphicalViewer viewer, IEntity contents) {
		viewer.setInteractive(contents, false, true, false);
	}

	@Override
	protected Page createGraphicalPage(WholeGraphicalViewer viewer) {
		return new WholeGraphicalPage(viewer, this);
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		return part == this;
	}

	@Override
	protected void createContributions(IActionBars actionBars) {
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		toolBarManager.add(new Separator(VIEW_ACTIONS));

		toolBarManager.appendToGroup(VIEW_ACTIONS, createRunAction());
		toolBarManager.appendToGroup(VIEW_ACTIONS, createResumeAction());
		toolBarManager.appendToGroup(VIEW_ACTIONS, createTerminateAction());
		updateEnablement(false);
	}

	protected IAction run;
	protected IAction createRunAction() {
		run = new Action("Run", Action.AS_PUSH_BUTTON) {
			public void run() {
				doRun();
			}
		};
		run.setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/run.gif"));
		return run;
	}

	protected IAction resume;
	protected IAction createResumeAction() {
		resume = new Action("Resume", Action.AS_PUSH_BUTTON) {
			public void run() {
				doResume();
			}
		};
		resume.setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/resume.gif"));
		return resume;
	}
	protected IAction terminate;
	protected IAction createTerminateAction() {
		terminate = new Action("Terminate", Action.AS_PUSH_BUTTON) {
			public void run() {
				doTerminate();
			}
		};
		terminate.setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/terminate.gif"));
		return terminate;
	}

	public void updateEnablement(boolean isSuspended) {
		run.setEnabled(isSuspended);
		resume.setEnabled(isSuspended);
		terminate.setEnabled(isSuspended);

		if (!isSuspended) {
			setContents(null);
//			((VariablesView) getSite().getPage().findView(VariablesView.ID)).setContents(null);
		}
	}

	public void doBreak(IBindingManager debugEnv) {
		this.debugEnv = debugEnv;
		updateEnablement(true);
		try {
			barrier.await(); 
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		} catch (BrokenBarrierException e) {
			throw new OperationCanceledException(e);
		}
	}
	public void doRun() {
		if (debugEnv.wIsSet("breakpointsDisabled"))
			debugEnv.wSetValue("breakpointsDisabled", true);
		else
			debugEnv.wDefValue("breakpointsDisabled", true);

		debugEnv = null;
		doResume();
	}
	public void doResume() {
		updateEnablement(false);
		try {
			barrier.await(); 
		} catch (InterruptedException e) { 
		} catch (BrokenBarrierException e) {
		}
	}
	public void doTerminate() {
		updateEnablement(false);
		barrier.reset();
	}
	
//	public void doBreak(IBindingManager debugEnv) {
//		((DebugPage) getActivePage()).doBreak(debugEnv);
//	}
}
