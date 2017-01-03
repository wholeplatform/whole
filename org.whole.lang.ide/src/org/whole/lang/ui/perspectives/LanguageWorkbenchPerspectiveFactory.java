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

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPlaceholderFolderLayout;
import org.eclipse.ui.console.IConsoleConstants;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.ui.WholeUIPerspectiveFactory;

/**
 * @author Riccardo Solmi
 */
public class LanguageWorkbenchPerspectiveFactory extends WholeUIPerspectiveFactory {
	public static String ID = LanguageWorkbenchPerspectiveFactory.class.getName();

	@Override
	protected void addTopLeftViews(IFolderLayout folder) {
		folder.addView(JavaUI.ID_PACKAGES);
		super.addTopLeftViews(folder);
	}

	protected void addBottomRightViews(IFolderLayout folder) {
		folder.addPlaceholder(IE4UIConstants.RESULTS_PART_ID);
	}

	@Override
	protected void addBottomViews(IPlaceholderFolderLayout folder) {
		super.addBottomViews(folder);
		folder.addPlaceholder(IConsoleConstants.ID_CONSOLE_VIEW);
	}

	@Override
	protected void addActionSets(IPageLayout layout) {
		super.addActionSets(layout);
		layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
		layout.addActionSet(JavaUI.ID_ACTION_SET);
		layout.addActionSet(JavaUI.ID_ELEMENT_CREATION_ACTION_SET);
		layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
		layout.addActionSet("org.whole.lang.ui.wholeElementCreationActions");
	}

	@Override
	protected void addNewWizardShortcuts(IPageLayout layout) {
		super.addNewWizardShortcuts(layout);
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.JavaProjectWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewPackageCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewClassCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewInterfaceCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSourceFolderCreationWizard"); //$NON-NLS-1$
	}

	@Override
	protected void addPerspectiveShortcuts(IPageLayout layout) {
		super.addPerspectiveShortcuts(layout);
		layout.addPerspectiveShortcut(JavaUI.ID_PERSPECTIVE);
		layout.addPerspectiveShortcut(LanguageWorkbenchDebugPerspectiveFactory.ID);
		layout.addPerspectiveShortcut(LanguageWorkbenchSamplePerspectiveFactory.ID);
		layout.addPerspectiveShortcut(LanguageWorkbenchExplorePerspectiveFactory.ID);
		layout.addPerspectiveShortcut(IDebugUIConstants.ID_DEBUG_PERSPECTIVE);
	}

	@Override
	protected void addShowViewShortcuts(IPageLayout layout) {
		super.addShowViewShortcuts(layout);
		layout.addShowViewShortcut(JavaUI.ID_PACKAGES);
		layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);
		layout.addShowViewShortcut(IE4UIConstants.SAMPLE_PART_ID);
		layout.addShowViewShortcut(IE4UIConstants.CONTEXT_PART_ID);
	}
}
