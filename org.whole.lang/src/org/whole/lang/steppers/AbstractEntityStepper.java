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

import java.util.HashSet;
import java.util.Set;

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractEntityStepper extends AbstractStepper {
	public EntityScopeStepper entityScope;

	public AbstractEntityStepper(EntityScopeStepper context, int argumentsSize, IExecutable... producers) {
		super(argumentsSize);
		withProducers(producers);
		this.entityScope = context;
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		AbstractEntityStepper stepper = (AbstractEntityStepper) super.clone(cc);
		//TODO ? always same context
		
//FIXME cme from new EntityScopeStepper(ec)			context.addClonedAccessor(this, stepper);
		stepper.entityScope = null;
		return stepper;
	}

	public EntityScopeStepper getEntityScope() {
		if (entityScope == null && prototype != null) {
			entityScope = cloneContext.differentiate(((AbstractEntityStepper) prototype).getEntityScope());
		}
		return entityScope;
	}


	public abstract static class AbstractEntityGetter extends AbstractEntityStepper {
		public AbstractEntityGetter(EntityScopeStepper context, IExecutable... producers) {
			super(context, 0, producers);
		}

		@Override
		public boolean areAllArgumentsAvailable() {
			return super.areAllArgumentsAvailable() && getEntityScope().entity != null;
		}

		@Override
		public IEntity doEvaluateNext() {
			return getEntityScope().entity;
		}
	}
	public static class ConstantEntityGetter extends AbstractEntityGetter {
		public ConstantEntityGetter(EntityScopeStepper context, IExecutable... producers) {
			super(context, producers);
		}

	}
	public static class VariableEntityGetter extends AbstractEntityGetter {
		public VariableEntityGetter(EntityScopeStepper context, IExecutable... producers) {
			super(context, producers);
		}
	}

	public abstract static class AbstractEntitySetter extends AbstractEntityStepper {
		public AbstractEntitySetter(EntityScopeStepper context, IExecutable... producers) {
			super(context, 1, producers);
		}

		@Override
		public IEntity doEvaluateNext() {
			getEntityScope().setEntity(getArgument(0));
			return getEntityScope().entity;
		}
	}
	public static class ConstantEntitySetter extends AbstractEntitySetter {
		public ConstantEntitySetter(EntityScopeStepper context, IExecutable... producers) {
			super(context, producers);
		}
	}
	public static class VariableEntitySetter extends AbstractEntitySetter {
		public VariableEntitySetter(EntityScopeStepper context, IExecutable... producers) {
			super(context, producers);
		}
	}

	public static class EntityScopeStepper extends AbstractStepper {
		protected EntityScopeStepper parentContext;
		protected EntityScopeStepper[] contextParts = new EntityScopeStepper[0];
		/*protected*/ public IEntity entity;
		protected Set<AbstractEntityStepper> constantStepperSet = new HashSet<>();
		protected Set<AbstractEntityStepper> variableStepperSet = new HashSet<>();

		public EntityScopeStepper(IEntity entity) {
			super(0);
			this.entity = entity;
		}
		protected EntityScopeStepper(EntityScopeStepper prototypeContext) {
			super(0);
			this.parentContext = prototypeContext;
			prototypeContext.addContextPart(this);
			this.entity = null;//prototypeContext.entity;
			this.variableStepperSet = prototypeContext.variableStepperSet;
			prototypeContext.variableStepperSet = new HashSet<>(prototypeContext.variableStepperSet.size());
			this.variableStepperSet.forEach((stepper) -> {
				prototypeContext.variableStepperSet.add((AbstractEntityStepper) stepper.clone());
				stepper.entityScope = this;
			});
			this.constantStepperSet = new HashSet<>(prototypeContext.constantStepperSet.size());
			prototypeContext.constantStepperSet.forEach((stepper) -> {
				AbstractEntityStepper newStepper = (AbstractEntityStepper) stepper.clone();
				newStepper.entityScope = this;
				this.constantStepperSet.add(newStepper);
			});
		}

		//FIXME override clone

		public EntityScopeStepper getNextDifferentiationContext() {
			EntityScopeStepper ess = new EntityScopeStepper(this);
			IDifferentiationContext dc = getDifferentiationContext().getNextDifferentiationContext();
			ess.cloneContext = dc;
			ess.getDifferentiationContext().setClone(this, ess);
			return ess;
		}


		@Override
		public IEntity doEvaluateNext() {
			return entity;
		}

		protected void addContextPart(EntityScopeStepper part) {
			contextParts = CompositeUtils.grow(contextParts, contextParts.length+1, part);
		}

		public IEntity setEntity(IEntity entity) {
			return getNextDifferentiationContext().entity = entity;
		}

		public AbstractStepper createConstantGetter() {
			AbstractEntityStepper stepper = new ConstantEntityGetter(this);
			constantStepperSet.add(stepper);
			return stepper;
		}
		public AbstractStepper createConstantSetter() {
			AbstractEntityStepper stepper = new ConstantEntitySetter(this);
			constantStepperSet.add(stepper);
			return stepper;
		}
		public AbstractStepper createVariableGetter() {
			AbstractEntityStepper stepper = new VariableEntityGetter(this);
			variableStepperSet.add(stepper);
			return stepper;
		}
		public AbstractStepper createVariableSetter() {
			AbstractEntityStepper stepper = new VariableEntitySetter(this);
			variableStepperSet.add(stepper);
			return stepper;
		}
	}
}
