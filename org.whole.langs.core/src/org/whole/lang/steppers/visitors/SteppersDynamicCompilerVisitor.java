/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.steppers.visitors;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.steppers.AbstractStepper.ExecutableStepper;
import org.whole.lang.steppers.model.ISteppersEntity;
import org.whole.lang.steppers.model.Name;
import org.whole.lang.steppers.model.StepperApplication;
import org.whole.lang.steppers.model.StepperDeclaration;
import org.whole.lang.steppers.model.StepperReference;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class SteppersDynamicCompilerVisitor extends SteppersIdentityDefaultVisitor {
	protected Map<String, ExecutableStepper> nameStepperMap = new HashMap<>();

	protected ExecutableStepper getStepper(String name) {
		return nameStepperMap.computeIfAbsent(name, n -> new ExecutableStepper());
	}

	protected final String stringValue(Name entity) {
		setResult(null);
    	entity.accept(this);
    	IEntity result = getResult();
    	if (result == null)
    		throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(entity).withBindings(getBindings());
    	return result.wStringValue();
	}

	protected IExecutable compile(ISteppersEntity entity, Supplier<IExecutable> supplier) {
		setResult(null);
		entity.accept(this);
		return getBindings().isExecutableResult() ? getExecutableResult() : supplier.get();
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false), 0);
		return false;
	}
	
	@Override
	public void visit(ISteppersEntity entity) {
		stagedDefaultVisit(entity, 0);
	}

	@Override
	public void visit(StepperDeclaration entity) {
		String name = stringValue(entity.getName());
		ExecutableStepper stepper = getStepper(name);
		stepper.withExecutable(compile(entity.getExpression(), () -> ExecutableFactory.instance.createSelf()));
		stepper.withSourceEntity(entity);
		setResult(BindingManagerFactory.instance.createVoid());
//		setExecutableResult(stepper.withSourceEntity(entity));
	}

	@Override
	public void visit(StepperReference entity) {
		ExecutableStepper stepper = getStepper(entity.wStringValue());
		setExecutableResult(stepper.withSourceEntity(entity));
	}

	@Override
	public void visit(Name entity) {
		setResult(BindingManagerFactory.instance.createValue(entity.getValue()));
	}

	@Override
	public void visit(StepperApplication entity) {
		entity.getGoals().accept(this);
//		IEntity stepperR = getResult();
		//TODO test only
//		if (stepperR instanceof ExecutableStepper) {
//		ExecutableStepper stepper = (ExecutableStepper) getResult();
//    	if (stepper != null) {
//    		IEntity result = stepper.evaluateRemaining();
//    		setResult(result);
//    	}
//		}
	}
}

