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

import java.util.NoSuchElementException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.iterators.AbstractCloneableIterator;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCloneableEvaluatorWithDelegatingIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
	private boolean isEvaluated;
	private IBindingScope lookaheadScope;
	protected E lookaheadEntity;
    protected E lastEntity;

    public void reset(IEntity entity) {
    	isEvaluated = false;
		lastEntity = null;
		lookaheadEntity = null;
		clearLookaheadScope();
   }

	public boolean hasNext() {
		cachedEvaluateNext();
		return lookaheadEntity != null;
	}

	public E next() {
		cachedEvaluateNext();
		if (lookaheadEntity == null)
			throw new NoSuchElementException();

    	getBindings().wAddAll(lookaheadScope());
		return lastEntity = lookaheadEntity;
	}

	public E lookahead() {
		cachedEvaluateNext();
		return lookaheadEntity;
	}
	protected void cachedEvaluateNext() {
		if (!isEvaluated) {
			isEvaluated = true;
			getBindings().wEnterScope(lookaheadScope(), true);
			lookaheadEntity = evaluateNext();
			getBindings().wExitScope();
		}
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

