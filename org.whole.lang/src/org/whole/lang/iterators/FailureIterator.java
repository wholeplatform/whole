/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class FailureIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
	protected final Throwable failure;

	protected FailureIterator(Throwable failure) {
		this.failure = failure;
	}

	public void reset(IEntity entity) {
	}

	public void setBindings(IBindingManager bindings) {
	}
	public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	public boolean hasNext() {
		return true;
	}
	public E lookahead() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	public E next() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}

	public void prune() {
	}
	public void set(E entity) {
		throw new IllegalStateException(failure);
	}
	public void add(E entity) {
		throw new IllegalStateException(failure);
	}
	public void remove() {
		throw new IllegalStateException(failure);
	}
}
