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
package org.whole.lang.e4.ui.parts;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.IUIConstants;
import org.whole.lang.e4.ui.actions.ResumeAction;
import org.whole.lang.e4.ui.actions.RunAction;
import org.whole.lang.e4.ui.actions.TerminateAction;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.actions.IUpdatableAction;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editpolicies.SuspensionFeedbackEditPolicy;
import org.whole.lang.ui.util.SuspensionKind;
import org.whole.lang.ui.viewers.EntityEditDomain;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class E4DebugGraphicalPart extends E4GraphicalPart {
	protected CyclicBarrier barrier;
	protected IBindingManager debugEnv;
	protected SuspensionKind suspensionKind = SuspensionKind.NONE;

	public SuspensionKind getSuspensionKind() {
		return suspensionKind;
	}
	public void setSuspensionKind(SuspensionKind suspensionKind) {
		this.suspensionKind = suspensionKind;
		updateActions();
	}

	@Override
	protected IEntityPartViewer createEntityViewer(Composite parent) {
		IEntityPartViewer viewer = super.createEntityViewer(parent);
		viewer.setOperationExecutable(false);
		return viewer;
	}

	@Inject
	@Optional
	private void doBreak(@UIEventTopic(IUIConstants.TOPIC_BREAK_DEBUG) Object[] args) {
		// release any suspended thread
		if (this.barrier != null)
			doRun();

		setSuspensionKind((SuspensionKind) args[0]);

		final Throwable throwable = (Throwable) args[1];
		final IEntity breakpoint = (IEntity) args[2];
		IEntity contents = EntityUtils.getCompoundRoot(breakpoint);

		this.debugEnv = (IBindingManager) args[3];
		this.barrier = (CyclicBarrier) args[4];

		getViewer().setContents(contents);
		getViewer().setInteractive(contents, false, true, false);
		//FIXME workaround call reveal twice (async for Linux, the other for Mac)
		context.get(UISynchronize.class).asyncExec(new Runnable() {
			@Override
			public void run() {
				IEntityPart breakpointPart = getViewer().getEditPartRegistry().get(breakpoint);
				breakpointPart.installEditPolicy(SuspensionFeedbackEditPolicy.SUSPENSION_FEEDBACK_ROLE,
						new SuspensionFeedbackEditPolicy(suspensionKind, throwable));
				getViewer().reveal(breakpoint);
			}
		});
		getViewer().reveal(breakpoint);
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
		setSuspensionKind(SuspensionKind.NONE);
		resetContents();
		try {
			CyclicBarrier barrier = this.barrier;
			this.barrier = null;
			barrier.await();
		} catch (InterruptedException e) { 
		} catch (BrokenBarrierException e) {
		}
	}
	public void doTerminate() {
		setSuspensionKind(SuspensionKind.NONE);
		resetContents();
		CyclicBarrier barrier = this.barrier;
		this.barrier = null;
		barrier.reset();
	}

	protected void resetContents() {
		getViewer().setEditDomain(new EntityEditDomain());
		getViewer().setEntityContents(createDefaultContents());
	}

	protected Set<IUpdatableAction> actions = new HashSet<IUpdatableAction>();
	protected void updateActions() {
		for (IUpdatableAction action : actions)
			action.update();
	}

	protected RunAction runAction;
	public IAction getRunAction(IEclipseContext context) {
		if (runAction == null)
			actions.add(runAction = new RunAction(context, this));
		return runAction;
	}

	protected ResumeAction resumeAction;
	public IAction getResumeAction(IEclipseContext context) {
		if (resumeAction == null)
			actions.add(resumeAction = new ResumeAction(context, this));
		return resumeAction;
	}

	protected TerminateAction terminateAction;
	public IAction getTerminateAction(IEclipseContext context) {
		if (terminateAction == null)
			actions.add(terminateAction = new TerminateAction(context, this));
		return terminateAction;
	}
}
