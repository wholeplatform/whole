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
package org.whole.lang.e4.ui.actions;

import org.eclipse.e4.ui.workbench.modeling.ISelectionListener;

/**
 * @author Enrico Persiani
 */
public interface ILinkableSelectionListener extends ILinkable, ISelectionListener {
	public static final String LINK_TYPE = "org.whole.lang.e4.ui.actions.linkType";
	public static final String FUNCTION_URI = "org.whole.lang.e4.ui.actions.functionUri";
	public static final String FUNCTION_IS_TRANSACTIONAL = "org.whole.lang.e4.ui.actions.functionIsTransactional";
	public static final String RESULTS_SHOWING_POLICY = "org.whole.lang.e4.ui.actions.resultsShowingPolicy";
	public static final String SHARE_EDIT_DOMAIN = "org.whole.lang.e4.ui.actions.shareEditDoman";
	public static final String SYNCHRONIZE_SELECTION = "org.whole.lang.e4.ui.actions.synchronizeSelection";
	public static final String IGNORABLE_PART_IDS = "org.whole.lang.e4.ui.actions.ignorablePartIds";

	public void addLinkViewerListener(ILinkViewerListener listener);
	public void removeLinkViewerListener(ILinkViewerListener listener); 
}
