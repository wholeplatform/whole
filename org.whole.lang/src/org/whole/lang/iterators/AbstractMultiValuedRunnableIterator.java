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
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractMultiValuedRunnableIterator<E extends IEntity> extends AbstractRunnableIterator<E> {
	protected IEntityIterator<E> resultIterator;

	protected AbstractMultiValuedRunnableIterator(IEntityIterator<?>... argsIterators) {
		super(argsIterators);
	}
	protected AbstractMultiValuedRunnableIterator(int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		super(optionalArgsIndexes, argsIterators);
	}

	public IExecutable<E> clone(ICloneContext cc) {
		AbstractMultiValuedRunnableIterator<E> iterator = (AbstractMultiValuedRunnableIterator<E>) super.clone(cc);
		iterator.resultIterator = cc.clone(resultIterator);
		return iterator;
	}

	public void reset(IEntity entity) {
        super.reset(entity);
		resultIterator = null;
    }

	@Override
	public IBindingScope lookaheadScope() {
		return resultIterator != null ? resultIterator.lookaheadScope() : NullScope.instance;
	}

	protected IEntityIterator<E> getResultIterator() {
		if (resultIterator == null) {
			try {
				IBindingManager bm = getBindings();
				bm.setResult(null);

				try {
					run(selfEntity, bm);
		        } catch (Throwable e) {
		            throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), bm);
		        }

				resultIterator = (IEntityIterator<E>) bm.getExecutableResult().iterator();
				if (bm.isExecutableResult())
					bm.setExecutableResult(null);

				resetResultIterator(resultIterator, selfEntity, bm);
			} catch (Throwable e) {
				resultIterator = iteratorFactory().failureIterator(e);
				//TODO reset
			}
		}
		return resultIterator;
	}
	protected void resetResultIterator(IEntityIterator<E> resultIterator, IEntity selfEntity, IBindingManager bm) {
		resultIterator.setBindings(bm);
		resultIterator.reset(selfEntity);
	}


	public boolean hasNext() {
		return getResultIterator().hasNext();
	}

	public E lookahead() {
		return getResultIterator().lookahead();
	}

	public E next() {
    	return getResultIterator().next();
	}

    public void prune() {
    	if (resultIterator != null)
    		resultIterator.prune();
    }
	public void set(E entity) {
    	if (resultIterator == null)
    		throw new IllegalStateException();

    	resultIterator.set(entity);
	}
	public void add(E entity) {
    	if (resultIterator == null)
    		throw new IllegalStateException();

    	resultIterator.add(entity);
	}
	public void remove() {
    	if (resultIterator == null)
    		throw new IllegalStateException();

    	resultIterator.remove();
	}
}
