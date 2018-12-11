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
package org.whole.lang.steppers;

import org.whole.lang.evaluators.AbstractNestedEvaluator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractStepper extends AbstractNestedEvaluator {
	protected StepperState state = StepperState.IDLE;
	protected ArgumentDataFlowConsumer[] arguments;

	protected AbstractStepper(IExecutable... producers) {
		this(producers.length, producers);
	}
	protected AbstractStepper(int argumentsSize, IExecutable... producers) {
		super(producers);
		arguments = new ArgumentDataFlowConsumer[argumentsSize];
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		AbstractStepper stepper = (AbstractStepper) super.clone(cc);
		// TODO add lazy clone of arguments
		stepper.arguments = new ArgumentDataFlowConsumer[argumentsSize()];
		return stepper;
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		state = StepperState.IDLE;
		resetArguments();
	}

	public void resetArguments() {
		for (int i=0; i<argumentsSize(); i++)
			if (arguments[i] != null)
				arguments[i].entity = null;
	}

	public int argumentsSize() {
		return arguments.length;
	}

	public ArgumentDataFlowConsumer getArgumentConsumer(int index) {
		if (arguments[index] == null)
			arguments[index] = new ArgumentDataFlowConsumer();

		return arguments[index];
	}
	public IEntity getArgument(int index) {
		return getArgumentConsumer(index).entity;
	}

	public boolean areAllArgumentsAvailable() {
		for (int i=0; i<argumentsSize(); i++)
			if (arguments[i] == null || arguments[i].entity == null)
				return false;
		return true;
	}	

	@Override
	protected void initProducer(IExecutable p, int index) {
		super.initProducer(p, index);
		p.withConsumer(getArgumentConsumer(index));
	}

	public StepperState getState() {
		return state;
	}

	public synchronized /*final*/ IEntity evaluateNext() {
		callNext();
		try {
			while (state != StepperState.ACTION)
				wait();
		} catch (InterruptedException e) {
			lastEntity = null;
			getConsumer().done();
		}
		return lastEntity;
	}
	public synchronized /*final*/ IEntity evaluateRemaining() {
		callRemaining();
		try {
			while (state != StepperState.ACTION)
				wait();
		} catch (InterruptedException e) {
			lastEntity = null;
		}
		return lastEntity;
	}

	public synchronized void callNext() {
		switch (state) {
		case ACTION:
			state = StepperState.IDLE;
			resetArguments();
		case IDLE:
			state = StepperState.CALL;
			if (producersSize() > 0) {
				for (int i=0; i<producersSize(); i++)
					getProducer(i).callNext();//TODO ? callRemaining
				break;
			}
			if (!areAllArgumentsAvailable())
				break;
		case DATA:
			doNextAction();
		default:
		}
	}
	public synchronized void callRemaining() {
		switch (state) {
		case ACTION:
			state = StepperState.IDLE;
			resetArguments();
		case IDLE:
			state = StepperState.CALL;
			if (producersSize() > 0) {
				for (int i=0; i<producersSize(); i++)
					getProducer(i).callRemaining();
				break;
			}
			if (!areAllArgumentsAvailable())
				break;
		case DATA:
			doNextAction();
		default:
		}
	}

	protected synchronized void doNextAction() {
		state = StepperState.ACTION;
		lastEntity = doEvaluateNext();
		if (lastEntity != null)
			getConsumer().accept(lastEntity);
		else
			getConsumer().done();
		notify();
	};
	public abstract IEntity doEvaluateNext();


	public class ArgumentDataFlowConsumer implements IDataFlowConsumer {
		public IEntity entity;

		public void accept(IEntity entity) {
			this.entity = entity;
			if (areAllArgumentsAvailable())
				doNextAction();
		}

		public void done() {
			this.entity = null;
		}
	}

	public static enum StepperState {
		IDLE, CALL, DATA, ACTION
	}
}
