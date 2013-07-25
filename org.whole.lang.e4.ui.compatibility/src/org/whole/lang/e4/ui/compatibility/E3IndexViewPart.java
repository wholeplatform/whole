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

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.whole.lang.e4.ui.actions.DerivedSelectionLinkable;
import org.whole.lang.e4.ui.actions.LinkToEditorAction;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class E3IndexViewPart extends E3ViewPart {
	protected DerivedSelectionLinkable selectionLinkable;
	protected LinkToEditorAction linkToEditorAction;

	public E3IndexViewPart() {
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		
		IEntityPartViewer viewer = getComponent().getViewer();
		selectionLinkable = new DerivedSelectionLinkable(viewer, "whole:org.whole.lang:ViewDerivationLibrary#deriveIndexViewContents") {
			@Override
			protected void linkViewer(IEntityPartViewer fromViewer) {
				super.linkViewer(fromViewer);
				CommandStack commandStack = viewer.getCommandStack();
				undoAction.track(commandStack);
				redoAction.track(commandStack);
			}
			@Override
			protected void unlinkViewer() {
				super.unlinkViewer();
				CommandStack commandStack = viewer.getCommandStack();
				undoAction.track(commandStack);
				redoAction.track(commandStack);
			}

			@Override
			protected void setDerivedContents(IEntity result) {
				super.setDerivedContents(result);
				viewer.setInteractive(result, false, true, false);
			}
		};

		ESelectionService selectionService = getContext().get(ESelectionService.class);
		selectionService.addSelectionListener(selectionLinkable);
		linkToEditorAction.setLinkable(selectionLinkable);
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		IActionBars actionBars = site.getActionBars();
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		toolBarManager.add(linkToEditorAction = new LinkToEditorAction());
	}

	@Override
	public void dispose() {
		ESelectionService selectionService = getContext().get(ESelectionService.class);
		selectionService.removeSelectionListener(selectionLinkable);
		super.dispose();
	}
}
