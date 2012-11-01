/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.iterators;

import java.util.NoSuchElementException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.iterators.AbstractDelegatingIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCartesianIterator<E extends IEntity> extends AbstractDelegatingIterator<E> {
	protected IEntityIterator<? extends E> valuesIterator;
	private E nextEntity = null;
	private IEntity lastToEntity;

	protected AbstractCartesianIterator(IEntityIterator<? extends E> valuesIterator, IEntityIterator<E> toIterator) {
		super(toIterator);
		this.valuesIterator = valuesIterator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractCartesianIterator<E> iterator = (AbstractCartesianIterator<E>) super.clone(cc);
		iterator.valuesIterator = cc.clone(valuesIterator);
		return iterator;
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public E lookahead() {
		if (nextEntity != null)
			return nextEntity;

		do {
			if (lastToEntity == null) {
				if (!super.hasNext())
					return null;
				
				lastToEntity = super.next();
	
				clearLookaheadScope();
				valuesIterator.reset(lastToEntity);
			}
	
			getBindings().wEnterScope(lookaheadScope(), true);
	
			lookaheadScope().wAddAll(super.lookaheadScope());
			lookaheadScope().wDef("self", lastToEntity);
	
			nextEntity = valuesIterator.lookahead();
	
			getBindings().wExitScope();
	
			if (nextEntity == null)
				lastToEntity = null;
		} while (nextEntity == null);

		nextEntity = doLookahead(lastToEntity, nextEntity);

		return nextEntity;
	}
	protected abstract E doLookahead(IEntity lastToEntity, E nextEntity);

	public E next() {
		E result = lookahead();
		if (result == null)
			throw new NoSuchElementException();

		getBindings().wAddAll(lookaheadScope());
		valuesIterator.next();
		
		doNext(lastToEntity, result);

		nextEntity = null;
		return result;
	}
	protected abstract void doNext(IEntity lastToEntity, E nextEntity);
	
	public void reset(IEntity entity) {
		super.reset(entity);
		clearLookaheadScope();
		lastToEntity = null;
		nextEntity = null;
	}

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
			super.setBindings(bindings);
	    	valuesIterator.setBindings(bindings);
		}
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	private IBindingScope lookaheadScope;
	public IBindingScope lookaheadScope() {
		if (lookaheadScope == null)
			lookaheadScope = BindingManagerFactory.instance.createSimpleScope();
		return lookaheadScope;
	}
	protected void clearLookaheadScope() {
		if (lookaheadScope != null) {
			for (String name : lookaheadScope.wLocalNames())
				getBindings().wUnset(name);
			lookaheadScope.wClear();
		}
	}
}
