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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.whole.lang.ui.WholeUIPlugin;


/**
 * @author Riccardo Solmi
 */
public class IndexPage extends WholeGraphicalPage {
	public IndexPage(WholeGraphicalViewer viewer, WholeGraphicalView view) {
		super(viewer, view);
	}

	@Override
	protected void createContributions(IActionBars actionBars) {
		super.createContributions(actionBars);

		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		toolBarManager.appendToGroup(PAGE_ACTIONS, createShowOccurrencesAction());
		toolBarManager.appendToGroup(PAGE_ACTIONS, createSaveAsAction("", "_index"));
	}

	protected Action createShowOccurrencesAction() {
		Action action = new Action("Show Occurrences", Action.AS_CHECK_BOX) {
			public void run() {
				//TODO
			}
		};
		action.setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/mark_occurrences.gif"));
		return action;
	}
}
