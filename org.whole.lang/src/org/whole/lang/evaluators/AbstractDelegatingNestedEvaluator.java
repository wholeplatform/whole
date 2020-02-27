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

import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 * 
 * TODO keep same code in the two classes except declaration line
 */
public abstract class AbstractDelegatingNestedEvaluator extends AbstractNestedEvaluator {
//public abstract class AbstractDelegatingNestedStepper extends AbstractNestedStepper {
	protected int producerIndex = 0;

	public AbstractDelegatingNestedEvaluator(IExecutable... executables) {
		super(executables);
	}
	protected AbstractDelegatingNestedEvaluator(int producersSize) {
		super(producersSize);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		producerIndex = 0;
	}

	protected boolean isFirstProducer() {
		return producerIndex == 0;
	}
	protected boolean isNotFirstProducer() {
		return producerIndex > 0;
	}
	protected boolean isLastProducer() {
		return producerIndex == producersSize()-1;
	}
	protected boolean isNotLastProducer() {
		return producerIndex < producersSize()-1;
	}
	protected boolean isValidProducer() {
		return producerIndex < producersSize();
	}
	protected boolean isValidResultProducer() {
		return isValidProducer();
	}

	protected IExecutable getProducer() {
		return getProducer(producerIndex);
	}
	protected void selectFollowingProducer() {
		producerIndex += 1;
	}
	protected void selectPrecedingProducer() {
		producerIndex -= 1;
	}

	protected void scopedCallNext(IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			getProducer().call();
		} finally {
			getBindings().wExitScope();
		}
	}
	protected IEntity scopedEvaluateNext(IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			return getProducer().evaluateNext();
		} finally {
			getBindings().wExitScope();
		}
	}
	protected IEntity scopedEvaluateNext() {
		IEntity result = null;
		try {
			clearProducerScope();
			getBindings().wEnterScope(executorScope(), true);
			return result = getProducer().evaluateNext();
		} finally {
			getBindings().wExitScope(result != null);
		}
	}
	protected IEntity scopedEvaluateRemaining(IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			return getProducer().evaluateRemaining();
		} finally {
			getBindings().wExitScope();
		}
	}
	protected IEntity scopedEvaluateRemaining() {
		IEntity result = null;
		try {
			clearProducerScope();
			getBindings().wEnterScope(executorScope(), true);
			return result = getProducer().evaluateRemaining();
		} finally {
			getBindings().wExitScope(result != null);
		}
	}
	protected boolean scopedEvaluateAsBooleanOrFail(IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			return getProducer().evaluateAsBooleanOrFail();
		} finally {
			getBindings().wExitScope();
		}
	}
	protected boolean scopedEvaluateAsBooleanOrFail() {
		boolean result = false;
		try {
			getBindings().wEnterScope(executorScope(), true);
			return result = getProducer().evaluateAsBooleanOrFail();
		} finally {
			getBindings().wExitScope(result);
		}
	}

	@Override
	public void prune() {
		if (isValidResultProducer())
			getProducer().prune();
	}

	public void set(IEntity entity) {
    	if (!isValidResultProducer())
    		throw new IllegalStateException();

    	((IExecutable) getProducer()).set(entity);
	}
	public void add(IEntity entity) {
    	if (!isValidResultProducer())
    		throw new IllegalStateException();

		((IExecutable) getProducer()).add(entity);
	}
	public void remove() {
    	if (!isValidResultProducer())
    		throw new IllegalStateException();

		getProducer().remove();
	}
}

