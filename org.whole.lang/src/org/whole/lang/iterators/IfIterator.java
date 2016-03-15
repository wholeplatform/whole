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
public class IfIterator<E extends IEntity> extends AbstractDelegatingIterator<E> {
	private IBindingManager lookaheadScope;
	private IEntityIterator<?> conditionIterator;
	private boolean conditionEvaluated = false;
	private boolean conditionValue;
	private E nextEntity = null;

	protected IfIterator(IEntityIterator<?> conditionIterator, IEntityIterator<E> doIterator) {
		super(doIterator);
		this.conditionIterator = conditionIterator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		IfIterator<E> iterator = (IfIterator<E>) super.clone(cc);
		iterator.conditionIterator = cc.clone(conditionIterator);
		return iterator;
	}

	protected boolean predicateIsTrue() {
		if (!conditionEvaluated) {
			conditionEvaluated = true;
			if (conditionIterator.hasNext()) {
				getBindings().wEnterScope(lookaheadScope(), true);
				conditionIterator.next();
				getBindings().wExitScope();
				lookaheadScope.wEnterScope();
				conditionValue = true;
			} else
				conditionValue = false;
		}
		return conditionValue;
	}

	@Override
	public boolean hasNext() {
		return lookahead() != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E lookahead() {
		if (nextEntity != null)
			return nextEntity;

		boolean isFirstValue = !conditionEvaluated;
		if (predicateIsTrue()) {
			clearLookaheadScope();
			getBindings().wEnterScope(lookaheadScope(), true);
			nextEntity = super.lookahead();
			getBindings().wExitScope();
			lookaheadScope().wAddAll(super.lookaheadScope());

			if (isFirstValue && nextEntity == null)
				nextEntity = (E) BindingManagerFactory.instance.createVoid();
		} else
			nextEntity = null;

		return nextEntity;
	}

	@Override
	public E next() {
		E result = lookahead();
		if (result == null)
			throw new NoSuchElementException();
		
		getBindings().wEnterScope(lookaheadScope(), true);
		if (super.hasNext())
			super.next();
		getBindings().wExitScope(true);

		nextEntity = null;
		return result;
	}

	@Override
	public void reset(IEntity entity) {
		nextEntity = null;
		if (conditionEvaluated) {
			conditionEvaluated = false;
			if (conditionValue) {
				lookaheadScope.wExitScope();
				lookaheadScope.wClear();
			}
		}
		conditionIterator.reset(entity);
		super.reset(entity);
	}

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
	    	super.setBindings(bindings);
	    	conditionIterator.setBindings(bindings);
		}
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	public IBindingScope lookaheadScope() {
		if (lookaheadScope == null)
			lookaheadScope = BindingManagerFactory.instance.createBindingManager();
		return lookaheadScope;
	}
	protected void clearLookaheadScope() {
		if (lookaheadScope != null) {
			for (String name : lookaheadScope.wNames())
				getBindings().wUnset(name);
			lookaheadScope.wClear();
		}
	}

	@Override
	public void prune() {
    	if (!predicateIsTrue())
    		throw new IllegalStateException();
		super.prune();
	}
	@Override
	public void add(E entity) {
    	if (!predicateIsTrue())
    		throw new IllegalStateException();
		super.add(entity);
	}
	@Override
	public void set(E entity) {
    	if (!predicateIsTrue())
    		throw new IllegalStateException();
		super.set(entity);
	}
	@Override
	public void remove() {
    	if (!predicateIsTrue())
    		throw new IllegalStateException();
		super.remove();
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append("if ");
		sb.append(conditionIterator);
		sb.append(" do ");
		super.toString(sb);
	}
}
