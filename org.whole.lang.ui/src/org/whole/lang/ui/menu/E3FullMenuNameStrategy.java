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
import org.eclipse.jface.action.MenuManager;

/**
 * @author Riccardo Solmi
 */
public class E3FullMenuNameStrategy implements IE3MenuNameStrategy {
	private static final IE3MenuNameStrategy instance = new E3FullMenuNameStrategy();
	public static IE3MenuNameStrategy instance() {
		return instance;
	}
	protected FullMenuNameStrategy menuNameStrategy;
	protected E3FullMenuNameStrategy() {
		this.menuNameStrategy = new FullMenuNameStrategy();
	}
	
	public String menuName(IAction[] actions, int beginIndex, int endIndex) {
		return menuName(ActionSet.create(actions), beginIndex, endIndex);
	}

	public String menuName(MenuManager[] menus, int beginIndex, int endIndex) {
		return menuName(MenuManagerSet.create(menus), beginIndex, endIndex);
	}

	public <I, F>  String menuName(IItemSet<I, F>  itemSet, int beginIndex, int endIndex) {
		return menuNameStrategy.menuName(itemSet, beginIndex, endIndex);
	}
}
