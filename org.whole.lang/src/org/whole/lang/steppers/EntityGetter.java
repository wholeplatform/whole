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

import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Riccardo Solmi
 */
public class EntityGetter extends AbstractStepper {
	public EntityScope entityScope;

	public EntityGetter(EntityScope scope, boolean active) {
		if (active)
			withArguments(1);
		this.entityScope = scope;
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		EntityGetter stepper = this;
		EntityGetter newStepper = (EntityGetter) super.clone(cc);
		newStepper.entityScope = null;

		EntityScope prototypeScope = stepper.getEntityScope();
		EntityScope newScope = newStepper.getEntityScope();

		if (prototypeScope.constantGetterSet.contains(stepper)) {
			newScope.constantGetterSet.add(newStepper);
		} else {
			prototypeScope.variableGetterSet.add(newStepper);
		}
		return newStepper;
	}

	public EntityScope getEntityScope() {
		if (entityScope == null && prototype != null) {
			entityScope = cloneContext.differentiate(((EntityGetter) prototype).getEntityScope());
		}
		return entityScope;
	}

	public boolean isActive() {
		return argumentsSize() == 1;
	}

	@Override
	public boolean areAllArgumentsAvailable() {
//		return getEntityScope().entity != null || (isActive() && super.areAllArgumentsAvailable());
		return super.areAllArgumentsAvailable() && getEntityScope().entity != null;
	}

	@Override
	protected IExecutable getExecutableAction() {
		//use setEntity value of preceding scope
		if (isActive() && arguments[0] != null)
			getEntityScope().setNestedEntity(getArgumentExecutable(0).evaluateRemaining());
		return ExecutableFactory.instance.createConstant(getEntityScope().entity, false);
	}


	public static class EntityScope extends AbstractStepper {
		protected EntityScope outerScope;
		protected EntityScope[] innerScopes = new EntityScope[0];
		protected IEntity entity;
		protected Set<EntityGetter> constantGetterSet = new HashSet<>();
		protected Set<EntityGetter> variableGetterSet = new HashSet<>();

		public EntityScope() {
			withArguments(1);
		}
		public EntityScope(IEntity entity) {
			this();
			setArgument(0, entity);
		}

		@Override
		public IExecutable clone(ICloneContext cc) {
			EntityScope newScope = (EntityScope) super.clone(cc);
			newScope.outerScope = this;
			newScope.innerScopes = new EntityScope[0];
			addInnerScope(newScope);
			newScope.entity = null;
			newScope.variableGetterSet = variableGetterSet;
			variableGetterSet = new HashSet<>(variableGetterSet.size());
			newScope.constantGetterSet = new HashSet<>(constantGetterSet.size());
			
			newScope.variableGetterSet.forEach((stepper) -> {
				stepper.entityScope = newScope;
			});

			return newScope;
		}

		@Override
		public boolean areAllArgumentsAvailable() {
			return entity != null || super.areAllArgumentsAvailable();
		}

		public EntityScope getNestedScope() {
			return (EntityScope) clone();
		}

		@Override
		protected IExecutable getExecutableAction() {
			if (arguments[0] != null)
				setEntity(getArgumentExecutable(0).evaluateRemaining());
			return ExecutableFactory.instance.createConstant(entity, false);
		}

		public void doPropagateNext() {
			Consumer<EntityGetter> doNextAction = (getter) -> {
				if (getter.getState().equals(StepperState.CALL))
					getter.doAction();
			};
			variableGetterSet.forEach(doNextAction);
			constantGetterSet.forEach(doNextAction);
		}

		protected void addInnerScope(EntityScope scope) {
			innerScopes = CompositeUtils.grow(innerScopes, innerScopes.length+1, scope);
		}

		public IEntity setNestedEntity(IEntity entity) {
			if (this.entity == null)
				return setEntity(entity); //FIXME recursive call to the running active getter 
			else
				return getNestedScope().setEntity(entity);
		}
		public IEntity setEntity(IEntity entity) {
			this.entity = entity;
			doPropagateNext();
			return entity;
		}

		public AbstractStepper createConstantPassiveGetter() {
			EntityGetter getter = new EntityGetter(this, false);
			initSetters(getter);
			constantGetterSet.add(getter);
			return getter;
		}
		public AbstractStepper createVariablePassiveGetter() {
			EntityGetter getter = new EntityGetter(this, false);
			initSetters(getter);
			variableGetterSet.add(getter);
			return getter;
		}
		public AbstractStepper createConstantActiveGetter() {
			EntityGetter getter = new EntityGetter(this, true);
			initSetters(getter);
			constantGetterSet.add(getter);
			return getter;
		}
		public AbstractStepper createVariableActiveGetter() {
			EntityGetter getter = new EntityGetter(this, true);
			initSetters(getter);
			variableGetterSet.add(getter);
			return getter;
		}

		protected Set<IControlFlowProducer> setterGoalSet = new HashSet<>();
		protected Set<AbstractStepper> setterActionSet = new HashSet<>();

		protected void initSetters(EntityGetter getter) {
			setterGoalSet.forEach((setterGoal) -> {
				getter.addCall(0, setterGoal);
			});
			setterActionSet.forEach((setterAction) -> {
				setterAction.addAction(getter.getArgumentConsumer(0));
			});
		}

		public void addSetter(AbstractStepper setter) {
			addCall(setter);
			addArgumentActionTo(setter);
		}
		public void addCall(IControlFlowProducer setterGoal) {
			setterGoalSet.add(setterGoal);

			Consumer<EntityGetter> addSetter = (getter) -> {
				getter.addCall(0, setterGoal);
			};
			variableGetterSet.forEach(addSetter);
			constantGetterSet.forEach(addSetter);
		}
		public void addArgumentActionTo(AbstractStepper setterAction) {
			setterActionSet.add(setterAction);

			Consumer<EntityGetter> addSetter = (getter) -> {
				setterAction.addAction(getter.getArgumentConsumer(0));
			};
			variableGetterSet.forEach(addSetter);
			constantGetterSet.forEach(addSetter);
		}
	}
}
