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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.instrumentation.IEntityIteratorInstrumentation;
import org.whole.lang.iterators.instrumentation.IdentityInstrumentation;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class InstrumentingIterator<E extends IEntity> extends AbstractDelegatingIterator<E> {
	public static IEntityIteratorInstrumentation instrumentation =
//			CompositeInstrumentation.instance;
			IdentityInstrumentation.instance;

	public InstrumentingIterator(IEntityIterator<E> iterator) {
		super(iterator);
	}

	public IEntity getResetEntity() {
		return resetEntity;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		instrumentation.beforeClone(this);
		IEntityIterator<E> result = super.clone(cc);
		instrumentation.afterClone(this, result);
		return result;
	}

	@Override
	protected void setArgumentsBindings(IBindingManager bindings) {
		instrumentation.beforeSetBindings(this);
		super.setArgumentsBindings(bindings);
		instrumentation.afterSetBindings(this);
	}
	
	@Override
	public void reset(IEntity entity) {
		instrumentation.beforeReset(this);
		super.reset(entity);
		instrumentation.afterReset(this);
	}

	@Override
	public boolean hasNext() {
		instrumentation.beforeHasNext(this);
		boolean result = super.hasNext();
		instrumentation.afterHasNext(this, result);
		return result;
	}

	@Override
	public E lookahead() {
		instrumentation.beforeLookahead(this);
		E result = super.lookahead();
		instrumentation.afterLookahead(this, result);
		return result;
	}

	@Override
	public E next() {
		instrumentation.beforeNext(this);
		E result = super.next();
		instrumentation.afterNext(this, result);
		return result;
	}

	@Override
	public IEntityIterator<E> withSourceEntity(IEntity entity) {
		getIterator().withSourceEntity(entity);
		return super.withSourceEntity(entity);
	}
}
