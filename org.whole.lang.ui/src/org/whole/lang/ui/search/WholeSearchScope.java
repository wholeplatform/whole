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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;

/**
 * @author Enrico Persiani
 */
public class WholeSearchScope implements IWholeSearchScope {
	private static List<ISearchScopeFilter> searchScopeFilterList = new ArrayList<ISearchScopeFilter>();
	public static boolean addSearchScopeFilter(ISearchScopeFilter filter) {
		return searchScopeFilterList.add(filter);
	}
	public static boolean removeSearchScopeFilter(ISearchScopeFilter filter) {
		return searchScopeFilterList.remove(filter);
	}

	private Set<IResource> rootResources;
	
	private static final Collection<IResource> EMPTY_ROOTS = Collections.emptySet();
	
	public WholeSearchScope() {
		this(EMPTY_ROOTS);
	}
	
	public WholeSearchScope(Collection<IResource> roots) {
		rootResources = new HashSet<IResource>(roots);
	}
	
	public Collection<IResource> getRoots() {
		return rootResources;
	}

	public boolean encloses(IResource resource) {
		// default implementation skips nothing
		for(ISearchScopeFilter filter : searchScopeFilterList) {
			if(!filter.encloses(resource))
				return false;
		}
		return true;
	}

	public interface ISearchScopeFilter {
		public boolean encloses(IResource resource);
	}
}
