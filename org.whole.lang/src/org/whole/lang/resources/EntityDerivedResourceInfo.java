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

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class EntityDerivedResourceInfo extends AbstractResourceInfo {
	protected IResource resource;

	public EntityDerivedResourceInfo(IResource resource) {
		this(resource, NullResourceInfo.instance);
	}
	public EntityDerivedResourceInfo(IResource resource, IResourceInfo nextResourceInfo) {
		super(nextResourceInfo);
		this.resource = resource;
	}

	protected String getFeature(String name, String value) {
		IEntity entity = resource.getEntity();
		if (entity != null) {
			FeatureDescriptor fd = entity.wGetLanguageKit().getFeatureDescriptorEnum().valueOf(name);
			if (fd != null) {
				IEntity evalue = entity.wGet(fd);
				if (DataTypeUtils.getDataKind(evalue).isString())
					return evalue.wStringValue();
			}
		}
		return null;
	}
}
