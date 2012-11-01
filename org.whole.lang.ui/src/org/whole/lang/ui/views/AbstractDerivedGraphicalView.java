/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.views;

import static org.whole.lang.ui.views.WholeGraphicalPage.PAGE_ACTIONS;

import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.ui.editors.WholeGraphicalEditor;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public abstract class AbstractDerivedGraphicalView extends WholeGraphicalView implements ISchedulingRule {	
	@Override
	protected WholeGraphicalViewer createGraphicalViewer(final IWorkbenchPart part) {
		final WholeGraphicalViewer viewer = (WholeGraphicalViewer) part.getAdapter(GraphicalViewer.class);
		final AbstractDerivedGraphicalViewer detailsGraphicalViewer = createGraphicalViewer(
				getPageBook(), viewer.getEditDomain());
		//necessary if view is already opened when Eclipse starts
		Display.getCurrent().asyncExec(new Runnable() {
			public void run() {
				detailsGraphicalViewer.selectionChanged(part, viewer.getSelection());
			}
		});
		return detailsGraphicalViewer;
	}

	abstract protected AbstractDerivedGraphicalViewer createGraphicalViewer(Composite parent, WholeEditDomain editDomain);

	protected void createContributions(IActionBars actionBars) {
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		toolBarManager.add(new Separator(PAGE_ACTIONS));
		toolBarManager.add(new Separator(VIEW_ACTIONS));
		toolBarManager.appendToGroup(VIEW_ACTIONS, createLinkToEditorAction(true));
	}

	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
		if (!(part instanceof WholeGraphicalEditor))
			return null;
		return super.doCreatePage(part);
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		LinkType linkType = getLinkType();
		if (linkType.isNotLinked() ||
				(linkType.isLinkedToFixedEditor() && getLinkedEditor() != part))
			return false;

		return super.isImportant(part);
	}

	@Override
	protected IWorkbenchPart getCurrentContributingPart() {
		LinkType linkType = getLinkType();
		if (linkType.isNotLinked() || linkType.isLinkedToFixedEditor())
			return null;

		return super.getCurrentContributingPart();
	}

	public boolean contains(ISchedulingRule rule) {
		return rule == this;
	}
	public boolean isConflicting(ISchedulingRule rule) {
		return rule == this;
	}
}
