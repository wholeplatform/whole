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
package org.whole.lang.executables;

import java.util.NoSuchElementException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 * 
 * TODO keep same code in the two classes except declaration line
 */
//public abstract class AbstractExecutableSteppingEvaluatingIterator<E extends IEntity> extends AbstractExecutableSteppingEvaluator<E> {
public abstract class AbstractExecutableEvaluatingStepperIterator<E extends IEntity> extends AbstractExecutableEvaluatingStepper<E> {
	private boolean lookaheadIsCached;
	private IBindingScope lookaheadScope;
	protected E lookaheadEntity;
    protected E lastEntity;

    public void reset(IEntity entity) {
    	lookaheadIsCached = false;
		lastEntity = null;
		lookaheadEntity = null;
		clearLookaheadScope();
   }

	public final boolean hasNext() {
		return cachedEvaluateNext() != null;
	}

	public final E next() {
		E nextEntity = cachedEvaluateNext();
		if (nextEntity == null)
			throw new NoSuchElementException();

    	getBindings().wAddAll(lookaheadScope());

    	lookaheadEntity = null;
		return lastEntity = nextEntity;
	}

	public final E lookahead() {
		return cachedEvaluateNext();
	}
	protected E cachedEvaluateNext() {
		if (!lookaheadIsCached) {
			lookaheadIsCached = true;
			
			getBindings().wEnterScope(lookaheadScope(), true);

			E cachedLastEntity = lastEntity;
			lookaheadEntity = evaluateNext();
			lastEntity = cachedLastEntity;

			getBindings().wExitScope();
		}
		return lookaheadEntity;
	}

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

