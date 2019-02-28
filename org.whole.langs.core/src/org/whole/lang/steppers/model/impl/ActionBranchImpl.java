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
package org.whole.lang.steppers.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.steppers.model.ActionBranch;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.steppers.visitors.ISteppersVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.steppers.model.ActionFlow;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ActionBranchImpl extends AbstractSimpleEntity implements ActionBranch {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ActionBranch> wGetEntityDescriptor() {
        return SteppersEntityDescriptorEnum.ActionBranch;
    }

    public int wGetEntityOrd() {
        return SteppersEntityDescriptorEnum.ActionBranch_ord;
    }

    public void accept(ISteppersVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private ActionFlow goals;

    public ActionFlow getGoals() {
        return notifyRequested(SteppersFeatureDescriptorEnum.goals, goals);
    }

    public void setGoals(ActionFlow goals) {
        notifyChanged(SteppersFeatureDescriptorEnum.goals, this.goals, this.goals = goals);
    }
    private ActionFlow arguments;

    public ActionFlow getArguments() {
        return notifyRequested(SteppersFeatureDescriptorEnum.arguments, arguments);
    }

    public void setArguments(ActionFlow arguments) {
        notifyChanged(SteppersFeatureDescriptorEnum.arguments, this.arguments, this.arguments = arguments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getGoals().wGetAdaptee(false);
            case 1 :
            return getArguments().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setGoals(value.wGetAdapter(SteppersEntityDescriptorEnum.ActionFlow));
            break;
            case 1 :
            setArguments(value.wGetAdapter(SteppersEntityDescriptorEnum.ActionFlow));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
