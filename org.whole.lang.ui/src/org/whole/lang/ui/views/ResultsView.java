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
package org.whole.lang.ui.views;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.Page;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ResultsView extends WholeGraphicalView {
	public static String ID = ResultsView.class.getName();
	@Override
	public String getViewId() {
		return ID;
	}

	@Override
	protected Page createGraphicalPage(WholeGraphicalViewer viewer) {
		return new ResultsPage(viewer, this);
	}

	protected void createContributions(IActionBars actionBars) {
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		toolBarManager.add(createMultiViewAction(true));
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		return part == this;
	}
}
