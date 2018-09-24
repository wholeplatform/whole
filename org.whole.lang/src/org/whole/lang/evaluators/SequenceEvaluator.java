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
	public SequenceEvaluator(IExecutable<? extends E>... executables) {
		super(executables);
	}

	protected AbstractFilterScope localScope;
	public AbstractFilterScope localScope() {
		if (localScope == null)
			localScope = BindingManagerFactory.instance.createExcludeFilterSimpleScope();
		return localScope;
	}
	protected void clearLocalScope() {
		if (localScope != null) {
			localScope.setFilterEnabled(false);
			for (String name : localScope.wLocalNames())
				getBindings().wUnset(name);
			localScope.wClear();
			localScope.getFilterNames().clear();
			localScope.setFilterEnabled(true);
		}
	}
	protected IEntity localScopedEvaluateNext() {
		try {
			//clearLocalScope();
			localScope().setFilterEnabled(false);
			for (String name : localScope().wLocalNames())
				getBindings().wUnset(name);
			getBindings().wEnterScope(localScope(), true);
			return getProducer().evaluateNext();
		} finally {
			localScope().setFilterEnabled(true);
			getBindings().wExitScope(true);
			localScope().getFilterNames().addAll(localScope().wLocalNames());
		}
	}
	protected IEntity localScopedEvaluateRemaining() {
		try {
			//clearLocalScope();
			localScope().setFilterEnabled(false);
			for (String name : localScope().wLocalNames())
				getBindings().wUnset(name);
			getBindings().wEnterScope(localScope(), true);
			return getProducer().evaluateRemaining();
		} finally {
			localScope().setFilterEnabled(true);
			getBindings().wExitScope(true);
			localScope().getFilterNames().addAll(localScope().wLocalNames());
		}
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		clearLocalScope();
	}

	@SuppressWarnings("unchecked")
	public E evaluateNext() {
		IEntity result = null;

		while (isValidProducer()) {
			result = localScopedEvaluateNext();
			if (result != null)
				break;
			producerIndex += 1;
		}
		return (E) result;
	}

	@SuppressWarnings("unchecked")
	public E evaluateRemaining() {
		IEntity result = null;

		while (isValidProducer()) {
			result = localScopedEvaluateRemaining();
			producerIndex += 1;
		}
		return (E) result;
	}
}

