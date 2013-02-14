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

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @author Enrico Persiani
 */
public class ActionContainer implements IItemContainer<IAction, ImageDescriptor> {
	protected IMenuManager menuManager;
	protected ActionContainer(IMenuManager menuManager) {
		this.menuManager = menuManager;
	}
	public IMenuManager getMenuManager() {
		return menuManager;
	}

	public static ActionContainer create(IMenuManager menuManager) {
		return new ActionContainer(menuManager);
	}
	public static ActionContainer create(String name, ImageDescriptor icon) {
		return create(new MenuManager(name, icon, null));
	}

	public void appendToGroup(String groupName, IAction item) {
		getMenuManager().appendToGroup(groupName, item);
	}
	public void add(IAction item) {
		getMenuManager().add(item);
	}

	public void addSeparator() {
		getMenuManager().add(new Separator());
	}
	public void addSeparator(String groupName) {
		getMenuManager().add(new Separator(groupName));
	}
	public void addGroupMarker(String groupName) {
		getMenuManager().add(new GroupMarker(groupName));
	}

	public ActionContainer appendToGroupIntoSubContainer(String groupName, String name, ImageDescriptor icon) {
		ActionContainer menuManagerContainer = create(name, icon);
		getMenuManager().appendToGroup(groupName, menuManagerContainer.getMenuManager());
		return menuManagerContainer;
	}
	public ActionContainer addIntoSubContainer(String name, ImageDescriptor icon) {
		ActionContainer menuManagerContainer = create(name, icon);
		getMenuManager().add(menuManagerContainer.getMenuManager());
		return menuManagerContainer;
	}
}