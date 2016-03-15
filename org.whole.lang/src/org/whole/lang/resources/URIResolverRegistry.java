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

import java.util.ArrayList;
import java.util.List;

import org.whole.lang.codebase.IPersistenceProvider;

/**
 * @author Riccardo Solmi
 */
public class URIResolverRegistry implements IURIResolverRegistry {
	private IResourceRegistry<?> resourceRegistry;
	protected List<IURIResolver> uriResolverList = new ArrayList<IURIResolver>();

	public URIResolverRegistry(IResourceRegistry<?> resourceRegistry) {
		this.resourceRegistry = resourceRegistry;
	}

	public String getId() {
		return getClass().getName();
	}

	public IResourceRegistry<?> getResourceRegistry() {
		return resourceRegistry;
	}
	public IURIResolverRegistry getUriResolverRegistry() {
		return this;
	}
	public void setUriResolverRegistry(IURIResolverRegistry uriResolverRegistry) {
		throw new UnsupportedOperationException();
	}

	public void addURIResolver(IURIResolver uriResolver) {
		uriResolverList.add(0, uriResolver);
		uriResolver.setUriResolverRegistry(this);
	}
	public IURIResolver getURIResolver(String contextUri, String uri) {
		for (IURIResolver uriResolver : uriResolverList)
			if (uriResolver.canResolve(contextUri, uri))
				return uriResolver;
		throw new IllegalArgumentException();
	}

	public boolean canResolve(String contextUri, String uri) {
		for (IURIResolver uriResolver : uriResolverList)
			if (uriResolver.canResolve(contextUri, uri))
				return true;
		return false;
	}
	public IPersistenceProvider resolve(String contextUri, String uri) {
		return getURIResolver(contextUri, uri).resolve(contextUri, uri);
	}

	public String getLocator(String contextUri, String uri) {
		return getURIResolver(contextUri, uri).getLocator(contextUri, uri);
	}
	public String addLocator(String uri, String url) {
		IURIResolver mappedURIResolver = null;
		for (IURIResolver uriResolver : uriResolverList)
			if (uriResolver.getId().equals(MappedURIResolver.class.getName())) {
				mappedURIResolver = uriResolver;
				break;
			}

		if (mappedURIResolver == null)
			addURIResolver(mappedURIResolver = new MappedURIResolver());

		return mappedURIResolver.addLocator(uri, url);
	}
}
