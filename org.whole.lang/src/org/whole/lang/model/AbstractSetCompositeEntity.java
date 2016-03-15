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

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractSetCompositeEntity<E extends IEntity> extends AbstractUniqueCollectionCompositeEntity<E> implements Set<E> {
	protected Set<E> childrenSet;

	@Override
	protected void initElements(int initialCapacity) {
		super.initElements(initialCapacity);
		childrenSet = new HashSet<E>(initialCapacity);
	}

    @SuppressWarnings("unchecked")
	public IEntity wShallowClone() {
    	AbstractSetCompositeEntity<E> entity = (AbstractSetCompositeEntity<E>) super.wShallowClone();
    	entity.childrenSet = (Set<E>) ((HashSet<E>) entity.childrenSet).clone();
    	return entity;
	}

	@Override
	protected boolean elementsContains(IEntity entity) {
		if (childrenSet.contains(entity))
			return true;
		return super.elementsContains(entity);
	}

	@Override
	protected void elementsAdd(E entity) {
		childrenSet.add(entity);
	}

	@Override
	protected void elementsRemove(E entity) {
		childrenSet.remove(entity);
	}

	@Override
	protected void elementsFill(int uptoSize) {
	}

    public String toDebugString() {
    	return childrenSet.toString();
    }
}
