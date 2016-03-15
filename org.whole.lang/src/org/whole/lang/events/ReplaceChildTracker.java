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
public class ReplaceChildTracker extends IdentityChangeEventHandler {
	private static final long serialVersionUID = 1L;
	private IEntity parentEntity;
	private IEntity entity;

	public ReplaceChildTracker(IEntity entity) {
		this.entity = entity;

		parentEntity = entity.wGetParent();
    	if (!EntityUtils.isNull(parentEntity))
    		parentEntity.wAddChangeEventHandler(this);
	}

	public final IEntity entity() {
		return entity;
	}

	public void dispose() {
    	if (!EntityUtils.isNull(parentEntity))
    		parentEntity.wRemoveChangeEventHandler(this);
	}

    public void notifyRemoved(IEntity source, FeatureDescriptor feature, int index, IEntity oldValue) {
    	if (source == parentEntity && oldValue == entity)
    		entity = null;
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, int index, IEntity oldValue, IEntity newValue) {
    	if (source == parentEntity && oldValue == entity)
    		entity = newValue;
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, IEntity oldValue, IEntity newValue) {
    	if (source == parentEntity && oldValue == entity)
    		entity = newValue;
    }
}