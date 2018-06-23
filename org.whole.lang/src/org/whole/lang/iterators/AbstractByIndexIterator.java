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

import java.util.NoSuchElementException;

import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * Iterator that returns all immediate elements of a given IEntity in order.
 * 
 * @author Riccardo Solmi
 */
public abstract class AbstractByIndexIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
	protected IEntity entity; //parent
	protected int nextIndex;
	protected int lastIndex = -1;
	protected boolean forward;
	protected FirstIndexSupplier firstIndexSupplier;

	@FunctionalInterface
	public interface FirstIndexSupplier {
	    int firstIndex(AbstractByIndexIterator<?> iterator);
	}

	protected AbstractByIndexIterator(boolean forward) {
		this.forward = forward;
		this.firstIndexSupplier = (i) -> i.forward ? 0 : i.endIndex()-i.startIndex();
	}
	protected AbstractByIndexIterator(boolean forward, int relativeFirstIndex) {
		this.forward = forward;
		this.firstIndexSupplier = (i) -> relativeFirstIndex >= 0 ? relativeFirstIndex : i.endIndex()-i.startIndex() + relativeFirstIndex+1;
	}
	protected AbstractByIndexIterator(boolean forward, FirstIndexSupplier firstIndexSupplier) {
		this.forward = forward;
		this.firstIndexSupplier = firstIndexSupplier;
	}

	protected abstract int startIndex();
	protected abstract int endIndex();

	public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	public boolean hasNext() {
		return entity != null && (forward ? startIndex() + nextIndex <= endIndex() : nextIndex >= 0);
	}

	@SuppressWarnings("unchecked")
	public E next() {
		try {
			lastIndex = nextIndex;
			nextIndex += forward ? +1 : -1;
			return (E) entity.wGet(startIndex() + lastIndex);
		} catch (Exception e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public E lookahead() {
		return hasNext() ? (E) entity.wGet(startIndex() + nextIndex) : null;
	}

	public void reset(IEntity entity) {
		this.entity = entity;
		nextIndex = entity != null ? firstIndexSupplier.firstIndex(this) : -1;
		lastIndex = -1;
	}

	public void prune() {
	}

	public int nextIndex() {
		return nextIndex;
	}
	public void set(E value) {
		if (lastIndex == -1)
			throw new IllegalStateException();

		entity.wSet(startIndex() + lastIndex, value);
	}
	public void add(E value) {
		if (lastIndex == -1)
			throw new IllegalStateException();

		if (forward) {
			entity.wAdd(startIndex() + lastIndex, value);
			lastIndex = nextIndex++;
		} else
			entity.wAdd(startIndex() + lastIndex+1, value);
	}
	public void remove() {
		if (lastIndex == -1)
			throw new IllegalStateException();

		entity.wRemove(startIndex() + lastIndex);
		if (forward && EntityUtils.isComposite(entity))
			nextIndex = lastIndex;
		lastIndex = -1;
	}
}
