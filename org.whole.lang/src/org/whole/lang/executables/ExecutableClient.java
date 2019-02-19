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

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.steppers.IControlFlowProducer;
import org.whole.lang.steppers.IDataFlowConsumer;
import org.whole.lang.steppers.IDifferentiationContext;

/**
 * @author Riccardo Solmi
 */
class ExecutableClient<E extends IEntity> implements IExecutableClient<E>, Iterator<E> {
	protected E lastEntity;
	protected boolean hasCachedEntity;
	protected boolean needMergeScope = true;
	protected IBindingScope executorScope;
	protected IExecutable executable;

	protected ExecutableClient(IExecutable executable) {
		this.executable = executable;
	}

	public IExecutableClient<E> clone() {
		return clone(new CloneContext());
	}
	public IExecutableClient<E> clone(ICloneContext cc) {
		try {
			@SuppressWarnings("unchecked")
			ExecutableClient<E> result = (ExecutableClient<E>) super.clone();
			cc.setClone(this, result);
			result.executorScope = executorScope != null ? executorScope.clone() : null;
			result.executable = cc.differentiate(executable);
			return result;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	public IDifferentiationContext getDifferentiationContext() {
		return executable.getDifferentiationContext();
	}

	public IExecutableClient<E> withConsumer(IDataFlowConsumer consumer) {
		executable.withConsumer(consumer);
		return this;
	}
	public IExecutableClient<E> withAdditionalConsumer(IDataFlowConsumer consumer) {
		executable.withAdditionalConsumer(consumer);
		return this;
	}
	public IDataFlowConsumer getConsumer() {
		return executable.getConsumer();
	}

	public IExecutableClient<E> withSourceEntity(IEntity entity) {
		executable.withSourceEntity(entity);
		return this;
	}
	public IEntity getSourceEntity() {
		return executable.getSourceEntity();
	}

	public IBindingManager getBindings() {
		return executable.getBindings();
	}
	public void setBindings(IBindingManager bindings) {
		executable.setBindings(bindings);
	}

	public void reset(IEntity entity) {
		executable.reset(entity);
		lastEntity = null;
	}

	protected IBindingScope executorScope() {
		if (executorScope == null)
			executorScope = BindingManagerFactory.instance.createSimpleScope();
		return executorScope;
	}
	protected void clearExecutorScope() {
		if (executorScope != null) {
			if (lastEntity != null)
				for (String name : executorScope.wTargetNames())
					getBindings().wUnset(name);
			executorScope.wClear();
		}
	}

	public void forEachExecutableProducer(Consumer<IControlFlowProducer> c) {
		executable.forEachExecutableProducer(c);
	}

	@SuppressWarnings("unchecked")
	public E evaluateNext() {
		clearExecutorScope();
		try {
			getBindings().wEnterScope(executorScope(), true);
			return lastEntity = (E) executable.evaluateNext();
		} finally {
			getBindings().wExitScope(lastEntity != null && needMergeScope);
		}
	}
	@SuppressWarnings("unchecked")
	public E evaluateRemaining() {
		clearExecutorScope();
		try {
			getBindings().wEnterScope(executorScope(), true);
			return lastEntity = (E) executable.evaluateRemaining();
		} finally {
			getBindings().wExitScope(lastEntity != null && needMergeScope);
		}	
	}

	@SuppressWarnings("unchecked")
	public E evaluateSingleton() {
		return (E) executable.evaluateSingleton();
	}
	@SuppressWarnings("unchecked")
	public E evaluate(IEntity self, IBindingManager bm) {
		return (E) executable.evaluate(self, bm);
	}
	@SuppressWarnings("unchecked")
	public E evaluateFirst(IEntity self, IBindingManager bm) {
		return (E) executable.evaluateFirst(self, bm);
	}
	public boolean evaluateAsBooleanOrFail(IEntity selfEntity, IBindingManager bm) {
		return executable.evaluateAsBooleanOrFail(selfEntity, bm);
	}
	public boolean evaluateAsBooleanOrFail() {
		return executable.evaluateAsBooleanOrFail();
	}

	public void callNext() {
		executable.callNext();
	}
	public void callRemaining() {
		executable.callRemaining();
	}


	public ExecutableFactory executableFactory() {
		return executable.executableFactory();
	}

	public IExecutable undecoratedExecutable() {
		return executable.undecoratedExecutable();
	}


	public Iterator<E> iterator() {
		return this;
	}
	public boolean hasNext() {
		return cachingEvaluateNext(false) != null;
	}
	public final E next() {
		E nextEntity = cachingEvaluateNext(true);
		if (nextEntity == null)
			throw new NoSuchElementException();

    	hasCachedEntity = false;
		return nextEntity;
	}
	protected final E cachingEvaluateNext(boolean merge) {
		if (!hasCachedEntity) {
			hasCachedEntity = true;

			needMergeScope = merge;
			evaluateNext();
			needMergeScope = true;

		} else if (merge && lastEntity != null)
			getBindings().wAddAll(executorScope());

		return lastEntity;
	}

	@SuppressWarnings("unchecked")
	public Spliterator<E> spliterator() {
		return (Spliterator<E>) executable.spliterator();
	}

	@SuppressWarnings("unchecked")
	public void forEach(Consumer<? super E> action) {
		executable.forEach((Consumer<? super IEntity>) action);
	}

	public void prune() {
		executable.prune();
	}

	public void set(E entity) {
		executable.set(entity);
	}
	public void add(E entity) {
		executable.add(entity);
	}
	public void remove() {
		executable.remove();
	}

	public void toString(StringBuilder sb) {
		executable.toString(sb);
	}
}

