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

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractContainer<I, F> implements IItemContainer<I, F> {
	protected IContributionItem pendingSeparator;
	protected AbstractContainer() {
		this.pendingSeparator = null;
	}

	protected void setPendingSeparator(IContributionItem pendingSeparator) {
		this.pendingSeparator = pendingSeparator;
	}
	protected IContributionItem getPendingSeparator() {
		return pendingSeparator;
	}
	protected void addPendingSeparator() {
		if (this.pendingSeparator != null) {
			IContributionItem item = pendingSeparator;
			setPendingSeparator(null);
			addContributionItem(item);
		}
	}

	public void addSeparator() {
		setPendingSeparator(new Separator());
	}
	public void addSeparator(String groupName) {
		setPendingSeparator(hasContributions() ? new Separator(groupName) : new GroupMarker(groupName));
	}
	public void addGroupMarker(String groupName) {
		setPendingSeparator(new GroupMarker(groupName));
	}

	protected abstract void addContributionItem(IContributionItem item);
	protected abstract boolean hasContributions();
}
