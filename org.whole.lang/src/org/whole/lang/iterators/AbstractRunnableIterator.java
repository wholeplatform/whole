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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractRunnableIterator<E extends IEntity> extends AbstractCloneableIterator<E> implements IRunnable {
	protected IEntity selfEntity;
	protected IBindingManager bindings;
	protected IEntityIterator<?>[] argsIterators;

	protected AbstractRunnableIterator(IEntityIterator<?>... argsIterators) {
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
        if (argsIterators != null)
    		for (IEntityIterator<? extends IEntity> i : argsIterators)
    			i.reset(entity);
    }

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
			this.bindings = bindings;
			if (argsIterators != null)
				for (IEntityIterator<? extends IEntity> i : argsIterators)
					i.setBindings(bindings);
		}
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	protected IEntity[] evaluateArguments(IEntity selfEntity, IBindingManager bm) {
		IEntity[] arguments = null;
        if (argsIterators != null) {
        	arguments = new IEntity[argsIterators.length];
        	for (int i=0; i<argsIterators.length; i++) {
        		arguments[i] = evaluateArgument(argsIterators[i], selfEntity, bm);
        		if (arguments[i] == null)
        			throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(argsIterators[i].getSourceEntity()).withBindings(bm);
        	}
        }
        return arguments;
	}
	protected IEntity evaluateArgument(IEntityIterator<? extends IEntity> argumentIterator, IEntity selfEntity, IBindingManager bm) {
		return BehaviorUtils.evaluate(argumentIterator, selfEntity, bm);
	}

    @Override
	public void toString(StringBuilder sb) {
    	sb.append("(");
    	
		for (int i=0; i<argsIterators.length; i++) {
			if (i>0)
				sb.append(",");
			sb.append(argsIterators[i].toString());
		}

    	sb.append(")");
    }
}
