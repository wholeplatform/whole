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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceProvider;


/**
 * @author Riccardo Solmi
 */
public abstract class AbstractURIResolver implements IURIResolver {
	private IURIResolverRegistry uriResolverRegistry;

	public String getId() {
		return getClass().getName();
	}

	public IURIResolverRegistry getUriResolverRegistry() {
		return uriResolverRegistry;
	}
	public void setUriResolverRegistry(IURIResolverRegistry uriResolverRegistry) {
		this.uriResolverRegistry = uriResolverRegistry;
	}

	public IPersistenceProvider resolve(IBindingManager bm, String uri) {
		throw new IllegalArgumentException();
	}

	public String getLocator(IBindingManager bm, String uri) {
		return uri;
	}
	public String addLocator(String uri, String url) {
		throw new UnsupportedOperationException();
	}
}
