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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.executables.AbstractExecutable;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.IdentityCloneContext;

/**
 * @author Riccardo Solmi
 */
public class StepperEvaluator extends AbstractExecutable {
	protected ICloneContext cloneContext = IdentityCloneContext.instance;
	protected IExecutable stepper; //TODO IControlFlowProducer
	protected IExecutable evaluator;
	protected IEntity selfEntity;

	public StepperEvaluator(IExecutable stepper) { //TODO IControlFlowProducer
		this.stepper = stepper;
		stepper.addAction(new AbstractDataFlowConsumer() {
			public void accept(IExecutable executable) {
				evaluator = getDifferentiationContext().differentiate(executable);
				if (hasBindings())
					evaluator.setBindings(getBindings());
				if (selfEntity != null)
					evaluator.reset(selfEntity);
			}
		});
	}

	@Override
	public IExecutable clone() {
		IDifferentiationContext dc = getDifferentiationContext().getNextDifferentiationContext();
		return clone(dc);
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		StepperEvaluator stepperEvaluator = (StepperEvaluator) super.clone(cc);
		stepperEvaluator.cloneContext = cc;
		if (evaluator != null)
			stepperEvaluator.evaluator = stepperEvaluator.getDifferentiationContext().differentiate(evaluator);
		stepper.addAction(new AbstractDataFlowConsumer() {
			public void accept(IExecutable executable) {
				stepperEvaluator.evaluator = stepperEvaluator.getDifferentiationContext().differentiate(executable);
				if (stepperEvaluator.hasBindings())
					stepperEvaluator.evaluator.setBindings(stepperEvaluator.getBindings());
				if (stepperEvaluator.selfEntity != null)
					stepperEvaluator.evaluator.reset(stepperEvaluator.selfEntity);
			}
		});
		return stepperEvaluator;
	}

	public IDifferentiationContext getDifferentiationContext() {
		if (cloneContext == IdentityCloneContext.instance)
			cloneContext = new CloneContext(false);
		return (IDifferentiationContext) cloneContext;
	}

	@Override
	protected void setProducersBindings(IBindingManager bindings) {
		super.setProducersBindings(bindings);


		if (evaluator != null)
			evaluator.setBindings(getBindings());
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
        selfEntity = entity;

		if (evaluator != null)
			evaluator.reset(selfEntity);
	}

	@Override
	public synchronized IEntity evaluateNext() {
		if (evaluator == null) {
			stepper.call();
			try {
				while (evaluator == null) {
					wait(1000);
					handleCanceled();
				}
			} catch (InterruptedException e) {
				return lastEntity = null;
			}
		}
		return lastEntity = evaluator.evaluateNext();
	}

	@Override
	public synchronized IEntity evaluateRemaining() {
		if (evaluator == null) {
			stepper.call();
			try {
				while (evaluator == null) {
					wait(1000);
					handleCanceled();
				}
			} catch (InterruptedException e) {
				return lastEntity = null;
			}
			lastEntity = null;
		}

		return evaluator.evaluateRemaining();
	}


	public void call() {
		stepper.call();
	}

	public void prune() {
		if (evaluator != null)
			evaluator.prune();
	}

	public void set(IEntity entity) {
    	if (evaluator == null)
    		throw new IllegalStateException();

    	evaluator.set(entity);
	}
	public void add(IEntity entity) {
    	if (evaluator == null)
    		throw new IllegalStateException();

    	evaluator.add(entity);
	}
	public void remove() {
    	if (evaluator == null)
    		throw new IllegalStateException();

    	evaluator.remove();
	}

	@Override
	public void toString(StringBuilder sb) {
		stepper.toString(sb);
	}
}
