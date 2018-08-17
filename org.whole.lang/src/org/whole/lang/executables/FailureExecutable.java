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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class FailureExecutable<E extends IEntity> extends AbstractExecutableEvaluatingStepper<E> {
	protected final Throwable failure;

	public FailureExecutable(Throwable failure) {
		this.failure = failure;
	}

	public void reset(IEntity entity) {
	}

    public E evaluateNext() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	@Override
	public E evaluateRemaining() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	@Override
	public E evaluate(IEntity self, IBindingManager bm) {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	@Override
	public E evaluateFirst(IEntity self, IBindingManager bm) {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	@Override
	public E evaluateSingleton() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}


	public boolean hasNext() {
		return true;
	}
	public E next() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	public E lookahead() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	public IBindingScope lookaheadScope() {
		return NullScope.instance;
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

    @Override
	public void toString(StringBuilder sb) {
		sb.append("failure()");
    }
}
