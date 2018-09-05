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
import java.util.stream.Collectors;

import org.whole.lang.bindings.IBindingManager;
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
public abstract class AbstractNestedEvaluator<E extends IEntity> extends AbstractExecutableEvaluatingStepperIterator<E> {
	protected IEntity selfEntity;
	protected IEntityIterator<? extends IEntity>[] producers;
	protected Set<Integer> optionalProducersIndexSet;

	protected AbstractNestedEvaluator(IEntityIterator<?>... producers) {
		optionalProducersIndexSet = Collections.emptySet();
		this.producers = producers;
	}
	protected AbstractNestedEvaluator(int[] optionalArgsIndexes, IEntityIterator<?>... producers) {
		optionalProducersIndexSet = Arrays.stream(optionalArgsIndexes).boxed().collect(Collectors.toSet());
		this.producers = producers;
	}

	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractNestedEvaluator<E> iterator = (AbstractNestedEvaluator<E>) super.clone(cc);
		if (producers != null) {
			iterator.producers = producers.clone();
			for (int i=0; i<producersSize(); i++)
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
        	arguments = new IEntity[producersSize()];
        	for (int i=0; i<producersSize(); i++) {
        		arguments[i] = producers[i].evaluateRemaining();
        		if (arguments[i] == null && !optionalProducersIndexSet.contains(i))
        			throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(producers[i].getSourceEntity()).withBindings(bm);
        	}
        }
        return arguments;
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
    	sb.append("(");
    	
    	if (producers != null)
			for (int i=0; i<producersSize(); i++) {
				if (i>0)
					sb.append(", ");
				producers[i].toString(sb);
			}

    	sb.append(")");
    }
}
