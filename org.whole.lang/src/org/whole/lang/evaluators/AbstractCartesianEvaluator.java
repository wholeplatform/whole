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
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCartesianEvaluator extends AbstractDelegatingNestedEvaluator {
	protected IEntity[] nestedResults;

	public AbstractCartesianEvaluator(IExecutable... executables) {
		super(executables);
		nestedResults = new IEntity[executables.length];
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		AbstractCartesianEvaluator executor = (AbstractCartesianEvaluator) super.clone(cc);
		executor.nestedResults = nestedResults.clone();
		return executor;
	}

	@Override
	protected boolean isValidResultProducer() {
		return isLastProducer();
	}

	@Override
	protected void initProducer(IExecutable p, int index) {
		p.setBindings(getBindings());
		p.reset(index == 0 ? selfEntity : nestedResults[index-1]);
	}

	@Override
	protected IBindingManager executorScope() {
		if (executorScope == null)
			executorScope = BindingManagerFactory.instance.createBindingManager(
					BindingManagerFactory.instance.createSimpleScope(), getBindings().wGetEnvironmentManager());

		return (IBindingManager) executorScope;
	}
	@Override
	protected void clearExecutorScope() {
		if (executorScope != null) {
			if (lastEntity != null)
				for (String name : executorScope.wTargetNames())
					getBindings().wUnset(name);
			((BindingManager) executorScope).wSetTargetScope(BindingManagerFactory.instance.createSimpleScope());
		}
	}
	@Override
	protected void clearProducerScope() {
		if (executorScope != null) {
			for (String name : executorScope.wNames())
				getBindings().wUnset(name);
			executorScope.wClear();
		}
	}

	public IEntity evaluateNext() {
		if (lastEntity != null)
			clearProducerScope();

		try {
			getBindings().wEnterScope(executorScope(), true);
	
			boolean needFollowingProducerResult, needPrecedingProducerResult;
			do {
				nestedResults[producerIndex] = getProducer(producerIndex).evaluateNext();
	
				needFollowingProducerResult = isNotLastProducer() && nestedResults[producerIndex] != null;
				needPrecedingProducerResult = isNotFirstProducer() && nestedResults[producerIndex] == null;
	
				if (needFollowingProducerResult) {
					executorScope().wEnterScope();
					producerIndex += 1;
					producersNeedInit.set(producerIndex);
				} else if (needPrecedingProducerResult) {
					executorScope().wExitScope();
					producerIndex -= 1;
				}
			} while (needFollowingProducerResult || needPrecedingProducerResult);

			return lastEntity = evaluateNestedResults();
		} finally {
			getBindings().wExitScope(lastEntity != null);
		}
	}
	protected abstract IEntity evaluateNestedResults();
}

