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

/**
 * @author Riccardo Solmi
 */
public class IfEvaluator extends AbstractDelegatingNestedEvaluator<IEntity> {
	protected boolean conditionValue;
	protected boolean isFirstValue;

	@SuppressWarnings("unchecked")
	public IfEvaluator(IExecutable<IEntity> conditionExecutable, IExecutable<IEntity> doExecutable) {
		super(conditionExecutable, doExecutable);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		isFirstValue = true;
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
//			if (lastEntity != null)
//				for (String name : executorScope.wTargetNames())
//					getBindings().wUnset(name);
			((BindingManager) executorScope).wSetTargetScope(BindingManagerFactory.instance.createSimpleScope());
		}
	}
	@Override
	protected void clearProducerScope() {
		if (executorScope != null) {
//			for (String name : executorScope.wTargetScope().wLocalNames())
//				getBindings().wUnset(name);
			executorScope.wClear();
		}
	}

	@Override
	protected void selectFollowingProducer() {
		executorScope().wEnterScope();
		super.selectFollowingProducer();
		producersNeedInit.set(producerIndex);
	}

	@Override
	protected boolean isValidResultProducer() {
		return isLastProducer();
	}

	public IEntity evaluateNext() {
		if (isFirstProducer()) {
			conditionValue = scopedEvaluateAsBooleanOrFail();
			selectFollowingProducer();
		}

		return lastEntity = conditionValue ? enforceSomeValue(scopedEvaluateNext()) : null;
	}

	public IEntity evaluateRemaining() {
		if (isFirstProducer()) {
			conditionValue = scopedEvaluateAsBooleanOrFail();
			selectFollowingProducer();				
		}

		return lastEntity = conditionValue ? enforceSomeValue(scopedEvaluateRemaining()) : null;
	}

	protected IEntity enforceSomeValue(IEntity entity) {
		if (isFirstValue) {
			isFirstValue = false;
			getBindings().wAddAll(executorScope());
			return entity != null ? entity : BindingManagerFactory.instance.createVoid();
		} else
			return entity;
	}

	protected String toStringPrefix() {
		return "if ";
	}
	protected String toStringSeparator() {
		return " do ";
	}
	protected String toStringSuffix() {
		return "";
	}
}

