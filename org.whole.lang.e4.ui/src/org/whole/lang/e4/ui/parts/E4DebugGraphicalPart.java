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
package org.whole.lang.e4.ui.parts;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.BreakpointsDisableAction;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.actions.ResumeAction;
import org.whole.lang.e4.ui.actions.TerminateAction;
import org.whole.lang.e4.ui.jobs.ExecutionState;
import org.whole.lang.e4.ui.jobs.IExecutionListener;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.actions.IUpdatableAction;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editpolicies.SuspensionFeedbackEditPolicy;
import org.whole.lang.ui.util.SuspensionKind;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class E4DebugGraphicalPart extends E4GraphicalPart {
	protected IExecutionListener executionListener = new IExecutionListener() {
		public void executionPushed(ExecutionState execution) {
			updateUI();
		}
		public void executionPopped(ExecutionState execution) {
			updateUI();
		}
	};

	@PostConstruct
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		debugService.addExecutionListener(executionListener);
	}
	
	@PreDestroy
	public void dispose() {
		debugService.removeExecutionListener(executionListener);
		super.dispose();
	}

	public SuspensionKind getSuspensionKind() {
		return debugService.peekSuspensionKind();
	}

	protected void updateUI() {
		updateActions();

		IEventBroker eventBroker = context.get(IEventBroker.class);

		if (debugService.isSuspended()) {
			final IEntity sourceEntity = debugService.peekSourceEntity();
			IEntity contents = EntityUtils.getCompoundRoot(sourceEntity);

			getViewer().setContents(contents);
			getViewer().setInteractive(contents, false, true, false);
			context.get(UISynchronize.class).asyncExec(new Runnable() {
				@Override
				public void run() {
					IEntity adaptee = sourceEntity.wGetAdaptee(false);
					IEntityPart sourceEntityPart = getViewer().getEditPartRegistry().get(adaptee);
					sourceEntityPart.installEditPolicy(SuspensionFeedbackEditPolicy.SUSPENSION_FEEDBACK_ROLE,
							new SuspensionFeedbackEditPolicy(getSuspensionKind(), debugService.peekThrowable()));
					getViewer().reveal(sourceEntity);
				}
			});

			eventBroker.post(IE4UIConstants.TOPIC_UPDATE_VARIABLES, debugService.peekVariablesModel());
		} else {
			getViewer().setEntityContents(createDefaultContents());
			eventBroker.post(IE4UIConstants.TOPIC_UPDATE_VARIABLES, null);
		}
	}

	protected void pushExecution(ExecutionState execution) {
		debugService.pushExecution(execution);
	}
	protected ExecutionState popExecution() {
		return debugService.popExecution();
	}

	@Override
	protected IEntityPartViewer createEntityViewer(Composite parent) {
		IEntityPartViewer viewer = super.createEntityViewer(parent);
		viewer.setOperationExecutable(false);
		return viewer;
	}

	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		if (bm == null || bm.wGetValue("viewer") != getViewer())
			return;

		//TODO
	}

	@Inject
	@Optional
	private void getNotified(@UIEventTopic(IE4UIConstants.TOPIC_UPDATE_DEBUG) ExecutionState execution) {
		pushExecution(execution);
	}

	protected Set<IUpdatableAction> actions = new HashSet<IUpdatableAction>();
	protected void updateActions() {
		for (IUpdatableAction action : actions)
			action.update();
	}

	protected BreakpointsDisableAction breakpointsDisableAction;
	public IAction getBreakpoiontsDisableAction(IEclipseContext context) {
		if (breakpointsDisableAction == null)
			actions.add(breakpointsDisableAction = new BreakpointsDisableAction(context));
		return breakpointsDisableAction;
	}

	protected ResumeAction resumeAction;
	public IAction getResumeAction(IEclipseContext context) {
		if (resumeAction == null)
			actions.add(resumeAction = new ResumeAction(context));
		return resumeAction;
	}

	protected TerminateAction terminateAction;
	public IAction getTerminateAction(IEclipseContext context) {
		if (terminateAction == null)
			actions.add(terminateAction = new TerminateAction(context));
		return terminateAction;
	}
}
