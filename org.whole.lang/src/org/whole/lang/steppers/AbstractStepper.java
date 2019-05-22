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
	protected MutableArgument[] arguments;
//	protected BitSet argumentsNeedInit;

	protected static final IControlFlowProducer[] EMPTY_PRODUCERS = new IControlFlowProducer[0];
	protected static final MutableArgument[] EMPTY_ARGUMENTS = new MutableArgument[0];

	protected AbstractStepper() {
		withProducers(EMPTY_PRODUCERS);
		withArguments(EMPTY_ARGUMENTS);
	}

	public AbstractStepper withProducers(IControlFlowProducer... producers) {
		this.producers = producers;
		producersNeedInit = new BitSet(producersSize());
		producersNeedInit.set(0, producersSize(), true);
		return this;
	};
	public AbstractStepper withArguments(MutableArgument... arguments) {
		this.arguments = arguments;
//		argumentsNeedInit = new BitSet(argumentsSize);
//		argumentsNeedInit.set(0, producersSize(), true);
		return this;
	};
	public AbstractStepper withArguments(int argumentsSize) {
		withArguments(new MutableArgument[argumentsSize]);

		for (int i=0; i<argumentsSize(); i++)
			arguments[i] = createArgument(i);

		return this;
	};
	protected MutableArgument createArgument(int i) {
		return new MutableArgument();
	}

	public void connectExecutableProducersWithNewArguments() {
		for (int i=0; i<producersSize(); i++) {
			connectExecutableProducersWithArgument(i, argumentsSize());
			//getProducer(i).withAdditionalConsumer(getArgumentConsumer(i)); 

			if (getProducer(i) instanceof AbstractStepper)
				((AbstractStepper) getProducer(i)).cloneContext = getDifferentiationContext();
		}
	};

	public void connectExecutableProducersWithArgument(int atProducerIndex, int argumentIndex) {
		getProducer(atProducerIndex).forEachExecutableProducer((cfp) -> {
			IExecutable e = (IExecutable) cfp;
			e.addAction(getArgumentConsumer(argumentIndex));
		});
	}


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

		stepper.producers = new IControlFlowProducer[producers.length];
		stepper.producersNeedInit = (BitSet) producersNeedInit.clone();
		stepper.arguments = new MutableArgument[arguments.length];
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
//		argumentsNeedInit.set(0, argumentsSize(), true);

//		state = StepperState.IDLE;
//		resetArguments();
	}

	public void resetArguments() {
		for (int i=0; i<argumentsSize(); i++)
			if (arguments[i] != null)
				arguments[i].executable = null;
	}

	public void applyToExecutableProducers(Consumer<IControlFlowProducer> c) {
		for (int i=0; i<producersSize(); i++)
			getProducer(i).forEachExecutableProducer(c);
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

	public int argumentsSize() {
		return arguments.length;
	}

	public MutableArgument getArgumentConsumer(int index) {
		if (argumentsSize() <= index) {
			int oldSize = argumentsSize();
			arguments = Arrays.copyOf(arguments, index+1);
			for (int i=oldSize; i<argumentsSize(); i++)
				arguments[i] = createArgument(i);
		}

		if (arguments[index] == null && prototype != null) {
			arguments[index] = cloneContext.differentiate(prototype.getArgumentConsumer(index));
		}

		MutableArgument consumer = arguments[index];

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

	public boolean areArgumentsAvailable() {
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
			if (areArgumentsAvailable()) {
				doAction();
				break;
			}
			state = StepperState.CALL;
			if (producersSize() > 0) {
				for (int i=0; i<producersSize() && !areArgumentsAvailable(); i++)
					getProducer(i).call();
				break;
			}
			if (!areArgumentsAvailable())
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
	public void toStringHeader(StringBuilder sb, boolean fromInput) {
		IEntity sourceEntity = getSourceEntity();
		if (sourceEntity != null && sourceEntity.wGet(0).wGetEntityDescriptor().getDataKind().isString())
			sb.append(sourceEntity.wGet(0).wStringValue());
		else
			super.toStringHeader(sb, fromInput);

		sb.append('^');
		sb.append(getState());
	}

	@Override
	public void toString(StringBuilder sb) {
		toStringHeader(sb, true);

		if (producersSize() > 0) {
			sb.append("\n\u2192{ ");
			for (int i=0; i<producersSize(); i++) {
				if (i>0)
					sb.append(toStringSeparator());

				IControlFlowProducer p = producers[i] != null ? producers[i] : prototype.getProducer(i);
				p.toStringHeader(sb, true);
			}
		}

		if (argumentsSize() > 0) {
			sb.append("\n\u2190{ ");
			for (int i=0; i<argumentsSize(); i++) {
				if (i>0)
					sb.append(toStringSeparator());

				IDataFlowConsumer p = arguments[i] != null ? arguments[i] : prototype.getArgumentConsumer(i);
				p.toStringHeader(sb, false);
			}
		}
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
	public void addAction(TesterDataFlowConsumer tester) {
		addFirstAction(tester);
	}

	public void addArgumentConsumer(IExecutable stepper) {
		int index = arguments.length;
		arguments = Arrays.copyOf(arguments, index+1);
		arguments[index] = new MutableArgument();
		
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
			consumer.accept(ExecutableFactory.instance.createDone());
		}

		@Override
		public void toStringHeader(StringBuilder sb, boolean fromInput) {
//			super.toStringHeader(sb);
			consumer.toStringHeader(sb, true);
			sb.append("\u21B2");
		}

		@Override
		public void toString(StringBuilder sb) {
			toStringHeader(sb, true);
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


	public class MutableArgument extends AbstractDataFlowConsumer {
		public IExecutable executable;

		@Override
		public MutableArgument clone(ICloneContext cc) {
			MutableArgument consumer = cc.differentiate(AbstractStepper.this).new MutableArgument();
			cc.setClone(this, consumer);
			consumer.cloneContext = cc;
			consumer.executable = null;
			return consumer;
//WAS			return (MutableArgumentDataFlowConsumer) super.clone(cc);
		}

		public void accept(IExecutable executable) {
			this.executable = executable;
			if (state.equals(StepperState.CALL) && areArgumentsAvailable())
				doAction();
		}

		@Override
		public void toStringHeader(StringBuilder sb, boolean fromInput) {
			if (fromInput) {
				AbstractStepper.this.toStringHeader(sb, true);
				sb.append(' ');
			}
			sb.append(executable != null ? "\u25C0" : "\u25C1");
		}

		public void toString(StringBuilder sb) {
			toStringHeader(sb, true);
		}
	}

	public class ImmutableArgument extends MutableArgument {
		@Override
		public ImmutableArgument clone(ICloneContext cc) {
			ImmutableArgument consumer = cc.differentiate(AbstractStepper.this).new ImmutableArgument();
			cc.setClone(this, consumer);
			consumer.cloneContext = cc;
//WAS			MutableArgument consumer = (MutableArgument) super.clone();
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
}
