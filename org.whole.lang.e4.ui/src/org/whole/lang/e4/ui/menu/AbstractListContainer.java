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
package org.whole.lang.e4.ui.menu;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.IContributionItem;
import org.whole.lang.ui.menu.AbstractContainer;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractListContainer<I, F> extends AbstractContainer<I, F> {
	protected List<IContributionItem> list;
	protected AbstractListContainer(List<IContributionItem> list) {
		this.list = list;
	}
	protected List<IContributionItem> getList() {
		return list;
	}

	public int calculateGroupIndex(String groupName) {
		int groupIndex = -1;
		Iterator<IContributionItem> iterator = getList().iterator();
		while (iterator.hasNext()) {
			IContributionItem ci = iterator.next();
			if (ci.isGroupMarker() && groupName.equalsIgnoreCase(ci.getId())) {
				groupIndex = getList().indexOf(ci) + 1;
				while (groupIndex < getList().size()) {
					if (getList().get(groupIndex).isGroupMarker())
						break;
					groupIndex++;
				}
				break;
			}
		}
		if (groupIndex == -1)
			throw new IllegalArgumentException("unknown group name "+groupName);
		return groupIndex;
	}

	protected void addContributionItem(IContributionItem item) {
		getList().add(item);
	}
	protected boolean hasContributions() {
		return !getList().isEmpty();
	}
}
