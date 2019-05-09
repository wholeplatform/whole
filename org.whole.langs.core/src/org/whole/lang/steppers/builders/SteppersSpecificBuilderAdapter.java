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
package org.whole.lang.steppers.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SteppersSpecificBuilderAdapter extends GenericBuilderContext implements ISteppersBuilder {

    public SteppersSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public SteppersSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void arguments() {
        wFeature(SteppersFeatureDescriptorEnum.arguments);
    }

    public void calls() {
        wFeature(SteppersFeatureDescriptorEnum.calls);
    }

    public void goals() {
        wFeature(SteppersFeatureDescriptorEnum.goals);
    }

    public void name() {
        wFeature(SteppersFeatureDescriptorEnum.name);
    }

    public void actions() {
        wFeature(SteppersFeatureDescriptorEnum.actions);
    }

    public void expression() {
        wFeature(SteppersFeatureDescriptorEnum.expression);
    }

    public void declarations() {
        wFeature(SteppersFeatureDescriptorEnum.declarations);
    }

    public void visit() {
    }

    public void Scope() {
        wEntity(SteppersEntityDescriptorEnum.Scope);
    }

    public void Scope_() {
        wEntity_(SteppersEntityDescriptorEnum.Scope);
    }

    public void _Scope() {
        _wEntity(SteppersEntityDescriptorEnum.Scope);
    }

    public void ResultAction() {
        wEntity(SteppersEntityDescriptorEnum.ResultAction);
    }

    public void ResultAction_() {
        wEntity_(SteppersEntityDescriptorEnum.ResultAction);
    }

    public void _ResultAction() {
        _wEntity(SteppersEntityDescriptorEnum.ResultAction);
    }

    public void Argument() {
        wEntity(SteppersEntityDescriptorEnum.Argument);
    }

    public void Argument(int value) {
        wEntity(SteppersEntityDescriptorEnum.Argument, value);
    }

    public void Declarations() {
        wEntity(SteppersEntityDescriptorEnum.Declarations);
    }

    public void Declarations_() {
        wEntity_(SteppersEntityDescriptorEnum.Declarations);
    }

    public void Declarations_(int initialCapacity) {
        wEntity_(SteppersEntityDescriptorEnum.Declarations, initialCapacity);
    }

    public void _Declarations() {
        _wEntity(SteppersEntityDescriptorEnum.Declarations);
    }

    public void Step() {
        wEntity(SteppersEntityDescriptorEnum.Step);
    }

    public void Step_() {
        wEntity_(SteppersEntityDescriptorEnum.Step);
    }

    public void _Step() {
        _wEntity(SteppersEntityDescriptorEnum.Step);
    }

    public void Choose() {
        wEntity(SteppersEntityDescriptorEnum.Choose);
    }

    public void Choose_() {
        wEntity_(SteppersEntityDescriptorEnum.Choose);
    }

    public void _Choose() {
        _wEntity(SteppersEntityDescriptorEnum.Choose);
    }

    public void StepperReference() {
        wEntity(SteppersEntityDescriptorEnum.StepperReference);
    }

    public void StepperReference(String value) {
        wEntity(SteppersEntityDescriptorEnum.StepperReference, value);
    }

    public void Name() {
        wEntity(SteppersEntityDescriptorEnum.Name);
    }

    public void Name(String value) {
        wEntity(SteppersEntityDescriptorEnum.Name, value);
    }

    public void Target() {
        wEntity(SteppersEntityDescriptorEnum.Target);
    }

    public void Target_() {
        wEntity_(SteppersEntityDescriptorEnum.Target);
    }

    public void _Target() {
        _wEntity(SteppersEntityDescriptorEnum.Target);
    }

    public void Calls() {
        wEntity(SteppersEntityDescriptorEnum.Calls);
    }

    public void Calls_() {
        wEntity_(SteppersEntityDescriptorEnum.Calls);
    }

    public void Calls_(int initialCapacity) {
        wEntity_(SteppersEntityDescriptorEnum.Calls, initialCapacity);
    }

    public void _Calls() {
        _wEntity(SteppersEntityDescriptorEnum.Calls);
    }

    public void CallBranch() {
        wEntity(SteppersEntityDescriptorEnum.CallBranch);
    }

    public void CallBranch_() {
        wEntity_(SteppersEntityDescriptorEnum.CallBranch);
    }

    public void _CallBranch() {
        _wEntity(SteppersEntityDescriptorEnum.CallBranch);
    }

    public void Actions() {
        wEntity(SteppersEntityDescriptorEnum.Actions);
    }

    public void Actions_() {
        wEntity_(SteppersEntityDescriptorEnum.Actions);
    }

    public void Actions_(int initialCapacity) {
        wEntity_(SteppersEntityDescriptorEnum.Actions, initialCapacity);
    }

    public void _Actions() {
        _wEntity(SteppersEntityDescriptorEnum.Actions);
    }

    public void ActionBranch() {
        wEntity(SteppersEntityDescriptorEnum.ActionBranch);
    }

    public void ActionBranch_() {
        wEntity_(SteppersEntityDescriptorEnum.ActionBranch);
    }

    public void _ActionBranch() {
        _wEntity(SteppersEntityDescriptorEnum.ActionBranch);
    }

    public void AndGoals() {
        wEntity(SteppersEntityDescriptorEnum.AndGoals);
    }

    public void AndGoals_() {
        wEntity_(SteppersEntityDescriptorEnum.AndGoals);
    }

    public void AndGoals_(int initialCapacity) {
        wEntity_(SteppersEntityDescriptorEnum.AndGoals, initialCapacity);
    }

    public void _AndGoals() {
        _wEntity(SteppersEntityDescriptorEnum.AndGoals);
    }

    public void OrGoals() {
        wEntity(SteppersEntityDescriptorEnum.OrGoals);
    }

    public void OrGoals_() {
        wEntity_(SteppersEntityDescriptorEnum.OrGoals);
    }

    public void OrGoals_(int initialCapacity) {
        wEntity_(SteppersEntityDescriptorEnum.OrGoals, initialCapacity);
    }

    public void _OrGoals() {
        _wEntity(SteppersEntityDescriptorEnum.OrGoals);
    }

    public void GoalBranch() {
        wEntity(SteppersEntityDescriptorEnum.GoalBranch);
    }

    public void GoalBranch_() {
        wEntity_(SteppersEntityDescriptorEnum.GoalBranch);
    }

    public void _GoalBranch() {
        _wEntity(SteppersEntityDescriptorEnum.GoalBranch);
    }

    public void AndArgument() {
        wEntity(SteppersEntityDescriptorEnum.AndArgument);
    }

    public void AndArgument_() {
        wEntity_(SteppersEntityDescriptorEnum.AndArgument);
    }

    public void AndArgument_(int initialCapacity) {
        wEntity_(SteppersEntityDescriptorEnum.AndArgument, initialCapacity);
    }

    public void _AndArgument() {
        _wEntity(SteppersEntityDescriptorEnum.AndArgument);
    }

    public void OrArgument() {
        wEntity(SteppersEntityDescriptorEnum.OrArgument);
    }

    public void OrArgument_() {
        wEntity_(SteppersEntityDescriptorEnum.OrArgument);
    }

    public void OrArgument_(int initialCapacity) {
        wEntity_(SteppersEntityDescriptorEnum.OrArgument, initialCapacity);
    }

    public void _OrArgument() {
        _wEntity(SteppersEntityDescriptorEnum.OrArgument);
    }

    public void ArgumentBranch() {
        wEntity(SteppersEntityDescriptorEnum.ArgumentBranch);
    }

    public void ArgumentBranch_() {
        wEntity_(SteppersEntityDescriptorEnum.ArgumentBranch);
    }

    public void _ArgumentBranch() {
        _wEntity(SteppersEntityDescriptorEnum.ArgumentBranch);
    }
}
