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
import org.whole.lang.operations.InterpreterOperation;

/**
 * @author Riccardo Solmi
 */
public class TemplateInterpreterIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
	private IBindingManager bindings;
	protected IEntity resetEntity;
	protected IEntity pattern;
	protected IEntityIterator<E> nextEntityIterator;

	protected TemplateInterpreterIterator(IEntity pattern) {
		this.pattern = pattern;
	}

	public IEntityIterator<E> clone(ICloneContext cc) {
		TemplateInterpreterIterator<E> iterator = (TemplateInterpreterIterator<E>) super.clone(cc);
		iterator.nextEntityIterator = cc.clone(nextEntityIterator);
		return iterator;
	}

	public void reset(IEntity entity) {
        resetEntity = entity;
		clearLookaheadScope();
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

	public boolean hasNext() {
		return lookahead() != null;
	}

	public E lookahead() {
		if (nextEntityIterator != null)
			return nextEntityIterator.lookahead();

		clearLookaheadScope();
		getBindings().wEnterScope(lookaheadScope(), true);
		IEntity selfEntity = getBindings().wGet("self");
		if (selfEntity != resetEntity)
			getBindings().wDef("self", resetEntity);

		IBindingScope results = InterpreterOperation.interpret(pattern, getBindings(), true);

		getBindings().wExitScope();

		nextEntityIterator = results.getResultIterator();
		if (results.hasResultIterator()) {
			results.setResultIterator(null);
			selfEntity = getBindings().wGet("self");
			if (selfEntity != resetEntity)
				getBindings().wDef("self", resetEntity);
			nextEntityIterator.reset(resetEntity);
			lookaheadScope = null;
		}
		return nextEntityIterator.lookahead();
	}

	public E next() {
    	E result = lookahead();
    	if (result == null)
        	throw new NoSuchElementException();

    	if (lookaheadScope != null)
    		getBindings().wAddAll(lookaheadScope());

		nextEntityIterator.next();
		return result;
	}

    public void prune() {
    	if (nextEntityIterator != null)
    		nextEntityIterator.prune();
    }
	public void set(E entity) {
    	if (nextEntityIterator != null)
    		nextEntityIterator.set(entity);
	}
	public void add(E entity) {
    	if (nextEntityIterator != null)
    		nextEntityIterator.add(entity);
	}
	public void remove() {
    	if (nextEntityIterator != null)
    		nextEntityIterator.remove();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("eval(");
		sb.append(pattern.toString());
		sb.append(")");
    }
}
