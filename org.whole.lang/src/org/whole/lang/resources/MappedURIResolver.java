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
package org.whole.lang.resources;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.codebase.IPersistenceProvider;

/**
 * @author Riccardo Solmi
 */
public class MappedURIResolver extends AbstractURIResolver {
	private final Map<String, String> uriLocatorMap = new HashMap<String, String>();

	public boolean canResolve(String contextUri, String uri) {
		return uriLocatorMap.containsKey(uri) && getUriResolverRegistry().canResolve(contextUri, getLocator(contextUri, uri));
	}
	public IPersistenceProvider resolve(String contextUri, String uri) {
		return getUriResolverRegistry().resolve(contextUri, getLocator(contextUri, uri));
	}

	public String getLocator(String contextUri, String uri) {
		return uriLocatorMap.get(uri);
	}
	public String addLocator(String uri, String url) {
		return uriLocatorMap.put(uri, url);
	}
	public String removeLocator(String uri) {
		return uriLocatorMap.remove(uri);
	}
}
