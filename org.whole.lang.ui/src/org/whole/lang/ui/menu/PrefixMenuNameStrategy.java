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
	
	public <I, F>  String menuName(IItemSet<I, F>  actions, int beginIndex, int endIndex) {
		String firstName = actions.getLabel(beginIndex);
		String lastName = actions.getLabel(endIndex-1);
		int commonPrefixSize = StringUtils.commonPrefix(firstName, lastName);
		
		int firstPrefixSize = commonPrefixSize;
		if (beginIndex > 0) {
			String prevName = actions.getLabel(beginIndex-1);
			firstPrefixSize = Math.max(commonPrefixSize, StringUtils.commonPrefix(prevName, firstName));	
		}

		int lastPrefixSize = commonPrefixSize;
		if (endIndex < actions.size() && actions.get(endIndex) != null) {
			String succName = actions.getLabel(endIndex);
			lastPrefixSize = Math.max(commonPrefixSize, StringUtils.commonPrefix(lastName, succName));	
		}
		
		return StringUtils.camelPrefix(firstName, firstPrefixSize)+" \u2013 "+StringUtils.camelPrefix(lastName, lastPrefixSize);
	}
}
