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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.executables.IExecutable;
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
	public IExecutable<E> clone(ICloneContext cc) {
		AbstractPointwiseIterator<E> iterator = (AbstractPointwiseIterator<E>) super.clone(cc);
		iterator.toIterator = cc.clone(toIterator);
		return iterator;
	}

    protected void setProducersBindings(IBindingManager bindings) {
		super.setProducersBindings(bindings);
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

		try {
			nextEntity = doLookahead(toLookahead, nextEntity);
		} catch(Exception e) {
			throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), getBindings());
		}

		return nextEntity;
	}
	protected abstract E doLookahead(IEntity toLookahead, E nextEntity);

	public E next() {
		E result = lookahead();
		if (result == null)
			throw new NoSuchElementException();

		super.next();
		IEntity toEntity = toIterator.next();

		try {
			doNext(toEntity, result);
		} catch(Exception e) {
			throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), getBindings());
		}

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
