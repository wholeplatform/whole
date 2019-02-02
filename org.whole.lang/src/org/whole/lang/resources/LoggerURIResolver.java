/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.resources;

import java.util.logging.Logger;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class LoggerURIResolver extends AbstractURIResolver {
	private Logger logger;

    public LoggerURIResolver() {
    	logger = Logger.getLogger("org.whole.lang.resources");
    }

	public boolean canResolve(IBindingManager bm, String uri) {
		logger.fine("canResolve: "+uri+" in context: "+ReflectionFactory.contextURI(bm));
		return false;
	}

	@Override
	public IPersistenceProvider resolve(IBindingManager bm, String uri) {
		logger.fine("resolve: "+uri+" in context: "+ReflectionFactory.contextURI(bm));
		return super.resolve(bm, uri);
	}

	@Override
	public String getLocator(IBindingManager bm, String uri) {
		logger.fine("get Locator: "+uri+" in context: "+ReflectionFactory.contextURI(bm));
		return super.getLocator(bm, uri);
	}

	@Override
	public String addLocator(String uri, String url) {
		logger.fine("add Locator: "+uri+" for URI: "+uri);
		return super.addLocator(uri, url);
	}
}
