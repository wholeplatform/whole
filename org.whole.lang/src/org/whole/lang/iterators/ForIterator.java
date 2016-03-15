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
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class ForIterator<E extends IEntity> extends AbstractDelegatingIterator<E> {
	private IBindingManager lookaheadScope;
	private IEntityIterator<?> forIterator;
	private IEntity forEntity = null;
	private E nextEntity = null;

	protected ForIterator(IEntityIterator<?> forIterator, IEntityIterator<E> doIterator) {
		super(doIterator);
		this.forIterator = forIterator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		ForIterator<E> iterator = (ForIterator<E>) super.clone(cc);
		iterator.forIterator = cc.clone(forIterator);
		return iterator;
	}

	protected boolean updateForEntity() {
		if (lookaheadScope.wEnclosingScope() == NullScope.instance)
			lookaheadScope.wEnterScope();//FIXME workaround see choose2 test

		lookaheadScope.wExitScope();
		lookaheadScope.wClear();
		if (forIterator.hasNext()) {
			forEntity = forIterator.next();
			lookaheadScope.wEnterScope();
//was			super.reset(forEntity);
			getIterator().reset(forEntity);
			return true;
		} else
			return false;
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

		clearLookaheadScope();
		getBindings().wEnterScope(lookaheadScope(), true);

		boolean isFirstValue = resetEntity != null;
		if (isFirstValue) {
			lookaheadScope.wEnterScope();
			forIterator.reset(resetEntity);
			resetEntity = null;
		}

		if (forEntity != null)
			nextEntity = super.lookahead();
		while (nextEntity == null && updateForEntity())
			nextEntity = super.lookahead();

		getBindings().wExitScope();
		if (nextEntity != null)
			lookaheadScope().wAddAll(super.lookaheadScope());

		if (isFirstValue && forEntity != null && nextEntity == null)
			nextEntity = (E) BindingManagerFactory.instance.createVoid();

		return nextEntity;
	}

	@Override
	public E next(){
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
		forEntity = null;
		nextEntity = null;
		resetEntity = entity;
		clearLookaheadScope();
	}

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
	    	super.setBindings(bindings);
	    	forIterator.setBindings(bindings);
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
	public void toString(StringBuilder sb) {
		sb.append("foreach ");
		sb.append(forIterator);
		sb.append(" do ");
		super.toString(sb);
	}
}
