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
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractFilterIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
	protected IEntityIterator<E> iterator;
	private int nextIndex = 0;
	private E nextEntity = null;
    private E lastEntity;
	private boolean autoPrune = false;

	protected AbstractFilterIterator(IEntityIterator<E> iterator) {
		this.iterator = iterator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractFilterIterator<E> iterator = (AbstractFilterIterator<E>) super.clone(cc);
		iterator.iterator = cc.clone(this.iterator);
		return iterator;
	}

    public void setBindings(IBindingManager bindings) {
		iterator.setBindings(bindings);
	}

	public int nextIndex() {
		return nextIndex;
	}

	public final boolean hasNext() {
		return lookahead() != null;
	}
	public E next() {
		E result = lookahead();
		if (result == null)
			throw new NoSuchElementException();

		iterator.next();
		nextIndex++;
		nextEntity = null;
		if (autoPrune)
			prune();
		return lastEntity = result;
	}

	public final E lookahead() {
		if (nextEntity == null)
			nextEntity = filteredLookahead();
		return nextEntity;
	}
	protected abstract E filteredLookahead();
	
    public void reset(IEntity entity) {
    	iterator.reset(entity);
    	nextIndex = 0;
		lastEntity = null;
    	nextEntity = null;
    }

	public boolean autoPrune() {
		return autoPrune;
	}
	public AbstractFilterIterator<E> withAutoPrune(boolean value) {
		autoPrune = value;
		return this;
	}

	public void prune() {
		nextEntity = null;
		iterator.prune();
	}

	public void set(E value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wSet(lastEntity, value);
    	lastEntity = value;
	}
	public void add(E value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	iterator.add(value);
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	iterator.remove();
    	lastEntity = null;
	}

	public boolean skip(int count) {
		while (count-- >0 && hasNext())
			next();
		return count < 0;
	}
}
