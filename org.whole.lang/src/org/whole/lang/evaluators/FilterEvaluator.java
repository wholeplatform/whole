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

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class FilterEvaluator extends AbstractDelegatingNestedEvaluator {
	private boolean autoPrune = false;
	
	public FilterEvaluator(IExecutable doExecutable, IExecutable filterExecutable) {
		super(doExecutable, filterExecutable);
	}

	@Override
	protected void initProducer(IExecutable p, int index) {
		p.setBindings(getBindings());
		if (index == 0)
			p.reset(selfEntity);
	}

	public IEntity evaluateNext() {
		if (lastEntity != null)
			for (String name : executorScope.wTargetNames())
				getBindings().wUnset(name);

		try {
			getBindings().wEnterScope(executorScope(), true);
			while (true) {
				executorScope.wClear();
				lastEntity = getProducer(0).evaluateNext();
				if (lastEntity == null) {
					executorScope().wClear();
					return lastEntity;
				}

				getProducer(1).reset(lastEntity);
				if (getProducer(1).evaluateAsBooleanOrFail()) {
					if (autoPrune())
						prune();
					return lastEntity;
				}
			}
		} finally {
			getBindings().wExitScope(lastEntity != null);
		}
	}

//	public IEntity evaluateRemaining() {
//		do {
//			doEntity = scopedEvaluateNext();//TODO add producerIndex and remove explicit calls to increment/decrement
//			if (doEntity == null) {
//				if (lastExecutorScope != null)
//					executorScope = lastExecutorScope;
//				getBindings().wAddAll(executorScope);
//				return lastEntity;
//			}
//			selectFollowingProducer();
//			if (scopedEvaluateAsBooleanOrFail()) {
//				lastExecutorScope = executorScope().clone();
//				lastEntity = doEntity;
//			} else
//				selectPrecedingProducer();
//		} while (true);
//	}

	public boolean autoPrune() {
		return autoPrune;
	}
	public FilterEvaluator withAutoPrune(boolean value) {
		autoPrune = value;
		return this;
	}

	public void prune() {
		getProducer(0).prune();
	}

	public void set(IEntity entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wSet(lastEntity, entity);
    	lastEntity = entity;
	}
	public void add(IEntity entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	getProducer(0).add(entity);
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	getProducer(0).remove();
    	lastEntity = null;
	}

	protected String toStringPrefix() {
		return "";
	}
	protected String toStringSeparator() {
		return "[";
	}
	protected String toStringSuffix() {
		return "]";
	}
}

