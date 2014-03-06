/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.iterators;

import java.util.NoSuchElementException;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.AbstractDelegatingIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractPointwiseIterator<E extends IEntity> extends AbstractDelegatingIterator<E> {
	protected IEntityIterator<? super E> toIterator;
	private E nextEntity = null;

	protected AbstractPointwiseIterator(IEntityIterator<E> valuesIterator, IEntityIterator<? super E> toIterator) {
		super(valuesIterator);
		this.toIterator = toIterator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractPointwiseIterator<E> iterator = (AbstractPointwiseIterator<E>) super.clone(cc);
		iterator.toIterator = cc.clone(toIterator);
		return iterator;
	}

    public void setBindings(IBindingManager bindings) {
		super.setBindings(bindings);
		toIterator.setBindings(bindings);
	}

	public boolean hasNext() {
		return super.hasNext() && toIterator.hasNext();
	}

	public E lookahead() {
		if (nextEntity != null)
			return nextEntity;

		IEntity toLookahead = toIterator.lookahead();
		if (toLookahead == null)
			return null;

		nextEntity = super.lookahead();
		if (nextEntity == null)
			return null;

		nextEntity = doLookahead(toLookahead, nextEntity);

		return nextEntity;
	}
	protected abstract E doLookahead(IEntity toLookahead, E nextEntity);

	public E next() {
		E result = lookahead();
		if (result == null)
			throw new NoSuchElementException();

		super.next();
		IEntity toEntity = toIterator.next();

		doNext(toEntity, result);

		nextEntity = null;
		return result;
	}
	protected abstract void doNext(IEntity toEntity, E nextEntity);

	public void reset(IEntity entity) {
		super.reset(entity);
		toIterator.reset(entity);
		nextEntity = null;
	}
}
