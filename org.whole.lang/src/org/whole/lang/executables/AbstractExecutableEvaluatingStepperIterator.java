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
package org.whole.lang.executables;

import java.util.NoSuchElementException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 * 
 * TODO keep same code in the two classes except declaration line
 */
//public abstract class AbstractExecutableSteppingEvaluatingIterator<E extends IEntity> extends AbstractExecutableSteppingEvaluator<E> implements IEntityIterator<E> {
public abstract class AbstractExecutableEvaluatingStepperIterator<E extends IEntity> extends AbstractExecutableEvaluatingStepper<E> implements IEntityIterator<E> {
	protected IBindingScope executorScope;
	protected boolean mergeLookaheadScope = true;
	protected boolean lookaheadIsCached;
	protected E lookaheadEntity;
    protected E lastEntity;

	@Override
    public IExecutable<E> clone(ICloneContext cc) {
    	AbstractExecutableEvaluatingStepperIterator<E> executor = (AbstractExecutableEvaluatingStepperIterator<E>) super.clone(cc);
		executor.executorScope = executorScope != null ? executorScope.clone() : null;
		return executor;
    }

    public void reset(IEntity entity) {
    	lookaheadIsCached = false;
		lookaheadEntity = null;
		lastEntity = null;
		clearExecutorScope();
   }

	public IEntityIterator<E> iterator() {
		return this;
	}

	public final boolean hasNext() {
		try {
			return cachedEvaluateNext(false) != null;
		} catch (Exception e) {
			return false;
		}
	}

	public final E next() {
		E nextEntity = cachedEvaluateNext(true);
		if (nextEntity == null)
			throw new NoSuchElementException();

		//TODO uncomment for testing merge scope issues
//		IBindingScope scope = lookaheadScope();
//		if (scope != NullScope.instance) {
//			boolean useLocalNames = scope.wEnclosingScope() == this || scope.wEnclosingScope() == NullScope.instance;
//			Set<String> names = useLocalNames ? scope.wLocalNames() : scope.wNames();
//			for (String name : names) {
//				IEntity actualValue = getBindings().wGet(name);
//				IEntity localValue = scope.wGet(name);
//				if (actualValue != localValue)
//					getBindings().wDef(name, scope.wGet(name)); //should never stop with a breakpoint here
//			}
//		}

    	lookaheadIsCached = false;
		lookaheadEntity = null;
		return lastEntity = nextEntity;
	}

	public final E lookahead() {
		return cachedEvaluateNext(false);
	}
	protected final E cachedEvaluateNext(boolean merge) {
		if (!lookaheadIsCached) {
			lookaheadIsCached = true;

			E cachedLastEntity = lastEntity;
			lookaheadEntity = scopedEvaluateNext(merge);
			lastEntity = cachedLastEntity;

		} else if (merge && lookaheadEntity != null)
			getBindings().wAddAll(lookaheadScope());

		return lookaheadEntity;
	}
	protected E scopedEvaluateNext(boolean merge) {
		getBindings().wEnterScope(lookaheadScope(), true);
		E result = evaluateNext();
		getBindings().wExitScope(merge && result != null);
		return result;
	}

	public IBindingScope lookaheadScope() {
		return executorScope();
	}
	protected void clearLookaheadScope() {
		clearExecutorScope();
	}

	protected IBindingScope executorScope() {
		if (executorScope == null)
			executorScope = BindingManagerFactory.instance.createSimpleScope();
		return executorScope;
	}
	protected void clearExecutorScope() {
		if (executorScope != null) {
//			if (lastEntity != null)
//				for (String name : executorScope.wTargetNames())
//					getBindings().wUnset(name);
			executorScope.wClear();
		}
	}
	protected boolean needClearExecutorScope(/*int producerIndex*/) {
		return true;
	}
	protected void clearProducerScope(/*int producerIndex*/) {
		clearExecutorScope();
	}
	protected boolean needMergeExecutorScope(/*int producerIndex*/) {
		return mergeLookaheadScope;
	}
}

