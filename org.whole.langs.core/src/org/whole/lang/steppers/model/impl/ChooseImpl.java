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
import org.whole.lang.steppers.model.Choose;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.steppers.visitors.ISteppersVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.steppers.model.Name;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.steppers.model.GoalFlow;
import org.whole.lang.steppers.model.Calls;

/**
 *  @generator Whole
 */
public class ChooseImpl extends AbstractSimpleEntity implements Choose {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Choose> wGetEntityDescriptor() {
        return SteppersEntityDescriptorEnum.Choose;
    }

    public int wGetEntityOrd() {
        return SteppersEntityDescriptorEnum.Choose_ord;
    }

    public void accept(ISteppersVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name name;

    public Name getName() {
        return notifyRequested(SteppersFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(SteppersFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private GoalFlow goals;

    public GoalFlow getGoals() {
        return notifyRequested(SteppersFeatureDescriptorEnum.goals, goals);
    }

    public void setGoals(GoalFlow goals) {
        notifyChanged(SteppersFeatureDescriptorEnum.goals, this.goals, this.goals = goals);
    }
    private Calls calls;

    public Calls getCalls() {
        return notifyRequested(SteppersFeatureDescriptorEnum.calls, calls);
    }

    public void setCalls(Calls calls) {
        notifyChanged(SteppersFeatureDescriptorEnum.calls, this.calls, this.calls = calls);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getGoals().wGetAdaptee(false);
            case 2 :
            return getCalls().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(SteppersEntityDescriptorEnum.Name));
            break;
            case 1 :
            setGoals(value.wGetAdapter(SteppersEntityDescriptorEnum.GoalFlow));
            break;
            case 2 :
            setCalls(value.wGetAdapter(SteppersEntityDescriptorEnum.Calls));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
