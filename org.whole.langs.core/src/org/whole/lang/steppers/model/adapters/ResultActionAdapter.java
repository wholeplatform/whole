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
public class ResultActionAdapter extends AbstractEntityAdapter implements ResultAction {
    private static final long serialVersionUID = 1;

    public ResultActionAdapter(IEntity implementor) {
        super(implementor);
    }

    public ResultActionAdapter() {
    }

    public void accept(ISteppersVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ResultAction> wGetEntityDescriptor() {
        return SteppersEntityDescriptorEnum.ResultAction;
    }

    public Expression getExpression() {
        return wGet(SteppersFeatureDescriptorEnum.expression).wGetAdapter(SteppersEntityDescriptorEnum.Expression);
    }

    public void setExpression(Expression expression) {
        wSet(SteppersFeatureDescriptorEnum.expression, expression);
    }

    public ActionFlow getActions() {
        return wGet(SteppersFeatureDescriptorEnum.actions).wGetAdapter(SteppersEntityDescriptorEnum.ActionFlow);
    }

    public void setActions(ActionFlow actions) {
        wSet(SteppersFeatureDescriptorEnum.actions, actions);
    }
}
