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
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractLinkableSelectionListener implements ILinkableSelectionListener {
	protected IEntityPartViewer viewer;
	protected LinkType linkType;
	protected IEntityPartViewer linkedViewer;
	protected IBindingManager lastSelection;

	public AbstractLinkableSelectionListener(IEntityPartViewer viewer) {
		this(viewer, LinkType.ACTIVE_PART);
	}
	public AbstractLinkableSelectionListener(IEntityPartViewer viewer, LinkType defaultLinkType) {
		this.viewer = viewer;
		this.linkType = defaultLinkType;
		this.linkedViewer = null;
		this.lastSelection = null;
	}

	@Override
	public void selectionChanged(MPart part, Object selection) {
		if (isRelevant(selection))
			updateViewerContents();
	}

	protected abstract void updateViewerContents();

	@Override
	public void updateLinkType(LinkType linkType) {
		this.linkType = linkType;
		this.linkedViewer = linkType.isLinkedToFixedPart() ? (IEntityPartViewer) this.lastSelection.wGetValue("viewer") : null;
	}

	protected boolean isRelevant(Object selection) {
		if (!(selection instanceof IBindingManager))
			return false;

		IBindingManager actualSelection = (IBindingManager) selection;
		IEntityPartViewer selectedViewer = (IEntityPartViewer) actualSelection.wGetValue("viewer");
		if (viewer == selectedViewer)
			return false;

		lastSelection = actualSelection.wClone();

		if (!linkType.isUpdateOnSelectionChange())
			return false;

		return linkType.isLinkedToActivePart() ||
				(linkType.isLinkedToFixedPart() && selectedViewer == linkedViewer);
	}
}
