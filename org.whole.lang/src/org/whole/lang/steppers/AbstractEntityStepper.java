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
		AbstractEntityStepper stepper = this;
		AbstractEntityStepper newStepper = (AbstractEntityStepper) super.clone(cc);
		newStepper.entityScope = null;

		EntityScopeStepper prototypeScope = stepper.getEntityScope();
		EntityScopeStepper newScope = newStepper.getEntityScope();

		if (prototypeScope.constantStepperSet.contains(stepper)) {
			newScope.constantStepperSet.add(newStepper);
		} else {
			//TODO test and remove
			if (!newScope.variableStepperSet.contains(stepper))
				throw new IllegalStateException();

			prototypeScope.variableStepperSet.add(newStepper);
		}
		return newStepper;
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
			//use setEntity value of preceding scope
			if (arguments[0] != null)
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

		@Override
		public IExecutable clone(ICloneContext cc) {
			EntityScopeStepper newScope = (EntityScopeStepper) super.clone(cc);
			newScope.parentContext = this;
			newScope.contextParts = new EntityScopeStepper[0];
			addContextPart(newScope);
			newScope.entity = null;
			newScope.variableStepperSet = variableStepperSet;
			variableStepperSet = new HashSet<>(variableStepperSet.size());
			newScope.constantStepperSet = new HashSet<>(constantStepperSet.size());
			
			newScope.variableStepperSet.forEach((stepper) -> {
				stepper.entityScope = newScope;
			});

			return newScope;
		}

		public EntityScopeStepper getNestedScope() {
			return (EntityScopeStepper) clone();
		}

		@Override
		public IEntity doEvaluateNext() {
			return entity;
		}

		protected void addContextPart(EntityScopeStepper part) {
			contextParts = CompositeUtils.grow(contextParts, contextParts.length+1, part);
		}

		public IEntity setEntity(IEntity entity) {
			return getNestedScope().entity = entity;
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
