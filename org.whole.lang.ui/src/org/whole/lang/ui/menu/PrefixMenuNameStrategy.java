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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class PrefixMenuNameStrategy implements IMenuNameStrategy {
	private static final IMenuNameStrategy instance = new PrefixMenuNameStrategy();
	public static IMenuNameStrategy instance() {
		return instance;
	}
	protected PrefixMenuNameStrategy() {}
	
	public String menuName(IAction[] actions, int beginIndex, int endIndex) {
		String firstName = actions[beginIndex].getText();
		String lastName = actions[endIndex-1].getText();
		int commonPrefixSize = StringUtils.commonPrefix(firstName, lastName);
		
		int firstPrefixSize = commonPrefixSize;
		if (beginIndex > 0) {
			String prevName = actions[beginIndex-1].getText();
			firstPrefixSize = Math.max(commonPrefixSize, StringUtils.commonPrefix(prevName, firstName));	
		}

		int lastPrefixSize = commonPrefixSize;
		if (endIndex < actions.length && actions[endIndex] != null) {
			String succName = actions[endIndex].getText();
			lastPrefixSize = Math.max(commonPrefixSize, StringUtils.commonPrefix(lastName, succName));	
		}
		
		return StringUtils.camelPrefix(firstName, firstPrefixSize)+" \u2013 "+StringUtils.camelPrefix(lastName, lastPrefixSize);
	}

	public String menuName(MenuManager[] menus, int beginIndex, int endIndex) {
		String firstName = menus[beginIndex].getMenuText();
		String lastName = menus[endIndex-1].getMenuText();
		int commonPrefixSize = StringUtils.commonPrefix(firstName, lastName);
		
		int firstPrefixSize = commonPrefixSize;
		if (beginIndex > 0) {
			String prevName = menus[beginIndex-1].getMenuText();
			firstPrefixSize = Math.max(commonPrefixSize, StringUtils.commonPrefix(prevName, firstName));	
		}

		int lastPrefixSize = commonPrefixSize;
		if (endIndex < menus.length && menus[endIndex] != null) {
			String succName = menus[endIndex].getMenuText();
			lastPrefixSize = Math.max(commonPrefixSize, StringUtils.commonPrefix(lastName, succName));	
		}
		
		return StringUtils.camelPrefix(firstName, firstPrefixSize)+" \u2013 "+StringUtils.camelPrefix(lastName, lastPrefixSize);
	}
}
