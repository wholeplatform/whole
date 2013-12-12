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
package org.whole.lang.e4.ui.actions;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.whole.lang.e4.ui.jobs.DeriveModelRunnable;
import org.whole.lang.e4.ui.jobs.RunnableJob;
import org.whole.lang.e4.ui.util.ChangeTracker;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.viewers.EntityEditDomain;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class DerivedLinkableSelectionListener extends AbstractLinkableSelectionListener {
	public static final String LABEL = "derive model";
	protected ChangeTracker changeTracker;

	@Inject @Named(FUNCTION_URI)
	protected String functionUri;
	
	@Inject @Named(SHARE_EDIT_DOMAIN)
	protected boolean shareEditDomain;

	@PostConstruct
	void init() {
		changeTracker = ChangeTracker.create();
	}

	@Override
	public void updateLinkType(LinkType linkType) {
		super.updateLinkType(linkType);

		if (linkType.isNotLinked()) {
			viewer.setEditDomain(new EntityEditDomain());
			viewer.setEntityContents(EntityUtils.clone(viewer.getEntityContents()));
			fireViewerUnlinked();
		} else if (lastSelection != null)
			updateViewerContents(true);
	}

	protected void updateViewerContents() {
		viewer.getControl().getDisplay().asyncExec(new Runnable() {
			public void run() {
				updateViewerContents(linkType.isLinkedToActivePart());
			}
		});
	}

	protected void updateViewerContents(boolean relink) {
		if (lastSelection == null)
			return;

		if (shareEditDomain && relink) {
			IEntityPartViewer toViewer = (IEntityPartViewer) lastSelection.wGetValue("viewer");
			viewer.linkEditDomain(toViewer);
			fireViewerLinked(toViewer);
		}
		
		if (!changeTracker.testChangedAndUpdate(lastSelection, lastSelection.wGet("self")))
			return;

		IRunnableWithProgress runnable = new DeriveModelRunnable(context, lastSelection, LABEL, functionUri) {
			@Override
			protected void updateUI(IEntity result) {
				super.updateUI(result);
				fireContentsDerived(result);
			}
		};
		final RunnableJob job = new RunnableJob("Executing "+LABEL+" operation...", runnable);
		job.setUser(false);
		job.setPriority(Job.INTERACTIVE);
		job.schedule();
	}
}
