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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class ComposeEvaluator extends AbstractDelegatingNestedEvaluator<IEntity> {
	protected IEntity[] nestedResults;

	public ComposeEvaluator(IExecutable<?>... nestedExecutables) {
		super(nestedExecutables);
		nestedResults = new IEntity[nestedExecutables.length];
	}

	@Override
	public IExecutable<IEntity> clone(ICloneContext cc) {
		ComposeEvaluator executor = (ComposeEvaluator) super.clone(cc);
		executor.nestedResults = nestedResults.clone();
		return executor;
	}

	@Override
	protected boolean isValidResultProducer() {
		return isLastProducer();
	}

	@Override
	protected void initProducer(IExecutable<?> p, int index) {
		p.setBindings(getBindings());
		p.reset(index == 0 ? selfEntity : nestedResults[index-1]);
	}

	@Override
	protected IBindingManager executorScope() {
		if (executorScope == null)
			executorScope = BindingManagerFactory.instance.createBindingManager();

		return (IBindingManager) executorScope;
	}
	@Override
	protected void clearExecutorScope() {
		if (executorScope != null) {
			if (lastEntity != null)
				for (String name : executorScope.wTargetNames())
					getBindings().wUnset(name);
			executorScope = null;
		}
	}
	@Override
	protected void clearProducerScope() {
		if (executorScope != null) {
			for (String name : executorScope.wNames()) //TODO ? optimize clear 1/3 .wTaretScope().wLocalNames()
				getBindings().wUnset(name);
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
	protected void selectPrecedingProducer() {
		//TODO ? optimize clear 2/3
//		clearProducerScope(); //unneeded wClear() in clearProducerScope()
		executorScope().wExitScope();
		super.selectPrecedingProducer();
	}

	@Override
	protected IEntity scopedEvaluateNext(boolean merge) {
		mergeLookaheadScope = merge;
		IEntity result = evaluateNext();
		mergeLookaheadScope = true;
		return result;
	}

	@Override
	protected boolean needClearExecutorScope(/*int producerIndex*/) {
		return lastEntity != null && isLastProducer(); //TODO ? optimize clear 3/3 without && isLastProducer()
	}
	@Override
	protected boolean needMergeExecutorScope(/*int producerIndex*/) {
		return super.needMergeExecutorScope() && isLastProducer();
	}


	protected void updateResults() {
		boolean needFollowingProducerResult, needPrecedingProducerResult;

		do {
			nestedResults[producerIndex] = scopedEvaluateNext();

			needFollowingProducerResult = isNotLastProducer() && nestedResults[producerIndex] != null;
			needPrecedingProducerResult = isNotFirstProducer() && nestedResults[producerIndex] == null;

			if (needFollowingProducerResult)
				selectFollowingProducer();
			else if (needPrecedingProducerResult)
				selectPrecedingProducer();

		} while (needFollowingProducerResult || needPrecedingProducerResult);
	}

	public IEntity evaluateNext() {
		updateResults();
		return lastEntity = enforceSomeValue(nestedResults[producerIndex]);
	}

//	public IEntity evaluateRemaining() {
//		do {
//			updateResults();
//			if (nestedResults[producerIndex] != null)
//				lastEntity = nestedResults[producerIndex];
//		} while (nestedResults[producerIndex] != null);
//
//		return lastEntity = enforceSomeValue(lastEntity);
//	}

	protected IEntity enforceSomeValue(IEntity entity) {
		return entity;
	}

	protected String toStringPrefix() {
		return "";
	}
	protected String toStringSeparator() {
		return "/";
	}
	protected String toStringSuffix() {
		return "";
	}
}

