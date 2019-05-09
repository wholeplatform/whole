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
package org.whole.lang.steppers.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.steppers.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class SteppersIdentitySwitchVisitor extends AbstractVisitor implements ISteppersVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case SteppersEntityDescriptorEnum.Scope_ord :
            visit((Scope) entity);
            break;
            case SteppersEntityDescriptorEnum.ResultAction_ord :
            visit((ResultAction) entity);
            break;
            case SteppersEntityDescriptorEnum.Argument_ord :
            visit((Argument) entity);
            break;
            case SteppersEntityDescriptorEnum.Declarations_ord :
            visit((Declarations) entity);
            break;
            case SteppersEntityDescriptorEnum.Step_ord :
            visit((Step) entity);
            break;
            case SteppersEntityDescriptorEnum.Choose_ord :
            visit((Choose) entity);
            break;
            case SteppersEntityDescriptorEnum.StepperReference_ord :
            visit((StepperReference) entity);
            break;
            case SteppersEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case SteppersEntityDescriptorEnum.Target_ord :
            visit((Target) entity);
            break;
            case SteppersEntityDescriptorEnum.Calls_ord :
            visit((Calls) entity);
            break;
            case SteppersEntityDescriptorEnum.CallBranch_ord :
            visit((CallBranch) entity);
            break;
            case SteppersEntityDescriptorEnum.Actions_ord :
            visit((Actions) entity);
            break;
            case SteppersEntityDescriptorEnum.ActionBranch_ord :
            visit((ActionBranch) entity);
            break;
            case SteppersEntityDescriptorEnum.AndGoals_ord :
            visit((AndGoals) entity);
            break;
            case SteppersEntityDescriptorEnum.OrGoals_ord :
            visit((OrGoals) entity);
            break;
            case SteppersEntityDescriptorEnum.GoalBranch_ord :
            visit((GoalBranch) entity);
            break;
            case SteppersEntityDescriptorEnum.AndArgument_ord :
            visit((AndArgument) entity);
            break;
            case SteppersEntityDescriptorEnum.OrArgument_ord :
            visit((OrArgument) entity);
            break;
            case SteppersEntityDescriptorEnum.ArgumentBranch_ord :
            visit((ArgumentBranch) entity);
            break;
        }
    }
}
