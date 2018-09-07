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
package org.whole.lang.steppers;

import java.util.BitSet;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.AbstractExecutableSteppingEvaluatingIterator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.IdentityCloneContext;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractNestedStepper<E extends IEntity> extends AbstractExecutableSteppingEvaluatingIterator<E> {
	protected ICloneContext cloneContext = IdentityCloneContext.instance;
	protected IEntity selfEntity;
	protected IExecutable<?>[] producers;
	protected BitSet producersNeedClone;
	protected BitSet producersNeedInit;

	protected AbstractNestedStepper(IEntityIterator<?>... producers) {
		this.producers = producers;
		producersNeedClone = new BitSet(producersSize());
		producersNeedClone.set(0, producersSize(), false);
		producersNeedInit = new BitSet(producersSize());
		producersNeedInit.set(0, producersSize(), true);
	}

	public IEntityIterator<E> clone(ICloneContext cc) {
		cloneContext = cc.getPrototypeCloneContext();
		producersNeedClone.set(0, producersSize(), true);
		
		AbstractNestedStepper<E> iterator = (AbstractNestedStepper<E>) super.clone(cc);
		iterator.cloneContext = cc;
		iterator.producers = producers.clone();
		iterator.producersNeedClone = (BitSet) producersNeedClone.clone();
		iterator.producersNeedInit = (BitSet) producersNeedInit.clone();
		return iterator;
	}

	public void reset(IEntity entity) {
        selfEntity = entity;
        producersNeedInit.set(0, producersSize(), true);
    }

	public int producersSize() {
		return producers.length;
	}
	public IExecutable<?> getProducer(int index) {
		if (producersNeedClone.get(index)) {
			producersNeedClone.clear(index);
			producers[index] = producers[index].clone(cloneContext);
		}

		IExecutable<?> producer = producers[index];

		if (producersNeedInit.get(index)) {
			producersNeedInit.clear(index);
			initProducer(producer, index);			
		}

		return producer;
	}
	protected void initProducer(IExecutable<?> p, int index) {
		p.setBindings(getBindings());
		p.reset(selfEntity);
		p.withConsumer(this);
	}

	protected void scopedCallNext(int producerIndex, IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			getProducer(producerIndex).callNext();
		} finally {
			getBindings().wExitScope();
		}
	}
	protected void scopedCallRemaining(int producerIndex, IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			getProducer(producerIndex).callRemaining();
		} finally {
			getBindings().wExitScope();
		}
	}
	protected IEntity scopedEvaluateNext(int producerIndex, IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			return getProducer(producerIndex).evaluateNext();
		} finally {
			getBindings().wExitScope();
		}
	}
	protected IEntity scopedEvaluateRemaining(int producerIndex, IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			return getProducer(producerIndex).evaluateRemaining();
		} finally {
			getBindings().wExitScope();
		}
	}
	protected boolean scopedEvaluateAsBooleanOrFail(int producerIndex, IBindingScope scope) {
		try {
			getBindings().wEnterScope(scope, true);
			return getProducer(producerIndex).evaluateAsBooleanOrFail();
		} finally {
			getBindings().wExitScope();
		}
	}
	protected boolean scopedEvaluateAsBooleanOrFail(int producerIndex, boolean mergeOnTrue) {
		boolean merge = false;
		try {
			getBindings().wEnterScope(BindingManagerFactory.instance.createSimpleScope(), true);
			return merge = getProducer(producerIndex).evaluateAsBooleanOrFail();
		} finally {
			getBindings().wExitScope(mergeOnTrue ? merge : !merge);
		}
	}


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
    		IEntity parent = lastEntity.wGetParent();
			parent.wAdd(parent.wIndexOf(lastEntity), entity);
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
		sb.append(toStringName());
    	sb.append("(");
    	
		for (int i=0; i<producersSize(); i++) {
			if (i>0)
				sb.append(toStringSeparator());
			producers[i].toString(sb);
		}

    	sb.append(")");
    }
	protected String toStringName() {
		return "";
	}
	protected String toStringSeparator() {
		return ", ";
	}
}
