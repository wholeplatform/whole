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
package org.whole.lang.ui.actions;

import java.util.List;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractContributionItemsMenuCreator implements IMenuCreator {
	private List<IContributionItem> items;
	private boolean isMutuallyExclusive;
	private Menu dropDownMenu;
	private IContributionItem lastSelected;

	public AbstractContributionItemsMenuCreator(List<IContributionItem> items, boolean isMutuallyExclusive) {
		this.isMutuallyExclusive = isMutuallyExclusive;
		this.items = items; 
		if (!items.isEmpty())
			this.lastSelected = items.get(0);
	}

	public void dispose() {
		if (dropDownMenu != null) {
			MenuItem[] items = dropDownMenu.getItems();
			for (int i=0; i < items.length; i++)
				items[i].dispose();
			dropDownMenu.dispose();
		}
	}

	public Menu getMenu(Menu parent) {
		return null;
	}

	public Menu getMenu(Control parent) {
		if (items != null)
			updateItems(items);

		if (isMutuallyExclusive && dropDownMenu != null) {
			dropDownMenu.dispose();
			dropDownMenu = null;
		}
		if (dropDownMenu == null) {
			dropDownMenu = new Menu(parent);

			for (IContributionItem item : items)
				if (item != lastSelected)
					addMenuItem(item);
		}
		return dropDownMenu;
	}

	protected void addMenuItem(final IContributionItem item) {
		item.fill(dropDownMenu, -1);
		if (!item.isGroupMarker()) {
			MenuItem menuItem = dropDownMenu.getItem(dropDownMenu.getItemCount()-1);
			menuItem.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					itemSelected(item);
					lastSelected = item;
				}
			});
		}
	}

	protected void updateItems(List<IContributionItem> items) {
	}
	protected abstract void itemSelected(IContributionItem item);
}
