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
package org.whole.lang.executables;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.evaluators.AbstractEvaluator;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class FailureExecutable extends AbstractEvaluator  {
	protected final Throwable failure;

	public FailureExecutable(Throwable failure) {
		this.failure = failure;
	}

    public IEntity evaluateNext() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	@Override
	public IEntity evaluateRemaining() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	@Override
	public IEntity evaluate(IEntity self, IBindingManager bm) {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	@Override
	public IEntity evaluateFirst(IEntity self, IBindingManager bm) {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	@Override
	public IEntity evaluateSingleton() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}

	public boolean hasNext() {
		return true;
	}
	public IEntity next() {
		throw IWholeRuntimeException.asWholeException(failure, getSourceEntity(), null);
	}
	public void prune() {
	}

	public void set(IEntity entity) {
		throw new IllegalStateException(failure);
	}
	public void add(IEntity entity) {
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
