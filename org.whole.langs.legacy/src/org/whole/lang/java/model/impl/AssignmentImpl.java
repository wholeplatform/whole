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
import org.whole.lang.java.model.Assignment;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.model.Expression;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.AssignmentOperator;

/**
 *  @generator Whole
 */
public class AssignmentImpl extends AbstractSimpleEntity implements Assignment {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Assignment> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.Assignment;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.Assignment_ord;
    }

    public void accept(IJavaVisitor visitor) {
        visitor.visit(this);
    }
    private Expression leftHandSide;

    public Expression getLeftHandSide() {
        return notifyRequested(JavaFeatureDescriptorEnum.leftHandSide, leftHandSide);
    }

    public void setLeftHandSide(Expression leftHandSide) {
        notifyChanged(JavaFeatureDescriptorEnum.leftHandSide, this.leftHandSide, this.leftHandSide = leftHandSide);
    }
    private AssignmentOperator operator;

    public AssignmentOperator getOperator() {
        return notifyRequested(JavaFeatureDescriptorEnum.operator, operator);
    }

    public void setOperator(AssignmentOperator operator) {
        notifyChanged(JavaFeatureDescriptorEnum.operator, this.operator, this.operator = operator);
    }
    private Expression rightHandSide;

    public Expression getRightHandSide() {
        return notifyRequested(JavaFeatureDescriptorEnum.rightHandSide, rightHandSide);
    }

    public void setRightHandSide(Expression rightHandSide) {
        notifyChanged(JavaFeatureDescriptorEnum.rightHandSide, this.rightHandSide, this.rightHandSide = rightHandSide);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLeftHandSide().wGetAdaptee(false);
            case 1 :
            return getOperator().wGetAdaptee(false);
            case 2 :
            return getRightHandSide().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLeftHandSide(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setOperator(value.wGetAdapter(JavaEntityDescriptorEnum.AssignmentOperator));
            break;
            case 2 :
            setRightHandSide(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
