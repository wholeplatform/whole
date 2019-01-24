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

import java.util.BitSet;

import org.whole.lang.evaluators.AbstractNestedEvaluator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.IdentityCloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractStepper extends AbstractNestedEvaluator {
	protected StepperState state = StepperState.IDLE;
	protected MutableArgumentDataFlowConsumer[] arguments;
	protected BitSet argumentsNeedClone;
//	protected BitSet argumentsNeedInit;

	protected AbstractStepper(IExecutable... producers) {
		super(producers);
		withArgumentProducers(producersSize());
	}
	protected AbstractStepper(int argumentsSize) {
		super(0);
		withArguments(argumentsSize);
	}

//	@Override
//	protected void initProducer(IExecutable p, int index) {
//		super.initProducer(p, index);
//
//		//FIXME API
//		if (p instanceof AbstractNestedEvaluator)
//			((AbstractNestedEvaluator) p).cloneContext = getCloneContext();
//	}
	
	public AbstractStepper withArgumentProducers(IExecutable... producers) {
		withProducers(producers);
		withArgumentProducers(producersSize());

		return this;
	};
	public AbstractStepper withArgumentProducers(int argumentsSize) {
		withArguments(argumentsSize);

		for (int i=0; i<argumentsSize() && i<producersSize(); i++)
			getProducer(i).withAdditionalConsumer(getArgumentConsumer(i)); 

		for (int i=0; i<producersSize(); i++)
			if (getProducer(i) instanceof AbstractNestedEvaluator)
				((AbstractNestedEvaluator) getProducer(i)).cloneContext = getDifferentiationContext();

		return this;
	};
	public AbstractStepper withArguments(int argumentsSize) {
		arguments = new MutableArgumentDataFlowConsumer[argumentsSize];
		for (int i=0; i<argumentsSize(); i++)
			arguments[i] = new MutableArgumentDataFlowConsumer();

		argumentsNeedClone = new BitSet(argumentsSize);
		argumentsNeedClone.set(0, argumentsSize, false);
//		argumentsNeedInit = new BitSet(argumentsSize);
//		argumentsNeedInit.set(0, producersSize(), true);

		return this;
	};

	@Override
	public IExecutable clone() {
		IDifferentiationContext dc = getDifferentiationContext().getNextDifferentiationContext();
		return clone(dc);
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		argumentsNeedClone.set(0, argumentsSize(), true);

		AbstractStepper stepper = (AbstractStepper) super.clone(cc);
		stepper.arguments = arguments.clone();
		stepper.argumentsNeedClone = (BitSet) argumentsNeedClone.clone();
//		stepper.argumentsNeedInit = (BitSet) argumentsNeedInit.clone();
		return stepper;
	}

	public IDifferentiationContext getDifferentiationContext() {
		if (cloneContext == IdentityCloneContext.instance)
			cloneContext = new CloneContext(true);
		return (IDifferentiationContext) cloneContext;
	}

	@Override
	public void reset(IEntity entity) {
		//FIXME workaround for circular reset loop
		if (selfEntity == entity)
			return;
		super.reset(entity);
		state = StepperState.IDLE;
//		argumentsNeedInit.set(0, producersSize(), true);
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

	public MutableArgumentDataFlowConsumer getArgumentConsumer(int index) {
		if (argumentsNeedClone.get(index)) {
			argumentsNeedClone.clear(index);
			arguments[index] = cloneContext.differentiate(arguments[index]);
		}

		MutableArgumentDataFlowConsumer consumer = arguments[index];

//		if (argumentsNeedInit.get(index)) {
//			argumentsNeedInit.clear(index);
//			initConsumer(consumer, index);			
//		}

		return consumer;
	}
	public IEntity getArgument(int index) {
		return getArgumentConsumer(index).entity;
	}
//	protected void initConsumer(MutableArgumentDataFlowConsumer p, int index) {
//		p.cloneContext = getCloneContext();
//	}

	public boolean areAllArgumentsAvailable() {
		for (int i=0; i<argumentsSize(); i++)
			if (getArgument(i) == null)
				return false;
		return true;
	}

	@Override
	public IDataFlowConsumer getConsumer() {
		IDataFlowConsumer consumer = super.getConsumer();
		IDataFlowConsumer consumerInContext = getDifferentiationContext().differentiate(consumer);
		if (consumer != consumerInContext)
			consumer = consumerInContext;
		return consumer;
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


	public class MutableArgumentDataFlowConsumer extends AbstractDataFlowConsumer {
		public IEntity entity;

		@Override
		public MutableArgumentDataFlowConsumer clone(ICloneContext cc) {
			MutableArgumentDataFlowConsumer consumer = cc.differentiate(AbstractStepper.this).new MutableArgumentDataFlowConsumer();
			cc.setClone(this, consumer);
			consumer.cloneContext = cc;
			return consumer;
//WAS			return (MutableArgumentDataFlowConsumer) super.clone(cc);
		}

		public void accept(IEntity entity) {
			this.entity = entity;
			if (state == StepperState.CALL && areAllArgumentsAvailable())
				doNextAction();
		}

		public void done() {
			this.entity = null;
		}
	}

	public class ImmutableArgumentDataFlowConsumer extends MutableArgumentDataFlowConsumer {
		@Override
		public ImmutableArgumentDataFlowConsumer clone(ICloneContext cc) {
			ImmutableArgumentDataFlowConsumer consumer = cc.differentiate(AbstractStepper.this).new ImmutableArgumentDataFlowConsumer();
			cc.setClone(this, consumer);
			consumer.cloneContext = cc;
//WAS			MutableArgumentDataFlowConsumer consumer = (MutableArgumentDataFlowConsumer) super.clone();
			consumer.entity = null;
			return consumer;
		}

		@Override
		public void accept(IEntity entity) {
			if (this.entity == null)
				super.accept(entity);
			else
				clone(getCloneContext().getNextDifferentiationContext()).accept(entity);
		}
	}

	public static enum StepperState {
		IDLE, CALL, DATA, ACTION
	}
}
