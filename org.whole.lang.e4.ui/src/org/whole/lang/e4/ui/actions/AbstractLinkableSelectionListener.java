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

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractLinkableSelectionListener implements ILinkableSelectionListener {
	@Inject
	protected IEclipseContext context;
	@Inject
	protected IEntityPartViewer viewer;
	@Inject @Named(LINK_TYPE)
	protected LinkType linkType;

	protected IEntityPartViewer linkedViewer;
	protected IBindingManager lastSelection;
	protected ListenerList linkViewerListenerList = new ListenerList();

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

		lastSelection = actualSelection.clone();

		if (!linkType.isUpdateOnSelectionChange())
			return false;

		return linkType.isLinkedToActivePart() ||
				(linkType.isLinkedToFixedPart() && selectedViewer == linkedViewer);
	}

	public void addLinkViewerListener(ILinkViewerListener listener) { 
		linkViewerListenerList.add(listener); 
	} 
	public void removeLinkViewerListener(ILinkViewerListener listener) { 
		linkViewerListenerList.remove(listener); 
	} 
	protected void fireViewerLinked(IEntityPartViewer toViewer) { 
		Object[] listeners = linkViewerListenerList.getListeners(); 
		for (int i = 0; i < listeners.length; i++)
			((ILinkViewerListener) listeners[i]).viewerLinked(viewer, toViewer); 
	}
	protected void fireViewerUnlinked() { 
		Object[] listeners = linkViewerListenerList.getListeners(); 
		for (int i = 0; i < listeners.length; i++)
			((ILinkViewerListener) listeners[i]).viewerUnlinked(viewer); 
	}
	protected void fireContentsDerived(IEntity result) { 
		Object[] listeners = linkViewerListenerList.getListeners(); 
		for (int i = 0; i < listeners.length; i++)
			((ILinkViewerListener) listeners[i]).contentsDerived(viewer, lastSelection, result); 
	}
}
