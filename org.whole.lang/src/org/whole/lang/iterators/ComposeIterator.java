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
 * iterator(nestedIterators[0](nestedIterators[1](...)))
 * 
 * @author Riccardo Solmi
 */
public class ComposeIterator<E extends IEntity> extends AbstractLazyCloneableCompositeIterator<E> {
	private IBindingScope lookaheadScope;
	private IEntityIterator<E> iterator;
	private IEntityIterator<? extends IEntity>[] nestedIterators;
	private int laIndex = -1;
	private E nextEntity = null;

	protected ComposeIterator(IEntityIterator<E> iterator, IEntityIterator<? extends IEntity>... nestedIterators) {
		this.iterator = iterator;
		this.nestedIterators = nestedIterators;
		laIndex = nestedIterators.length-1;
		initLazyClone(false);
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		ComposeIterator<E> iterator = (ComposeIterator<E>) super.clone(cc);
		iterator.nestedIterators = iterator.nestedIterators.clone();
		return iterator;
	}

	protected boolean lazyReset() {
		return false;
	}

	public int childIteratorSize() {
		return 1+nestedIterators.length;
	}
	protected IEntityIterator<?> childIterator(int index) {
		return index == 0 ? iterator : nestedIterators[index-1];
	}
	@SuppressWarnings("unchecked")
	protected void childIterator(int index, IEntityIterator<?> iterator) {
		if (index == 0)
			this.iterator = (IEntityIterator<E>) iterator;
		else
			nestedIterators[index-1] = (IEntityIterator<? extends E>) iterator;
	}

	protected final IEntityIterator<? extends IEntity> nestedIterator(int index) {
		return getChildIterator(index+1);
//was		return index == -1 ? iterator : nestedIterators[index];
	}
	protected boolean updateIterators(int startIndex) {
		int updateIndex = startIndex;
		do {
			lookaheadScope().wClear();
			for (int i=nestedIterators.length-1; i>updateIndex; i--)
				lookaheadScope().wAddAll(nestedIterator(i).lookaheadScope());
				
			while (nestedIterator(updateIndex).hasNext()) {
				if (updateIndex == -1)
					return true;
				IEntity la = nestedIterator(updateIndex).next();
				nestedIterator(--updateIndex).reset(la);
			}
		} while (updateIndex++ < startIndex);
		return false;
	}
	protected boolean updateIterators() {
		boolean result = false;
		if (resetEntity != null) {
			nestedIterator(laIndex).reset(resetEntity);
			resetEntity = null;
		}
		getBindings().wEnterScope(lookaheadScope(), true);
		for (int updateIndex = laIndex; updateIndex <= nestedIterators.length-1; updateIndex++)
			if (updateIterators(updateIndex)) {
				laIndex = -1;
				result = true;
				break;
			}
		getBindings().wExitScope();
		return result;
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public E next() {
		E result = lookahead();
		if (result == null)
			throw new NoSuchElementException();

		//FIXME path prefix bindings are not bound
//		for (String name : getChildIterator(0).lookaheadScope().wLocalNames()) {
//			getBindings().wUnset(name);
//			lookaheadScope().wUnset(name);
//		}
//		getBindings().wEnterScope(lookaheadScope(), true);
		getChildIterator(0).next();
//		getBindings().wExitScope(true);
		getBindings().wAddAll(lookaheadScope());

		laIndex = -1;
		nextEntity = null;
		return result;
	}
	@SuppressWarnings("unchecked")
	public E lookahead() {
		if (nextEntity != null)
			return nextEntity;

		if (!updateIterators())
			return null;

		//FIXME path prefix bindings are not bound
//		getBindings().wEnterScope(lookaheadScope(), true);
		nextEntity = ((IEntityIterator<E>) getChildIterator(0)).lookahead();
//		getBindings().wExitScope();
		lookaheadScope().wAddAll(getChildIterator(0).lookaheadScope());
		return nextEntity;
	}

	@SuppressWarnings("unchecked")
	public void set(E entity) {
		((IEntityIterator<E>) getChildIterator(0)).set(entity);
	}
	@SuppressWarnings("unchecked")
	public void add(E entity) {
		((IEntityIterator<E>) getChildIterator(0)).add(entity);
	}
	public void remove() {
		getChildIterator(0).remove();
	}

	public void reset(IEntity entity) {
		super.reset(entity);
		nextEntity = null;
		laIndex = nestedIterators.length-1;
	}

	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}
	public IBindingScope lookaheadScope() {
		if (lookaheadScope == null)
			lookaheadScope = BindingManagerFactory.instance.createSimpleScope();
		return lookaheadScope;
	}
	
	public void prune() {
	}

    @Override
	public void toString(StringBuilder sb) {    	
		for (int i=nestedIterators.length-1; i>=0; i--) {
			sb.append(nestedIterators[i].toString());
			sb.append("/");
		}
		sb.append(iterator.toString());
    }
}
