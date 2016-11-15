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
package org.whole.lang.e4.ui.actions;


import java.util.Comparator;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.widgets.Menu;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractCompositeContributionItem extends ContributionItem {
	protected IContextProvider contextProvider;
	protected Comparator<IAction> comparator;
	protected IContributionItem[] items;
	protected IMenuListener listener;

	public AbstractCompositeContributionItem(IContextProvider contextProvider) {
		this.contextProvider = contextProvider;
		this.comparator = new Comparator<IAction>() {
			public int compare(IAction left, IAction right) {
				if (left.getText() == null || right.getText() == null)
					return right.getText() == left.getText() ? 0 : (right.getText() == null ? 1 : -1);
				return left.getText().compareTo(right.getText());
			}
		};
		this.items = null;
		this.listener = new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				manager.markDirty();
			}
		};
	}

	public void dispose() {
		if (items == null)
			return;

		for (int i = 0; i < items.length; i++)
			items[i].dispose();

		items = null;
	}

	public void fill(Menu parent, int index) {
		dispose();

		index = index == -1 ? parent.getItemCount() : Math.min(index, parent.getItemCount());

		items = getItems();
		for (int i = 0; i < items.length; i++) {
			int beforeFillCount = parent.getItemCount();
			if (items[i].isVisible())
				items[i].fill(parent, index);
			int afterFillCount = parent.getItemCount();
			index += afterFillCount - beforeFillCount;
		}
	}

	public boolean isDirty() {
		return true;
	}

	public boolean isDynamic() {
		return true;
	}

	public void setParent(IContributionManager parent) {
		if (getParent() instanceof IMenuManager)
			((IMenuManager) getParent()).removeMenuListener(listener);

		if (parent instanceof IMenuManager)
			((IMenuManager) parent).addMenuListener(listener);
		super.setParent(parent);
	}

	protected abstract IContributionItem[] getItems();
}
