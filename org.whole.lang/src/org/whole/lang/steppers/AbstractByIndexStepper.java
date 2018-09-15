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
package org.whole.lang.steppers;

import java.util.NoSuchElementException;

import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.executables.AbstractExecutableSteppingEvaluator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * Returns the immediate elements of the self entity in selected order and range.
 * 
 * @author Riccardo Solmi
 */
public abstract class AbstractByIndexStepper<E extends IEntity> extends AbstractExecutableSteppingEvaluator<E> implements IEntityIterator<E> {
	protected IEntity selfEntity; //parent
	protected int nextIndex;
	protected int lastIndex = -1;
	protected boolean forward;
	protected FirstIndexSupplier firstIndexSupplier;

	@FunctionalInterface
	public interface FirstIndexSupplier {
	    int firstIndex(AbstractByIndexStepper<?> iterator);
	}

	public AbstractByIndexStepper(boolean forward) {
		this.forward = forward;
		this.firstIndexSupplier = (i) -> i.forward ? 0 : i.endIndex()-i.startIndex();
	}
	public AbstractByIndexStepper(boolean forward, int relativeFirstIndex) {
		this.forward = forward;
		this.firstIndexSupplier = (i) -> relativeFirstIndex >= 0 ? relativeFirstIndex : i.endIndex()-i.startIndex() + relativeFirstIndex+1;
	}
	public AbstractByIndexStepper(boolean forward, FirstIndexSupplier firstIndexSupplier) {
		this.forward = forward;
		this.firstIndexSupplier = firstIndexSupplier;
	}

	public void reset(IEntity entity) {
		this.selfEntity = entity;
		nextIndex = entity != null ? firstIndexSupplier.firstIndex(this) : -1;
		lastIndex = -1;
	}

	protected abstract int startIndex();
	protected abstract int endIndex();

	public IEntityIterator<E> iterator() {
		return this;
	}

	public boolean hasNext() {
		return selfEntity != null && (forward ? startIndex() + nextIndex <= endIndex() : nextIndex >= 0);
	}

	@SuppressWarnings("unchecked")
	public final E get() {
		return (E) selfEntity.wGet(startIndex() + nextIndex);
	}

	public E next() {
		E nextEntity = evaluateNext();
		if (nextEntity == null)
			throw new NoSuchElementException();

		return nextEntity;
	}

	public E lookahead() {
		return hasNext() ? get() : null;
	}

	public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	@Override
	public E evaluateRemaining() {
		E result = null;
		E next;
		while ((next = evaluateNext()) != null)
			result = next;
		return result;
	}

	@Override
	public E evaluateSingleton() {
		if (hasNext()) {
			E nextEntity = evaluateNext();
			if (!hasNext())
				return nextEntity;
		}

		throw new IllegalArgumentException("The result is not a singleton");
	}

	public void callNext() {
		if (hasNext()) {
			accept(get());
		} else
			done();
	}

	public void callRemaining() {
		while (hasNext()) {
			accept(get());
		}
		done();
	}

	@Override
	public void accept(IEntity entity) {
		lastIndex = nextIndex;
		nextIndex += forward ? +1 : -1;
		super.accept(entity);
	}

	public void prune() {
	}

	public int nextIndex() {
		return nextIndex;
	}
	public void set(E value) {
		if (lastIndex == -1)
			throw new IllegalStateException();

		selfEntity.wSet(startIndex() + lastIndex, value);
	}
	public void add(E value) {
		if (lastIndex == -1)
			throw new IllegalStateException();

		if (forward) {
			selfEntity.wAdd(startIndex() + lastIndex, value);
			lastIndex = nextIndex++;
		} else
			selfEntity.wAdd(startIndex() + lastIndex+1, value);
	}
	public void remove() {
		if (lastIndex == -1)
			throw new IllegalStateException();

		selfEntity.wRemove(startIndex() + lastIndex);
		if (forward && EntityUtils.isComposite(selfEntity))
			nextIndex = lastIndex;
		lastIndex = -1;
	}
}
