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
package org.whole.lang.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;
import org.whole.lang.e4.ui.actions.IE4UIConstants;

/**
 * @author Riccardo Solmi
 */
public class LanguageWorkbenchDebugPerspectiveFactory implements IPerspectiveFactory {
	public static String ID = LanguageWorkbenchDebugPerspectiveFactory.class.getName();

	public void createInitialLayout(IPageLayout layout)  {
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.TOP, 0.45f, IPageLayout.ID_EDITOR_AREA);
		IFolderLayout topRight = layout.createFolder("topRight", IPageLayout.RIGHT, 0.5f, "topLeft");

		addTopLeftViews(topLeft);
		addTopRightViews(topRight);

		addActionSets(layout);
		addNewWizardShortcuts(layout);
		addPerspectiveShortcuts(layout);
		addShowViewShortcuts(layout);
	}

	protected void addTopLeftViews(IFolderLayout folder) {
		folder.addView(IE4UIConstants.DEBUG_PART_ID);
		folder.addPlaceholder(IE4UIConstants.SAMPLE_PART_ID);
		folder.addView(IPageLayout.ID_RES_NAV);
//		topLeft.addView(IPageLayout.ID_OUTLINE);
	}
	protected void addTopRightViews(IFolderLayout folder) {
		folder.addView(IE4UIConstants.VARIABLES_PART_ID);
		folder.addPlaceholder(IE4UIConstants.CONTEXT_PART_ID);
		folder.addPlaceholder(IE4UIConstants.RESULTS_PART_ID);
		folder.addView(IConsoleConstants.ID_CONSOLE_VIEW);
	}

	protected void addActionSets(IPageLayout layout) {
	}

	protected void addNewWizardShortcuts(IPageLayout layout) {
	}

	protected void addPerspectiveShortcuts(IPageLayout layout) {
		layout.addPerspectiveShortcut(LanguageWorkbenchExplorePerspectiveFactory.ID);
		layout.addPerspectiveShortcut(LanguageWorkbenchSamplePerspectiveFactory.ID);
		layout.addPerspectiveShortcut("org.eclipse.ui.resourcePerspective"); //$NON-NLS-1$
	}

	protected void addShowViewShortcuts(IPageLayout layout) {
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);
		layout.addShowViewShortcut(IE4UIConstants.DEBUG_PART_ID);
		layout.addShowViewShortcut(IE4UIConstants.VARIABLES_PART_ID);
		layout.addShowViewShortcut(IE4UIConstants.CONTEXT_PART_ID);
		layout.addShowViewShortcut(IE4UIConstants.INDEX_PART_ID);
		layout.addShowViewShortcut(IE4UIConstants.PALETTE_PART_ID);
		layout.addShowViewShortcut(IE4UIConstants.MAP_PART_ID);
		layout.addShowViewShortcut(IE4UIConstants.DETAILS_PART_ID);
		layout.addShowViewShortcut(IE4UIConstants.SAMPLE_PART_ID);
	}
}
