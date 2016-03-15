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

/**
 * @author Riccardo Solmi
 */
public class ExcludeFilterScope extends AbstractFilterScope {
	protected ExcludeFilterScope(Set<String> names) {
		super(names);
	}

	protected boolean isHidden(String name, boolean forReading) {
		return getFilterNames().contains(name);
	}

	@Override
	public Set<String> wLocalNames() {
		if (isFilterEnabled()) {
			Set<String> filteredNames = new HashSet<String>(super.wLocalNames());
			filteredNames.removeAll(getFilterNames());
			return Collections.unmodifiableSet(filteredNames);
		} else
			return super.wLocalNames();
	}
	@Override
	public Set<String> wNames() {
		if (isFilterEnabled()) {
			Set<String> filteredNames = super.wNames();
			filteredNames.removeAll(getFilterNames());
			return filteredNames;
		} else
			return super.wNames();
	}

	@Override
	protected String filterName() {
		return "exclude filter";
	}
}
