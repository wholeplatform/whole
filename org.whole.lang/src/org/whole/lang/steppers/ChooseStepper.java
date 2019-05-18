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
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class ChooseStepper extends AbstractStepper {
	protected IExecutable evaluator;

	@Override
	public AbstractStepper withProducers(IControlFlowProducer... producers) {
		return super.withProducers(producers);
	}

	@Override
	public void addCall(int index, IControlFlowProducer producer) {
		super.addCall(index, producer);
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		ChooseStepper stepper = (ChooseStepper) super.clone(cc);
		stepper.evaluator = null;
		return stepper;
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

		if (evaluator != null)
			evaluator.reset(selfEntity);
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

	@Override
	protected IExecutable getExecutableAction() {
		if (evaluator == null) {
			for (int i=0; i<argumentsSize(); i++) {
				evaluator = getArgumentExecutable(i);
				if (evaluator != null)
					return evaluator;
			}
			return ExecutableFactory.instance.createEmpty();
		}

		return evaluator;
	}

	@Override
	public boolean areArgumentsAvailable() {
		for (int i=0; i<argumentsSize(); i++)
			if (getArgumentExecutable(i) != null)
				return true;
		return false;
	}

	@Override
	public void connectExecutableProducersWithArgument(int atProducerIndex, int argumentIndex) {
		super.connectExecutableProducersWithArgument(atProducerIndex, argumentIndex);

		getProducer(atProducerIndex).forEachExecutableProducer((cfp) -> {
			if (cfp instanceof AbstractStepper) {
				AbstractStepper s = (AbstractStepper) cfp;
				if (s.argumentsSize() == 0)
					s.getArgumentConsumer(0);
			}
		});
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append('#');
		super.toString(sb);
	}
}
