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

import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.AbstractExecutableIteratingEvaluatingStepper;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.resources.FunctionLibraryRegistry;

/**
 * @author Riccardo Solmi
 */
public class FunctionApplicationIterator extends AbstractExecutableIteratingEvaluatingStepper<IEntity> {
	protected String functionUri;
	private IEntityIterator<IEntity> functionIterator;
	private boolean lazyReset;
	private IEntity nextEntity = null;
	private IEntity resetEntity = null;

	public FunctionApplicationIterator(String functionUri) {
		this.functionUri = functionUri;
		functionIterator = null;
		lazyReset = true;
	}

	@Override
	public IExecutable<IEntity> clone(ICloneContext cc) {
		FunctionApplicationIterator iterator = (FunctionApplicationIterator) super.clone(cc);
		iterator.functionIterator = cc.clone(functionIterator);
		return iterator;
	}

	protected IEntityIterator<IEntity> functionIterator() {
		if (functionIterator == null) {
			try {
				functionIterator = FunctionLibraryRegistry.instance().getFunctionCode(functionUri, true, getBindings());
			} catch (Exception e) {
				throw new WholeIllegalArgumentException("Unknown function application: "+functionUri, e).withSourceEntity(resetEntity).withBindings(getBindings());
			}
	    	functionIterator.setBindings(getBindings());
		}
		if (lazyReset && resetEntity != null) {
			lazyReset = false;
			functionIterator.reset(resetEntity);
		}
		return functionIterator;
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public IEntity next() {
		IEntity result = functionIterator().next();
		getBindings().wAddAll(lookaheadScope());

		nextEntity = null;
		return result;
	}
	public IEntity lookahead() {
		if (nextEntity != null)
			return nextEntity;

		if (functionIterator == null && !lazyReset)
			return null;

		IBindingScope laScope = lookaheadScope();
		for (String name : laScope.wLocalNames())
			getBindings().wUnset(name);

		return nextEntity = functionIterator().lookahead();
	}

	public void set(IEntity entity) {
		functionIterator().set(entity);
	}
	public void add(IEntity entity) {
		functionIterator().add(entity);
	}

	public void remove() {
		functionIterator().remove();
	}

	public void reset(IEntity entity) {
		resetEntity = entity;
		functionIterator = null;
		lazyReset = true;
//		lookaheadScope = null;
		nextEntity = null;
	}

//	private IDelegatingScope lookaheadScope;
	public IBindingScope lookaheadScope() {
//		if (lookaheadScope != null)
//			return lookaheadScope.wWithTargetScope(functionIterator().lookaheadScope());
//		else
			return functionIterator != null ? functionIterator().lookaheadScope() : NullScope.instance;
	}

	public void prune() {
		functionIterator().prune();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append(functionUri);
    	sb.append("()");
    }
}
