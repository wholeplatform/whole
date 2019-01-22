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

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.steppers.AbstractDataFlowConsumer;
import org.whole.lang.steppers.IDataFlowConsumer;
import org.whole.lang.steppers.IDifferentiationContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractExecutable implements IExecutable, Iterator<IEntity>, Spliterator<IEntity> {
    protected IEntity lastEntity;

	private IEntity sourceEntity;
	public IExecutable withSourceEntity(IEntity entity) {
		sourceEntity = entity;
		return this;
	}
	public IEntity getSourceEntity() {
		return sourceEntity;
	}

	public IExecutable clone() {
		return clone(new CloneContext());
	}

	public IExecutable clone(ICloneContext cc) {
		try {
			AbstractExecutable executable = (AbstractExecutable) super.clone();
			cc.setClone(this, executable);
			return executable;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	public IDifferentiationContext getDifferentiationContext() {
		return null;
	}

	protected IDataFlowConsumer consumer = IDataFlowConsumer.IDENTITY;
	public IExecutable withConsumer(IDataFlowConsumer consumer) {
		this.consumer = consumer;
		return this;
	}
	public IExecutable withAdditionalConsumer(IDataFlowConsumer consumer) {
		this.consumer = this.consumer.getAdded(consumer);
		return this;
	}
	public IDataFlowConsumer getConsumer() {
		return consumer;
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

    public void reset(IEntity entity) {
    	lookaheadEntity = null;
		lastEntity = null;
    }

	public IEntity evaluateRemaining() {
		IEntity result = null;
		IBindingManager bm = getBindings();

		IBindingScope nextScope = BindingManagerFactory.instance.createSimpleScope();
		IBindingScope resultScope = null;

		try {
			bm.wEnterScope(nextScope, true);
			IEntity next;
			while ((next = evaluateNext()) != null) {
				result = next;
				resultScope = nextScope.clone();
				nextScope.wClear();
			}
		} finally {
			bm.wExitScope();
			if (resultScope != null)
				bm.wAddAll(resultScope);
		}
		return result;
	}

	public IEntity evaluateSingleton() {
		IEntity result = null;
		IBindingManager bm = getBindings();

		IBindingScope nextScope = BindingManagerFactory.instance.createSimpleScope();
		IBindingScope resultScope = null;

		try {
			bm.wEnterScope(nextScope, true);
			if ((result = evaluateNext()) != null) {
				resultScope = nextScope.clone();
				nextScope.wClear();
			}
			if (result == null || evaluateNext() != null)
				throw new IllegalArgumentException("The result is not a singleton");
		} finally {
			bm.wExitScope();
			if (resultScope != null)
				bm.wAddAll(resultScope);
		}
		return result;
	}


	public Iterator<IEntity> iterator() {
		return this;
	}

	private IEntity lookaheadEntity;
	public boolean hasNext() {
		if (lookaheadEntity == null)
			lookaheadEntity = evaluateNext();
		return lookaheadEntity != null;
	}

	public IEntity next() {
		if (lookaheadEntity == null)
			lookaheadEntity = evaluateNext();

		IEntity result = lookaheadEntity;
		lookaheadEntity = null;
		return result;
	}

	//TODO workaround to avoid conflict with the default method inherited
	public void remove() {
        throw new UnsupportedOperationException("remove");
    }


	public Spliterator<IEntity> spliterator() {
		return this;
	}

	public boolean tryAdvance(Consumer<? super IEntity> action) {
		final IEntity nextValue = evaluateNext();
		final boolean hasNext = nextValue != null;

		if (hasNext) action.accept(nextValue);

		return hasNext;
	}

	public void forEach(Consumer<? super IEntity> action) {
		forEachRemaining(action);
	}
	public void forEachRemaining(Consumer<? super IEntity> action) {
		IDataFlowConsumer oldConsumer = getConsumer();

		withConsumer(new AbstractDataFlowConsumer() {
			public void accept(IEntity entity) {
				action.accept(entity);
			}
			public void done() {
			}
		});
		callRemaining();

		withConsumer(oldConsumer);
	}

	public Spliterator<IEntity> trySplit() {
		return null;
	}

	public long estimateSize() {
		return Long.MAX_VALUE;
	}

	public int characteristics() {
		return NONNULL;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(sb);
		return sb.toString();
	}
	public void toString(StringBuilder sb) {
	}
}
