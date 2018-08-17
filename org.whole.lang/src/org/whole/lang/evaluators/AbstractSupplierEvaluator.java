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

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.AbstractExecutableEvaluatingStepperIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractSupplierEvaluator<E extends IEntity> extends AbstractExecutableEvaluatingStepperIterator<E> implements Supplier<E> {
    protected boolean isEvaluated;
	protected IEntity selfEntity;
	protected IEntityIterator<? extends IEntity>[] producers;
	protected Set<Integer> optionalProducersIndexSet;

	protected AbstractSupplierEvaluator(IEntityIterator<?>... producers) {
		optionalProducersIndexSet = Collections.emptySet();
		this.producers = producers;
	}
	protected AbstractSupplierEvaluator(int[] optionalArgsIndexes, IEntityIterator<?>... producers) {
		optionalProducersIndexSet = Arrays.stream(optionalArgsIndexes).boxed().collect(Collectors.toSet());
		this.producers = producers;
	}

	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractSupplierEvaluator<E> iterator = (AbstractSupplierEvaluator<E>) super.clone(cc);
		if (producers != null) {
			iterator.producers = producers.clone();
			for (int i=0; i<producers.length; i++)
				iterator.producers[i] = cc.clone(producers[i]);
		}
		return iterator;
	}

	public int producersSize() {
		return producers.length;
	}
	public IEntityIterator<?> getProducer(int index) {
		return producers[index];
	}

	public void reset(IEntity entity) {
		super.reset(entity);
		isEvaluated = false;
        selfEntity = entity;
        resetProducers(entity);
    }
	protected void resetProducers(IEntity entity) {
        if (producers != null)
    		for (IEntityIterator<? extends IEntity> i : producers)
    			i.reset(entity);		
	}

    protected void setProducersBindings(IBindingManager bindings) {
		super.setProducersBindings(bindings);
		if (producers != null)
			for (IEntityIterator<? extends IEntity> i : producers)
				i.setBindings(bindings);
	}

	protected IEntity[] evaluateProducers() {
		IEntity[] arguments = null;
        if (producers != null) {
        	IBindingManager bm = getBindings();
        	arguments = new IEntity[producers.length];
        	for (int i=0; i<producers.length; i++) {
        		arguments[i] = producers[i].evaluateRemaining();
        		if (arguments[i] == null && !optionalProducersIndexSet.contains(i))
        			throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(producers[i].getSourceEntity()).withBindings(bm);
        	}
        }
        return arguments;
	}

	public E evaluateNext() {
		if (isEvaluated)
			return null;
		else {
			isEvaluated = true;

			try {
				return lastEntity = get();
	        } catch (Throwable e) {
	            throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), getBindings());
	        }
		}
	}

	@Override
	public E evaluateRemaining() {
		return evaluateNext();
	}

	@Override
	public E evaluateSingleton() {
		if (isEvaluated)
			throw new IllegalArgumentException("The result is not a singleton");
		else
			return evaluateNext();
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
    	sb.append("(");
    	
		for (int i=0; i<producers.length; i++) {
			if (i>0)
				sb.append(", ");
			producers[i].toString(sb);
		}

    	sb.append(")");
    }
}
