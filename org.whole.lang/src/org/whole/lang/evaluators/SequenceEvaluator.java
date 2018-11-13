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

import org.whole.lang.bindings.BindingManager;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class SequenceEvaluator<E extends IEntity> extends AbstractDelegatingNestedEvaluator<E> {
	protected IBindingScope selfEntityScope;
	protected IBindingScope lastEntityScope;

	@SuppressWarnings("unchecked")
	public SequenceEvaluator(IExecutable<IEntity>... executables) {
		super(executables);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		lastEntityScope = null;
	}

	@Override
	public IBindingScope lookaheadScope() {
		return selfEntityScope != null ? selfEntityScope : NullScope.instance;
	}

	@Override
	protected IBindingManager executorScope() {
		if (executorScope == null)
			executorScope = BindingManagerFactory.instance.createBindingManager(
					selfEntityScope = BindingManagerFactory.instance.createSimpleScope(), getBindings().wGetEnvironmentManager());

		return (IBindingManager) executorScope;
	}

	@Override
	protected void clearExecutorScope() {
		if (executorScope != null) {
			((BindingManager) executorScope).wSetTargetScope(selfEntityScope = BindingManagerFactory.instance.createSimpleScope());
		}
	}

	@Override
	protected E scopedEvaluateNext(boolean merge) {
		mergeLookaheadScope = merge;
		E result = evaluateNext();
		mergeLookaheadScope = true;
		return result;
	}

	@SuppressWarnings("unchecked")
	public E evaluateNext() {
		IEntity result = null;

		if (lastEntity != null) {
			lastEntityScope = selfEntityScope.clone();
			selfEntityScope.wClear();
		}

		try {
			getBindings().wEnterScope(executorScope(), true);

			while (isValidProducer()) {
				result = getProducer().evaluateNext();

				if (result != null) {
					break;
				} else if (isNotLastProducer()) {
					if (lastEntityScope != null)
						selfEntityScope.wAddAll(lastEntityScope);
					executorScope().wEnterScope(selfEntityScope = BindingManagerFactory.instance.createSimpleScope(), true);
				}
				selectFollowingProducer();
			}
		} finally {
//TODO ? alternate semantics with effects of all producers
//			getBindings().wExitScope(needMergeExecutorScope() && result != null);
			getBindings().wExitScope();
			if (needMergeExecutorScope() && result != null) {
				getBindings().wAddAll(selfEntityScope);
			}
		}

		return lastEntity = (E) result;
	}

	@SuppressWarnings("unchecked")
	public E evaluateRemaining() {
		IEntity result = null;

		if (lastEntity != null)
			selfEntityScope.wClear();

		try {
			getBindings().wEnterScope(executorScope(), true);

			while (isValidProducer()) {
				result = getProducer().evaluateRemaining();

				if (isLastProducer())
					break;

				executorScope().wEnterScope(selfEntityScope = BindingManagerFactory.instance.createSimpleScope(), true);
				selectFollowingProducer();
			}
		} finally {
			getBindings().wExitScope();
			if (needMergeExecutorScope() && result != null) {
				getBindings().wAddAll(selfEntityScope);
			}
		}

		return lastEntity = (E) result;
	}
}

