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
package org.whole.lang.steppers.visitors;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.steppers.AbstractStepper.ExecutableStepper;
import org.whole.lang.steppers.model.ActionBranch;
import org.whole.lang.steppers.model.AndArgument;
import org.whole.lang.steppers.model.Argument;
import org.whole.lang.steppers.model.ArgumentBranch;
import org.whole.lang.steppers.model.CallBranch;
import org.whole.lang.steppers.model.ISteppersEntity;
import org.whole.lang.steppers.model.Name;
import org.whole.lang.steppers.model.OrArgument;
import org.whole.lang.steppers.model.ResultAction;
import org.whole.lang.steppers.model.Scope;
import org.whole.lang.steppers.model.StepperApplication;
import org.whole.lang.steppers.model.StepperDeclaration;
import org.whole.lang.steppers.model.StepperReference;
import org.whole.lang.steppers.model.Target;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class SteppersDynamicCompilerVisitor extends SteppersTraverseAllChildrenVisitor {
	protected Map<String, ExecutableStepper> nameStepperMap = new HashMap<>();

	protected ExecutableStepper getStepper(String name) {
		return name != null ? nameStepperMap.computeIfAbsent(name, n -> new ExecutableStepper()) : new ExecutableStepper();
	}

	protected final String stringValue(Name entity) {
		setResult(null);
    	entity.accept(this);
    	IEntity result = getResult();
    	return result != null ? result.wStringValue() : null;
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
	
//	@Override
//	public void visit(ISteppersEntity entity) {
//		stagedDefaultVisit(entity, 0);
//	}


	@Override
	public void visit(Scope entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
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

	protected Consumer<ExecutableStepper> stepperWeaver = (s) -> {};
	protected Consumer<ExecutableStepper> stepperGoalWeaver = (s) -> {};
	protected Consumer<ExecutableStepper> stepperArgumentWeaver = (s) -> {};
	protected Function<Integer, IExecutable> argumentWeaver = (i) -> null;
	
	public static final String ARGUMENT_WEAVER_NAME = "enclosingStepper#argumentWeaver";

	@Override
	public void visit(StepperDeclaration entity) {
		//FIXME use binding scope
		Consumer<ExecutableStepper> outerStepperWeaver = stepperWeaver;
		Consumer<ExecutableStepper> outerStepperGoalWeaver = stepperGoalWeaver;
		Consumer<ExecutableStepper> outerStepperArgumentWeaver = stepperArgumentWeaver;
		Function<Integer, IExecutable> outerArgumentWeaver = argumentWeaver;
		
		getBindings().wDefValue("outerStepperWeaver", "outerStepperWeaver");
		
		String name = stringValue(entity.getName());
		ExecutableStepper stepper = getStepper(name);
		stepperWeaver.accept(stepper);

		//FIXME get stepper from cloneContext
		argumentWeaver = (i) -> {
			return stepper.getExecutableArgument(i);
		};

		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable compiledExpression = f.createScope(
						f.createBlock(
								f.createFilter(f.createConstant(BindingManagerFactory.instance.createValue(argumentWeaver), false), f.createAsVariable(ARGUMENT_WEAVER_NAME)),
								compile(entity.getExpression(), () -> ExecutableFactory.instance.createSelf())
						), null, Set.of(ARGUMENT_WEAVER_NAME), true);
		stepper.withExecutable(compiledExpression);
		stepper.withSourceEntity(entity);

		stepperWeaver = stepperGoalWeaver = (s) -> {
			stepper.addCall(s);
		};
		stepperArgumentWeaver = (s) -> {
			//FIXME ensure argument size
			stepper.addCall(s.getArgumentConsumer(0));
		};
		entity.getCalls().accept(this);

		stepperWeaver = stepperGoalWeaver = (s) -> {
			stepper.addAction(s);
		};
		stepperArgumentWeaver = (s) -> {
			//FIXME ensure argument size
			stepper.addAction(s.getArgumentConsumer(0));
		};
		entity.getActions().accept(this);
		
		if (EntityUtils.isResolver(entity.getArguments()) && stepper.producersSize()>0) {
			//TODO && executable contains Argument
			stepper.withArgumentProducers(stepper.producersSize());
		}
		
		stepperWeaver = (s) -> {
			stepper.addArgumentConsumer(s);
		};
		entity.getArguments().accept(this);

		if (Matcher.match(SteppersEntityDescriptorEnum.Declarations, entity.wGetParent()))
			setResult(BindingManagerFactory.instance.createVoid());
		else
			setExecutableResult(stepper.withSourceEntity(entity));
		
		stepperWeaver = outerStepperWeaver;
		stepperGoalWeaver = outerStepperGoalWeaver;
		stepperArgumentWeaver = outerStepperArgumentWeaver;
		argumentWeaver = outerArgumentWeaver;
	}

	@Override
	public void visit(StepperReference entity) {
		ExecutableStepper stepper = getStepper(entity.wStringValue());
		stepperWeaver.accept(stepper);
		setExecutableResult(stepper);//FIXME overwrites declaration source entity .withSourceEntity(entity)
	}

	@Override
	public void visit(ResultAction entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(Name entity) {
		setResult(BindingManagerFactory.instance.createValue(entity.getValue()));
	}

	@Override
	public void visit(CallBranch entity) {
		Consumer<ExecutableStepper> outerStepperWeaver = stepperWeaver;

        stepperWeaver = stepperGoalWeaver;
		entity.getGoals().accept(this);
		stepperWeaver = stepperArgumentWeaver;
        entity.getArguments().accept(this);

		stepperWeaver = outerStepperWeaver;
	}

	@Override
	public void visit(ActionBranch entity) {
		Consumer<ExecutableStepper> outerStepperWeaver = stepperWeaver;

        stepperWeaver = stepperGoalWeaver;
		entity.getGoals().accept(this);
		stepperWeaver = stepperArgumentWeaver;
        entity.getArguments().accept(this);

		stepperWeaver = outerStepperWeaver;
	}

	@Override
	public void visit(Argument entity) {
		int index = entity.getValue();

		setExecutableResult(argumentWeaver.apply(index).withSourceEntity(entity));
	}

	@Override
	public void visit(AndArgument entity) {
		if (!Matcher.match(SteppersEntityDescriptorEnum.StepperDeclaration, entity.wGetParent())) {
//FIXME			stepperWeaver.accept(t);
		}
		super.visit(entity);
	}

	@Override
	public void visit(OrArgument entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(ArgumentBranch entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(Target entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
}

