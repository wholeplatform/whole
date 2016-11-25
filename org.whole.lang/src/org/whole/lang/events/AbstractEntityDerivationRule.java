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
package org.whole.lang.events;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractEntityDerivationRule<E extends IEntity> extends IdentityEventHandler {
	@SuppressWarnings("unchecked")
	public IEntity notifyRequested(IEntity entity, FeatureDescriptor fd, IEntity value) {
		if (EntityUtils.isResolver(value)) {
			IEntity newValue = derive((E) entity, fd, value);
			if (newValue != value)
				entity.wSet(fd, newValue);
			return newValue;
		} else
			return value;
	}
	public IEntity derive(E entity, FeatureDescriptor fd, IEntity value) {
		return value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
		if (EntityUtils.isResolver(newValue) && entity.wGetModel().getCompoundModel().isObserved(entity))//FIXME ? or oldValue.wIsObserved()
			notifyRequested(entity, fd, newValue);
		else
			invalidate((E) entity, fd, oldValue, newValue);
	}
	public void invalidate(E entity, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
	}
}
