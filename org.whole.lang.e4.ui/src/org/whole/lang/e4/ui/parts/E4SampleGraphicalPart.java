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

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.e4.ui.actions.ILinkableSelectionListener;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.actions.LinkViewerAdapter;
import org.whole.lang.e4.ui.jobs.ExecuteSampleModelRunnable;
import org.whole.lang.e4.ui.jobs.ISynchronizableRunnable;
import org.whole.lang.e4.ui.jobs.ShowingPolicy;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
@Singleton
public class E4SampleGraphicalPart extends AbstractE4DerivedGraphicalPart {
	@Inject IEventBroker eventBroker;

	protected IEntity contextModel;
	protected IEntity selfModel;
	protected IBindingManager selfBindings;

	@PostConstruct
	void init() {
		contextModel = BindingManagerFactory.instance.createVoid();
		selfModel = BindingManagerFactory.instance.createVoid();
	}

	@Inject
	@Optional
	private void getNotified(@UIEventTopic(IE4UIConstants.TOPIC_UPDATE_SAMPLE_CONTEXT) IEntity sampleContext) {
		if (sampleContext != null) {
			contextModel = sampleContext.wGet(0);
			selfModel = sampleContext.wGet(1);
			selfBindings = (IBindingManager) sampleContext.wGet(2).wGetValue();
			execute();
		}
	}

	@Override
	protected IEclipseContext configureSelectionLinkable(IEclipseContext params) {
		params = super.configureSelectionLinkable(params);
		params.set(ILinkableSelectionListener.RESULTS_SHOWING_POLICY, ShowingPolicy.IGNORABLE);
		return params;
	}

	protected String getDerivationFunction() {
		return "whole:org.whole.lang:ViewDerivationLibrary#deriveSampleViewContents";
	}

	protected IBindingManager bm;
	protected IEntity behaviorModel;
	protected String behaviorLabel;

	@Override
	protected ILinkableSelectionListener createSelectionLinkable(IEntityPartViewer viewer) {
		ILinkableSelectionListener listener = super.createSelectionLinkable(viewer);
		listener.addLinkViewerListener(new LinkViewerAdapter() {
			@Override
			public void contentsDerived(IEntityPartViewer viewer, IBindingManager selection, IEntity result) {
				boolean canExecute = EntityUtils.safeBooleanValue(result, false);
				if (canExecute) {
					IEntity primarySelectedEntity = selection.wGet("primarySelectedEntity");
					IEntity model = EntityUtils.getCompoundRoot(primarySelectedEntity);
					bm = selection.clone();
					bm.wDefValue("debug#reportModeEnabled", false);
					BehaviorUtils.evaluate(contextModel, 0, bm);

					ITransactionScope transactionScope = BindingManagerFactory.instance.createTransactionScope();
					bm.wEnterScope(transactionScope);
					try {
						behaviorModel = EntityUtils.mapEntity(primarySelectedEntity, EntityUtils.clone(model));
						behaviorLabel = BehaviorUtils.apply(
								"whole:org.whole.lang.ui.views:SamplePerspectiveSemantics#SampleViewBehaviorLabel",
								behaviorModel, bm).wStringValue();
					} finally {
						transactionScope.rollback();
						bm.wExitScope();
					}
					execute();

				} else {
					bm = null;
					behaviorModel = null;
					behaviorLabel = null;
					getViewer().setContents(null, createDefaultContents());
				}
			}
		});
		return listener;
	}

	protected void execute() {
		if (behaviorModel == null || selfBindings == null)
			return;
		else {
			ISynchronizableRunnable runnable = new ExecuteSampleModelRunnable(context, behaviorLabel, contextModel, selfBindings, selfModel, bm, behaviorModel);
			runnable.asyncExec("Executing "+behaviorLabel+" operation...");
		}
	}
}
