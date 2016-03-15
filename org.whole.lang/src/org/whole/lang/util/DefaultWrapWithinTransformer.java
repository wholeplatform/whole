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
public class DefaultWrapWithinTransformer implements IEntityTransformer {
	private final FeatureDescriptor featureDescriptor;

	public DefaultWrapWithinTransformer(FeatureDescriptor featureDescriptor) {
		this.featureDescriptor = featureDescriptor;
	}

	public FeatureDescriptor getFeatureDescriptor() {
		return featureDescriptor;
	}

	public void transform(IEntity oldEntity, IEntity newEntity) {
		EntityKinds newKind = newEntity.wGetEntityKind();
		if (newKind.isData())
			return;

		IEntity containerEntity;
		if (featureDescriptor != null)
			containerEntity = newEntity.wGet(featureDescriptor);
		else
			containerEntity = newEntity;

		if (!EntityUtils.isComposite(containerEntity))
			return;

		if (containerEntity.wGetEntityDescriptor(0).isPlatformSupertypeOf(oldEntity.wGetEntityDescriptor())) {
			IEntity clone = EntityUtils.clone(oldEntity);
			containerEntity.wSet(0, clone);
		}
	}
}
