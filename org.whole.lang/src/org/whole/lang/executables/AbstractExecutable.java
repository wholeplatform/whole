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

import java.util.Spliterator;
import java.util.function.Consumer;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.iterators.ExecutableFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IJavaIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.steppers.IDataFlowConsumer;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractExecutable<E extends IEntity> implements IEntityIterator<E> {
	private IEntity sourceEntity;
	public IExecutable<E> withSourceEntity(IEntity entity) {
		sourceEntity = entity;
		return this;
	}
	public IEntity getSourceEntity() {
		return sourceEntity;
	}

	public IExecutable<E> clone() {
		return clone(new CloneContext());
	}

	@SuppressWarnings("unchecked")
	public IExecutable<E> clone(ICloneContext cc) {
		try {
			AbstractExecutable<E> iterator = (AbstractExecutable<E>) super.clone();
			cc.putClone(this, iterator);
			return iterator;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	protected IDataFlowConsumer consumer = IDataFlowConsumer.IDENTITY;
	public IExecutable<E> withConsumer(IDataFlowConsumer consumer) {
		this.consumer = consumer;
		return this;
	}
	public IDataFlowConsumer getConsumer() {
		return consumer;
	}
	public void doBegin(int size) {
		getConsumer().doBegin(size);
	}
	public void doNext(IEntity entity) {
		getConsumer().doNext(entity);
	}
	public void doEnd() {
		getConsumer().doEnd();
	}

	private IBindingManager bindings;
	public final boolean hasBindings() {
		return bindings != null;
	}
	public final IBindingManager getBindings() {
		if (bindings == null)
			setDefaultBindings();
		return bindings;
	}
	protected void setDefaultBindings() {
		setBindings(BindingManagerFactory.instance.createBindingManager());
	}
    public final void setBindings(IBindingManager bindings) {
    	if (this.bindings != bindings) {
    		this.bindings = bindings;
    		setProducersBindings(bindings);
    	}
	}
    protected void setProducersBindings(IBindingManager bindings) {
	}

	public ExecutableFactory executableFactory() {
		return hasBindings() ? ExecutableFactory.instance(getBindings()) : ExecutableFactory.instance;
	}

	public IEntityIterator<E> iterator() {
//	public IJavaIterator<E> iterator() {
		return this;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(sb);
		return sb.toString();
	}
	public void toString(StringBuilder sb) {
	}


	public E evaluateRemaining() {
		E result = null;
		IBindingManager bm = getBindings();
		ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(resettableScope);
		try {
			E next;
			while ((next = evaluateNext()) != null) {
				result = next;
				bm.setResult(result);
				resettableScope.commit();
			}
		} finally {
			resettableScope.rollback();
			bm.wExitScope();
		}
		return result;
	}

	public E evaluateSingleton() {
		E result = null;
		IBindingManager bm = getBindings();
		ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(resettableScope);
		try {
			if ((result = evaluateNext()) != null) {
				bm.setResult(result);
				resettableScope.commit();
			}
			if (result == null || evaluateNext() != null)
				throw new IllegalArgumentException("The result is not a singleton");
		} finally {
			resettableScope.rollback();
			bm.wExitScope();
		}
		return result;
	}


	public Spliterator<E> spliterator() {
		return this;
	}

	public boolean tryAdvance(Consumer<? super E> action) {
		final E nextValue = evaluateNext();
		final boolean hasNext = nextValue != null;

		if (hasNext) action.accept((E) nextValue);

		return hasNext;
	}

	public void forEach(Consumer<? super E> action) {
		forEachRemaining(action);
	}
	public void forEachRemaining(Consumer<? super E> action) {
		IDataFlowConsumer oldConsumer = getConsumer();

		withConsumer(new IDataFlowConsumer() {
			public void doBegin(int size) {
			}
			@SuppressWarnings("unchecked")
			public void doNext(IEntity entity) {
				action.accept((E) entity);
			}
			public void doEnd() {
			}
		});
		callRemaining();

		withConsumer(oldConsumer);
	}

	public Spliterator<E> trySplit() {
		return null;
	}

	public long estimateSize() {
		return Long.MAX_VALUE;
	}

	public int characteristics() {
		return NONNULL;
	}
}
