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
package org.whole.lang.iterators;

import java.util.Iterator;

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCloneableIterator<E extends IEntity> implements IEntityIterator<E> {
	private IEntity sourceEntity;
	public IEntityIterator<E> withSourceEntity(IEntity entity) {
		sourceEntity = entity;
		return this;
	}
	public IEntity getSourceEntity() {
		return sourceEntity;
	}
	
	public IEntityIterator<E> clone() {
		return clone(new CloneContext());
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<E> clone(ICloneContext cc) {
		try {
			AbstractCloneableIterator<E> iterator = (AbstractCloneableIterator<E>) super.clone();
			cc.putClone(this, iterator);
			return iterator;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	public Iterator<E> iterator() {
		return this;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(sb);
		return sb.toString();
	}
	public void toString(StringBuilder sb) {
	}
}
