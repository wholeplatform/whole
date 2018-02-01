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
package org.whole.lang.bindings;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Riccardo Solmi
 */
public class IncludeFilterScope extends AbstractFilterScope {
	protected IncludeFilterScope(Set<String> names) {
		super(names);
	}

	protected boolean isHidden(String name, boolean forReading) {
		return !getFilterNames().contains(name) && !name.startsWith("eclipse#") && !name.startsWith("debug#");
	}

	@Override
	public Set<String> wLocalNames() {
		if (isFilterEnabled()) {
			Set<String> filteredNames = new HashSet<String>(super.wLocalNames());
			filteredNames.retainAll(extendedFilterNames(filteredNames));
			return Collections.unmodifiableSet(filteredNames);
		} else
			return super.wLocalNames();
	}

	@Override
	public Set<String> wNames() {
		if (isFilterEnabled()) {
			Set<String> filteredNames = super.wNames();
			filteredNames.retainAll(extendedFilterNames(filteredNames));
			return filteredNames;
		} else
			return super.wNames();
	}

	protected Set<String> extendedFilterNames(Set<String> names) {
		Set<String> filterNames = names.stream().filter( (name) -> name.startsWith("eclipse#") || name.startsWith("debug#") ).collect(Collectors.toSet());
		filterNames.addAll(getFilterNames());
		return filterNames;
	}

	@Override
	protected String filterName() {
		return "include filter";
	}
}
