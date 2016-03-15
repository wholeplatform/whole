/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.ConditionalExpression;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.Expression;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ConditionalExpressionImpl extends AbstractSimpleEntity implements ConditionalExpression {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ConditionalExpression> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.ConditionalExpression;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.ConditionalExpression_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression expression;

    public Expression getExpression() {
        return notifyRequested(JavaFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expression expression) {
        notifyChanged(JavaFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }
    private Expression thenExpression;

    public Expression getThenExpression() {
        return notifyRequested(JavaFeatureDescriptorEnum.thenExpression, thenExpression);
    }

    public void setThenExpression(Expression thenExpression) {
        notifyChanged(JavaFeatureDescriptorEnum.thenExpression, this.thenExpression, this.thenExpression = thenExpression);
    }
    private Expression elseExpression;

    public Expression getElseExpression() {
        return notifyRequested(JavaFeatureDescriptorEnum.elseExpression, elseExpression);
    }

    public void setElseExpression(Expression elseExpression) {
        notifyChanged(JavaFeatureDescriptorEnum.elseExpression, this.elseExpression, this.elseExpression = elseExpression);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getExpression().wGetAdaptee(false);
            case 1 :
            return getThenExpression().wGetAdaptee(false);
            case 2 :
            return getElseExpression().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setExpression(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setThenExpression(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            case 2 :
            setElseExpression(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
