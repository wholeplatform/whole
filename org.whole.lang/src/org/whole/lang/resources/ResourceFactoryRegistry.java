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

import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class ResourceFactoryRegistry implements IResourceFactoryRegistry {
	private IResourceRegistry<?> resourceRegistry;
	protected Map<EntityDescriptor<?>, IResourceFactory> descriptorResourceFactoryMap = new HashMap<EntityDescriptor<?>, IResourceFactory>();
	protected IResourceFactory defaultResourceFactory;
	
	public ResourceFactoryRegistry(IResourceRegistry<?> resourceRegistry) {
		this.resourceRegistry = resourceRegistry;
	}

	public IResourceRegistry<?> getResourceRegistry() {
		return resourceRegistry;
	}
	public IResourceFactoryRegistry getResourceFactoryRegistry() {
		return this;
	}

	public IResourceFactory getResourceFactory(String uri) {
		IResourceFactory resourceFactory = null;
		//TODO
		
		if (resourceFactory == null)
			resourceFactory = getDefaultResourceFactory();
		return resourceFactory;
	}
	public IResourceFactory getResourceFactory(String uri, EntityDescriptor<?> ed) {
		IResourceFactory resourceFactory;
		resourceFactory = getResourceFactory(ed);
		if (resourceFactory == null)
			resourceFactory = getDefaultResourceFactory();
		return resourceFactory;
	}

	public IResourceFactory getDefaultResourceFactory() {
		if (defaultResourceFactory == null)
			defaultResourceFactory = new EntityResourceFactory(this);
		return defaultResourceFactory;
	}
	public void setDefaultResourceFactory(IResourceFactory resourceFactory) {
		defaultResourceFactory = resourceFactory;
	}

	public IResourceFactory getResourceFactory(EntityDescriptor<?> ed) {
		return descriptorResourceFactoryMap.get(ed);
	}
	public IResourceFactory addResourceFactory(EntityDescriptor<?> ed, IResourceFactory resourceFactory) {
		return descriptorResourceFactoryMap.put(ed, resourceFactory);
	}
	public IResourceFactory removeResourceFactory(EntityDescriptor<?> ed) {
		return descriptorResourceFactoryMap.remove(ed);
	}

	public IResource createResource(String uri) {
		return getResourceFactory(uri).createResource(uri);
	}
	public IResource createResource(String uri, EntityDescriptor<?> ed) {
		return getResourceFactory(uri).createResource(uri, ed);
	}
}
