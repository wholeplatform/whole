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

import org.whole.lang.bindings.AbstractFilterScope;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class SequenceEvaluator<E extends IEntity> extends AbstractDelegatingNestedEvaluator<E> {
	@SuppressWarnings("unchecked")
	public SequenceEvaluator(IExecutable<IEntity>... executables) {
		super(executables);
	}

	public AbstractFilterScope executorScope() {
		if (executorScope == null)
			executorScope = BindingManagerFactory.instance.createExcludeFilterSimpleScope();
		return (AbstractFilterScope) executorScope;
	}
	protected void clearExecutorScope() {
		if (executorScope != null) {
			executorScope().setFilterEnabled(false);
			for (String name : executorScope.wLocalNames())
				getBindings().wUnset(name);
			executorScope.wClear();
			executorScope().getFilterNames().clear();
			executorScope().setFilterEnabled(true);
		}
	}
	protected IEntity scopedEvaluateNext() {
		try {
			//clearLocalScope();
			executorScope().setFilterEnabled(false);
			for (String name : executorScope().wLocalNames())
				getBindings().wUnset(name);
			getBindings().wEnterScope(executorScope(), true);
			return getProducer().evaluateNext();
		} finally {
			executorScope().setFilterEnabled(true);
			getBindings().wExitScope(true);
			executorScope().getFilterNames().addAll(executorScope().wLocalNames());
		}
	}
	protected IEntity scopedEvaluateRemaining() {
		try {
			//clearLocalScope();
			executorScope().setFilterEnabled(false);
			for (String name : executorScope().wLocalNames())
				getBindings().wUnset(name);
			getBindings().wEnterScope(executorScope(), true);
			return getProducer().evaluateRemaining();
		} finally {
			executorScope().setFilterEnabled(true);
			getBindings().wExitScope(true);
			executorScope().getFilterNames().addAll(executorScope().wLocalNames());
		}
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		clearExecutorScope();
	}

	@SuppressWarnings("unchecked")
	public E evaluateNext() {
		IEntity result = null;

		while (isValidProducer()) {
			result = scopedEvaluateNext();
			if (result != null)
				break;
			selectFollowingProducer();
		}
		return lastEntity = (E) result;
	}

//	@SuppressWarnings("unchecked")
//	public E evaluateRemaining() {
//		IEntity result = null;
//
//		while (isValidProducer()) {
//			result = scopedEvaluateRemaining();
//			selectFollowingProducer();
//		}
//		return lastEntity = (E) result;
//	}
}

