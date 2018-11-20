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
package org.whole.lang.evaluators;

import java.util.Iterator;

import org.whole.lang.executables.AbstractExecutableEvaluatingStepper;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.IDataTypeWrapper;

/**
 * @author Riccardo Solmi
 */
public class CollectionEvaluator extends AbstractExecutableEvaluatingStepper {
	protected Iterable<?> collectionIterable;
	protected Iterator<?> collectionIterator;
	protected IDataTypeWrapper elementWrapper;

    public CollectionEvaluator() {
    	this(IDataTypeWrapper.identity, null);
    }
    public CollectionEvaluator(IDataTypeWrapper elementWrapper, Iterable<?> optCollectionIterable) {
    	this.elementWrapper = elementWrapper;
    	this.collectionIterable = optCollectionIterable;
    	if (optCollectionIterable != null)
    		this.collectionIterator = optCollectionIterable.iterator();
    }

	@Override
	public IExecutable clone(ICloneContext cc) {
		CollectionEvaluator evaluator = (CollectionEvaluator) super.clone(cc);
		if (collectionIterator != null)
			evaluator.collectionIterator = collectionIterable.iterator();
		return evaluator;
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

	public void reset(IEntity entity) {
		super.reset(entity);
		resetCollectionIterable(entity);
    }

	@Override
	public IEntity evaluateNext() {
		return collectionIterator.hasNext() ? lastEntity = elementWrapper.createEntity(collectionIterator.next()) : null;
	}

	@Override
	public IEntity evaluateRemaining() {
		if (collectionIterator.hasNext()) {
			Object value = null;
			do {
				value = collectionIterator.next();
			} while (collectionIterator.hasNext());
			return lastEntity = elementWrapper.createEntity(value);			
		} else
			return null;
	}

	public void prune() {
	}

    public void set(IEntity entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	lastEntity.wGetParent().wSet(lastEntity, entity);
    	lastEntity = entity;
    }
	public void add(IEntity entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

		IEntity parentEntity = lastEntity.wGetParent();
		parentEntity.wAdd(parentEntity.wIndexOf(lastEntity), entity);        
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	lastEntity.wGetParent().wRemove(lastEntity);
    	lastEntity = null;
	}
}
