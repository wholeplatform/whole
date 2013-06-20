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

import org.whole.lang.e4.ui.viewers.E4EditDomain;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class DerivedSelectionLinkable extends AbstractSelectionLinkable {
	protected String functionUri;

	public DerivedSelectionLinkable(IEntityPartViewer viewer, String functionUri) {
		super(viewer);
		this.functionUri = functionUri;
	}

	protected void updateViewerContents() {
		viewer.getControl().getDisplay().asyncExec(new Runnable() {
			public void run() {
				updateViewerContents(linkType.isLinkedToActivePart());
			}
		});
	}

	@Override
	public void updateLinkType(LinkType linkType) {
		super.updateLinkType(linkType);

		if (linkType.isNotLinked())
			unlinkViewer();
		else if (lastSelection != null)
			updateViewerContents(true);
	}

	protected void updateViewerContents(boolean relink) {
		if (lastSelection == null)
			return;

		if (relink)
			linkViewer((IEntityPartViewer) lastSelection.wGetValue("viewer"));

		IEntity result = BehaviorUtils.apply(functionUri, lastSelection.wGet("self"), lastSelection);
		if (result != null)
			setDerivedContents(result);
	}

	protected void setDerivedContents(IEntity result) {
		viewer.setContents(result);
	}

	protected void linkViewer(IEntityPartViewer fromViewer) {
		viewer.linkEditDomain(fromViewer);
	}
	protected void unlinkViewer() {
		viewer.setEditDomain(new E4EditDomain());
		viewer.setEntityContents(EntityUtils.clone(viewer.getEntityContents()));
	}
}
