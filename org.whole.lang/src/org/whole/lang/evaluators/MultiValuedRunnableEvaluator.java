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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.IRunnable;

/**
 * @author Riccardo Solmi
 */
public class MultiValuedRunnableEvaluator<E extends IEntity> extends AbstractNestedEvaluator<E> {
	protected IEntityIterator<E> resultIterator;
	protected IRunnable runnable;

	public MultiValuedRunnableEvaluator(IRunnable runnable, IEntityIterator<?>... argsIterators) {
		super(argsIterators);
		this.runnable = runnable;
	}
	public MultiValuedRunnableEvaluator(IRunnable runnable, int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		super(optionalArgsIndexes, argsIterators);
		this.runnable = runnable;
	}

	public IEntityIterator<E> clone(ICloneContext cc) {
		MultiValuedRunnableEvaluator<E> iterator = (MultiValuedRunnableEvaluator<E>) super.clone(cc);
		iterator.resultIterator = cc.clone(resultIterator);
		return iterator;
	}

	public void reset(IEntity entity) {
        super.reset(entity);
		resultIterator = null;
    }

	@Override
	public E evaluateNext() {
		return lastEntity = getResultIterator().evaluateNext();
	}

	@Override
	public E evaluateRemaining() {
		return lastEntity = getResultIterator().evaluateRemaining();
	}

	protected IEntityIterator<E> getResultIterator() {
		if (resultIterator == null) {
			try {
				IBindingManager bm = getBindings();
				bm.setResult(null);

				try {
					runnable.run(selfEntity, bm, evaluateProducers());
		        } catch (Throwable e) {
		            throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), bm);
		        }

				resultIterator = bm.getResultIterator();
				if (bm.hasResultIterator())
					bm.setResultIterator(null);

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

	@Override
	public void toString(StringBuilder sb) {
		sb.append(runnable.toString());
		super.toString(sb);
	}
}
