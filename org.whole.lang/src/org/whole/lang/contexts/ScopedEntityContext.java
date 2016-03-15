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
package org.whole.lang.contexts;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;


/**
 * @author Riccardo Solmi
 */
public class ScopedEntityContext extends AbstractEntityContext {
    public ScopedEntityContext(IEntity root) {
        super(root);
    }

    protected IEntity entityContext(IEntity root) {
        return new ScopedEntityContext(root);
    }
    
	public IEntity wGet(FeatureDescriptor feature) {
		int index;
		IEntity entityInScope = entity;
		while ((index = entityInScope.wIndexOf(feature)) == -1)
			entityInScope = entityInScope.wGetParent();
		
		return entityContext(entityInScope.wGet(index));
	}
	public void wSet(FeatureDescriptor feature, IEntity value) {
		int index;
		IEntity entityInScope = entity;
		while ((index = entityInScope.wIndexOf(feature)) == -1)
			entityInScope = entityInScope.wGetParent();

		entityInScope.wSet(index, value);
	}
	public void wUnset(FeatureDescriptor feature) {
		IEntity entityInScope = entity;
		while (entityInScope.wIndexOf(feature) == -1)
			entityInScope = entityInScope.wGetParent();

		entityInScope.wUnset(feature);
	}
	public boolean wIsSet(FeatureDescriptor feature) {
		IEntity entityInScope = entity;
		while (entityInScope.wIndexOf(feature) == -1)
			entityInScope = entityInScope.wGetParent();

		return entityInScope.wIsSet(feature);
	}

}
