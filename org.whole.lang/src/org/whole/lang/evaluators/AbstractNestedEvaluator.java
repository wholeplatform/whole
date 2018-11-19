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

import java.util.BitSet;

import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.AbstractExecutableEvaluatingStepper;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.IdentityCloneContext;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractNestedEvaluator<E extends IEntity> extends AbstractExecutableEvaluatingStepper<E> {
	protected ICloneContext cloneContext = IdentityCloneContext.instance;
	protected IEntity selfEntity;
	protected IExecutable<IEntity>[] producers;
	protected BitSet producersNeedClone;
	protected BitSet producersNeedInit;

	protected AbstractNestedEvaluator(IExecutable<IEntity>... producers) {
		this.producers = producers;
		producersNeedClone = new BitSet(producersSize());
		producersNeedClone.set(0, producersSize(), false);
		producersNeedInit = new BitSet(producersSize());
		producersNeedInit.set(0, producersSize(), true);
	}

	public IExecutable<E> clone(ICloneContext cc) {
		cloneContext = cc.getPrototypeCloneContext();
		producersNeedClone.set(0, producersSize(), true);

		AbstractNestedEvaluator<E> evaluator = (AbstractNestedEvaluator<E>) super.clone(cc);
		evaluator.cloneContext = cc;
		evaluator.producers = producers.clone();
		evaluator.producersNeedClone = (BitSet) producersNeedClone.clone();
		evaluator.producersNeedInit = (BitSet) producersNeedInit.clone();
		return evaluator;
	}

	public void reset(IEntity entity) {
		super.reset(entity);
        selfEntity = entity;
        producersNeedInit.set(0, producersSize(), true);
    }

    public int producersSize() {
		return producers.length;
	}
	public IExecutable<IEntity> getProducer(int index) {
		if (producersNeedClone.get(index)) {
			producersNeedClone.clear(index);
			producers[index] = producers[index].clone(cloneContext);
		}

		IExecutable<IEntity> producer = producers[index];

		if (producersNeedInit.get(index)) {
			producersNeedInit.clear(index);
			initProducer(producer, index);			
		}

		return producer;
	}
	protected void initProducer(IExecutable<?> p, int index) {
		p.setBindings(getBindings());
		p.reset(selfEntity);
	}

	protected IEntity scopedEvaluateNext(int producerIndex) {
		return scopedEvaluateNext(producerIndex, executorScope());
	}
	protected IEntity scopedEvaluateNext(int producerIndex, IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			return getProducer(producerIndex).evaluateNext();
		} finally {
			getBindings().wExitScope();
		}
	}
//	protected IEntity scopedEvaluateRemaining(int producerIndex) {
//		return scopedEvaluateRemaining(producerIndex, executorScope());
//	}
//	protected IEntity scopedEvaluateRemaining(int producerIndex, IBindingScope scope) {
//		try {
//			getBindings().wEnterScope(scope, true);
//			return getProducer(producerIndex).evaluateRemaining();
//		} finally {
//			getBindings().wExitScope();
//		}
//	}
	protected boolean scopedEvaluateAsBooleanOrFail(int producerIndex) {
		return scopedEvaluateAsBooleanOrFail(producerIndex, executorScope());
	}
	protected boolean scopedEvaluateAsBooleanOrFail(int producerIndex, IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			return getProducer(producerIndex).evaluateAsBooleanOrFail();
		} finally {
			getBindings().wExitScope();
		}
	}
//	protected boolean scopedEvaluateAsBooleanOrFail(int producerIndex, boolean mergeOnTrue) {
//		boolean result = false;
//		try {
//			getBindings().wEnterScope(BindingManagerFactory.instance.createSimpleScope(), true);
//			return result = getProducer(producerIndex).evaluateAsBooleanOrFail();
//		} finally {
//			getBindings().wExitScope(mergeOnTrue && result);
//		}
//	}


    public void prune() {
    }
	public void set(E entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wSet(lastEntity, entity);
    	lastEntity = entity;
	}
	public void add(E entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	if (EntityUtils.hasParent(lastEntity)) {
    		IEntity lastEntityParent = lastEntity.wGetParent();
    		lastEntityParent.wAdd(lastEntityParent.wIndexOf(lastEntity), entity);
    	}
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wRemove(lastEntity);
    	lastEntity = null;
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append(toStringPrefix());
    	
		for (int i=0; i<producersSize(); i++) {
			if (i>0)
				sb.append(toStringSeparator());
			producers[i].toString(sb);
		}

    	sb.append(toStringSuffix());
    }
	protected String toStringPrefix() {
		return "(";
	}
	protected String toStringSeparator() {
		return ", ";
	}
	protected String toStringSuffix() {
		return ")";
	}
}
