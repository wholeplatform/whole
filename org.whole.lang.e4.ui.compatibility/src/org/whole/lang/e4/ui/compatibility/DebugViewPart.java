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
package org.whole.lang.e4.ui.compatibility;

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.whole.lang.e4.ui.parts.E4DebugGraphicalPart;

/**
 * @author Enrico Persiani
 */
public class DebugViewPart extends ViewPart<E4DebugGraphicalPart> {
	public DebugViewPart() {
		super(DEBUG_PART_ID, E4DebugGraphicalPart.class);
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		
		IViewSite viewSite = getViewSite();
		IActionBars actionBars = viewSite.getActionBars();
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		toolBarManager.add(getComponent().getBreakpoiontsDisableAction(getContext()));
		toolBarManager.add(getComponent().getResumeAction(getContext()));
		toolBarManager.add(getComponent().getTerminateAction(getContext()));
	}
}
