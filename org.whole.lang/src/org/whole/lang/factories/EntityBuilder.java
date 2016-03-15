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
package org.whole.lang.factories;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class EntityBuilder<E extends IEntity> implements IEntityBuilder<E> {
	protected E e;
	
	public EntityBuilder(E entity) {
		this.e = entity;
	}

	public E getResult() {
		return e;
	}

	public IEntityBuilder<E> set(FeatureDescriptor fd, IEntity value) {
		e.wSet(fd, value);
		return this;
	}
	public IEntityBuilder<E> set(FeatureDescriptor fd, IEntity... values) {
		IEntity compositeEntity = e.wGet(fd);
		for (int i=0, length=values.length; i<length; i++)
			compositeEntity.wSet(i, values[i]);
		return this;
	}
	public IEntityBuilder<E> set(FeatureDescriptor fd, Object value) {
		e.wGet(fd).wSetValue(value);
		return this;
	}


// interface [Lang]EntityBuilder<E extends IEntity> extends IEntityBuilder<E>

//	public E setF(Tspec value)
}
