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
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractNestedSupplierEvaluator<E extends IEntity> extends AbstractSupplierEvaluator<E> {
	protected IExecutable<? extends IEntity>[] producers;
	protected Set<Integer> optionalProducersIndexSet;

	protected AbstractNestedSupplierEvaluator(IExecutable<?>... producers) {
		optionalProducersIndexSet = Collections.emptySet();
		this.producers = producers;
	}
	protected AbstractNestedSupplierEvaluator(int[] optionalArgsIndexes, IExecutable<?>... producers) {
		optionalProducersIndexSet = Arrays.stream(optionalArgsIndexes).boxed().collect(Collectors.toSet());
		this.producers = producers;
	}

	public IExecutable<E> clone(ICloneContext cc) {
		AbstractNestedSupplierEvaluator<E> iterator = (AbstractNestedSupplierEvaluator<E>) super.clone(cc);
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
	public IExecutable<?> getProducer(int index) {
		return producers[index];
	}

	public void reset(IEntity entity) {
		super.reset(entity);
        resetProducers(entity);
    }
	protected void resetProducers(IEntity entity) {
        if (producers != null)
    		for (IExecutable<? extends IEntity> i : producers)
    			i.reset(entity);		
	}

    protected void setProducersBindings(IBindingManager bindings) {
		super.setProducersBindings(bindings);
		if (producers != null)
			for (IExecutable<? extends IEntity> i : producers)
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
