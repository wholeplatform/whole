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

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class MultiValuedRunnableEvaluator<E extends IEntity> extends AbstractNestedEvaluator<E> {
	protected Set<Integer> optionalProducersIndexSet;
	protected IExecutable<E> executableResult;
	protected IRunnable runnable;

	public MultiValuedRunnableEvaluator(IRunnable runnable, IExecutable<IEntity>... argsExecutables) {
		super(argsExecutables);
		optionalProducersIndexSet = Collections.emptySet();
		this.runnable = runnable;
	}
	public MultiValuedRunnableEvaluator(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<IEntity>... argsExecutables) {
		super(argsExecutables);
		optionalProducersIndexSet = Arrays.stream(optionalArgsIndexes).boxed().collect(Collectors.toSet());
		this.runnable = runnable;
	}

	public IExecutable<E> clone(ICloneContext cc) {
		MultiValuedRunnableEvaluator<E> evaluator = (MultiValuedRunnableEvaluator<E>) super.clone(cc);
		evaluator.executableResult = cc.clone(executableResult);
		return evaluator;
	}

	public void reset(IEntity entity) {
        super.reset(entity);
		executableResult = null;
    }

	protected IEntity[] evaluateProducers() {
		IEntity[] arguments = null;
    	IBindingManager bm = getBindings();
    	arguments = new IEntity[producersSize()];
    	for (int i=0; i<producersSize(); i++) {
    		arguments[i] = getProducer(i).evaluateRemaining();
    		if (arguments[i] == null && !optionalProducersIndexSet.contains(i))
    			throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(getProducer(i).getSourceEntity()).withBindings(bm);
    	}
        return arguments;
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
				executableResult = executableFactory().createFailure(e);
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

	protected String toStringPrefix() {
		return runnable.toString()+"(";
	}
}
