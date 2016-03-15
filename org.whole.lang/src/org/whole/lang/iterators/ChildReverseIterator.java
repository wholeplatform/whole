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
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ChildReverseIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
    protected IEntity entity; //parent
    protected int nextIndex; //zero relative
    private int firstIndex;
    private int lastIndex = -1;

    protected ChildReverseIterator() {
    	this(Integer.MAX_VALUE);
    }
    protected ChildReverseIterator(int firstIndex) {
        this.firstIndex = firstIndex;
    }

	public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	public boolean hasNext() {
        return entity != null && nextIndex >= 0;
    }
	@SuppressWarnings("unchecked")
	public E next() {
		return (E) entity.wGet(lastIndex = nextIndex--);
	}

	@SuppressWarnings("unchecked")
	public E lookahead() {
		try {
			return (E) entity.wGet(nextIndex);
		} catch (IndexOutOfBoundsException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
    }

    public void reset(IEntity entity) {
        this.entity = entity;
        nextIndex = firstIndex != Integer.MAX_VALUE ? firstIndex : entity != null ? entity.wSize()-1 : -1;
        lastIndex = -1;
    }

    public void setBindings(IBindingManager bindings) {
    }

    public void prune() {
    }

    public int nextIndex() {
    	return nextIndex;
    }
   public void set(E value) {
    	if (lastIndex == -1)
    		throw new IllegalStateException();

    	entity.wSet(lastIndex, value);
    }
    public void add(E value) {
		if (lastIndex == -1)
			throw new IllegalStateException();

    	entity.wAdd(lastIndex+1, value);
    }
    public void remove() {
    	if (lastIndex == -1)
    		throw new IllegalStateException();

        entity.wRemove(lastIndex);
        lastIndex = -1;
    }
}
