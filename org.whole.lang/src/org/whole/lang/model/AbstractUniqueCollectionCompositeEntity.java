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
package org.whole.lang.model;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractUniqueCollectionCompositeEntity<E extends IEntity> extends AbstractCollectionCompositeEntity<E> {
	public int wIndexOf(IEntity entity) {
		IEntity childAdaptee = entity.wGetAdaptee(false);
		for (int i=0, size=elements.size(); i<size; i++)
			if (childAdaptee.wEquals(elements.get(i)))
			    return i;
		return -1;
	}

	public int lastIndexOf(Object o) {
		return indexOf(o);
	}

	public E set(int index, E entity) {
		int entityIndex = wIndexOf(entity);
		return entityIndex != -1 && entityIndex != index ? entity : super.set(index, entity);
	}

	public boolean add(E entity) {
		return wContains(entity) ? false : super.add(entity);
	}

    public void add(int index, E entity) {
		if (!wContains(entity))
			super.add(index, entity);
	}

	public boolean wAdd(int index, IEntity entity) {
		if (wContains(entity))
			return false;
		else {
			super.add(index, adaptElement(entity));
			return true;
		}
    }
}
