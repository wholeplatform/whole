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
public class EntityGetter extends AbstractStepper {
	public EntityScope entityScope;

	public EntityGetter(EntityScope scope, boolean active, IExecutable... producers) {
		super(active ? 1 : 0);
		withProducers(producers);
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
		return super.areAllArgumentsAvailable() && getEntityScope().entity != null;
	}

	@Override
	public IEntity doEvaluateNext() {
		//use setEntity value of preceding scope
		if (isActive() && arguments[0] != null)
			getEntityScope().setNestedEntity(getArgument(0));
		return getEntityScope().entity;
	}


	public static class EntityScope extends AbstractStepper {
		protected EntityScope outerScope;
		protected EntityScope[] innerScopes = new EntityScope[0];
		protected IEntity entity;
		protected Set<EntityGetter> constantGetterSet = new HashSet<>();
		protected Set<EntityGetter> variableGetterSet = new HashSet<>();

		public EntityScope() {
			super(1);
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
		public IEntity doEvaluateNext() {
			if (arguments[0] != null)
				setEntity(getArgument(0));
			return entity;
		}

		public void doPropagateNext() {
			Consumer<EntityGetter> doNextAction = (getter) -> {
				if (getter.getState() == StepperState.CALL)
					getter.doNextAction();
			};
			variableGetterSet.forEach(doNextAction);
			constantGetterSet.forEach(doNextAction);
		}

		protected void addInnerScope(EntityScope scope) {
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

		public AbstractStepper createConstantPassiveGetter() {
			EntityGetter stepper = new EntityGetter(this, false);
			constantGetterSet.add(stepper);
			return stepper;
		}
		public AbstractStepper createVariablePassiveGetter() {
			EntityGetter stepper = new EntityGetter(this, false);
			variableGetterSet.add(stepper);
			return stepper;
		}
		public AbstractStepper createConstantActiveGetter() {
			EntityGetter stepper = new EntityGetter(this, true);
			constantGetterSet.add(stepper);
			return stepper;
		}
		public AbstractStepper createVariableActiveGetter() {
			EntityGetter stepper = new EntityGetter(this, true);
			variableGetterSet.add(stepper);
			return stepper;
		}

		protected Set<IDataFlowConsumer> argumentSet = new HashSet<>();
		protected Set<IDataFlowConsumer> setterSet = new HashSet<>();

		public void addSetter(AbstractStepper setter) {
			addSetter(setter, setter);
		}
		public void addSetter(IControlFlowProducer setter, AbstractStepper result) {
			Consumer<EntityGetter> addSetter = (getter) -> {
				//TODO 
			};
			variableGetterSet.forEach(addSetter);
			constantGetterSet.forEach(addSetter);

			argumentSet.forEach((argument) -> {
				//argument. branch
				result.addAction(argument);
			});

		}
	}
}
