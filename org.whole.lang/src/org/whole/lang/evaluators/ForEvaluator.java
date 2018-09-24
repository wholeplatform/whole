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
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ForEvaluator extends AbstractDelegatingNestedEvaluator<IEntity> {
//	protected IEntity forEntity = null;
	protected boolean isFirstValue;
	protected IEntity[] result;

	@SuppressWarnings("unchecked")
	public ForEvaluator(IExecutable<IEntity> forExecutable, IExecutable<IEntity> doExecutable) {
		super(forExecutable, doExecutable);
		result = new IEntity[2];
	}

	//FIXME clone localScope

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		isFirstValue = true;
//		localScope = null;
	}

	@Override
	protected void initProducer(IExecutable<?> p, int index) {
		if (index == 0) {
			p.setBindings(getBindings());
			p.reset(selfEntity);
		} else {
			p.setBindings(getBindings());
			p.reset(result[index-1]);
			p.withConsumer(this);
		}
	}

	@Override
	protected IEntity cachedEvaluateNext() {
		if (!lookaheadIsCached) {
			lookaheadIsCached = true;
			
			IEntity cachedLastEntity = lastEntity;
			lookaheadEntity = evaluateNext();//FIXME exitScope(false)
			lastEntity = cachedLastEntity;
		}
		return lookaheadEntity;
	}

//	protected IBindingScope localScope;
	public IBindingScope localScope() {
		return lookaheadScope();
//		if (localScope == null)
//			localScope = BindingManagerFactory.instance.createSimpleScope();
//		return localScope;
	}
	protected void clearLocalScope() {
		clearLookaheadScope();
//		if (localScope != null) {
//			for (String name : localScope.wLocalNames())
//				getBindings().wUnset(name);
//			localScope.wClear();
//		}
	}
	protected IEntity localScopedEvaluateNext() {
		try {
			clearLocalScope();
			getBindings().wEnterScope(localScope(), true);
			return getProducer().evaluateNext();
		} finally {
			getBindings().wExitScope(true);
		}
	}
	protected IEntity localScopedEvaluateRemaining() {
		try {
			clearLocalScope();
			getBindings().wEnterScope(localScope(), true);
			return getProducer().evaluateRemaining();
		} finally {
			getBindings().wExitScope(true);
		}
	}


	protected void updateResults() {
		result[producerIndex] = localScopedEvaluateNext();
		if (producerIndex > 0 && result[producerIndex] == null) {
			//FIXME cache scope if producerIndex = producersSize()-1
			producerIndex -= 1;
			updateResults();
		}
		if (producerIndex < producersSize()-1 && result[producerIndex] != null) {
			producerIndex += 1;
			updateResults();
		}
	}

	public IEntity evaluateNext() {
		updateResults();
		return enforceSomeValue(result[producerIndex]);
	}

	public IEntity evaluateRemaining() {
		IEntity lastEntity = null;

		do {
			updateResults();
			if (result[producerIndex] != null)
				lastEntity = result[producerIndex];
		} while (result[producerIndex] != null);

		return enforceSomeValue(lastEntity);
	}

	protected IEntity enforceSomeValue(IEntity entity) {
		if (isFirstValue) {
			isFirstValue = false;
			return entity != null ? entity : BindingManagerFactory.instance.createVoid();
		} else
			return entity;
	}

	protected String toStringPrefix() {
		return "for ";
	}
	protected String toStringSeparator() {
		return " do ";
	}
	protected String toStringSuffix() {
		return "";
	}
}

