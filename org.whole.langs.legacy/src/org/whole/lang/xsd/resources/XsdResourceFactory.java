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
package org.whole.lang.xsd.resources;

import org.whole.lang.resources.EntityResourceFactory;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceFactoryRegistry;
import org.whole.lang.resources.Resource;
import org.whole.lang.xsd.codebase.XsdPersistenceKit;
import org.whole.lang.xsd.util.SchemaUtils;

/**
 * @author Riccardo Solmi
 */
public class XsdResourceFactory extends EntityResourceFactory {
	public XsdResourceFactory(IResourceFactoryRegistry resourceFactoryRegistry) {
		super(resourceFactoryRegistry);
	}

	@Override
	public IResource createResource(String uri) {
		Resource resource = (Resource) super.createResource(uri);
		resource.setNamespace(SchemaUtils.calculateNamespace(uri));
		resource.setName(SchemaUtils.calculateName(uri));
		resource.setVersion("1.0");
		resource.setResourcePersistenceKit(XsdPersistenceKit.instance());
		return resource;
	}
}
