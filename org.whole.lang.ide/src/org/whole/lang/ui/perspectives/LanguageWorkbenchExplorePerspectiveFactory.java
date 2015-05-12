/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.e4.ui.actions.IUIConstants;

/**
 * @author Riccardo Solmi
 */
public class LanguageWorkbenchExplorePerspectiveFactory extends LanguageWorkbenchPerspectiveFactory {
	public static String ID = LanguageWorkbenchExplorePerspectiveFactory.class.getName();

	protected void addTopRightViews(IFolderLayout folder) {
		folder.addView(IUIConstants.MAP_PART_ID);
	}
	protected void addBottomRightViews(IFolderLayout folder) {
		folder.addView(IUIConstants.INDEX_PART_ID);
		folder.addView(IUIConstants.DETAILS_PART_ID);
		folder.addPlaceholder(IUIConstants.RESULTS_PART_ID);
	}

	@Override
	protected void addShowViewShortcuts(IPageLayout layout) {
		super.addShowViewShortcuts(layout);
		layout.addShowViewShortcut(IUIConstants.MAP_PART_ID);
		layout.addShowViewShortcut(IUIConstants.INDEX_PART_ID);
		layout.addShowViewShortcut(IUIConstants.DETAILS_PART_ID);
	}
}
