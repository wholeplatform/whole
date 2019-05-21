/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.steppers.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.steppers.model.*;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class SteppersEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int Expression_ord = 0;
    public static final int Scope_ord = 1;
    public static final int Declarations_ord = 2;
    public static final int Declaration_ord = 3;
    public static final int Stepper_ord = 4;
    public static final int Step_ord = 5;
    public static final int Choose_ord = 6;
    public static final int StepperReference_ord = 7;
    public static final int Name_ord = 8;
    public static final int Target_ord = 9;
    public static final int CallFlow_ord = 10;
    public static final int Calls_ord = 11;
    public static final int CallBranch_ord = 12;
    public static final int ActionFlow_ord = 13;
    public static final int Actions_ord = 14;
    public static final int ActionBranch_ord = 15;
    public static final int GoalFlow_ord = 16;
    public static final int AndGoals_ord = 17;
    public static final int OrGoals_ord = 18;
    public static final int GoalBranch_ord = 19;
    public static final int ArgumentFlow_ord = 20;
    public static final int AndArgument_ord = 21;
    public static final int OrArgument_ord = 22;
    public static final int ArgumentBranch_ord = 23;
    public static final SteppersEntityDescriptorEnum instance = new SteppersEntityDescriptorEnum();
    public static final EntityDescriptor<Expression> Expression = (EntityDescriptor<Expression>) instance.valueOf(Expression_ord);
    public static final EntityDescriptor<Scope> Scope = (EntityDescriptor<Scope>) instance.valueOf(Scope_ord);
    public static final EntityDescriptor<Declarations> Declarations = (EntityDescriptor<Declarations>) instance.valueOf(Declarations_ord);
    public static final EntityDescriptor<Declaration> Declaration = (EntityDescriptor<Declaration>) instance.valueOf(Declaration_ord);
    public static final EntityDescriptor<Stepper> Stepper = (EntityDescriptor<Stepper>) instance.valueOf(Stepper_ord);
    public static final EntityDescriptor<Step> Step = (EntityDescriptor<Step>) instance.valueOf(Step_ord);
    public static final EntityDescriptor<Choose> Choose = (EntityDescriptor<Choose>) instance.valueOf(Choose_ord);
    public static final EntityDescriptor<StepperReference> StepperReference = (EntityDescriptor<StepperReference>) instance.valueOf(StepperReference_ord);
    public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);
    public static final EntityDescriptor<Target> Target = (EntityDescriptor<Target>) instance.valueOf(Target_ord);
    public static final EntityDescriptor<CallFlow> CallFlow = (EntityDescriptor<CallFlow>) instance.valueOf(CallFlow_ord);
    public static final EntityDescriptor<Calls> Calls = (EntityDescriptor<Calls>) instance.valueOf(Calls_ord);
    public static final EntityDescriptor<CallBranch> CallBranch = (EntityDescriptor<CallBranch>) instance.valueOf(CallBranch_ord);
    public static final EntityDescriptor<ActionFlow> ActionFlow = (EntityDescriptor<ActionFlow>) instance.valueOf(ActionFlow_ord);
    public static final EntityDescriptor<Actions> Actions = (EntityDescriptor<Actions>) instance.valueOf(Actions_ord);
    public static final EntityDescriptor<ActionBranch> ActionBranch = (EntityDescriptor<ActionBranch>) instance.valueOf(ActionBranch_ord);
    public static final EntityDescriptor<GoalFlow> GoalFlow = (EntityDescriptor<GoalFlow>) instance.valueOf(GoalFlow_ord);
    public static final EntityDescriptor<AndGoals> AndGoals = (EntityDescriptor<AndGoals>) instance.valueOf(AndGoals_ord);
    public static final EntityDescriptor<OrGoals> OrGoals = (EntityDescriptor<OrGoals>) instance.valueOf(OrGoals_ord);
    public static final EntityDescriptor<GoalBranch> GoalBranch = (EntityDescriptor<GoalBranch>) instance.valueOf(GoalBranch_ord);
    public static final EntityDescriptor<ArgumentFlow> ArgumentFlow = (EntityDescriptor<ArgumentFlow>) instance.valueOf(ArgumentFlow_ord);
    public static final EntityDescriptor<AndArgument> AndArgument = (EntityDescriptor<AndArgument>) instance.valueOf(AndArgument_ord);
    public static final EntityDescriptor<OrArgument> OrArgument = (EntityDescriptor<OrArgument>) instance.valueOf(OrArgument_ord);
    public static final EntityDescriptor<ArgumentBranch> ArgumentBranch = (EntityDescriptor<ArgumentBranch>) instance.valueOf(ArgumentBranch_ord);

    private SteppersEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(Expression_ord, "Expression", Expression.class, true, Stepper_ord, Step_ord, Scope_ord, Choose_ord, StepperReference_ord);
        putSimpleEntity(Scope_ord, "Scope", Scope.class, false).withFeature(SteppersFeatureDescriptorEnum.declarations, Declarations_ord).withFeature(SteppersFeatureDescriptorEnum.expression, Expression_ord);
        putCompositeEntity(Declarations_ord, "Declarations", Declarations.class, false, Declaration_ord, true, false);
        putSimpleEntity(Declaration_ord, "Declaration", Declaration.class, true, Stepper_ord, Step_ord, Choose_ord, StepperReference_ord);
        putSimpleEntity(Stepper_ord, "Stepper", Stepper.class, true, Choose_ord, StepperReference_ord, Step_ord);
        putSimpleEntity(Step_ord, "Step", Step.class, false).withFeature(SteppersFeatureDescriptorEnum.name, Name_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.goals, GoalFlow_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.calls, CallFlow_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.arguments, ArgumentFlow_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.actions, ActionFlow_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.expression, Expression_ord, true, false, false, false, false);
        putSimpleEntity(Choose_ord, "Choose", Choose.class, false).withFeature(SteppersFeatureDescriptorEnum.name, Name_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.goals, GoalFlow_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.calls, Calls_ord, true, false, false, false, false);
        putDataEntity(StepperReference_ord, "StepperReference", StepperReference.class, false, String.class);
        putDataEntity(Name_ord, "Name", Name.class, false, String.class);
        putSimpleEntity(Target_ord, "Target", Target.class, false);
        putSimpleEntity(CallFlow_ord, "CallFlow", CallFlow.class, true, Calls_ord, Stepper_ord, CallBranch_ord, Step_ord, Choose_ord, StepperReference_ord);
        putCompositeEntity(Calls_ord, "Calls", Calls.class, false, CallFlow_ord, true, false);
        putSimpleEntity(CallBranch_ord, "CallBranch", CallBranch.class, false).withFeature(SteppersFeatureDescriptorEnum.goals, CallFlow_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.arguments, CallFlow_ord, true, false, false, false, false);
        putSimpleEntity(ActionFlow_ord, "ActionFlow", ActionFlow.class, true, ActionBranch_ord, Stepper_ord, Step_ord, Actions_ord, Choose_ord, StepperReference_ord);
        putCompositeEntity(Actions_ord, "Actions", Actions.class, false, ActionFlow_ord, true, false);
        putSimpleEntity(ActionBranch_ord, "ActionBranch", ActionBranch.class, false).withFeature(SteppersFeatureDescriptorEnum.goals, ActionFlow_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.arguments, ActionFlow_ord, true, false, false, false, false);
        putSimpleEntity(GoalFlow_ord, "GoalFlow", GoalFlow.class, true, Target_ord, AndGoals_ord, GoalBranch_ord, Choose_ord, StepperReference_ord, Stepper_ord, Step_ord, OrGoals_ord);
        putCompositeEntity(AndGoals_ord, "AndGoals", AndGoals.class, false, GoalFlow_ord, true, false);
        putCompositeEntity(OrGoals_ord, "OrGoals", OrGoals.class, false, GoalFlow_ord, true, false);
        putSimpleEntity(GoalBranch_ord, "GoalBranch", GoalBranch.class, false).withFeature(SteppersFeatureDescriptorEnum.calls, GoalFlow_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.actions, GoalFlow_ord, true, false, false, false, false);
        putSimpleEntity(ArgumentFlow_ord, "ArgumentFlow", ArgumentFlow.class, true, AndArgument_ord, Target_ord, Choose_ord, StepperReference_ord, Stepper_ord, ArgumentBranch_ord, Step_ord, OrArgument_ord);
        putCompositeEntity(AndArgument_ord, "AndArgument", AndArgument.class, false, ArgumentFlow_ord, true, false);
        putCompositeEntity(OrArgument_ord, "OrArgument", OrArgument.class, false, ArgumentFlow_ord, true, false);
        putSimpleEntity(ArgumentBranch_ord, "ArgumentBranch", ArgumentBranch.class, false).withFeature(SteppersFeatureDescriptorEnum.calls, ArgumentFlow_ord, true, false, false, false, false).withFeature(SteppersFeatureDescriptorEnum.actions, ArgumentFlow_ord, true, false, false, false, false);
    }

    protected void initForeignTypeRelations() {
        setAliasOf(true, "http://lang.whole.org/Queries#Expression", Expression_ord);
    }
}
