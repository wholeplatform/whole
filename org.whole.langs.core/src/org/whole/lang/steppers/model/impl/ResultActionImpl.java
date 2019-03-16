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
import org.whole.lang.steppers.model.ResultAction;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.steppers.visitors.ISteppersVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.steppers.model.Expression;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.steppers.model.ActionFlow;

/**
 *  @generator Whole
 */
public class ResultActionImpl extends AbstractSimpleEntity implements ResultAction {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ResultAction> wGetEntityDescriptor() {
        return SteppersEntityDescriptorEnum.ResultAction;
    }

    public int wGetEntityOrd() {
        return SteppersEntityDescriptorEnum.ResultAction_ord;
    }

    public void accept(ISteppersVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression expression;

    public Expression getExpression() {
        return notifyRequested(SteppersFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expression expression) {
        notifyChanged(SteppersFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }
    private ActionFlow actions;

    public ActionFlow getActions() {
        return notifyRequested(SteppersFeatureDescriptorEnum.actions, actions);
    }

    public void setActions(ActionFlow actions) {
        notifyChanged(SteppersFeatureDescriptorEnum.actions, this.actions, this.actions = actions);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getExpression().wGetAdaptee(false);
            case 1 :
            return getActions().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setExpression(value.wGetAdapter(SteppersEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setActions(value.wGetAdapter(SteppersEntityDescriptorEnum.ActionFlow));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
