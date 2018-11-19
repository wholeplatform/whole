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

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import org.whole.lang.executables.AbstractExecutableEvaluatingStepper;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractPureConditionalSupplierEvaluator<E extends IEntity> extends AbstractExecutableEvaluatingStepper<E> implements Supplier<E> {
    protected boolean isEvaluated;
	protected IEntity selfEntity;

	public void reset(IEntity entity) {
		super.reset(entity);
		isEvaluated = false;
        selfEntity = entity;
    }

	public boolean hasNext() {
		return !(isEvaluated || EntityUtils.isNull(selfEntity));
	}

	public E next() {
		E nextEntity = evaluateNext();
		if (nextEntity == null)
			throw new NoSuchElementException();

		return nextEntity;
	}

	public E evaluateNext() {
		if (hasNext()) {
			isEvaluated = true;

			return lastEntity = get();
		} else
			return null;
	}

	@Override
	public E evaluateRemaining() {
		return evaluateNext();
	}

	@Override
	public E evaluateSingleton() {
		if (hasNext())
			return evaluateNext();
		else
			throw new IllegalArgumentException("The result is not a singleton");
	}


    public void prune() {
    }

    public void set(E entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wSet(lastEntity, entity);
    	lastEntity = entity;
    }
	public void add(E value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	if (EntityUtils.hasParent(lastEntity)) {
    		IEntity lastEntityParent = lastEntity.wGetParent();
    		lastEntityParent.wAdd(lastEntityParent.wIndexOf(lastEntity), value);
    	}
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wRemove(lastEntity);
    	lastEntity = null;
	}
}
