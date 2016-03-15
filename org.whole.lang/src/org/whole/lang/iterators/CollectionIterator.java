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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.IDataTypeWrapper;

/**
 * @author Riccardo Solmi
 */
public class CollectionIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
	protected Iterable<?> collectionIterable;
	protected Iterator<?> collectionIterator;
	protected IDataTypeWrapper elementWrapper;
    private E lastEntity;
	private E nextEntity;

    protected CollectionIterator() {
    	this(IDataTypeWrapper.identity, null);
    }
    protected CollectionIterator(IDataTypeWrapper elementWrapper, Iterable<?> optCollectionIterable) {
    	this.elementWrapper = elementWrapper;
    	this.collectionIterable = optCollectionIterable;
    	if (optCollectionIterable != null)
    		this.collectionIterator = optCollectionIterable.iterator();
    }

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		CollectionIterator<E> iterator = (CollectionIterator<E>) super.clone(cc);
		if (collectionIterator != null)
			iterator.collectionIterator = collectionIterable.iterator();
		return iterator;
	}

	protected void resetCollectionIterable(IEntity entity) {
		collectionIterable = getCollectionIterable(entity);
		collectionIterator = collectionIterable.iterator();
	}
	protected Iterable<?> getCollectionIterable(IEntity entity) {
    	if (collectionIterable == null)
    		throw new UnsupportedOperationException();		

		return collectionIterable;
	}

	public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	public void reset(IEntity entity) {
		lastEntity = null;
		nextEntity = null;
		resetCollectionIterable(entity);
    }

	public void setBindings(IBindingManager bindings) {
	}

	public void prune() {
	}

	public final boolean hasNext() {
		return nextEntity != null || collectionIterator.hasNext();
	}
	public final E next() {
		E result = lookahead();
		nextEntity = null;
		return lastEntity = result;
	}

	public final E lookahead() {
		if (nextEntity == null && collectionIterator.hasNext())
			nextEntity = elementWrapper.createEntity(collectionIterator.next());

		return nextEntity;
	}

    public void set(E entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	lastEntity.wGetParent().wSet(lastEntity, entity);
    	lastEntity = entity;
    }
	public void add(E value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

		IEntity parentEntity = lastEntity.wGetParent();
		parentEntity.wAdd(parentEntity.wIndexOf(lastEntity), value);        
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	lastEntity.wGetParent().wRemove(lastEntity);
    	lastEntity = null;
	}
}
