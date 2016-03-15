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

import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class EntityResourceFactory implements IResourceFactory {
	private IResourceFactoryRegistry resourceFactoryRegistry;

	public EntityResourceFactory(IResourceFactoryRegistry resourceFactoryRegistry) {
		this.resourceFactoryRegistry = resourceFactoryRegistry;
	}

	public IResourceFactoryRegistry getResourceFactoryRegistry() {
		return resourceFactoryRegistry;
	}
	public void setResourceFactoryRegistry(IResourceFactoryRegistry resourceFactoryRegistry) {
		this.resourceFactoryRegistry = resourceFactoryRegistry;
	}

	public IResource createResource(String uri) {
		Resource resource = new Resource();
		resource.setURI(uri);
		resource.setResourceInfo(new StateDerivedResourceInfo(new EntityDerivedResourceInfo(resource)));
		return resource;
	}
	public IResource createResource(String uri, EntityDescriptor<?> ed) {
		return createResource(uri);
	}
}
