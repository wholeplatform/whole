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
import java.util.function.Consumer;

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractEntityStepper extends AbstractStepper {
	public EntityScopeStepper entityScope;

	public AbstractEntityStepper(EntityScopeStepper scope, int argumentsSize, IExecutable... producers) {
		super(argumentsSize);
		withProducers(producers);
		this.entityScope = scope;
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
		public AbstractEntityGetter(EntityScopeStepper scope, IExecutable... producers) {
			super(scope, 0, producers);
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
		public ConstantEntityGetter(EntityScopeStepper scope, IExecutable... producers) {
			super(scope, producers);
		}

	}
	public static class VariableEntityGetter extends AbstractEntityGetter {
		public VariableEntityGetter(EntityScopeStepper scope, IExecutable... producers) {
			super(scope, producers);
		}
	}

	public abstract static class AbstractEntitySetter extends AbstractEntityStepper {
		public AbstractEntitySetter(EntityScopeStepper scope, IExecutable... producers) {
			super(scope, 1, producers);
		}

		@Override
		public IEntity doEvaluateNext() {
			//use setEntity value of preceding scope
			if (arguments[0] != null)
				getEntityScope().setNestedEntity(getArgument(0));
			return getEntityScope().entity;
		}
	}
	public static class ConstantEntitySetter extends AbstractEntitySetter {
		public ConstantEntitySetter(EntityScopeStepper scope, IExecutable... producers) {
			super(scope, producers);
		}

		@Override
		public boolean areAllArgumentsAvailable() {
			return super.areAllArgumentsAvailable() && getEntityScope().entity != null;
		}
	}
	public static class VariableEntitySetter extends AbstractEntitySetter {
		public VariableEntitySetter(EntityScopeStepper scope, IExecutable... producers) {
			super(scope, producers);
		}
	}

	public static class EntityScopeStepper extends AbstractStepper {
		protected EntityScopeStepper outerScope;
		protected EntityScopeStepper[] innerScopes = new EntityScopeStepper[0];
		protected IEntity entity;
		protected Set<AbstractEntityStepper> constantStepperSet = new HashSet<>();
		protected Set<AbstractEntityStepper> variableStepperSet = new HashSet<>();

		public EntityScopeStepper() {
			super(1);
		}
		public EntityScopeStepper(IEntity entity) {
			this();
			setArgument(0, entity);
		}

		@Override
		public IExecutable clone(ICloneContext cc) {
			EntityScopeStepper newScope = (EntityScopeStepper) super.clone(cc);
			newScope.outerScope = this;
			newScope.innerScopes = new EntityScopeStepper[0];
			addInnerScope(newScope);
			newScope.entity = null;
			newScope.variableStepperSet = variableStepperSet;
			variableStepperSet = new HashSet<>(variableStepperSet.size());
			newScope.constantStepperSet = new HashSet<>(constantStepperSet.size());
			
			newScope.variableStepperSet.forEach((stepper) -> {
				stepper.entityScope = newScope;
			});

			return newScope;
		}

		@Override
		public boolean areAllArgumentsAvailable() {
			return entity != null || super.areAllArgumentsAvailable();
		}

		public EntityScopeStepper getNestedScope() {
			return (EntityScopeStepper) clone();
		}

		@Override
		public IEntity doEvaluateNext() {
			if (arguments[0] != null)
				setEntity(getArgument(0));
			return entity;
		}

		public void doPropagateNext() {
			Consumer<AbstractEntityStepper> doNextAction = (stepper) -> {
				if (stepper.getState() == StepperState.CALL)
					stepper.doNextAction();
			};
			variableStepperSet.forEach(doNextAction);
			constantStepperSet.forEach(doNextAction);
		}

		protected void addInnerScope(EntityScopeStepper scope) {
			innerScopes = CompositeUtils.grow(innerScopes, innerScopes.length+1, scope);
		}

		public IEntity setNestedEntity(IEntity entity) {
//			if (this.entity == null)
//				return this.entity = entity;
//			else
				return getNestedScope().setEntity(entity);
		}
		public IEntity setEntity(IEntity entity) {
			this.entity = entity;
			doPropagateNext();
			return entity;
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
