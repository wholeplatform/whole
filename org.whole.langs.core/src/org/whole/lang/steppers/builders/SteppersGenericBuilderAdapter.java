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

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SteppersGenericBuilderAdapter extends GenericIdentityBuilder {
    private ISteppersBuilder specificBuilder;

    public SteppersGenericBuilderAdapter(ISteppersBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public SteppersGenericBuilderAdapter(ISteppersBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case SteppersFeatureDescriptorEnum.declarations_ord :
            specificBuilder.declarations();
            break;
            case SteppersFeatureDescriptorEnum.expression_ord :
            specificBuilder.expression();
            break;
            case SteppersFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case SteppersFeatureDescriptorEnum.goals_ord :
            specificBuilder.goals();
            break;
            case SteppersFeatureDescriptorEnum.calls_ord :
            specificBuilder.calls();
            break;
            case SteppersFeatureDescriptorEnum.arguments_ord :
            specificBuilder.arguments();
            break;
            case SteppersFeatureDescriptorEnum.actions_ord :
            specificBuilder.actions();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SteppersEntityDescriptorEnum.Scope_ord :
            specificBuilder.Scope();
            break;
            case SteppersEntityDescriptorEnum.Declarations_ord :
            specificBuilder.Declarations();
            break;
            case SteppersEntityDescriptorEnum.Step_ord :
            specificBuilder.Step();
            break;
            case SteppersEntityDescriptorEnum.Choose_ord :
            specificBuilder.Choose();
            break;
            case SteppersEntityDescriptorEnum.Target_ord :
            specificBuilder.Target();
            break;
            case SteppersEntityDescriptorEnum.Calls_ord :
            specificBuilder.Calls();
            break;
            case SteppersEntityDescriptorEnum.CallBranch_ord :
            specificBuilder.CallBranch();
            break;
            case SteppersEntityDescriptorEnum.Actions_ord :
            specificBuilder.Actions();
            break;
            case SteppersEntityDescriptorEnum.ActionBranch_ord :
            specificBuilder.ActionBranch();
            break;
            case SteppersEntityDescriptorEnum.AndGoals_ord :
            specificBuilder.AndGoals();
            break;
            case SteppersEntityDescriptorEnum.OrGoals_ord :
            specificBuilder.OrGoals();
            break;
            case SteppersEntityDescriptorEnum.GoalBranch_ord :
            specificBuilder.GoalBranch();
            break;
            case SteppersEntityDescriptorEnum.AndArgument_ord :
            specificBuilder.AndArgument();
            break;
            case SteppersEntityDescriptorEnum.OrArgument_ord :
            specificBuilder.OrArgument();
            break;
            case SteppersEntityDescriptorEnum.ArgumentBranch_ord :
            specificBuilder.ArgumentBranch();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SteppersEntityDescriptorEnum.Scope_ord :
            specificBuilder.Scope_();
            break;
            case SteppersEntityDescriptorEnum.Declarations_ord :
            specificBuilder.Declarations_();
            break;
            case SteppersEntityDescriptorEnum.Step_ord :
            specificBuilder.Step_();
            break;
            case SteppersEntityDescriptorEnum.Choose_ord :
            specificBuilder.Choose_();
            break;
            case SteppersEntityDescriptorEnum.Target_ord :
            specificBuilder.Target_();
            break;
            case SteppersEntityDescriptorEnum.Calls_ord :
            specificBuilder.Calls_();
            break;
            case SteppersEntityDescriptorEnum.CallBranch_ord :
            specificBuilder.CallBranch_();
            break;
            case SteppersEntityDescriptorEnum.Actions_ord :
            specificBuilder.Actions_();
            break;
            case SteppersEntityDescriptorEnum.ActionBranch_ord :
            specificBuilder.ActionBranch_();
            break;
            case SteppersEntityDescriptorEnum.AndGoals_ord :
            specificBuilder.AndGoals_();
            break;
            case SteppersEntityDescriptorEnum.OrGoals_ord :
            specificBuilder.OrGoals_();
            break;
            case SteppersEntityDescriptorEnum.GoalBranch_ord :
            specificBuilder.GoalBranch_();
            break;
            case SteppersEntityDescriptorEnum.AndArgument_ord :
            specificBuilder.AndArgument_();
            break;
            case SteppersEntityDescriptorEnum.OrArgument_ord :
            specificBuilder.OrArgument_();
            break;
            case SteppersEntityDescriptorEnum.ArgumentBranch_ord :
            specificBuilder.ArgumentBranch_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SteppersEntityDescriptorEnum.Scope_ord :
            specificBuilder._Scope();
            break;
            case SteppersEntityDescriptorEnum.Declarations_ord :
            specificBuilder._Declarations();
            break;
            case SteppersEntityDescriptorEnum.Step_ord :
            specificBuilder._Step();
            break;
            case SteppersEntityDescriptorEnum.Choose_ord :
            specificBuilder._Choose();
            break;
            case SteppersEntityDescriptorEnum.Target_ord :
            specificBuilder._Target();
            break;
            case SteppersEntityDescriptorEnum.Calls_ord :
            specificBuilder._Calls();
            break;
            case SteppersEntityDescriptorEnum.CallBranch_ord :
            specificBuilder._CallBranch();
            break;
            case SteppersEntityDescriptorEnum.Actions_ord :
            specificBuilder._Actions();
            break;
            case SteppersEntityDescriptorEnum.ActionBranch_ord :
            specificBuilder._ActionBranch();
            break;
            case SteppersEntityDescriptorEnum.AndGoals_ord :
            specificBuilder._AndGoals();
            break;
            case SteppersEntityDescriptorEnum.OrGoals_ord :
            specificBuilder._OrGoals();
            break;
            case SteppersEntityDescriptorEnum.GoalBranch_ord :
            specificBuilder._GoalBranch();
            break;
            case SteppersEntityDescriptorEnum.AndArgument_ord :
            specificBuilder._AndArgument();
            break;
            case SteppersEntityDescriptorEnum.OrArgument_ord :
            specificBuilder._OrArgument();
            break;
            case SteppersEntityDescriptorEnum.ArgumentBranch_ord :
            specificBuilder._ArgumentBranch();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case SteppersEntityDescriptorEnum.Declarations_ord :
            specificBuilder.Declarations_(initialCapacity);
            break;
            case SteppersEntityDescriptorEnum.Calls_ord :
            specificBuilder.Calls_(initialCapacity);
            break;
            case SteppersEntityDescriptorEnum.Actions_ord :
            specificBuilder.Actions_(initialCapacity);
            break;
            case SteppersEntityDescriptorEnum.AndGoals_ord :
            specificBuilder.AndGoals_(initialCapacity);
            break;
            case SteppersEntityDescriptorEnum.OrGoals_ord :
            specificBuilder.OrGoals_(initialCapacity);
            break;
            case SteppersEntityDescriptorEnum.AndArgument_ord :
            specificBuilder.AndArgument_(initialCapacity);
            break;
            case SteppersEntityDescriptorEnum.OrArgument_ord :
            specificBuilder.OrArgument_(initialCapacity);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case SteppersEntityDescriptorEnum.StepperReference_ord :
            specificBuilder.StepperReference(value);
            break;
            case SteppersEntityDescriptorEnum.Name_ord :
            specificBuilder.Name(value);
            break;
        }
    }
}
