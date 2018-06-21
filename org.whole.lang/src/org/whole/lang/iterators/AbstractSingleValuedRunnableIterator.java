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
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractSingleValuedRunnableIterator<E extends IEntity> extends AbstractRunnableIterator<E> {
	private IBindingScope lookaheadScope;
	protected boolean isExecuted;
	protected E result;
    protected E lastEntity;

	protected AbstractSingleValuedRunnableIterator(IEntityIterator<?>... argsIterators) {
		super(argsIterators);
	}
	protected AbstractSingleValuedRunnableIterator(int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		super(optionalArgsIndexes, argsIterators);
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

	public void reset(IEntity entity) {
        super.reset(entity);
		isExecuted = false;
		result = lastEntity = null;

		clearLookaheadScope();
    }

	@SuppressWarnings("unchecked")
	protected E getResult() {
		if (!isExecuted) {
			isExecuted = true;
			IBindingManager bm = getBindings();
			bm.setResult(null);

			getBindings().wEnterScope(lookaheadScope(), true);

			try {
				run(selfEntity, bm);
	        } catch (Throwable e) {
	            throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), bm);
	        }
			result = (E) bm.getResult();

			getBindings().wExitScope();
		}
		return result;
	}

	public boolean hasNext() {
		return getResult() != null;
	}

	public E lookahead() {
		return getResult();
	}

	public E next() {
    	E result = lookahead();
    	if (result == null)
        	throw new NoSuchElementException();

    	getBindings().wAddAll(lookaheadScope());

    	this.result = null;
    	return lastEntity = result;
	}

    public void prune() {
    }
	public void set(E entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wSet(lastEntity, entity);
    	lastEntity = entity;
	}
	public void add(E entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	if (EntityUtils.hasParent(lastEntity)) {
    		IEntity parent = lastEntity.wGetParent();
			parent.wAdd(parent.wIndexOf(lastEntity), entity);
    	}
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wRemove(lastEntity);
    	lastEntity = null;
	}
}
