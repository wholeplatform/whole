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
package org.whole.lang.builders;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class FeaturesList extends AbstractList<IEntity> implements RandomAccess, Serializable {
	private static final long serialVersionUID = 1L;
	private IEntity entity;

	public FeaturesList(IEntity entity) {
		this.entity = entity;
	}

	public int size() {
		return entity.wSize();
	}

	public Object[] toArray() {
		Object[] result = new Object[size()];
		for (int i=0, size=size(); i<size; i++)
			result[i] = get(i);
		return result;
	}

	public IEntity get(int index) {
		return entity.wGet(index);
	}

	public IEntity set(int index, IEntity element) {
		IEntity oldValue = entity.wGet(index);
		entity.wSet(index, element);
		return oldValue;
	}

	public int indexOf(Object element) {
		return element instanceof IEntity ? entity.wIndexOf((IEntity) element) : -1;
	}
	public boolean contains(Object element) {
		return indexOf(element) != -1;
	}
}