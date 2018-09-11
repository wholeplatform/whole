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
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.IRunnable;

/**
 * @author Riccardo Solmi
 */
public class MultiValuedRunnableEvaluator<E extends IEntity> extends AbstractNestedEvaluator<E> {
	protected IExecutable<E> executableResult;
	protected IRunnable runnable;

	public MultiValuedRunnableEvaluator(IRunnable runnable, IExecutable<?>... argsIterators) {
		super(argsIterators);
		this.runnable = runnable;
	}
	public MultiValuedRunnableEvaluator(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<?>... argsIterators) {
		super(optionalArgsIndexes, argsIterators);
		this.runnable = runnable;
	}

	public IExecutable<E> clone(ICloneContext cc) {
		MultiValuedRunnableEvaluator<E> iterator = (MultiValuedRunnableEvaluator<E>) super.clone(cc);
		iterator.executableResult = cc.clone(executableResult);
		return iterator;
	}

	public void reset(IEntity entity) {
        super.reset(entity);
		executableResult = null;
    }

	@Override
	public E evaluateNext() {
		return lastEntity = getExecutableResult().evaluateNext();
	}

	@Override
	public E evaluateRemaining() {
		return lastEntity = getExecutableResult().evaluateRemaining();
	}

	protected IExecutable<E> getExecutableResult() {
		if (executableResult == null) {
			try {
				IBindingManager bm = getBindings();
				bm.setResult(null);

				try {
					runnable.run(selfEntity, bm, evaluateProducers());
		        } catch (Throwable e) {
		            throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), bm);
		        }

				executableResult = bm.getExecutableResult();
				if (bm.isExecutableResult())
					bm.setExecutableResult(null);

				resetExecutableResult(executableResult, selfEntity, bm);
			} catch (Throwable e) {
				executableResult = iteratorFactory().failureIterator(e);
				//TODO reset
			}
		}
		return executableResult;
	}
	protected void resetExecutableResult(IExecutable<E> executableResult, IEntity selfEntity, IBindingManager bm) {
		executableResult.setBindings(bm);
		executableResult.reset(selfEntity);
	}

    public void prune() {
    	if (executableResult != null)
    		executableResult.prune();
    }
	public void set(E entity) {
    	if (executableResult == null)
    		throw new IllegalStateException();

    	executableResult.set(entity);
	}
	public void add(E entity) {
    	if (executableResult == null)
    		throw new IllegalStateException();

    	executableResult.add(entity);
	}
	public void remove() {
    	if (executableResult == null)
    		throw new IllegalStateException();

    	executableResult.remove();
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append(runnable.toString());
		super.toString(sb);
	}
}
