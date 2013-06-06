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
package org.whole.lang.e4.ui.compatibility;

import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.modeling.ISelectionListener;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.ILinkable;
import org.whole.lang.e4.ui.actions.LinkToEditorAction;
import org.whole.lang.e4.ui.actions.LinkType;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class E3DetailsViewPart extends E3ViewPart implements ILinkable {
	protected LinkType linkType;
	protected IEntityPartViewer linkedViewer;
	protected IEntityPartViewer lastSelectedViewer;
	protected IEntity lastPrimarySelectedEntity;

	public E3DetailsViewPart() {
		this.linkType = LinkType.ACTIVE_PART;
		this.linkedViewer = null;
		this.lastSelectedViewer = null;
		this.lastPrimarySelectedEntity = null;
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		ESelectionService selectionService = getContext().get(ESelectionService.class);
		selectionService.addSelectionListener(new ISelectionListener() {
			@Override
			public void selectionChanged(MPart part, final Object selection) {
				if (isRelevant(selection)) {
					getContext().get(UISynchronize.class).asyncExec(new Runnable() {
						public void run() {
							updateViewerContents(getComponent().getViewer(), linkType.isLinkedToActivePart());
						}
					});
				}
			}
		});
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		IActionBars actionBars = site.getActionBars();
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		toolBarManager.add(new LinkToEditorAction(this));
	}
	
	protected boolean isRelevant(Object selection) {
		if (!(selection instanceof IBindingManager))
			return false;
		
		IBindingManager bm = (IBindingManager) selection;
		IEntityPartViewer selectedViewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntityPartViewer viewer = getComponent().getViewer();
		if (viewer == selectedViewer)
			return false;
		else {
			lastSelectedViewer = selectedViewer;
			lastPrimarySelectedEntity = bm.wGet("primarySelectedEntity");
		}
		
		if (!linkType.isUpdateOnSelectionChange())
			return false;
		
		return linkType.isLinkedToActivePart() ||
				(linkType.isLinkedToFixedPart() && lastSelectedViewer == linkedViewer);
	}

	@Override
	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
		this.linkedViewer = linkType.isLinkedToFixedPart() ? this.lastSelectedViewer : null;

		IEntityPartViewer viewer = getComponent().getViewer();
		if (linkType.isNotLinked())
			unlinkViewer(viewer);
		else if (lastSelectedViewer != null)
			updateViewerContents(viewer, true);
	}

	protected void updateViewerContents(IEntityPartViewer viewer, boolean relink) {
		if (relink)
			linkViewers(lastSelectedViewer, viewer);

		if (lastPrimarySelectedEntity != null)
			viewer.setContents(lastPrimarySelectedEntity);
	}
	protected void linkViewers(IEntityPartViewer fromViewer, IEntityPartViewer toViewer) {
		CommandStack commandStack = toViewer.linkEditDomain(fromViewer).getCommandStack();
		undoAction.track(commandStack);
		redoAction.track(commandStack);
	}
	protected void unlinkViewer(IEntityPartViewer viewer) {
		viewer.setEntityContents(EntityUtils.clone(viewer.getEntityContents()));
		CommandStack commandStack = viewer.getCommandStack();
		undoAction.track(commandStack);
		redoAction.track(commandStack);
	}
}
