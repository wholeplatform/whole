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

import java.util.ArrayList;
import java.util.List;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractTransitiveClosureIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
	private IBindingManager bindings;
	protected List<IEntityIterator<E>> iteratorStack = new ArrayList<IEntityIterator<E>>(16);
	protected IEntityIterator<E> lastIterator;
	protected E lastEntity;
	protected boolean includeSelf;

	protected AbstractTransitiveClosureIterator(boolean includeSelf) {
		this.includeSelf = includeSelf;
    }

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractTransitiveClosureIterator<E> iterator = (AbstractTransitiveClosureIterator<E>) super.clone(cc);
		if (iteratorStack != null) {
			iterator.iteratorStack = new ArrayList<IEntityIterator<E>>(iteratorStack.size());
			for (int i=0,size=iteratorStack.size(); i<size; i++) {
				IEntityIterator<E> isClone = cc.clone(iteratorStack.get(i));
				iterator.iteratorStack.add(isClone);
				if (iteratorStack.get(i) == lastIterator)
					iterator.lastIterator = isClone;
			}
		}
		return iterator;
	}

    protected IEntityIterator<E> peekIterator() {
    	return iteratorStack.get(iteratorStack.size()-1);
    }
    protected final void pushIterator(IEntityIterator<E> iterator, IEntity entity) {
    	iterator.setBindings(getBindings());
    	iterator.reset(entity);
    	iteratorStack.add(iterator);
    }
    protected final IEntityIterator<E> popIterator() {
    	return iteratorStack.remove(iteratorStack.size()-1);
    }
    protected IEntityIterator<E> currentIterator() {
    	IEntityIterator<E> result;
		while (!(result = peekIterator()).hasNext() && iteratorStack.size()>1)
			popIterator();

    	return result;
    }

	protected void pushInitialIterators(IEntity entity) {
    	pushIterator(includeSelf ?
    			IteratorFactory.<E>selfIterator() : createRelationIterator(), entity);		
	}
	protected boolean isRelationNotEmpty(IEntity entity) {
		return entity.wSize() > 0;
	}
    protected IEntityIterator<E> createRelationIterator() {
    	return IteratorFactory.<E>childIterator();
    }


    public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	public void reset(IEntity entity) {
		lastEntity = null;
		lastIterator = null;
    	iteratorStack.clear();
    	pushInitialIterators(entity);
    }

    public void setBindings(IBindingManager bindings) {
    	this.bindings = bindings;
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

    public boolean hasNext() {
    	return currentIterator().hasNext();
	}
	public E next() {
		lastIterator = currentIterator();
		E entity = lastIterator.next();

		if (isRelationNotEmpty(entity))
			pushIterator(createRelationIterator(), entity);
		
		return lastEntity = entity;
	}

    public E lookahead() {
    	return currentIterator().lookahead();
    }

	public void prune() {
		for (int i=iteratorStack.size()-1; i>=0; i--)
			if (iteratorStack.get(i) == lastIterator) {
				while (iteratorStack.size()-1 > i)
					popIterator();
				return;
			}
	}

	public void set(E value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	lastIterator.set(value);
	}
	public void add(E value) {
		lastIterator.add(value);
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	prune();

    	lastIterator.remove();

    	lastEntity = null;
    	lastIterator = null;
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("topDown()");
    }
}
