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
import org.whole.lang.executables.AbstractExecutable;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.IdentityCloneContext;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractStepper extends AbstractExecutable {
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
		if (stepper instanceof EntityGetter && StepperState.ACTION.equals(stepper.state)) {
			stepper.state = StepperState.ACTION;
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
				arguments[i].executable = null;
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

	public IExecutable getArgumentExecutable(int index) {
		return getArgumentConsumer(index).executable;
	}

//	protected void initConsumer(MutableArgumentDataFlowConsumer p, int index) {
//		p.cloneContext = getCloneContext();
//	}

	public void setArgument(int index, IEntity entity) {
		getArgumentConsumer(index).accept(ExecutableFactory.instance.createConstant(entity, false));
	}

	public boolean areAllArgumentsAvailable() {
		for (int i=0; i<argumentsSize(); i++)
			if (getArgumentExecutable(i) == null)
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
		call();
		try {
			while (state != StepperState.ACTION) {
				wait(1000);
				handleCanceled();
			}
		} catch (InterruptedException e) {
			lastEntity = null;
		}
		return lastEntity;
	}
	public synchronized /*final*/ IEntity evaluateRemaining() {
		call();
		try {
			while (state != StepperState.ACTION) {
				wait(1000);
				handleCanceled();
			}
		} catch (InterruptedException e) {
			lastEntity = null;
		}
		IEntity result = lastEntity;
		lastEntity = null;
		return result;
	}

	public synchronized void call() {
		switch (state) {
		case ACTION:
			state = StepperState.IDLE;
			resetArguments();
		case IDLE:
			//TODO READY state behavior
			if (areAllArgumentsAvailable()) {
				doAction();
				break;
			}
			state = StepperState.CALL;
			if (producersSize() > 0) {
				for (int i=0; i<producersSize(); i++)
					getProducer(i).call();
				break;
			}
			if (!areAllArgumentsAvailable())
				break;
//		case ACTION:
			doAction();
		default:
		}
	}

	protected synchronized void doAction() {
		state = StepperState.ACTION;
		getAction().accept(getExecutableAction());
		notify();
	}

	protected IExecutable getExecutableAction() {
		return ExecutableFactory.instance.createEmpty();
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

	public void addCall(int index, IControlFlowProducer producer) {
		if (index == producersSize()) {
			producers = Arrays.copyOf(producers, producers.length+1);
			producers[index] = producer;
		} else
			producers[index] = getProducer(index).getAdded(producer);
	}
	public void addCall(IControlFlowProducer producer) {
		addCall(producersSize(), producer);
	}
	public void addCall(int index, IDataFlowConsumer consumer) {
		addCall(index, new DoneCall(consumer));
	}
	public void addCall(IDataFlowConsumer consumer) {
		//FIXME 
		addCall(producersSize(), consumer);
	}

	public void addAction(IControlFlowProducer producer) {
		addAction(new GoalAction(producer));
	}
	public void addDoneAction(IDataFlowConsumer consumer) {
		addAction(new DoneAction(consumer));
	}
	public void addAction(TesterDataFlowConsumer tester) {
		addFirstAction(tester);
	}

	public void addArgumentConsumer(IExecutable stepper) {
		int index = arguments.length;
		arguments = Arrays.copyOf(arguments, index+1);
		arguments[index] = new MutableArgumentDataFlowConsumer();
		
		stepper.addAction(arguments[index]);
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

		public void call() {
			consumer.accept(ExecutableFactory.instance.createEmpty());
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
		public void accept(IExecutable executable) {
			//TODO reset(entity)
			producer.call();
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
		public void accept(IExecutable executable) {
		}
	}

	public class MutableArgumentDataFlowConsumer extends AbstractDataFlowConsumer {
		public IExecutable executable;

		@Override
		public MutableArgumentDataFlowConsumer clone(ICloneContext cc) {
			MutableArgumentDataFlowConsumer consumer = cc.differentiate(AbstractStepper.this).new MutableArgumentDataFlowConsumer();
			cc.setClone(this, consumer);
			consumer.cloneContext = cc;
			consumer.executable = null;
			return consumer;
//WAS			return (MutableArgumentDataFlowConsumer) super.clone(cc);
		}

		public void accept(IExecutable executable) {
			this.executable = executable;
			if (state.equals(StepperState.CALL) && areAllArgumentsAvailable())
				doAction();
		}
	}

	public class ImmutableArgumentDataFlowConsumer extends MutableArgumentDataFlowConsumer {
		@Override
		public ImmutableArgumentDataFlowConsumer clone(ICloneContext cc) {
			ImmutableArgumentDataFlowConsumer consumer = cc.differentiate(AbstractStepper.this).new ImmutableArgumentDataFlowConsumer();
			cc.setClone(this, consumer);
			consumer.cloneContext = cc;
//WAS			MutableArgumentDataFlowConsumer consumer = (MutableArgumentDataFlowConsumer) super.clone();
			consumer.executable = null;
			return consumer;
		}

		@Override
		public void accept(IExecutable executable) {
			if (this.executable == null)
				super.accept(executable);
			else
				clone(getCloneContext().getNextDifferentiationContext()).accept(executable);
		}
	}

	public static enum StepperState {
		IDLE, CALL, ACTION; //TODO add READY
	}

	public static enum ConnectionKind {
		DIFFERENTIATING, INTEGRATING
	}

	
	public static class ExecutableStepper extends AbstractStepper {
		protected IExecutable executable;
		protected IExecutable evaluator;

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
			stepper.evaluator = null;
			return stepper;
		}

		@Override
		public void reset(IEntity entity) {
			super.reset(entity);

			evaluator = null;
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

		protected boolean isLazy = true;

		@Override
		protected IExecutable getExecutableAction() {
			if (isLazy)
				return getExecutable();
			else {
				getExecutable().evaluateRemaining();
				return ExecutableFactory.instance.createEmpty();
			}
		}

		@Override
		public synchronized IEntity evaluateNext() {
			if (evaluator == null) {
				call();
				try {
					while (state != StepperState.ACTION) {
						wait(1000);
						handleCanceled();
					}
					evaluator = getExecutableAction();
				} catch (InterruptedException e) {
					return lastEntity = null;
				}
			}
			return lastEntity = evaluator.evaluateNext();
		}

		@Override
		public synchronized IEntity evaluateRemaining() {
			if (evaluator == null) {
				call();
				try {
					while (state != StepperState.ACTION) {
						wait(1000);
						handleCanceled();
					}
					evaluator = getExecutableAction();
				} catch (InterruptedException e) {
					return lastEntity = null;
				}
				lastEntity = null;
			}

			return evaluator.evaluateRemaining();
		}
	}
}
