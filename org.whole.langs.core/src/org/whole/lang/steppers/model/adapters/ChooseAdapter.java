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
package org.whole.lang.steppers.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.steppers.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.steppers.visitors.ISteppersVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ChooseAdapter extends AbstractEntityAdapter implements Choose {
    private static final long serialVersionUID = 1;

    public ChooseAdapter(IEntity implementor) {
        super(implementor);
    }

    public ChooseAdapter() {
    }

    public void accept(ISteppersVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Choose> wGetEntityDescriptor() {
        return SteppersEntityDescriptorEnum.Choose;
    }

    public Name getName() {
        return wGet(SteppersFeatureDescriptorEnum.name).wGetAdapter(SteppersEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(SteppersFeatureDescriptorEnum.name, name);
    }

    public GoalFlow getGoals() {
        return wGet(SteppersFeatureDescriptorEnum.goals).wGetAdapter(SteppersEntityDescriptorEnum.GoalFlow);
    }

    public void setGoals(GoalFlow goals) {
        wSet(SteppersFeatureDescriptorEnum.goals, goals);
    }

    public Calls getCalls() {
        return wGet(SteppersFeatureDescriptorEnum.calls).wGetAdapter(SteppersEntityDescriptorEnum.Calls);
    }

    public void setCalls(Calls calls) {
        wSet(SteppersFeatureDescriptorEnum.calls, calls);
    }
}
