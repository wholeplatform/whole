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
package org.whole.lang.ui.search;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * @author Enrico Persiani
 */
public class SearchResultLabelProvider extends WorkbenchLabelProvider {
	private StructuredViewer viewer;

	public SearchResultLabelProvider(StructuredViewer viewer) {
		super();
		this.viewer = viewer;
	}

	@Override
	protected String decorateText(String input, Object element) {
		if(!(element instanceof WholeMatch) ||
				viewer.getInput() == null ||
				!(viewer.getInput() instanceof WholeSearchResult))
			return input;

		return input + ((WholeMatch) element).getDecoration();
	}
}
