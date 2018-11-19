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

import org.whole.lang.executables.AbstractExecutableEvaluatingStepper;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractTransitiveClosureEvaluator<E extends IEntity> extends AbstractExecutableEvaluatingStepper<E> {
	protected List<IExecutable<E>> executableStack = new ArrayList<IExecutable<E>>(16);
	protected IExecutable<E> lastExecutable;
	protected boolean includeSelf;

	protected AbstractTransitiveClosureEvaluator(boolean includeSelf) {
		this.includeSelf = includeSelf;
    }

	@Override
	public IExecutable<E> clone(ICloneContext cc) {
		AbstractTransitiveClosureEvaluator<E> iterator = (AbstractTransitiveClosureEvaluator<E>) super.clone(cc);
		if (executableStack != null) {
			iterator.executableStack = new ArrayList<IExecutable<E>>(executableStack.size());
			for (int i=0,size=executableStack.size(); i<size; i++) {
				IExecutable<E> isClone = cc.clone(executableStack.get(i));
				iterator.executableStack.add(isClone);
				if (executableStack.get(i) == lastExecutable)
					iterator.lastExecutable = isClone;
			}
		}
		return iterator;
	}

    protected IExecutable<E> peekExecutable() {
    	return executableStack.get(executableStack.size()-1);
    }
    protected final void pushExecutable(IExecutable<E> executable, IEntity entity) {
    	executable.setBindings(getBindings());
    	executable.reset(entity);
    	executableStack.add(executable);
    }
    protected final IExecutable<E> popExecutable() {
    	return executableStack.remove(executableStack.size()-1);
    }

	protected void pushInitialExecutables(IEntity entity) {
    	pushExecutable(includeSelf ? executableFactory().<E>createSelf() : createRelationExecutable(), entity);		
	}

	protected abstract boolean isRelationNotEmpty(IEntity entity);
    protected abstract IExecutable<E> createRelationExecutable();


	public void reset(IEntity entity) {
		super.reset(entity);
		lastExecutable = null;
    	executableStack.clear();
    	pushInitialExecutables(entity);
    }

	@Override
	public E evaluateNext() {
    	E entity;
		while ((entity = (lastExecutable = peekExecutable()).evaluateNext()) == null && executableStack.size()>1)
			popExecutable();

		if (entity != null) {
			lastEntity = entity;
			if (isRelationNotEmpty(entity))
				pushExecutable(createRelationExecutable(), entity);
		}

		return entity;
	}

//	@Override
//	public E evaluateRemaining() {
//		while (evaluateNext() != null)
//			;
//		return lastEntity;
//	}

	public void prune() {
		for (int i=executableStack.size()-1; i>=0; i--)
			if (executableStack.get(i) == lastExecutable) {
				while (executableStack.size()-1 > i)
					popExecutable();
				return;
			}
	}

	public void set(E value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	lastExecutable.set(value);
	}
	public void add(E value) {
		lastExecutable.add(value);
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	prune();

    	lastExecutable.remove();

    	lastEntity = null;
    	lastExecutable = null;
	}

	public abstract void toString(StringBuilder sb);
}
