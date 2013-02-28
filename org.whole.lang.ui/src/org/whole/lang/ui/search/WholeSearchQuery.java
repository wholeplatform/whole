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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.search.ui.ISearchQuery;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.WholeUIPlugin;

/**
 * @author Enrico Persiani
 */
public class WholeSearchQuery implements ISearchQuery {
	WholeQuerySpecification specification;
	WholeSearchResult searchResult;
	
	public WholeSearchQuery(WholeQuerySpecification querySpec) {
		specification = querySpec;
	}

	public boolean canRerun() {
		return true;
	}

	public boolean canRunInBackground() {
		return true;
	}

	public String getLabel() {
		// TODO do a better work here
		return ReflectionFactory.getLanguageKit(specification.getPattern()).getName() +
			" pattern search in " + specification.getScopeDescription();
	}

	public WholeSearchResult getSearchResult() {
		if (searchResult == null) {
			searchResult= new WholeSearchResult(this);
			new WholeSearchResultUpdater(searchResult);
		}
		return searchResult;
	}

	public IStatus run(IProgressMonitor monitor)
			throws OperationCanceledException {

		WholeSearchResult result = getSearchResult();
		IWholeSearchScope scope = specification.getScope();
		result.removeAll();
		
		IEntity pattern = specification.getPattern();
		WholeResourceMatcher matcher = new WholeResourceMatcher(pattern, scope, result, monitor);
		try {
			matcher.searchScope();
		} catch (CoreException e) {
			return new Status(Status.ERROR, WholeUIPlugin.PLUGIN_ID, 1, "Error while searching in whole resources", e);
		}
		return Status.OK_STATUS;
	}

	public WholeQuerySpecification getQuerySpecification() {
		return specification;
	}
}
