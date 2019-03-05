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

import java.util.Arrays;
import java.util.BitSet;
import java.util.function.Consumer;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.evaluators.AbstractEvaluator;
import org.whole.lang.evaluators.AbstractPureConditionalSupplierEvaluator;
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
	protected IControlFlowProducer[] producers;
	protected BitSet producersNeedInit;
	protected MutableArgumentDataFlowConsumer[] arguments;
//	protected BitSet argumentsNeedInit;

	protected AbstractStepper(ICloneContext cloneContext) {
		this(0);
		this.cloneContext = cloneContext;
	}
	protected AbstractStepper(IControlFlowProducer... producers) {
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
	public IControlFlowProducer getProducer(int index) {
		if (producers[index] == null && prototype != null) {
			producers[index] = cloneContext.differentiate(prototype.getProducer(index));
		}

		IControlFlowProducer producer = producers[index];

		if (producersNeedInit.get(index)) {
			producersNeedInit.clear(index);
			initProducer(producer, index);
		}

		return producer;
	}

	public void applyToExecutableProducers(Consumer<IControlFlowProducer> c) {
		for (int i=0; i<producersSize(); i++)
			getProducer(i).forEachExecutableProducer(c);
	}

	protected void initProducer(IControlFlowProducer p, int index) {
		applyToExecutableProducers((cfp) -> {
			IExecutable e = (IExecutable) cfp;
			e.setBindings(getBindings());
			e.reset(selfEntity);
		});

//		//FIXME API
//		if (p instanceof AbstractNestedEvaluator)
//			((AbstractNestedEvaluator) p).cloneContext = getCloneContext();
	}

	public AbstractStepper withProducers(IControlFlowProducer... producers) {
		this.producers = producers;
		producersNeedInit = new BitSet(producersSize());
		producersNeedInit.set(0, producersSize(), true);
		return this;
	};

	public AbstractStepper withArgumentProducers(IExecutable... producers) {
		withProducers(producers);
		withArgumentProducers(producersSize());

		return this;
	};
	public AbstractStepper withArgumentProducers(int argumentsSize) {
		withArguments(argumentsSize);

		for (int i=0; i<argumentsSize() && i<producersSize(); i++) {
			IDataFlowConsumer dfc = getArgumentConsumer(i);
			getProducer(i).forEachExecutableProducer((cfp) -> {
				IExecutable e = (IExecutable) cfp;
				e.addAction(dfc);
			});
			//getProducer(i).withAdditionalConsumer(getArgumentConsumer(i)); 
		}

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
		if (stepper instanceof EntityGetter && stepper.state.isAction()) {
			stepper.state = StepperState.NEXT_ACTION;
		} else {
			stepper.state = StepperState.IDLE;
			//FIXME not yet cloned reset original arguments
//			stepper.resetArguments();
		}

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

	public void setArgument(int index, IEntity entity) {
		getArgumentConsumer(index).accept(entity);
	}

	public boolean areAllArgumentsAvailable() {
		for (int i=0; i<argumentsSize(); i++)
			if (getArgument(i) == null)
				return false;
		return true;
	}

	@Override
	public IDataFlowConsumer getAction() {
		if (consumer == null && prototype != null) {
			consumer = cloneContext.differentiate(prototype.getAction());
		}
		return consumer;
	}

	public StepperState getState() {
		return state;
	}

	public synchronized /*final*/ IEntity evaluateNext() {
		callNext();
		try {
			while (!state.isAction())
				wait();
		} catch (InterruptedException e) {
			lastEntity = null;
			getAction().done();
		}
		return lastEntity;
	}
	public synchronized /*final*/ IEntity evaluateRemaining() {
		callRemaining();
		try {
			while (state != StepperState.DONE_ACTION)
				wait();
		} catch (InterruptedException e) {
			lastEntity = null;
		}
		IEntity result = lastEntity;
		lastEntity = null;
		return result;
	}

	public synchronized void callNext() {
		switch (state) {
		case DONE_ACTION:
			state = StepperState.IDLE;
			resetArguments();
		case IDLE:
			state = StepperState.CALL_NEXT;
			if (producersSize() > 0) {
				for (int i=0; i<producersSize(); i++)
					getProducer(i).callNext();//TODO ? or callRemaining
				break;
			}
			if (!areAllArgumentsAvailable())
				break;
		case NEXT_ACTION:
			doNextAction();
		default:
		}
	}
	public synchronized void callRemaining() {
		switch (state) {
		case DONE_ACTION:
			state = StepperState.IDLE;
			resetArguments();
		case IDLE:
			state = StepperState.CALL_REMAINING;
			if (producersSize() > 0) {
				for (int i=0; i<producersSize(); i++)
					getProducer(i).callRemaining();//TODO ? or iterated callNext
				break;
			}
			if (!areAllArgumentsAvailable())
				break;
		case NEXT_ACTION:
			doRemainingAction();
		default:
		}
	}

	protected synchronized void doAction() {
		if (state == StepperState.CALL_NEXT)
			doNextAction();
		else if (state == StepperState.CALL_REMAINING)
			doRemainingAction();
	}

	protected synchronized void doNextAction() {
		state = StepperState.NEXT_ACTION;
		lastEntity = doEvaluateNext();
		if (lastEntity != null) 
			getAction().accept(lastEntity);
		else {
			state = StepperState.DONE_ACTION;
			getAction().done();
		}
		notify();
	};
	public abstract IEntity doEvaluateNext();

	protected synchronized void doRemainingAction() {
		IEntity result = null;
		while (state != StepperState.DONE_ACTION) {
			doNextAction();
			if (lastEntity == null) {
				lastEntity = result;
				return;
			}
			result = lastEntity;
		}
	}


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

	public void addCall(int index, IControlFlowProducer producer) {//WAS addGoalCall
		if (index == producersSize()) {
			producers = Arrays.copyOf(producers, producers.length+1);
			producers[index] = producer;
		} else
			producers[index] = getProducer(index).getAdded(producer);
	}
	public void addCall(int index, IDataFlowConsumer consumer) {//WAS addDoneCall
		addCall(index, new DoneCall(consumer));
	}

	public void addAction(IControlFlowProducer producer) {//WAS addGoalAction
		addAction(new GoalAction(producer));
	}
	public void addDoneAction(IDataFlowConsumer consumer) {
		addAction(new DoneAction(consumer));
	}
	public void addAction(TesterDataFlowConsumer tester) {//WAS addTesterAction
		addFirstAction(tester);
	}

	
	public static class DoneCall extends AbstractControlFlowProducer {
		public IDataFlowConsumer consumer;

		public DoneCall(IDataFlowConsumer consumer) {
			this.consumer = consumer;
		}

		@Override
		public void forEachExecutableProducer(Consumer<IControlFlowProducer> c) {
		}

		public void reset(IEntity entity) {
		}

		public void callNext() {
			consumer.done();
		}

		public void callRemaining() {
			consumer.done();
		}

		public void toString(StringBuilder sb) {
			// TODO Auto-generated method stub
		}
	}

	public static class GoalAction extends AbstractDataFlowConsumer {
		public IControlFlowProducer producer;

		public GoalAction(IControlFlowProducer producer) {
			this.producer = producer;
		}

		@Override
		public IDataFlowConsumer clone(ICloneContext cc) {
			GoalAction action = (GoalAction) super.clone(cc);
			//TODO lazy clone
			action.producer = cc.differentiate(producer);
			return action;
		}

		@Override
		public void accept(IEntity entity) {
		}

		@Override
		public void done() {
			producer.callRemaining();
		}
	}

	public static class DoneAction extends AbstractDataFlowConsumer {
		public IDataFlowConsumer consumer;

		public DoneAction(IDataFlowConsumer consumer) {
			this.consumer = consumer;
		}

		@Override
		public IDataFlowConsumer clone(ICloneContext cc) {
			DoneAction action = (DoneAction) super.clone(cc);
			//TODO lazy clone
			action.consumer = cc.differentiate(consumer);
			return action;
		}

		@Override
		public void accept(IEntity entity) {
		}

		@Override
		public void done() {
			consumer.done();
		}
	}

	public IExecutable getExecutableArgument(int index) {
		return new ExecutableArgument(index);
	}

	public class ExecutableArgument extends AbstractPureConditionalSupplierEvaluator {
		protected int index;

		protected ExecutableArgument() {
			this(0);
		}
		public ExecutableArgument(int index) {
			this.index = index;
		}

		@Override
		public ExecutableArgument clone(ICloneContext cc) {
			ExecutableArgument executableArgument = cc.differentiate(AbstractStepper.this).new ExecutableArgument();
			cc.setClone(this, executableArgument);
			executableArgument.index = index;
			return executableArgument;
		}

		public IEntity get() {
			return getArgument(index);
		}

		public void toString(StringBuilder sb) {
			sb.append("getArgument(");
			sb.append(index);
			sb.append(")");
		}
	}

	public class MutableArgumentDataFlowConsumer extends AbstractDataFlowConsumer {
		public IEntity entity;

		@Override
		public MutableArgumentDataFlowConsumer clone(ICloneContext cc) {
			MutableArgumentDataFlowConsumer consumer = cc.differentiate(AbstractStepper.this).new MutableArgumentDataFlowConsumer();
			cc.setClone(this, consumer);
			consumer.cloneContext = cc;
			consumer.entity = null;
			return consumer;
//WAS			return (MutableArgumentDataFlowConsumer) super.clone(cc);
		}

		public void accept(IEntity entity) {
			this.entity = entity;
			if (state.isCall() && areAllArgumentsAvailable())
				doAction();
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
		IDLE, CALL_NEXT, CALL_REMAINING, NEXT_ACTION, DONE_ACTION; //TODO add DATA

		public boolean isCall() {
			switch (this) {
			case CALL_NEXT:
			case CALL_REMAINING:
				return true;
			default:
				return false;
			}
		}

		public boolean isAction() {
			switch (this) {
			case NEXT_ACTION:
			case DONE_ACTION:
				return true;
			default:
				return false;
			}
		}
	}

	public static enum ConnectionKind {
		DIFFERENTIATING, INTEGRATING
	}

	
	public static class ExecutableStepper extends AbstractStepper {
		protected IExecutable executable;

		public ExecutableStepper(ICloneContext cloneContext) {
			super(cloneContext);
		}
		public ExecutableStepper(IControlFlowProducer... producers) {
			super(producers);
		}
		public ExecutableStepper(int argumentsSize) {
			super(argumentsSize);
		}
		public ExecutableStepper withExecutable(IExecutable executable) {
			this.executable = executable;
			return this;
		}

		@Override
		public IExecutable clone(ICloneContext cc) {
			ExecutableStepper stepper = (ExecutableStepper) super.clone(cc);
			stepper.executable = null;
			return stepper;
		}

		@Override
		public void reset(IEntity entity) {
			super.reset(entity);

			if (executable != null)
				executable.reset(selfEntity);
		}

		@Override
		protected void setProducersBindings(IBindingManager bindings) {
			super.setProducersBindings(bindings);

			if (executable != null)
				executable.setBindings(getBindings());
		}
		
		protected IExecutable getExecutable() {
			if (executable == null) {
				executable = cloneContext.differentiate(((ExecutableStepper) prototype).getExecutable());
				executable.setBindings(getBindings());
				executable.reset(selfEntity);
			}
			return executable;
		}

		public IEntity doEvaluateNext() {
			return getExecutable().evaluateNext();
		}

		//FIXME add actions to the executable
		public IEntity doEvaluateRemaining() {
			return getExecutable().evaluateRemaining();
		}
	}
}
