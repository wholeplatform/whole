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
package org.whole.lang.reflect;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author Riccardo Solmi
 */
public class NullLanguageRequestHandler implements ILanguageRequestHandler {
	public static NullLanguageRequestHandler instance = new NullLanguageRequestHandler();
	protected NullLanguageRequestHandler() {
	}

	public int getPriority() {
		return Integer.MIN_VALUE;
	}
	public void addLanguageRequestHandler(ILanguageRequestHandler handler) {
    	if (handler != this)
    		throw new IllegalStateException();
    }
    public ILanguageRequestHandler removeLanguageRequestHandler(ILanguageRequestHandler handler) {
    	return this;
    }

	public Collection<String> getLanguagesURIs(Collection<String> collection) {
		if (collection == null)
			return new HashSet<String>();
		else
			return collection;
	}
	public Collection<String> getLanguagesNames(Collection<String> collection) {
		if (collection == null)
			return new HashSet<String>();
		else
			return collection;
	}

	public boolean containsLanguage(String languageURI) {
		return false;
	}
	public boolean deployLanguage(String languageURI) {
		return false;
	}
	public boolean undeployLanguage(String languageURI) {
		return false;
	}
}
