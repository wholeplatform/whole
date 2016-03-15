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
package org.whole.lang.util;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;


/**
 * @author Riccardo Solmi
 */
public class DefaultWrapInTransformer implements IEntityTransformer {
	public static final DefaultWrapInTransformer instance = new DefaultWrapInTransformer();
	
	protected final FeatureDescriptor featureDescriptor;
	protected final int index;

	public DefaultWrapInTransformer() {
		this(0);
	}
	public DefaultWrapInTransformer(FeatureDescriptor featureDescriptor) {
		this(featureDescriptor, -1);
	}
	public DefaultWrapInTransformer(int index) {
		this(null, index);
	}
	protected DefaultWrapInTransformer(FeatureDescriptor featureDescriptor, int index) {
		this.featureDescriptor = featureDescriptor;
		this.index = index;
	}

	public FeatureDescriptor getFeatureDescriptor() {
		return featureDescriptor;
	}
	public int getIndex() {
		return index;
	}

	public void transform(IEntity oldEntity, IEntity newEntity) {
		EntityKinds newKind = newEntity.wGetEntityKind();
		if (newKind.isData())
			return;

		IEntity clone = EntityUtils.clone(oldEntity);
		if (featureDescriptor != null) {
			if (newEntity.wGetEntityDescriptor().getEntityDescriptor(featureDescriptor).isPlatformSupertypeOf(oldEntity.wGetEntityDescriptor()))
				newEntity.wSet(featureDescriptor, clone);
		} else if (newEntity.wGetEntityDescriptor().getEntityDescriptor(index).isPlatformSupertypeOf(oldEntity.wGetEntityDescriptor()))
			newEntity.wSet(index, clone);
	}
}
