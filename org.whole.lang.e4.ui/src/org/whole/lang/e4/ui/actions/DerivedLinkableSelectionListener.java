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
package org.whole.lang.e4.ui.actions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.whole.lang.e4.ui.jobs.DeriveModelRunnable;
import org.whole.lang.e4.ui.jobs.ISynchronizableRunnable;
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

		if (functionUri != null) {
			ISynchronizableRunnable runnable = new DeriveModelRunnable(context, lastSelection, LABEL, functionUri, functionIsTransactional, resultShowingPolicy) {
				@Override
				protected void updateUI(IEntity result) {
					super.updateUI(result);
					if (result != null)
						fireContentsDerived(result);
				}
			};
			runnable.asyncExec("Executing "+LABEL+" operation...");
		} else {
			IEntity newContents = lastSelection.wGet("self");
			if (viewer.getEntityContents() != newContents)
				viewer.setContents(newContents);
		}

		if (isSynchronizeSelection() && lastSelection.wIsSet("primarySelectedEntity")) {
			IEntity selectedEntities = lastSelection.wGet("selectedEntities");
			List<IEntity> selection = new ArrayList<>();
			for (int i=0, size=selectedEntities.wSize(); i<size; i++)
				selection.add(selectedEntities.wGet(i));
			viewer.selectAndReveal(selection);
		}
	}
}
