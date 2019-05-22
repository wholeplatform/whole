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
import org.whole.lang.evaluators.BlockEvaluator;
import org.whole.lang.evaluators.LocalScopeEvaluator;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class ExecutableStepper extends AbstractStepper {
	protected IExecutable executable;
	protected IExecutable evaluator;

	@Override
	public ExecutableStepper withArguments(int argumentsSize) {
		super.withArguments(argumentsSize);
		return this;
	};

	public ExecutableStepper withProducersConnectedToArguments(IControlFlowProducer... producers) {
		withProducers(producers);
		connectNewProducersWithNewArguments(0);

		return this;
	};

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

	@Override
	public void toString(StringBuilder sb) {
		super.toString(sb);

		if (executable != null) {
			sb.append("\n");
			if (executable instanceof LocalScopeEvaluator) {
				LocalScopeEvaluator se = (LocalScopeEvaluator) executable;
				if (se.getProducer(0) instanceof BlockEvaluator) {
					BlockEvaluator blockEvaluator = (BlockEvaluator) se.getProducer(0);
					blockEvaluator.getProducer(blockEvaluator.producersSize()-1).toString(sb);
				} else
					se.toString(sb);
			} else
				executable.toString(sb);
		}
	}
}