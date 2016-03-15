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

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractLanguageRequestHandler implements ILanguageRequestHandler {
	protected ILanguageRequestHandler successor = NullLanguageRequestHandler.instance;

	public int getPriority() {
		return 0;
	}
    public void addLanguageRequestHandler(ILanguageRequestHandler handler) {
    	if (successor.getPriority() < handler.getPriority()) {
    		handler.addLanguageRequestHandler(successor);
    		successor = handler;
    	} else if (successor != handler)
    		successor.addLanguageRequestHandler(handler);
    }
    public ILanguageRequestHandler removeLanguageRequestHandler(ILanguageRequestHandler handler) {
    	if (handler != this) {
    		successor = successor.removeLanguageRequestHandler(handler);
    		return this;
    	} else
    		return successor;
    }

	public Collection<String> getLanguagesURIs(Collection<String> collection) {
		return successor.getLanguagesURIs(collection);
	}
	public Collection<String> getLanguagesNames(Collection<String> collection) {
		return successor.getLanguagesNames(collection);
	}

	public boolean containsLanguage(String languageURI) {
		return successor.containsLanguage(languageURI);
	}
	public boolean deployLanguage(String languageURI) {
		return successor.deployLanguage(languageURI);
	}
	public boolean undeployLanguage(String languageURI) {
		return successor.undeployLanguage(languageURI);
	}
}
