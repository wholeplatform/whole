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
package org.whole.lang.evaluators;

import java.util.ArrayList;
import java.util.List;

import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.executables.AbstractExecutableEvaluatingStepperIterator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractTransitiveClosureEvaluator<E extends IEntity> extends AbstractExecutableEvaluatingStepperIterator<E> {
	protected List<IExecutable<E>> iteratorStack = new ArrayList<IExecutable<E>>(16);
	protected IExecutable<E> lastIterator;
	protected boolean includeSelf;

	protected AbstractTransitiveClosureEvaluator(boolean includeSelf) {
		this.includeSelf = includeSelf;
    }

	@Override
	public IExecutable<E> clone(ICloneContext cc) {
		AbstractTransitiveClosureEvaluator<E> iterator = (AbstractTransitiveClosureEvaluator<E>) super.clone(cc);
		if (iteratorStack != null) {
			iterator.iteratorStack = new ArrayList<IExecutable<E>>(iteratorStack.size());
			for (int i=0,size=iteratorStack.size(); i<size; i++) {
				IExecutable<E> isClone = cc.clone(iteratorStack.get(i));
				iterator.iteratorStack.add(isClone);
				if (iteratorStack.get(i) == lastIterator)
					iterator.lastIterator = isClone;
			}
		}
		return iterator;
	}

    protected IExecutable<E> peekIterator() {
    	return iteratorStack.get(iteratorStack.size()-1);
    }
    protected final void pushIterator(IExecutable<E> iterator, IEntity entity) {
    	iterator.setBindings(getBindings());
    	iterator.reset(entity);
    	iteratorStack.add(iterator);
    }
    protected final IExecutable<E> popIterator() {
    	return iteratorStack.remove(iteratorStack.size()-1);
    }

	protected void pushInitialIterators(IEntity entity) {
    	pushIterator(includeSelf ? executableFactory().<E>createSelf() : createRelationIterator(), entity);		
	}

	protected abstract boolean isRelationNotEmpty(IEntity entity);
    protected abstract IExecutable<E> createRelationIterator();


    public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	public void reset(IEntity entity) {
		super.reset(entity);
		lastIterator = null;
    	iteratorStack.clear();
    	pushInitialIterators(entity);
    }

	@Override
	public E evaluateNext() {
    	E entity;
		while ((entity = (lastIterator = peekIterator()).evaluateNext()) == null && iteratorStack.size()>1)
			popIterator();

		if (entity != null) {
			lastEntity = entity;
			if (isRelationNotEmpty(entity))
				pushIterator(createRelationIterator(), entity);
		}

		return entity;
	}

	@Override
	public E evaluateRemaining() {
		while (evaluateNext() != null)
			;
		return lastEntity;
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

	public abstract void toString(StringBuilder sb);
}
