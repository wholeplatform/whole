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

import java.util.HashSet;
import java.util.NoSuchElementException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.AbstractExecutableIteratingEvaluatingStepper;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class RecursiveFunctionApplicationIterator extends AbstractExecutableIteratingEvaluatingStepper<IEntity> {
	protected boolean lazyReset = true;
	protected IEntity resetEntity = null;
	protected IEntityIterator<IEntity> functionIterator;

	public IExecutable<IEntity> clone(ICloneContext cc) {
		RecursiveFunctionApplicationIterator iterator = (RecursiveFunctionApplicationIterator) super.clone(cc);
		iterator.functionIterator = cc.clone(functionIterator);
		return iterator;
	}

	public boolean hasNext() {
		return lookahead() != null;
	}
	public IEntity lookahead() {
		if (functionIterator != null)
			return functionIterator.lookahead();

		clearLookaheadScope();
		getBindings().wEnterScope(lookaheadScope(), true);
		getBindings().enforceSelfBinding(resetEntity);

		if (lazyReset && resetEntity != null) {
			getBindings().wGetEnvironmentManager().getCurrentOperation().stagedVisit(resetEntity, 0);
			lazyReset = false;
		}

		getBindings().wExitScope();

		functionIterator = getBindings().getResultIterator();
		if (getBindings().hasResultIterator())
			getBindings().setResultIterator(null);

		getBindings().enforceSelfBinding(resetEntity);
		functionIterator.reset(resetEntity);
		lookaheadScope = null;
		return functionIterator.lookahead();
	}
	public IEntity next() {
		IEntity result = lookahead();
    	if (result == null)
        	throw new NoSuchElementException();

    	if (lookaheadScope != null)
    		getBindings().wAddAll(lookaheadScope());

		functionIterator.next();
		return result;
	}

	public void reset(IEntity entity) {
		resetEntity = entity;
		lazyReset = true;
		functionIterator = null;
	}

	private IBindingScope lookaheadScope;
	public IBindingScope lookaheadScope() {
		if (lookaheadScope != null)
			return lookaheadScope;
		if (functionIterator != null)
			return functionIterator.lookaheadScope();
		else
			return lookaheadScope = BindingManagerFactory.instance.createSimpleScope();
	}
	protected void clearLookaheadScope() {
		if (lookaheadScope != null) {
			for (String name : new HashSet<String>(lookaheadScope.wLocalNames())) //lookaheadScope is nested in bindings
				getBindings().wUnset(name);
			lookaheadScope.wClear();
		}
	}

    public void prune() {
    	if (functionIterator != null)
    		functionIterator.prune();
    }
	public void set(IEntity entity) {
    	if (functionIterator != null)
    		functionIterator.set(entity);
	}
	public void add(IEntity entity) {
    	if (functionIterator != null)
    		functionIterator.add(entity);
	}
	public void remove() {
    	if (functionIterator != null)
    		functionIterator.remove();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("stagedVisit(self, 0)");
    }
}
