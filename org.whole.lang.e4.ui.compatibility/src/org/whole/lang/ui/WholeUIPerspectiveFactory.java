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
package org.whole.lang.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IPlaceholderFolderLayout;
import org.whole.lang.e4.ui.actions.IE4UIConstants;

/**
 * @author Riccardo Solmi
 */
public class WholeUIPerspectiveFactory implements IPerspectiveFactory {
	public static String ID = WholeUIPerspectiveFactory.class.getName();

	public void createInitialLayout(IPageLayout layout)  {
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.15f, IPageLayout.ID_EDITOR_AREA);
		IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.50f, "topLeft");
		IFolderLayout topRight = layout.createFolder("topRight", IPageLayout.RIGHT, 0.66f, IPageLayout.ID_EDITOR_AREA);
		IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, 0.60f, "topRight");
		IPlaceholderFolderLayout bottom = layout.createPlaceholderFolder("bottom", IPageLayout.BOTTOM, 0.70f, IPageLayout.ID_EDITOR_AREA);

		addTopLeftViews(topLeft);
		addBottomLeftViews(bottomLeft);
		addTopRightViews(topRight);
		addBottomRightViews(bottomRight);
		addBottomViews(bottom);

		addActionSets(layout);
		addNewWizardShortcuts(layout);
		addPerspectiveShortcuts(layout);
		addShowViewShortcuts(layout);
	}

	protected void addTopLeftViews(IFolderLayout folder) {
		folder.addView(IPageLayout.ID_RES_NAV);
	}
	protected void addBottomLeftViews(IFolderLayout folder) {
		folder.addView(IE4UIConstants.OUTLINE_PART_ID);
		folder.addView(IPageLayout.ID_PROGRESS_VIEW);
	}
	protected void addTopRightViews(IFolderLayout folder) {
	}
	protected void addBottomRightViews(IFolderLayout folder) {
	}
	protected void addBottomViews(IPlaceholderFolderLayout folder) {
		folder.addPlaceholder(IPageLayout.ID_PROP_SHEET);
		folder.addPlaceholder(IPageLayout.ID_PROBLEM_VIEW);
		folder.addPlaceholder(IPageLayout.ID_TASK_LIST);
	}

	protected void addActionSets(IPageLayout layout) {
	}

	protected void addNewWizardShortcuts(IPageLayout layout) {
		layout.addNewWizardShortcut("org.whole.lang.ui.wizards.WholeProjectWizard");
		layout.addNewWizardShortcut("org.whole.lang.ui.wizards.WholePluginProjectWizard");
		layout.addNewWizardShortcut("org.whole.lang.ui.wizards.WholeModelCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");//$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");//$NON-NLS-1$
	}

	protected void addPerspectiveShortcuts(IPageLayout layout) {
		layout.addPerspectiveShortcut("org.eclipse.ui.resourcePerspective"); //$NON-NLS-1$
	}

	protected void addShowViewShortcuts(IPageLayout layout) {
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
	}
}
