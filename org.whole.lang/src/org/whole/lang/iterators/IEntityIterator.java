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
import org.whole.lang.evaluators.IEvaluator;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.ICloneable;
import org.whole.lang.producers.IControlFlowProducer;
import org.whole.lang.reflect.ISourceable;
import org.whole.lang.steppers.IDataFlowConsumer;

/**
 * @author Riccardo Solmi
 */
public interface IEntityIterator<E extends IEntity> extends IControlFlowProducer, IEvaluator<E>, IJavaIterator<E>, ICloneable, ISourceable {
	public IEntityIterator<E> withConsumer(IDataFlowConsumer consumer);
	public IDataFlowConsumer getConsumer();
//	public IEntityIterator<E> withProducers(IControlFlowProducer... producers);
//	public IEntityIterator<E> withProducer(int index, IControlFlowProducer producer);
//	public int getProducersSize();
//	public IControlFlowProducer getProducer(int index);

	public IEntityIterator<E> withSourceEntity(IEntity entity);

	public IEntityIterator<E> clone();
	public IEntityIterator<E> clone(ICloneContext cc);

	public IBindingManager getBindings();
	public void setBindings(IBindingManager bindings);
	public void reset(IEntity entity);

	public void prune();

	public void set(E entity);
	public void add(E entity);

	public void toString(StringBuilder sb);

	public IteratorFactory iteratorFactory();

	public default IEntityIterator<E> specificIterator() {
		return this instanceof InstrumentingIterator ? ((InstrumentingIterator<E>) this).getIterator() : this;
	}

	public default E evaluate(IEntity self, IBindingManager bm) {
		IEntity oldSelfEntity = bm.wGet(IBindingManager.SELF);

		bm.wDef(IBindingManager.SELF, self);
		setBindings(bm);
		reset(self);

		E result = evaluateRemaining();

		if (oldSelfEntity == null && bm.wGet(IBindingManager.SELF) == self)
			bm.wUnset(IBindingManager.SELF);

		return result;
	}

	public default E evaluateFirst(IEntity self, IBindingManager bm) {
		IEntity oldSelfEntity = bm.wGet(IBindingManager.SELF);
    	
		bm.wDef(IBindingManager.SELF, self);
		setBindings(bm);
		reset(self);

		E result = evaluateNext();

		if (oldSelfEntity == null && bm.wGet(IBindingManager.SELF) == self)
			bm.wUnset(IBindingManager.SELF);

		return result;
	}

	public default boolean tryEvaluateAsBoolean(IEntity selfEntity, IBindingManager bm) {
		try {
			return evaluate(selfEntity, bm).wBooleanValue();
        } catch (Throwable e) {
            throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), bm);
        }
	}

}
