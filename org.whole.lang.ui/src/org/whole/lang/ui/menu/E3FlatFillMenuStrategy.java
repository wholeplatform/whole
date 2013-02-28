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
package org.whole.lang.ui.menu;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class E3FlatFillMenuStrategy implements IE3FillMenuStrategy {
	private static class SingletonHolder {
		private static final IE3FillMenuStrategy instance = new E3FlatFillMenuStrategy(null);
	}
	public static IE3FillMenuStrategy instance() {
		return SingletonHolder.instance;
	}
	public static IE3FillMenuStrategy instance(String groupName) {
		return new E3FlatFillMenuStrategy(groupName);
	}

	protected FlatFillMenuStrategy fillMenuStrategy;
	protected E3FlatFillMenuStrategy(String groupName) {
		this.fillMenuStrategy = new FlatFillMenuStrategy(groupName);
	}

	public void fillMenu(IMenuManager menu, IAction[] actions, int beginIndex, int endIndex) {
		fillMenu(ActionContainer.create(menu), ActionSet.create(actions), beginIndex, endIndex);
	}

	public void fillMenu(IMenuManager menu, MenuManager[] menus, int beginIndex, int endIndex) {
		fillMenu(MenuManagerContainer.create(menu), MenuManagerSet.create(menus), beginIndex, endIndex);
	}

	@Override
	public <I, F>  void fillMenu(IItemContainer<I, F>  container, IItemSet<I, F>  itemSet, int beginIndex, int endIndex) {
		fillMenuStrategy.fillMenu(container, itemSet, beginIndex, endIndex);
	}
}
