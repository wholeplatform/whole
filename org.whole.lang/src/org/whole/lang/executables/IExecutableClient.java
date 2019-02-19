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
import org.whole.lang.evaluators.IEvaluator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.ICloneable;
import org.whole.lang.reflect.ISourceable;
import org.whole.lang.steppers.IDataFlowConsumer;
import org.whole.lang.steppers.IFlowStepper;

/**
 * @author Riccardo Solmi
 */
public interface IExecutableClient<E extends IEntity> extends IFlowStepper, IEvaluator<E>, ICloneable, ISourceable, Iterable<E> {
	public IExecutableClient<E> withSourceEntity(IEntity entity);

	public IExecutableClient<E> clone();
	public IExecutableClient<E> clone(ICloneContext cc);

	public void addFirstConsumer(IDataFlowConsumer consumer);
	public void addConsumer(IDataFlowConsumer consumer);
	public IDataFlowConsumer getConsumer();
//	public IExecutable withProducers(IControlFlowProducer... producers);
//	public IExecutable withProducer(int index, IControlFlowProducer producer);
//	public int producersSize();
//	public IExecutable getProducer(int index);

	public IBindingManager getBindings();
	public void setBindings(IBindingManager bindings);
	public void reset(IEntity entity);

	public void prune();

	public void set(E entity);
	public void add(E entity);
	public void remove();

	public ExecutableFactory executableFactory();
}

