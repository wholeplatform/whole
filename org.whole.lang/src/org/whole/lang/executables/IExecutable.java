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
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.steppers.IDataFlowConsumer;

/**
 * @author Riccardo Solmi
 */
public interface IExecutable extends IExecutableClient<IEntity> {
	public IExecutable withConsumer(IDataFlowConsumer consumer);
	public IExecutable withAdditionalConsumer(IDataFlowConsumer consumer);
	public IDataFlowConsumer getConsumer();
//	public IExecutable withProducers(IControlFlowProducer... producers);
//	public IExecutable withProducer(int index, IControlFlowProducer producer);
//	public int producersSize();
//	public IExecutable getProducer(int index);

	public IExecutable withSourceEntity(IEntity entity);

	public IExecutable clone();
	public IExecutable clone(ICloneContext cc);

	public default <E extends IEntity> IExecutableClient<E> client() {
		return new ExecutableClient<E>(this);
	}

	public default IExecutable undecoratedExecutable() {
		return this instanceof InstrumentingExecutable ? ((InstrumentingExecutable) this).getExecutable() : this;
	}

	public default IEntity evaluate(IEntity self, IBindingManager bm) {
		IEntity oldSelfEntity = bm.wGet(IBindingManager.SELF);

		bm.wDef(IBindingManager.SELF, self);
		setBindings(bm);
		reset(self);

		IEntity result = evaluateRemaining();

		if (oldSelfEntity == null && bm.wGet(IBindingManager.SELF) == self)
			bm.wUnset(IBindingManager.SELF);

		return result;
	}

	public default IEntity evaluateFirst(IEntity self, IBindingManager bm) {
		IEntity oldSelfEntity = bm.wGet(IBindingManager.SELF);
    	
		bm.wDef(IBindingManager.SELF, self);
		setBindings(bm);
		reset(self);

		IEntity result = evaluateNext();

		if (oldSelfEntity == null && bm.wGet(IBindingManager.SELF) == self)
			bm.wUnset(IBindingManager.SELF);

		return result;
	}

	public default boolean evaluateAsBooleanOrFail(IEntity selfEntity, IBindingManager bm) {
		try {
			return evaluate(selfEntity, bm).wBooleanValue();
        } catch (Throwable e) {
            throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), bm);
        }
	}

	public default boolean evaluateAsBooleanOrFail() {
		try {
			return evaluateRemaining().wBooleanValue();
        } catch (Throwable e) {
            throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), getBindings());
        }
	}
}

