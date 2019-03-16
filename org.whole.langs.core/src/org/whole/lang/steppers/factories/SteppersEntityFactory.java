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
package org.whole.lang.steppers.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.steppers.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SteppersEntityFactory extends GenericEntityFactory {
    public static final SteppersEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static SteppersEntityFactory instance(IEntityRegistryProvider provider) {
        return new SteppersEntityFactory(provider);
    }

    protected SteppersEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public Scope createScope() {
        return create(SteppersEntityDescriptorEnum.Scope);
    }

    public Scope createScope(Declarations declarations, Expression expression) {
        return create(SteppersEntityDescriptorEnum.Scope, declarations, expression);
    }

    public IEntityBuilder<Scope> buildScope() {
        return new EntityBuilder<Scope>(create(SteppersEntityDescriptorEnum.Scope));
    }

    public StepperApplication createStepperApplication() {
        return create(SteppersEntityDescriptorEnum.StepperApplication);
    }

    public StepperApplication createStepperApplication(CallFlow goals, ArgumentFlow results) {
        return create(SteppersEntityDescriptorEnum.StepperApplication, goals, results);
    }

    public IEntityBuilder<StepperApplication> buildStepperApplication() {
        return new EntityBuilder<StepperApplication>(create(SteppersEntityDescriptorEnum.StepperApplication));
    }

    public ResultAction createResultAction() {
        return create(SteppersEntityDescriptorEnum.ResultAction);
    }

    public ResultAction createResultAction(Expression expression, ActionFlow actions) {
        return create(SteppersEntityDescriptorEnum.ResultAction, expression, actions);
    }

    public IEntityBuilder<ResultAction> buildResultAction() {
        return new EntityBuilder<ResultAction>(create(SteppersEntityDescriptorEnum.ResultAction));
    }

    public Argument createArgument() {
        return create(SteppersEntityDescriptorEnum.Argument);
    }

    public Argument createArgument(int value) {
        return create(SteppersEntityDescriptorEnum.Argument, value);
    }

    public Declarations createDeclarations() {
        return create(SteppersEntityDescriptorEnum.Declarations);
    }

    public Declarations createDeclarations(Declaration... entities) {
        return create(SteppersEntityDescriptorEnum.Declarations, (IEntity[]) entities);
    }

    public Declarations createDeclarations(int initialSize) {
        return clone(SteppersEntityDescriptorEnum.Declarations, initialSize);
    }

    public StepperDeclaration createStepperDeclaration() {
        return create(SteppersEntityDescriptorEnum.StepperDeclaration);
    }

    public StepperDeclaration createStepperDeclaration(Name name, GoalFlow goals, CallFlow calls, ArgumentFlow arguments, ActionFlow actions, Expression expression) {
        return create(SteppersEntityDescriptorEnum.StepperDeclaration, name, goals, calls, arguments, actions, expression);
    }

    public IEntityBuilder<StepperDeclaration> buildStepperDeclaration() {
        return new EntityBuilder<StepperDeclaration>(create(SteppersEntityDescriptorEnum.StepperDeclaration));
    }

    public StepperReference createStepperReference() {
        return create(SteppersEntityDescriptorEnum.StepperReference);
    }

    public StepperReference createStepperReference(String value) {
        return create(SteppersEntityDescriptorEnum.StepperReference, value);
    }

    public Name createName() {
        return create(SteppersEntityDescriptorEnum.Name);
    }

    public Name createName(String value) {
        return create(SteppersEntityDescriptorEnum.Name, value);
    }

    public Target createTarget() {
        return create(SteppersEntityDescriptorEnum.Target);
    }

    public Calls createCalls() {
        return create(SteppersEntityDescriptorEnum.Calls);
    }

    public Calls createCalls(CallFlow... entities) {
        return create(SteppersEntityDescriptorEnum.Calls, (IEntity[]) entities);
    }

    public Calls createCalls(int initialSize) {
        return clone(SteppersEntityDescriptorEnum.Calls, initialSize);
    }

    public CallBranch createCallBranch() {
        return create(SteppersEntityDescriptorEnum.CallBranch);
    }

    public CallBranch createCallBranch(CallFlow goals, CallFlow arguments) {
        return create(SteppersEntityDescriptorEnum.CallBranch, goals, arguments);
    }

    public IEntityBuilder<CallBranch> buildCallBranch() {
        return new EntityBuilder<CallBranch>(create(SteppersEntityDescriptorEnum.CallBranch));
    }

    public Actions createActions() {
        return create(SteppersEntityDescriptorEnum.Actions);
    }

    public Actions createActions(ActionFlow... entities) {
        return create(SteppersEntityDescriptorEnum.Actions, (IEntity[]) entities);
    }

    public Actions createActions(int initialSize) {
        return clone(SteppersEntityDescriptorEnum.Actions, initialSize);
    }

    public ActionBranch createActionBranch() {
        return create(SteppersEntityDescriptorEnum.ActionBranch);
    }

    public ActionBranch createActionBranch(ActionFlow goals, ActionFlow arguments) {
        return create(SteppersEntityDescriptorEnum.ActionBranch, goals, arguments);
    }

    public IEntityBuilder<ActionBranch> buildActionBranch() {
        return new EntityBuilder<ActionBranch>(create(SteppersEntityDescriptorEnum.ActionBranch));
    }

    public AndGoals createAndGoals() {
        return create(SteppersEntityDescriptorEnum.AndGoals);
    }

    public AndGoals createAndGoals(GoalFlow... entities) {
        return create(SteppersEntityDescriptorEnum.AndGoals, (IEntity[]) entities);
    }

    public AndGoals createAndGoals(int initialSize) {
        return clone(SteppersEntityDescriptorEnum.AndGoals, initialSize);
    }

    public OrGoals createOrGoals() {
        return create(SteppersEntityDescriptorEnum.OrGoals);
    }

    public OrGoals createOrGoals(GoalFlow... entities) {
        return create(SteppersEntityDescriptorEnum.OrGoals, (IEntity[]) entities);
    }

    public OrGoals createOrGoals(int initialSize) {
        return clone(SteppersEntityDescriptorEnum.OrGoals, initialSize);
    }

    public GoalBranch createGoalBranch() {
        return create(SteppersEntityDescriptorEnum.GoalBranch);
    }

    public GoalBranch createGoalBranch(GoalFlow calls, GoalFlow actions) {
        return create(SteppersEntityDescriptorEnum.GoalBranch, calls, actions);
    }

    public IEntityBuilder<GoalBranch> buildGoalBranch() {
        return new EntityBuilder<GoalBranch>(create(SteppersEntityDescriptorEnum.GoalBranch));
    }

    public AndArgument createAndArgument() {
        return create(SteppersEntityDescriptorEnum.AndArgument);
    }

    public AndArgument createAndArgument(ArgumentFlow... entities) {
        return create(SteppersEntityDescriptorEnum.AndArgument, (IEntity[]) entities);
    }

    public AndArgument createAndArgument(int initialSize) {
        return clone(SteppersEntityDescriptorEnum.AndArgument, initialSize);
    }

    public OrArgument createOrArgument() {
        return create(SteppersEntityDescriptorEnum.OrArgument);
    }

    public OrArgument createOrArgument(ArgumentFlow... entities) {
        return create(SteppersEntityDescriptorEnum.OrArgument, (IEntity[]) entities);
    }

    public OrArgument createOrArgument(int initialSize) {
        return clone(SteppersEntityDescriptorEnum.OrArgument, initialSize);
    }

    public ArgumentBranch createArgumentBranch() {
        return create(SteppersEntityDescriptorEnum.ArgumentBranch);
    }

    public ArgumentBranch createArgumentBranch(ArgumentFlow calls, ArgumentFlow actions) {
        return create(SteppersEntityDescriptorEnum.ArgumentBranch, calls, actions);
    }

    public IEntityBuilder<ArgumentBranch> buildArgumentBranch() {
        return new EntityBuilder<ArgumentBranch>(create(SteppersEntityDescriptorEnum.ArgumentBranch));
    }
}
