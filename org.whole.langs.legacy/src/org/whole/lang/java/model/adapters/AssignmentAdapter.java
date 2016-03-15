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
package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class AssignmentAdapter extends AbstractEntityAdapter implements Assignment {
    private static final long serialVersionUID = 1;

    public AssignmentAdapter(IEntity implementor) {
        super(implementor);
    }

    public AssignmentAdapter() {
    }

    public void accept(IJavaVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Assignment> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.Assignment;
    }

    public Expression getLeftHandSide() {
        return wGet(JavaFeatureDescriptorEnum.leftHandSide).wGetAdapter(JavaEntityDescriptorEnum.Expression);
    }

    public void setLeftHandSide(Expression leftHandSide) {
        wSet(JavaFeatureDescriptorEnum.leftHandSide, leftHandSide);
    }

    public AssignmentOperator getOperator() {
        return wGet(JavaFeatureDescriptorEnum.operator).wGetAdapter(JavaEntityDescriptorEnum.AssignmentOperator);
    }

    public void setOperator(AssignmentOperator operator) {
        wSet(JavaFeatureDescriptorEnum.operator, operator);
    }

    public Expression getRightHandSide() {
        return wGet(JavaFeatureDescriptorEnum.rightHandSide).wGetAdapter(JavaEntityDescriptorEnum.Expression);
    }

    public void setRightHandSide(Expression rightHandSide) {
        wSet(JavaFeatureDescriptorEnum.rightHandSide, rightHandSide);
    }
}
