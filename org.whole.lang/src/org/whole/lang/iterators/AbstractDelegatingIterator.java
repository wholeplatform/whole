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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class AbstractDelegatingIterator<E extends IEntity> extends AbstractLazyCloneableIterator<E> {
	private IEntityIterator<E> iterator;
	private boolean lazyClone;

	public AbstractDelegatingIterator() {
	}
	public AbstractDelegatingIterator(IEntityIterator<E> iterator) {
		this.iterator = iterator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractDelegatingIterator<E> iterator = (AbstractDelegatingIterator<E>) super.clone(cc);
		iterator.lazyClone = lazyClone = this.iterator != null;
		return iterator;
	}

	protected boolean isLazyCloneEmpty() {
		return !lazyClone;
	}

	public IEntityIterator<E> getIterator() {
		if (lazyClone) {
			withIterator(getCloneContext().clone(iterator));
			iterator.setBindings(bindings);
			if (resetEntity != null)
				iterator.reset(resetEntity);
		}
		return iterator;
	}
	public IEntityIterator<E> withIterator(IEntityIterator<E> iterator) {
		this.iterator = iterator;
		lazyClone = false;
		updateCloneContext();
		return this;
	}

	public void setBindings(IBindingManager bindings) {
		this.bindings = bindings;
		if (!lazyClone)
			getIterator().setBindings(bindings);
	}

	public void add(E entity) {
		getIterator().add(entity);
	}

	public boolean hasNext() {
		return getIterator().hasNext();
	}

	public E lookahead() {
		return getIterator().lookahead();
	}

	public IBindingScope lookaheadScope() {
		return getIterator().lookaheadScope();
	}

	public E next() {
		return getIterator().next();
	}

	public void prune() {
		getIterator().prune();
	}

	public void remove() {
		getIterator().remove();
	}

	public void reset(IEntity entity) {
		this.resetEntity = entity;
		if (!lazyClone)
			getIterator().reset(entity);
	}

	public void set(E entity) {
		getIterator().set(entity);
	}

	@Override
	public void toString(StringBuilder sb) {
    	sb.append(iterator.toString());
	}
}
