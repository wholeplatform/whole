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
public class HierarchicalFillMenuStrategy implements IFillMenuStrategy {
	public static final int MENU_MAX_SIZE = 20;

	private static class SingletonHolder {
		private static final IFillMenuStrategy instance = new HierarchicalFillMenuStrategy(PrefixMenuNameStrategy.instance(), MENU_MAX_SIZE);
	}
	public static IFillMenuStrategy instance() {
		return SingletonHolder.instance;
	}
	public static IFillMenuStrategy instance(IMenuNameStrategy menuNameStrategy) {
		return new HierarchicalFillMenuStrategy(menuNameStrategy, MENU_MAX_SIZE);
	}

	private int submenuMaxSize;
	private IMenuNameStrategy menuNameStrategy;
	private String groupName;

	public HierarchicalFillMenuStrategy(IMenuNameStrategy menuNameStrategy, int submenuMaxSize) {
		this(menuNameStrategy, submenuMaxSize, null);
	}
	public HierarchicalFillMenuStrategy(IMenuNameStrategy menuNameStrategy, int submenuMaxSize, String groupName) {
		this.menuNameStrategy = menuNameStrategy;
		this.submenuMaxSize = submenuMaxSize;
		this.groupName = groupName;
	}

	public <I, F>  void fillMenu(IItemContainer<I, F>  container, IItemSet<I, F>  itemSet, int beginIndex, int endIndex) {
		fillMenu(container, itemSet, beginIndex, endIndex, false);
	}
	protected <I, F>  void fillMenu(IItemContainer<I, F>  menu, IItemSet<I, F>  itemSet, int beginIndex, int endIndex, boolean isNested) {
		final double size = endIndex - beginIndex;
		if (size <= submenuMaxSize)
			for (int i=beginIndex; i<endIndex; i++)
				menu.add(itemSet.get(i));
		else {
			final double menus = Math.ceil(size / submenuMaxSize);
			final int subSize = (int) Math.ceil(size / Math.min(menus, submenuMaxSize)); 

			for (int j=beginIndex; j<endIndex; j+= subSize) {
				final int beginIndex1 = j;
				final int endIndex1 = Math.min(j + subSize, endIndex);

				String containerLabel = menuNameStrategy.menuName(itemSet, beginIndex1, endIndex1);
				F containerIcon = itemSet.getIcon(j);
				IItemContainer<I, F>  subContainer = !isNested && groupName != null ?
						menu.appendToGroupIntoSubContainer(groupName, containerLabel, containerIcon) :
							menu.addIntoSubContainer(containerLabel, containerIcon);

				fillMenu(subContainer, itemSet, beginIndex1, endIndex1, true);
			}
		}
	}
}
