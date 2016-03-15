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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @author Enrico Persiani
 */
public class ActionSet implements IItemSet<IAction, ImageDescriptor> {
	protected IAction[] actions;
	protected ActionSet(IAction[] actions) {
		this.actions = actions;
	}
	
	public static ActionSet create(IAction[] actions) {
		return new ActionSet(actions);
	}

	public int size() {
		return actions.length;
	}
	public IAction get(int index) {
		return actions[index];
	}
	public String getLabel(int index) {
		return get(index).getText();
	}
	public ImageDescriptor getIcon(int index) {
		return get(index).getImageDescriptor();
	}
}
