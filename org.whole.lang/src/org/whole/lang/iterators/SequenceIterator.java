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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import org.whole.lang.bindings.AbstractFilterScope;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class SequenceIterator<E extends IEntity> extends AbstractLazyCloneableCompositeIterator<E> {
	private AbstractFilterScope lookaheadScope;
	protected IEntityIterator<? extends E>[] iteratorChain;
	protected int iteratorIndex;
	private E nextEntity = null;

	protected SequenceIterator(IEntityIterator<? extends E>... iteratorChain) {
		this.iteratorChain = iteratorChain;
		initLazyClone(false);
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		SequenceIterator<E> iterator = (SequenceIterator<E>) super.clone(cc);
		iterator.iteratorChain = iteratorChain.clone();
		return iterator;
	}

	public int childIteratorSize() {
		return iteratorChain.length;
	}
	protected IEntityIterator<?> childIterator(int index) {
		return iteratorChain[index];
	}
	@SuppressWarnings("unchecked")
	protected void childIterator(int index, IEntityIterator<?> iterator) {
		iteratorChain[index] = (IEntityIterator<? extends E>) iterator;
	}

	@SuppressWarnings("unchecked")
	protected IEntityIterator<? extends E> currentIterator() {
		return (IEntityIterator<? extends E>) getChildIterator(iteratorIndex);
	}

	protected boolean updateCurrentIterator() {
		final IBindingManager bindings = getBindings();
		final Map<String, IEntity> lookaheadBindings = new HashMap<String, IEntity>();

		IBindingScope currentLookaheadScope = currentIterator().lookaheadScope();
		for (String name : currentLookaheadScope.wLocalNames()) {
			bindings.wUnset(name);
			lookaheadBindings.put(name, currentLookaheadScope.wGet(name));
		}

		if (currentIterator().hasNext())
			return true;
		else {
			for (Entry<String, IEntity> entry : lookaheadBindings.entrySet())
				if (bindings.wIsSet(entry.getKey()))
					bindings.wSet(entry.getKey(), entry.getValue());
				else
					bindings.wDef(entry.getKey(), entry.getValue());					
		
			lookaheadScope().getFilterNames().addAll(lookaheadBindings.keySet());

			while (iteratorIndex < iteratorChain.length-1) {
				iteratorIndex++;
//was			if (resetEntity != null)
//					currentIterator().reset(resetEntity);
				if (currentIterator().hasNext())
					return true;
			}
			return false;
		}
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public E next() {
		if (iteratorChain.length == 0)
			throw new NoSuchElementException();

		getBindings().wEnterScope(lookaheadScope(), true);
		lookaheadScope().setFilterEnabled(false);
		
		if (!updateCurrentIterator()) {
			lookaheadScope().setFilterEnabled(true);
			getBindings().wExitScope();
			throw new NoSuchElementException();
		}
		E result = currentIterator().next();
		lookaheadScope().setFilterEnabled(true);
		getBindings().wExitScope(true);

		nextEntity = null;
		return result;
	}
	public E lookahead() {
		if (nextEntity != null)
			return nextEntity;
		if (iteratorChain.length == 0)
			return null;

		lookaheadScope().setFilterEnabled(false);
		getBindings().wEnterScope(lookaheadScope(), true);
		if (updateCurrentIterator())
			nextEntity = currentIterator().lookahead();
		getBindings().wExitScope();

		lookaheadScope().wAddAll(currentIterator().lookaheadScope());
		lookaheadScope().setFilterEnabled(true);

		return nextEntity;
	}

	@SuppressWarnings("unchecked")
	public void set(E entity) {
		((IEntityIterator<? super E>) currentIterator()).set(entity);
	}
	@SuppressWarnings("unchecked")
	public void add(E entity) {
		((IEntityIterator<? super E>) currentIterator()).add(entity);
	}

	public void remove() {
		currentIterator().remove();
	}

	public void reset(IEntity entity) {
		super.reset(entity);
//		if (iteratorChain.length > 0)
//			iteratorChain[0].reset(entity);
		iteratorIndex = 0;
		clearLookaheadScope();
		nextEntity = null;
	}

	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	public AbstractFilterScope lookaheadScope() {
		if (lookaheadScope == null)
			lookaheadScope = BindingManagerFactory.instance.createExcludeFilterSimpleScope();
		return lookaheadScope;
	}
	protected void clearLookaheadScope() {
		if (lookaheadScope != null) {
			lookaheadScope().setFilterEnabled(false);
			for (String name : lookaheadScope.wLocalNames())
				getBindings().wUnset(name);
			lookaheadScope.wClear();
			lookaheadScope.getFilterNames().clear();
			lookaheadScope().setFilterEnabled(true);
		}
	}

	public void prune() {
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("(");
    	
		for (int i=0; i<iteratorChain.length; i++) {
			if (i>0)
				sb.append(",");
			sb.append(iteratorChain[i].toString());
		}

    	sb.append(")");
    }
}
