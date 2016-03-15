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

import java.util.Comparator;

import org.eclipse.jface.action.IAction;

/**
 * @author Enrico Persiani
 */
public class ActionsComparator implements Comparator<IAction> {
	private static class SingletonHolder {
		private static final ActionsComparator instance = new ActionsComparator();
	}

	public static ActionsComparator instance() {
		return SingletonHolder.instance;
	}
	public int compare(IAction a1, IAction a2) {
		String a1Label = a1.getText();
		String a2Label = a2.getText();
		return a1Label == null ? (a2Label == null ? 0 : -1 ) : 
			(a2Label == null ? 1 : a1Label.compareTo(a2Label) ) ;
	}
}
