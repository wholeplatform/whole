/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class BlockEvaluator extends AbstractDelegatingNestedEvaluator {
	protected IBindingScope accumulatedScope;
	protected IBindingScope selfEntityScope;

	public BlockEvaluator(IExecutable... executables) {
		super(executables);
	}

	@Override
	protected IBindingManager executorScope() {
		if (executorScope == null) {
			executorScope = BindingManagerFactory.instance.createBindingManager(
					accumulatedScope = BindingManagerFactory.instance.createSimpleScope(), getBindings().wGetEnvironmentManager());
			((IBindingManager) executorScope).wEnterScope(selfEntityScope = BindingManagerFactory.instance.createSimpleScope(), true);
		}

		return (IBindingManager) executorScope;
	}

	@Override
	protected void clearExecutorScope() {
		if (executorScope != null) {
			accumulatedScope.wClear();
			selfEntityScope.wClear();
		}
	}
	@Override
	protected void clearProducerScope() {
		if (executorScope != null) {
			selfEntityScope.wClear();
		}
	}

	public IEntity evaluateNext() {
		IEntity result = null;

		if (lastEntity != null)
			selfEntityScope.wClear();

		try {
			getBindings().wEnterScope(executorScope(), true);

			while (isNotLastProducer()) {
				getProducer().evaluateRemaining();
				selectFollowingProducer();
			}

			accumulatedScope.wAddAll(selfEntityScope);
			selfEntityScope.wClear();
			
			result = getProducer().evaluateNext();
		} finally {
//TODO ? alternate semantics with effects of all producers
//			getBindings().wExitScope(result != null);
			getBindings().wExitScope();
			if (result != null)
				getBindings().wAddAll(selfEntityScope);
		}

		return lastEntity = result;
	}

	public IEntity evaluateRemaining() {
		IEntity result = null;

		if (lastEntity != null)
			selfEntityScope.wClear();

		try {
			getBindings().wEnterScope(executorScope(), true);

			while (isNotLastProducer()) {
				getProducer().evaluateRemaining();
				selectFollowingProducer();
			}

			accumulatedScope.wAddAll(selfEntityScope);
			selfEntityScope.wClear();

			result = getProducer().evaluateRemaining();
		} finally {
			getBindings().wExitScope();
			if (result != null)
				getBindings().wAddAll(selfEntityScope);
		}

		return lastEntity = result;
	}
}

