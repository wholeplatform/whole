/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.java.model.InstanceofExpression;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.Expression;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.Type;

/**
 *  @generator Whole
 */
public class InstanceofExpressionImpl extends AbstractSimpleEntity implements InstanceofExpression {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<InstanceofExpression> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.InstanceofExpression;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.InstanceofExpression_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression leftOperand;

    public Expression getLeftOperand() {
        return notifyRequested(JavaFeatureDescriptorEnum.leftOperand, leftOperand);
    }

    public void setLeftOperand(Expression leftOperand) {
        notifyChanged(JavaFeatureDescriptorEnum.leftOperand, this.leftOperand, this.leftOperand = leftOperand);
    }
    private Type rightOperand;

    public Type getRightOperand() {
        return notifyRequested(JavaFeatureDescriptorEnum.rightOperand, rightOperand);
    }

    public void setRightOperand(Type rightOperand) {
        notifyChanged(JavaFeatureDescriptorEnum.rightOperand, this.rightOperand, this.rightOperand = rightOperand);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLeftOperand().wGetAdaptee(false);
            case 1 :
            return getRightOperand().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLeftOperand(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setRightOperand(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
