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
import org.whole.lang.java.model.InfixExpression;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.Expression;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.InfixOperator;
import org.whole.lang.java.model.Expressions;

/**
 *  @generator Whole
 */
public class InfixExpressionImpl extends AbstractSimpleEntity implements InfixExpression {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<InfixExpression> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.InfixExpression;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.InfixExpression_ord;
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
    private InfixOperator operator;

    public InfixOperator getOperator() {
        return notifyRequested(JavaFeatureDescriptorEnum.operator, operator);
    }

    public void setOperator(InfixOperator operator) {
        notifyChanged(JavaFeatureDescriptorEnum.operator, this.operator, this.operator = operator);
    }
    private Expression rightOperand;

    public Expression getRightOperand() {
        return notifyRequested(JavaFeatureDescriptorEnum.rightOperand, rightOperand);
    }

    public void setRightOperand(Expression rightOperand) {
        notifyChanged(JavaFeatureDescriptorEnum.rightOperand, this.rightOperand, this.rightOperand = rightOperand);
    }
    private Expressions extendedOperands;

    public Expressions getExtendedOperands() {
        return notifyRequested(JavaFeatureDescriptorEnum.extendedOperands, extendedOperands);
    }

    public void setExtendedOperands(Expressions extendedOperands) {
        notifyChanged(JavaFeatureDescriptorEnum.extendedOperands, this.extendedOperands, this.extendedOperands = extendedOperands);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLeftOperand().wGetAdaptee(false);
            case 1 :
            return getOperator().wGetAdaptee(false);
            case 2 :
            return getRightOperand().wGetAdaptee(false);
            case 3 :
            return getExtendedOperands().wGetAdaptee(false);
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
            setOperator(value.wGetAdapter(JavaEntityDescriptorEnum.InfixOperator));
            break;
            case 2 :
            setRightOperand(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            case 3 :
            setExtendedOperands(value.wGetAdapter(JavaEntityDescriptorEnum.Expressions));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
