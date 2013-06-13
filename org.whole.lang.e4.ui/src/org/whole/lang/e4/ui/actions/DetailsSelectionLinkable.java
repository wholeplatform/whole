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

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.whole.lang.e4.ui.viewers.E4EditDomain;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class DetailsSelectionLinkable extends AbstractSelectionLinkable {

	public DetailsSelectionLinkable(IEntityPartViewer viewer) {
		super(viewer);
	}

	@Override
	public void selectionChanged(MPart part, Object selection) {
		if (isRelevant(selection))
			updateViewerContents();
	}

	protected void updateViewerContents() {
		viewer.getControl().getDisplay().asyncExec(new Runnable() {
			public void run() {
				updateViewerContents(viewer, linkType.isLinkedToActivePart());
			}
		});
	}

	@Override
	public void updateLinkType(LinkType linkType) {
		super.updateLinkType(linkType);

		if (linkType.isNotLinked())
			unlinkViewer();
		else if (lastSelection != null)
			updateViewerContents(viewer, true);
	}

	protected void updateViewerContents(IEntityPartViewer viewer, boolean relink) {
		if (relink)
			linkViewer((IEntityPartViewer) lastSelection.wGetValue("viewer"));

		if (lastSelection != null && lastSelection.wIsSet("primarySelectedEntity"))
			viewer.setContents(lastSelection.wGet("primarySelectedEntity"));
	}
	protected void linkViewer(IEntityPartViewer fromViewer) {
		viewer.linkEditDomain(fromViewer);
	}
	protected void unlinkViewer() {
		viewer.setEditDomain(new E4EditDomain());
		viewer.setEntityContents(EntityUtils.clone(viewer.getEntityContents()));
	}
}
