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
import org.eclipse.ui.IPlaceholderFolderLayout;
import org.whole.lang.e4.ui.actions.IE4UIConstants;

/**
 * @author Riccardo Solmi
 */
public class LanguageWorkbenchSamplePerspectiveFactory extends LanguageWorkbenchPerspectiveFactory {
	public static String ID = LanguageWorkbenchSamplePerspectiveFactory.class.getName();

	public void createInitialLayout(IPageLayout layout)  {
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.15f, IPageLayout.ID_EDITOR_AREA);
		IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.50f, "topLeft");
		IFolderLayout topRight = layout.createFolder("topRight", IPageLayout.RIGHT, 0.66f, IPageLayout.ID_EDITOR_AREA);
		IFolderLayout midRight = layout.createFolder("midRight", IPageLayout.BOTTOM, 0.25f, "topRight");
		IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, 0.66f, "midRight");
		IPlaceholderFolderLayout bottom = layout.createPlaceholderFolder("bottom", IPageLayout.BOTTOM, 0.70f, IPageLayout.ID_EDITOR_AREA);

		addTopLeftViews(topLeft);
		addBottomLeftViews(bottomLeft);
		addTopRightViews(topRight);
		addMidRightViews(midRight);
		addBottomRightViews(bottomRight);
		addBottomViews(bottom);

		addActionSets(layout);
		addNewWizardShortcuts(layout);
		addPerspectiveShortcuts(layout);
		addShowViewShortcuts(layout);
	}

	protected void addTopRightViews(IFolderLayout folder) {
		folder.addView(IE4UIConstants.CONTEXT_PART_ID);
	}
	protected void addMidRightViews(IFolderLayout folder) {
		folder.addView(IE4UIConstants.SAMPLE_PART_ID);
		folder.addPlaceholder(IE4UIConstants.RESULTS_PART_ID);
	}
	protected void addBottomRightViews(IFolderLayout folder) {
		folder.addView(IE4UIConstants.VARIABLES_PART_ID);
	}

	@Override
	protected void addShowViewShortcuts(IPageLayout layout) {
		super.addShowViewShortcuts(layout);
		layout.addShowViewShortcut(IE4UIConstants.VARIABLES_PART_ID);
	}
}
