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
package org.whole.lang.steppers;

import java.util.BitSet;

import org.whole.lang.evaluators.AbstractEvaluator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.IdentityCloneContext;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractStepper extends AbstractEvaluator {
	protected ICloneContext cloneContext = IdentityCloneContext.instance;
	protected AbstractStepper prototype;
	protected IEntity selfEntity;
	protected StepperState state = StepperState.IDLE;
	protected IExecutable[] producers;
	protected BitSet producersNeedInit;
	protected MutableArgumentDataFlowConsumer[] arguments;
//	protected BitSet argumentsNeedInit;

	protected AbstractStepper(ICloneContext cloneContext) {
		this(0);
		this.cloneContext = cloneContext;
	}
	protected AbstractStepper(IExecutable... producers) {
		withProducers(producers);
		withArgumentProducers(producersSize());
	}
	protected AbstractStepper(int argumentsSize) {
		withProducers(new IExecutable[0]);
		withArguments(argumentsSize);
	}

    public int producersSize() {
		return producers.length;
	}
	public IExecutable getProducer(int index) {
		if (producers[index] == null && prototype != null) {
			producers[index] = cloneContext.differentiate(prototype.getProducer(index));
		}

		IExecutable producer = producers[index];

		if (producersNeedInit.get(index)) {
			producersNeedInit.clear(index);
			initProducer(producer, index);
		}

		return producer;
	}
	protected void initProducer(IExecutable p, int index) {
		p.setBindings(getBindings());
		p.reset(selfEntity);

//		//FIXME API
//		if (p instanceof AbstractNestedEvaluator)
//			((AbstractNestedEvaluator) p).cloneContext = getCloneContext();
	}

	public AbstractStepper withProducers(IExecutable... producers) {
		this.producers = producers;
		producersNeedInit = new BitSet(producersSize());
		producersNeedInit.set(0, producersSize(), true);
		return this;
	};
	public AbstractStepper withProducer(int index, IExecutable producer) {
		producers[index] = producer;
		return this;
	}

	
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
			if (getProducer(i) instanceof AbstractStepper)
				((AbstractStepper) getProducer(i)).cloneContext = getDifferentiationContext();

		return this;
	};
	public AbstractStepper withArguments(int argumentsSize) {
		arguments = new MutableArgumentDataFlowConsumer[argumentsSize];
		for (int i=0; i<argumentsSize(); i++)
			arguments[i] = new MutableArgumentDataFlowConsumer();

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
		cloneContext = cc.getPrototypeCloneContext();

		AbstractStepper stepper = (AbstractStepper) super.clone(cc);
		stepper.cloneContext = cc;
		stepper.prototype = this;

//FIXME state is function of differentiation style of the input connections
		stepper.state = StepperState.IDLE;
		stepper.resetArguments();

		stepper.producers = new IExecutable[producers.length];
		stepper.producersNeedInit = (BitSet) producersNeedInit.clone();
		stepper.arguments = new MutableArgumentDataFlowConsumer[arguments.length];
//		stepper.argumentsNeedInit = (BitSet) argumentsNeedInit.clone();
		stepper.consumer = null;
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
        selfEntity = entity;
        producersNeedInit.set(0, producersSize(), true);

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
		if (arguments[index] == null && prototype != null) {
			arguments[index] = cloneContext.differentiate(prototype.getArgumentConsumer(index));
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
		if (consumer == null && prototype != null) {
			consumer = cloneContext.differentiate(prototype.getConsumer());
		}
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


    public void prune() {
    }
	public void set(IEntity entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wSet(lastEntity, entity);
    	lastEntity = entity;
	}
	public void add(IEntity entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	if (EntityUtils.hasParent(lastEntity)) {
    		IEntity lastEntityParent = lastEntity.wGetParent();
    		lastEntityParent.wAdd(lastEntityParent.wIndexOf(lastEntity), entity);
    	}
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();

    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wRemove(lastEntity);
    	lastEntity = null;
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append(toStringPrefix());
    	
		for (int i=0; i<producersSize(); i++) {
			if (i>0)
				sb.append(toStringSeparator());
			
			if (producers[i] != null)
				producers[i].toString(sb);
			else
				prototype.getProducer(i).toString(sb);
		}

    	sb.append(toStringSuffix());
    }
	protected String toStringPrefix() {
		return "(";
	}
	protected String toStringSeparator() {
		return ", ";
	}
	protected String toStringSuffix() {
		return ")";
	}

	
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

	public static enum ConnectionKind {
		DIFFERENTIATING, INTEGRATING
	}
}
