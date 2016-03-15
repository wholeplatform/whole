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
import java.util.logging.Logger;

/**
 * @author Riccardo Solmi
 */
public class LoggerLanguageRequestHandler extends AbstractLanguageRequestHandler {
	private static Logger logger;

	private static class SingletonHolder {
		private static final LoggerLanguageRequestHandler instance = new LoggerLanguageRequestHandler();
	}
	public static final LoggerLanguageRequestHandler instance() {
		return SingletonHolder.instance;
	}
    private LoggerLanguageRequestHandler() {
    	logger = Logger.getLogger("org.whole.lang.reflect");
    }

	public int getPriority() {
		return Integer.MAX_VALUE;
	}

	public Collection<String> getLanguagesURIs(Collection<String> collection) {
		logger.fine("getLanguagesURIs");
		return super.getLanguagesURIs(collection);
	}
	public Collection<String> getLanguagesNames(Collection<String> collection) {
		logger.fine("getLanguagesNames");
		return super.getLanguagesNames(collection);
	}

	public boolean containsLanguage(String languageURI) {
		boolean result = super.containsLanguage(languageURI);
		if (result)
			logger.fine("Contains language: "+languageURI);
		else
			logger.info("Language not available: "+languageURI);
		return result;
	}
	public boolean deployLanguage(String languageURI) {
		boolean result = super.deployLanguage(languageURI);
		if (result)
			logger.fine("Language deployed: "+languageURI);
		else
			logger.info("Language not deployed: "+languageURI);
		return result;
	}
	public boolean undeployLanguage(String languageURI) {
		boolean result = super.undeployLanguage(languageURI);
		if (result)
			logger.fine("Language undeployed: "+languageURI);
		else
			logger.info("Language not undeployed: "+languageURI);
		return result;
	}
}
