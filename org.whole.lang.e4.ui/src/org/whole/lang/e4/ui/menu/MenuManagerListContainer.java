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

import java.util.List;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.ui.menu.MenuManagerContainer;

/**
 * @author Enrico Persiani
 */
public class MenuManagerListContainer extends AbstractListContainer<MenuManager, ImageDescriptor> {
	protected MenuManagerListContainer(List<IContributionItem> list) {
		super(list);
	}

	public static MenuManagerListContainer create(List<IContributionItem> list) {
		return new MenuManagerListContainer(list);
	}

	public void appendToGroup(String groupName, MenuManager menuManager) {
		addPendingSeparator();
		getList().add(calculateGroupIndex(groupName), menuManager);
	}
	public void add(MenuManager menuManager) {
		addPendingSeparator();
		getList().add(menuManager);
	}

	public MenuManagerContainer appendToGroupIntoSubContainer(String groupName, String name, ImageDescriptor icon) {
		addPendingSeparator();
		MenuManagerContainer container = MenuManagerContainer.create(name, icon);
		getList().add(calculateGroupIndex(groupName), container.getMenuManager());
		return container;
	}
	public MenuManagerContainer addIntoSubContainer(String name, ImageDescriptor icon) {
		addPendingSeparator();
		MenuManagerContainer container = MenuManagerContainer.create(name, icon);
		getList().add(container.getMenuManager());
		return container;
	}
}