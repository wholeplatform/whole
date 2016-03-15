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
package org.whole.lang.ui.menu;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class FlatFillMenuStrategy implements IFillMenuStrategy {
	private static class SingletonHolder {
		private static final IFillMenuStrategy instance = new FlatFillMenuStrategy(null);
	}
	public static IFillMenuStrategy instance() {
		return SingletonHolder.instance;
	}
	public static IFillMenuStrategy instance(String groupName) {
		return new FlatFillMenuStrategy(groupName);
	}

	private String groupName;
	protected FlatFillMenuStrategy(String groupName) {
		this.groupName = groupName;
	}

	public <I, F> void fillMenu(IItemContainer<I, F> container, IItemSet<I, F> itemSet, int beginIndex, int endIndex) {
		for (int i=beginIndex; i<endIndex; i++)
			if (groupName != null)
				container.appendToGroup(groupName, itemSet.get(i));
			else
				container.add(itemSet.get(i));
	}
}
