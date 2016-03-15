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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.comparators.BusinessIdentityComparator;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCollectIterator extends AbstractLazyCloneableIterator<IEntity> {
	protected IEntityComparator<IEntity> comparator;
	private IEntityIterator<? extends IEntity>[] iteratorChain;
	private boolean lazyCloneChain;
	protected IEntity nextEntity = null;
	protected boolean collected = false;

	protected AbstractCollectIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		this(BusinessIdentityComparator.instance, iteratorChain);
	}
	protected AbstractCollectIterator(IEntityComparator<IEntity> comparator, IEntityIterator<? extends IEntity>... iteratorChain) {
		this.comparator = comparator;
		this.iteratorChain = iteratorChain;
		lazyCloneChain = false;
	}

	@Override
	public IEntityIterator<IEntity> clone(ICloneContext cc) {
		AbstractCollectIterator iterator = (AbstractCollectIterator) super.clone(cc);
		iterator.comparator = cc.clone(comparator);
		iterator.iteratorChain = iteratorChain.clone();
		iterator.lazyCloneChain = lazyCloneChain = true;
		return iterator;
	}

	protected boolean isLazyCloneEmpty() {
		return !lazyCloneChain;
	}

	public AbstractCollectIterator withComparator(IEntityComparator<IEntity> comparator) {
		this.comparator = comparator;
		return this;
	}

	public IEntityIterator<? extends IEntity>[] getIteratorChain() {
		if (lazyCloneChain) {
			for (int i=0; i<iteratorChain.length; i++) {
				iteratorChain[i] = getCloneContext().clone(iteratorChain[i]);
				iteratorChain[i].setBindings(bindings);
				if (resetEntity != null)
					iteratorChain[i].reset(resetEntity);
			}
			lazyCloneChain = false;
			updateCloneContext();
		}
		return iteratorChain;
	}

	public void setBindings(IBindingManager bindings) {
		this.bindings = bindings;
		comparator.setBindings(bindings);
		if (!lazyCloneChain)
			for (int i=0; i<iteratorChain.length; i++)
				iteratorChain[i].setBindings(bindings);
	}

	public boolean hasNext() {
		return lookahead() != null;
	}
	public IEntity next() {
		IEntity result = lookahead();
		if (result == null)
			throw new NoSuchElementException();

		nextEntity = null;
		return result;
	}
	public IEntity lookahead() {
		if (nextEntity != null)
			return nextEntity;

		if (collected)
			return null;

		collected = true;
		return nextEntity = collect(getIteratorChain());
	}
	protected abstract IEntity collect(IEntityIterator<? extends IEntity>[] iteratorChain);

	protected IEntity createResult() {
		return createResult(false);
	}
	protected IEntity createResult(boolean withContainment) {
		return BindingManagerFactory.instance.createTuple(withContainment);
	}

	public void set(IEntity entity) {
		throw new UnsupportedOperationException();
	}
	public void add(IEntity entity) {
		throw new UnsupportedOperationException();
	}
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void reset(IEntity entity) {
		nextEntity = null;
		collected = false;
		resetEntity = entity;
		if (!lazyCloneChain)
			for (int i=0; i<iteratorChain.length; i++)
				iteratorChain[i].reset(entity);
	}

	public void prune() {
	}

	public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}
}
