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

import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.operations.ICloneContext;

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
	public boolean areArgumentsAvailable() {
//		return getEntityScope().entity != null || (isActive() && super.areAllArgumentsAvailable());
		return super.areArgumentsAvailable() && getEntityScope().entity != null;
	}

	@Override
	protected IExecutable getExecutableAction() {
		//use setEntity value of preceding scope
		if (isActive() && arguments[0] != null)
			getEntityScope().setNestedEntity(getArgumentExecutable(0).evaluateRemaining());
		return ExecutableFactory.instance.createConstant(getEntityScope().entity, false);
	}
}
