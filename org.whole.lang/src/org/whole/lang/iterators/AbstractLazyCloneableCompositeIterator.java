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

import java.util.BitSet;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractLazyCloneableCompositeIterator<E extends IEntity> extends AbstractLazyCloneableIterator<E> {
	protected BitSet lazyClone;

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractLazyCloneableCompositeIterator<E> iterator = (AbstractLazyCloneableCompositeIterator<E>) super.clone(cc);
		iterator.initLazyClone(true);
		lazyClone.set(0, childIteratorSize());
		return iterator;
	}

	protected boolean isLazyCloneEmpty() {
		return lazyClone.isEmpty();
	}

	protected void initLazyClone(boolean value) {
		lazyClone = new BitSet(childIteratorSize());
		lazyClone.set(0, childIteratorSize(), value);
	}

	public void setBindings(IBindingManager bm) {
		if (bindings != bm) {
			bindings = bm;
			for (int i=0; i<childIteratorSize(); i++)
				if (!lazyClone.get(i))
					getChildIterator(i).setBindings(bm);
		}
	}

	public void reset(IEntity entity) {
		resetEntity = entity;
		if (lazyReset())
			for (int i=0; i<childIteratorSize(); i++)
				if (!lazyClone.get(i))
					getChildIterator(i).reset(entity);
	}

	protected boolean lazyReset() {
		return resetEntity != null;
	}

	public abstract int childIteratorSize();

	public IEntityIterator<?> getChildIterator(int index) {
		if (lazyClone.get(index)) {
			setChildIterator(index, getCloneContext().clone(childIterator(index)));
			childIterator(index).setBindings(bindings);
			if (lazyReset())
				childIterator(index).reset(resetEntity);
		}
		return childIterator(index);
	}
	protected abstract IEntityIterator<?> childIterator(int index);
	public void setChildIterator(int index, IEntityIterator<?> iterator) {
		childIterator(index, iterator);
		lazyClone.clear(index);
		updateCloneContext();
	}
	protected abstract void childIterator(int index, IEntityIterator<?> iterator);	
}
