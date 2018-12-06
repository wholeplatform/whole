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

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.steppers.AbstractNestedStepper;
import org.whole.lang.steppers.IDataFlowConsumer;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractExecutableAsynchStepperEvaluator extends AbstractNestedStepper {
	protected ArgumentDataFlowConsumer[] arguments;

	protected AbstractExecutableAsynchStepperEvaluator(IExecutable... producers) {
		super(producers);
		arguments = new ArgumentDataFlowConsumer[producersSize()];
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		// TODO add lazy clone of arguments
		arguments = new ArgumentDataFlowConsumer[producersSize()];
		return super.clone(cc);
	}

	@Override
	protected void initProducer(IExecutable p, int index) {
		p.setBindings(getBindings());
		p.reset(selfEntity);
		p.withConsumer(getArgument(index));
	}

	public IDataFlowConsumer getArgument(int index) {
		if (arguments[index] == null)
			arguments[index] = new ArgumentDataFlowConsumer();

		return arguments[index];
	}
	public boolean areAllArgumentsAvailable() {
		for (int i=0; i<arguments.length; i++)
			if (arguments[i] == null || arguments[i].entity == null)
				return false;
		return true;
	}

	public synchronized final void callNext() {
		callNextAsynch();
		try {
			//TODO add while (!doneNext)
			wait();
		} catch (InterruptedException e) {
			nextEntity = null;
		}
	}

	public void callNextAsynch() {
		for (int i=0; i<producersSize(); i++)
			getProducer(i).callNextAsynch();//TODO ? callRemainingAsynch
	}

	public class ArgumentDataFlowConsumer implements IDataFlowConsumer {
		public IEntity entity;

		public void accept(IEntity entity) {
			this.entity = entity;
			if (areAllArgumentsAvailable()) {
				doNextAction();
				synchronized (AbstractExecutableAsynchStepperEvaluator.this) {
					AbstractExecutableAsynchStepperEvaluator.this.notify();
				}
			}
		}
		public void done() {
			this.entity = null;
		}
	}

	public abstract void doNextAction();

//TODO remove
	public void accept(IEntity entity) {
		nextEntity = entity;
		super.accept(entity);
	}
	public void done() {
		nextEntity = null;
		super.done();
	}
}
