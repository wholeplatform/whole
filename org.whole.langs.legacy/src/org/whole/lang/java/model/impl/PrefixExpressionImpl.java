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
package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.PrefixExpression;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.PrefixOperator;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.Expression;

/**
 *  @generator Whole
 */
public class PrefixExpressionImpl extends AbstractSimpleEntity implements PrefixExpression {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PrefixExpression> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.PrefixExpression;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.PrefixExpression_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private PrefixOperator operator;

    public PrefixOperator getOperator() {
        return notifyRequested(JavaFeatureDescriptorEnum.operator, operator);
    }

    public void setOperator(PrefixOperator operator) {
        notifyChanged(JavaFeatureDescriptorEnum.operator, this.operator, this.operator = operator);
    }
    private Expression operand;

    public Expression getOperand() {
        return notifyRequested(JavaFeatureDescriptorEnum.operand, operand);
    }

    public void setOperand(Expression operand) {
        notifyChanged(JavaFeatureDescriptorEnum.operand, this.operand, this.operand = operand);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getOperator().wGetAdaptee(false);
            case 1 :
            return getOperand().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setOperator(value.wGetAdapter(JavaEntityDescriptorEnum.PrefixOperator));
            break;
            case 1 :
            setOperand(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
