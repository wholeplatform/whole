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
public abstract class AbstractProductIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
	private IBindingManager bindings;
	private IBindingScope lookaheadScope;
	protected IEntityIterator<? extends IEntity>[] iterators;
	protected IEntity initialEntity;
	protected IEntity[] tuple;
	protected int tupleUpdateIndex;

	protected AbstractProductIterator(IEntityIterator<? extends IEntity>... iterators) {
		assert iterators.length > 0;
		
		this.iterators = iterators;
		tuple = new IEntity[iterators.length];
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractProductIterator<E> iterator = (AbstractProductIterator<E>) super.clone(cc);
		iterator.iterators = iterators.clone();
		for (int i=0; i<iterators.length; i++)
			iterator.iterators[i] = cc.clone(iterators[i]);
		return iterator;
	}

	protected abstract boolean updateIterators();

	public boolean hasNext() {
		return updateIterators();
	}

	public IEntity[] nextTuple() {
		if (updateIterators()) {
			getBindings().wAddAll(lookaheadScope());
		} else
			throw new NoSuchElementException();
		return tuple;
	}
	public IEntity[] lookaheadTuple() {
		return updateIterators() ? tuple : null;
	}

	public void remove() {
		for (IEntityIterator<?> i : iterators)
			i.remove();
	}

	public void reset(IEntity entity) {
		initialEntity = entity;
		for (IEntityIterator<?> i : iterators)
			i.reset(entity);
		tupleUpdateIndex = 0;
		lookaheadScope = null;
	}

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
			this.bindings = bindings;
			for (IEntityIterator<?> i : iterators)
				i.setBindings(bindings);
		}
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
		sb.append("(");
    	
		for (int i=0; i<iterators.length; i++) {
			if (i>0)
				sb.append(" x ");
			sb.append(iterators[i].toString());
		}

    	sb.append(")");
    }
}
