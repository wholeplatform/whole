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
		super(producers);
		arguments = new ArgumentDataFlowConsumer[producersSize()];
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		AbstractStepper stepper = (AbstractStepper) super.clone(cc);
		// TODO add lazy clone of arguments
		stepper.arguments = new ArgumentDataFlowConsumer[arguments.length];
		return stepper;
	}

	@Override
	protected void initProducer(IExecutable p, int index) {
		super.initProducer(p, index);
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
		case IDLE:
		case ACTION:
			state = StepperState.CALL;
			for (int i=0; i<producersSize(); i++)
				getProducer(i).callNext();//TODO ? callRemaining
			break;
		case DATA:
			doNextAction();
		default:
		}
	}
	public synchronized void callRemaining() {
		switch (state) {
		case IDLE:
		case ACTION:
			state = StepperState.CALL;
			for (int i=0; i<producersSize(); i++)
				getProducer(i).callRemaining();
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
