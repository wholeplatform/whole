/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class E3HierarchicalFillMenuStrategy implements IE3FillMenuStrategy {
	public static final int MENU_MAX_SIZE = 20;

	private static class SingletonHolder {
		private static final IE3FillMenuStrategy instance = new E3HierarchicalFillMenuStrategy(E3PrefixMenuNameStrategy.instance(), MENU_MAX_SIZE);
	}
	public static IE3FillMenuStrategy instance() {
		return SingletonHolder.instance;
	}
	public static IE3FillMenuStrategy instance(IE3MenuNameStrategy menuNameStrategy) {
		return new E3HierarchicalFillMenuStrategy(menuNameStrategy, MENU_MAX_SIZE);
	}

	private int submenuMaxSize;
	private IE3MenuNameStrategy menuNameStrategy;
	private String groupName;

	public E3HierarchicalFillMenuStrategy(IE3MenuNameStrategy menuNameStrategy, int submenuMaxSize) {
		this(menuNameStrategy, submenuMaxSize, null);
	}
	public E3HierarchicalFillMenuStrategy(IE3MenuNameStrategy menuNameStrategy, int submenuMaxSize, String groupName) {
		this.menuNameStrategy = menuNameStrategy;
		this.submenuMaxSize = submenuMaxSize;
		this.groupName = groupName;
	}

	public void fillMenu(IMenuManager menu, IAction[] actions, int beginIndex, int endIndex) {
		fillMenu(menu, actions, beginIndex, endIndex, false);
	}
	protected void fillMenu(IMenuManager menu, IAction[] actions, int beginIndex, int endIndex, boolean isNested) {
		final double size = endIndex - beginIndex;
		if (size <= submenuMaxSize)
			for (int i=beginIndex; i<endIndex; i++)
				menu.add(actions[i]);
		else {
			final double menus = Math.ceil(size / submenuMaxSize);
			final int subSize = (int) Math.ceil(size / Math.min(menus, submenuMaxSize)); 

			for (int j=beginIndex; j<endIndex; j+= subSize) {
				final int beginIndex1 = j;
				final int endIndex1 = Math.min(j + subSize, endIndex);
				final MenuManager subMenu = new MenuManager(
						menuNameStrategy.menuName(actions, beginIndex1, endIndex1),
						actions[j].getImageDescriptor(), null);
				fillMenu(subMenu, actions, beginIndex1, endIndex1, true);
				if (!isNested && groupName != null)
					menu.appendToGroup(groupName, subMenu);
				else
					menu.add(subMenu);
			}
		}
	}

	public void fillMenu(IMenuManager menu, MenuManager[] menus, int beginIndex, int endIndex) {
		fillMenu(menu, menus, beginIndex, endIndex, false);
	}
	protected void fillMenu(IMenuManager menu, MenuManager[] menus, int beginIndex, int endIndex, boolean isNested) {
		final double size = endIndex - beginIndex;
		if (size <= submenuMaxSize)
			for (int i=beginIndex; i<endIndex; i++)
				menu.add(menus[i]);
		else {
			final double menusSize = Math.ceil(size / submenuMaxSize);
			final int subSize = (int) Math.ceil(size / Math.min(menusSize, submenuMaxSize)); 

			for (int j=beginIndex; j<endIndex; j+= subSize) {
				final int beginIndex1 = j;
				final int endIndex1 = Math.min(j + subSize, endIndex);
				final MenuManager subMenu = new MenuManager(
						menuNameStrategy.menuName(menus, beginIndex1, endIndex1),
						menus[j].getImageDescriptor(), null);
				fillMenu(subMenu, menus, beginIndex1, endIndex1, true);
				if (!isNested && groupName != null)
					menu.appendToGroup(groupName, subMenu);
				else
					menu.add(subMenu);
			}
		}
	}
}
