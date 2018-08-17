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
package org.whole.lang.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.AbstractExecutableIteratingEvaluatingStepper;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 * 
 * TODO keep same as AbstractRunnableEvaluator
 */
public abstract class AbstractRunnableIterator<E extends IEntity> extends AbstractExecutableIteratingEvaluatingStepper<E> {
	protected IEntity selfEntity;
	protected IEntityIterator<? extends IEntity>[] argsIterators;
	protected Set<Integer> optionalArgsIndexSet;

	protected AbstractRunnableIterator(IEntityIterator<?>... argsIterators) {
		optionalArgsIndexSet = Collections.emptySet();
		this.argsIterators = argsIterators;
	}
	protected AbstractRunnableIterator(int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		optionalArgsIndexSet = Arrays.stream(optionalArgsIndexes).boxed().collect(Collectors.toSet());
		this.argsIterators = argsIterators;
	}

	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractRunnableIterator<E> iterator = (AbstractRunnableIterator<E>) super.clone(cc);
		if (argsIterators != null) {
			iterator.argsIterators = argsIterators.clone();
			for (int i=0; i<argsIterators.length; i++)
				iterator.argsIterators[i] = cc.clone(argsIterators[i]);
		}
		return iterator;
	}

	public void reset(IEntity entity) {
        selfEntity = entity;
        resetArguments(entity);
    }
	protected void resetArguments(IEntity entity) {
        if (argsIterators != null)
    		for (IEntityIterator<? extends IEntity> i : argsIterators)
    			i.reset(entity);		
	}

    protected void setProducersBindings(IBindingManager bindings) {
		super.setProducersBindings(bindings);
		if (argsIterators != null)
			for (IEntityIterator<? extends IEntity> i : argsIterators)
				i.setBindings(bindings);
	}

	protected void run(IEntity selfEntity, IBindingManager bm) {
		run(selfEntity, bm, evaluateArguments(selfEntity, bm));
	}
	public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
	}

	protected IEntity[] evaluateArguments(IEntity selfEntity, IBindingManager bm) {
		IEntity[] arguments = null;
        if (argsIterators != null) {
        	arguments = new IEntity[argsIterators.length];
        	for (int i=0; i<argsIterators.length; i++) {
        		arguments[i] = argsIterators[i].evaluate(selfEntity, bm);
        		if (arguments[i] == null && !optionalArgsIndexSet.contains(i))
        			throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(argsIterators[i].getSourceEntity()).withBindings(bm);
        	}
        }
        return arguments;
	}

	@Override
	public void toString(StringBuilder sb) {
    	sb.append("(");
    	
		for (int i=0; i<argsIterators.length; i++) {
			if (i>0)
				sb.append(", ");
			argsIterators[i].toString(sb);
		}

    	sb.append(")");
    }
}
