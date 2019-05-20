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
import java.util.function.Supplier;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.evaluators.MultiValuedRunnableEvaluator;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.steppers.AbstractStepper;
import org.whole.lang.steppers.ChooseStepper;
import org.whole.lang.steppers.ExecutableStepper;
import org.whole.lang.steppers.model.ActionBranch;
import org.whole.lang.steppers.model.AndArgument;
import org.whole.lang.steppers.model.Argument;
import org.whole.lang.steppers.model.ArgumentBranch;
import org.whole.lang.steppers.model.CallBranch;
import org.whole.lang.steppers.model.Choose;
import org.whole.lang.steppers.model.ISteppersEntity;
import org.whole.lang.steppers.model.Name;
import org.whole.lang.steppers.model.OrArgument;
import org.whole.lang.steppers.model.ResultAction;
import org.whole.lang.steppers.model.Scope;
import org.whole.lang.steppers.model.Step;
import org.whole.lang.steppers.model.StepperReference;
import org.whole.lang.steppers.model.Target;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class SteppersDynamicCompilerVisitor extends SteppersTraverseAllChildrenVisitor {
	protected Map<String, ExecutableStepper> nameStepMap = new HashMap<>();
	protected Map<String, ChooseStepper> nameChooseMap = new HashMap<>();

	@SuppressWarnings("unchecked")
	protected ExecutableStepper getStep(String name) {
		if (getBindings().wIsSet(NAMESTEPMAP_NAME))
			nameStepMap = (Map<String, ExecutableStepper>) getBindings().wGetValue(NAMESTEPMAP_NAME);

		return name != null ? nameStepMap.computeIfAbsent(name,
				n -> new ExecutableStepper()) : new ExecutableStepper();
	}
	@SuppressWarnings("unchecked")
	protected ChooseStepper getChoose(String name) {
		if (getBindings().wIsSet(NAMECHOOSEMAP_NAME))
			nameChooseMap = (Map<String, ChooseStepper>) getBindings().wGetValue(NAMECHOOSEMAP_NAME);

		return name != null ? nameChooseMap.computeIfAbsent(name,
				n -> new ChooseStepper()) : new ChooseStepper();
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

	protected Consumer<AbstractStepper> stepperWeaver = (s) -> {};
	protected Consumer<AbstractStepper> stepperGoalWeaver = (s) -> {};
	protected Consumer<AbstractStepper> stepperArgumentWeaver = (s) -> {};

	public static final String STEPPER_NAME = "enclosingStepper#stepper";
	public static final String NAMESTEPMAP_NAME = "steppers#nameStepMap";
	public static final String NAMECHOOSEMAP_NAME = "steppers#nameChooseMap";

	@Override
	public void visit(Step entity) {
		//FIXME use binding scope
		Consumer<AbstractStepper> outerStepperWeaver = stepperWeaver;
		Consumer<AbstractStepper> outerStepperGoalWeaver = stepperGoalWeaver;
		Consumer<AbstractStepper> outerStepperArgumentWeaver = stepperArgumentWeaver;
		
		getBindings().wDefValue("outerStepperWeaver", "outerStepperWeaver");
		
		String name = stringValue(entity.getName());
		ExecutableStepper stepper = getStep(name);
		stepper.withSourceEntity(entity);
		stepperWeaver.accept(stepper);

		stepperWeaver = (s) -> {};
		stepperGoalWeaver = (s) -> {};
		stepperArgumentWeaver = (s) -> {};
		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable compiledExpression = f.createScope(
						f.createBlock(
								f.createFilter(f.createConstant(BindingManagerFactory.instance.createValue(stepper), false), f.createAsVariable(STEPPER_NAME)),
								f.createFilter(f.createConstant(BindingManagerFactory.instance.createValue(nameStepMap), false), f.createAsVariable(NAMESTEPMAP_NAME)),
								f.createFilter(f.createConstant(BindingManagerFactory.instance.createValue(nameChooseMap), false), f.createAsVariable(NAMECHOOSEMAP_NAME)),
								compile(entity.getExpression(), () -> ExecutableFactory.instance.createSelf())
						), null, Set.of(STEPPER_NAME), true);
		stepper.withExecutable(compiledExpression);

		stepperWeaver = stepperGoalWeaver = (s) -> {
			stepper.addCall(s);
		};
		stepperArgumentWeaver = (s) -> {
			stepper.addCall(s.getArgumentConsumer(0));
		};
		entity.getCalls().accept(this);

		stepperWeaver = stepperGoalWeaver = (s) -> {
			stepper.addAction(s);
		};
		stepperArgumentWeaver = (s) -> {
			stepper.addAction(s.getArgumentConsumer(0));
		};
		entity.getActions().accept(this);
		
		if (EntityUtils.isResolver(entity.getArguments()) && stepper.producersSize()>0)
			stepper.connectExecutableProducersWithNewArguments();

		stepperWeaver = (s) -> {
			stepper.addArgumentConsumer(s);
		};
		entity.getArguments().accept(this);
		
		if (Matcher.match(SteppersEntityDescriptorEnum.Declarations, entity.wGetParent()))
			setResult(BindingManagerFactory.instance.createVoid());
		else
			setExecutableResult(stepper);
		
		stepperWeaver = outerStepperWeaver;
		stepperGoalWeaver = outerStepperGoalWeaver;
		stepperArgumentWeaver = outerStepperArgumentWeaver;
//		argumentWeaver = outerArgumentWeaver;
	}

	@Override
	public void visit(Choose entity) {
		Consumer<AbstractStepper> outerStepperWeaver = stepperWeaver;
		Consumer<AbstractStepper> outerStepperGoalWeaver = stepperGoalWeaver;

		String name = stringValue(entity.getName());
		ChooseStepper stepper = getChoose(name);
		stepper.withSourceEntity(entity);
		stepperWeaver.accept(stepper);

		stepperWeaver = stepperGoalWeaver = (s) -> {
			stepper.addCall(s);
		};
		entity.getCalls().accept(this);

		if (stepper.producersSize()>0)
			stepper.connectExecutableProducersWithNewArguments();

		if (Matcher.match(SteppersEntityDescriptorEnum.Declarations, entity.wGetParent()))
			setResult(BindingManagerFactory.instance.createVoid());
		else
			setExecutableResult(stepper);

		stepperWeaver = outerStepperWeaver;
		stepperGoalWeaver = outerStepperGoalWeaver;
	}

	@Override
	public void visit(StepperReference entity) {
		ExecutableStepper stepper = getStep(entity.wStringValue());
		stepperWeaver.accept(stepper);
		setExecutableResult(stepper);
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
		Consumer<AbstractStepper> outerStepperWeaver = stepperWeaver;

		stepperWeaver = stepperArgumentWeaver;
        entity.getArguments().accept(this);
        stepperWeaver = stepperGoalWeaver;
		entity.getGoals().accept(this);

		stepperWeaver = outerStepperWeaver;
	}

	@Override
	public void visit(ActionBranch entity) {
		Consumer<AbstractStepper> outerStepperWeaver = stepperWeaver;

        stepperWeaver = stepperGoalWeaver;
		entity.getGoals().accept(this);
		stepperWeaver = stepperArgumentWeaver;
        entity.getArguments().accept(this);

		stepperWeaver = outerStepperWeaver;
	}

	@Override
	public void visit(Argument entity) {
		int index = entity.getValue();

		setExecutableResult(new MultiValuedRunnableEvaluator( (selfEntity, bm, args) -> {
			ExecutableStepper stepper = (ExecutableStepper) getBindings().wGetValue(SteppersDynamicCompilerVisitor.STEPPER_NAME);
			bm.setExecutableResult(stepper.getArgumentExecutable(index));
		}) {
	
			public void toString(StringBuilder sb) {
				sb.append("argument "+index);
			}
		}.withSourceEntity(entity));
	}

	@Override
	public void visit(AndArgument entity) {
		if (!Matcher.match(SteppersEntityDescriptorEnum.Step, entity.wGetParent())) {
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

