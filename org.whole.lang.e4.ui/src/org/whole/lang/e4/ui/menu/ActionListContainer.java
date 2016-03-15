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

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.ui.menu.ActionContainer;

/**
 * @author Enrico Persiani
 */
public class ActionListContainer extends AbstractListContainer<IAction, ImageDescriptor> {
	protected ActionListContainer(List<IContributionItem> list) {
		super(list);
	}

	public static ActionListContainer create(List<IContributionItem> list) {
		return new ActionListContainer(list);
	}

	public void appendToGroup(String groupName, IAction action) {
		addPendingSeparator();
		getList().add(calculateGroupIndex(groupName), new ActionContributionItem(action));
	}
	public void add(IAction action) {
		addPendingSeparator();
		getList().add(new ActionContributionItem(action));
	}

	public ActionContainer appendToGroupIntoSubContainer(String groupName, String name, ImageDescriptor icon) {
		addPendingSeparator();
		ActionContainer container = ActionContainer.create(name, icon);
		getList().add(calculateGroupIndex(groupName), container.getMenuManager());
		return container;
	}
	public ActionContainer addIntoSubContainer(String name, ImageDescriptor icon) {
		addPendingSeparator();
		ActionContainer container = ActionContainer.create(name, icon);
		getList().add(container.getMenuManager());
		return container;
	}
}