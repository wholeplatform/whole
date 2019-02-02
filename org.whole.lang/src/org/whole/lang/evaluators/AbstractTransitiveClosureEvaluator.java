/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractTransitiveClosureEvaluator extends AbstractEvaluator {
	protected List<IExecutable> executableStack = new ArrayList<IExecutable>(16);
	protected IExecutable lastExecutable;
	protected boolean includeSelf;

	protected AbstractTransitiveClosureEvaluator(boolean includeSelf) {
		this.includeSelf = includeSelf;
    }

	@Override
	public IExecutable clone(ICloneContext cc) {
		AbstractTransitiveClosureEvaluator evaluator = (AbstractTransitiveClosureEvaluator) super.clone(cc);
		if (executableStack != null) {
			evaluator.executableStack = new ArrayList<IExecutable>(executableStack.size());
			for (int i=0,size=executableStack.size(); i<size; i++) {
				IExecutable isClone = cc.differentiate(executableStack.get(i));
				evaluator.executableStack.add(isClone);
				if (executableStack.get(i) == lastExecutable)
					evaluator.lastExecutable = isClone;
			}
		}
		return evaluator;
	}

    protected IExecutable peekExecutable() {
    	return executableStack.get(executableStack.size()-1);
    }
    protected final void pushExecutable(IExecutable executable, IEntity entity) {
    	executable.setBindings(getBindings());
    	executable.reset(entity);
    	executableStack.add(executable);
    }
    protected final IExecutable popExecutable() {
    	return executableStack.remove(executableStack.size()-1);
    }

	protected void pushInitialExecutables(IEntity entity) {
    	pushExecutable(includeSelf ? executableFactory().createSelf() : createRelationExecutable(), entity);		
	}

	protected abstract boolean isRelationNotEmpty(IEntity entity);
    protected abstract IExecutable createRelationExecutable();


	public void reset(IEntity entity) {
		super.reset(entity);
		lastExecutable = null;
    	executableStack.clear();
    	pushInitialExecutables(entity);
    }

	@Override
	public IEntity evaluateNext() {
    	IEntity entity;
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
//	public IEntity evaluateRemaining() {
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

	public void set(IEntity entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	lastExecutable.set(entity);
	}
	public void add(IEntity entity) {
		lastExecutable.add(entity);
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
