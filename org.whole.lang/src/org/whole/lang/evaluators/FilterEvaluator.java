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

/**
 * @author Riccardo Solmi
 */
public class FilterEvaluator extends AbstractDelegatingNestedEvaluator<IEntity> {
	protected IEntity doEntity;
	private boolean autoPrune = false;
	
	@SuppressWarnings("unchecked")
	public FilterEvaluator(IExecutable<IEntity> doExecutable, IExecutable<IEntity> filterExecutable) {
		super(doExecutable, filterExecutable);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		doEntity = null;
	}

	@Override
	protected void initProducer(IExecutable<?> p, int index) {
		p.setBindings(getBindings());
		p.reset(index == 0 ? selfEntity : doEntity);
	}

	@Override
	protected void selectFollowingProducer() {
		super.selectFollowingProducer();
		producersNeedInit.set(producerIndex);
	}

	@Override
	protected void clearProducerScope() {
		if (executorScope != null) {
			for (String name : executorScope.wNames()) //wLocalNames())
				getBindings().wUnset(name);
			executorScope.wClear();
		}
	}

	@Override
	protected boolean needClearExecutorScope(/*int producerIndex*/) {
//		return super.needClearExecutorScope();
		return lastEntity != null && isFirstProducer();
	}
	@Override
	protected boolean needMergeExecutorScope(/*int producerIndex*/) {
		return super.needMergeExecutorScope() && isLastProducer();
	}

	@Override
	protected IEntity scopedEvaluateNext(boolean merge) {
		mergeLookaheadScope = merge;
		IEntity result = evaluateNext();
		mergeLookaheadScope = true;
		return result;
	}

	public IEntity evaluateNext() {
		while (true) {
			doEntity = scopedEvaluateNext();//TODO add producerIndex and remove explicit calls to increment/decrement
			if (doEntity == null) {
				return lastEntity = doEntity;
			}
			selectFollowingProducer();
			boolean filterResult = scopedEvaluateAsBooleanOrFail();
			selectPrecedingProducer();
			if (filterResult) {
				return lastEntity = doEntity;
			}
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
//		nextEntity = null;
		getProducer(0).prune();
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

