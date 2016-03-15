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

import java.util.NoSuchElementException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class RecursiveFunctionApplicationIterator extends AbstractCloneableIterator<IEntity> {
	private IBindingManager bindings;
	protected IEntity resetEntity = null;
	protected IEntityIterator<IEntity> nextEntityIterator;

	public IEntityIterator<IEntity> clone(ICloneContext cc) {
		RecursiveFunctionApplicationIterator iterator = (RecursiveFunctionApplicationIterator) super.clone(cc);
		iterator.nextEntityIterator = cc.clone(nextEntityIterator);
		return iterator;
	}

	public boolean hasNext() {
		return lookahead() != null;
	}
	public IEntity lookahead() {
		if (nextEntityIterator != null)
			return nextEntityIterator.lookahead();

		clearLookaheadScope();
		getBindings().wEnterScope(lookaheadScope(), true);
		IEntity selfEntity = getBindings().wGet("self");
		if (selfEntity != resetEntity)
			getBindings().wDef("self", resetEntity);

		if (resetEntity != null) {
			getBindings().wGetEnvironmentManager().getCurrentOperation().stagedVisit(resetEntity, 0);
			resetEntity = null;
		}

		getBindings().wExitScope();

		nextEntityIterator = getBindings().getResultIterator();
		if (getBindings().hasResultIterator()) {
			getBindings().setResultIterator(null);
			selfEntity = getBindings().wGet("self");
			if (selfEntity != resetEntity)
				getBindings().wDef("self", resetEntity);
			nextEntityIterator.reset(resetEntity);
			lookaheadScope = null;
		}
		return nextEntityIterator.lookahead();
	}
	public IEntity next() {
		IEntity result = lookahead();
    	if (result == null)
        	throw new NoSuchElementException();

    	if (lookaheadScope != null)
    		getBindings().wAddAll(lookaheadScope());

		nextEntityIterator.next();
		return result;
	}

	public void reset(IEntity entity) {
		resetEntity = entity;
		nextEntityIterator = null;
	}

    public void setBindings(IBindingManager bindings) {
    	this.bindings = bindings;
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	private IBindingScope lookaheadScope;
	public IBindingScope lookaheadScope() {
		if (lookaheadScope != null)
			return lookaheadScope;
		if (nextEntityIterator != null)
			return nextEntityIterator.lookaheadScope();
		else
			return lookaheadScope = BindingManagerFactory.instance.createSimpleScope();
	}
	protected void clearLookaheadScope() {
		if (lookaheadScope != null) {
			for (String name : lookaheadScope.wLocalNames())
				getBindings().wUnset(name);
			lookaheadScope.wClear();
		}
	}

    public void prune() {
    	if (nextEntityIterator != null)
    		nextEntityIterator.prune();
    }
	public void set(IEntity entity) {
    	if (nextEntityIterator != null)
    		nextEntityIterator.set(entity);
	}
	public void add(IEntity entity) {
    	if (nextEntityIterator != null)
    		nextEntityIterator.add(entity);
	}
	public void remove() {
    	if (nextEntityIterator != null)
    		nextEntityIterator.remove();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("stagedVisit(self, 0)");
    }
}
