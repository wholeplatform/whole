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
import org.whole.lang.java.model.ArrayCreation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.ArrayType;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.Expressions;
import org.whole.lang.java.model.ArrayInitializer;

/**
 *  @generator Whole
 */
public class ArrayCreationImpl extends AbstractSimpleEntity implements ArrayCreation {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ArrayCreation> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.ArrayCreation;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.ArrayCreation_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private ArrayType type;

    public ArrayType getType() {
        return notifyRequested(JavaFeatureDescriptorEnum.type, type);
    }

    public void setType(ArrayType type) {
        notifyChanged(JavaFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private Expressions dimensions;

    public Expressions getDimensions() {
        return notifyRequested(JavaFeatureDescriptorEnum.dimensions, dimensions);
    }

    public void setDimensions(Expressions dimensions) {
        notifyChanged(JavaFeatureDescriptorEnum.dimensions, this.dimensions, this.dimensions = dimensions);
    }
    private ArrayInitializer initializer;

    public ArrayInitializer getInitializer() {
        return notifyRequested(JavaFeatureDescriptorEnum.initializer, initializer);
    }

    public void setInitializer(ArrayInitializer initializer) {
        notifyChanged(JavaFeatureDescriptorEnum.initializer, this.initializer, this.initializer = initializer);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getType().wGetAdaptee(false);
            case 1 :
            return getDimensions().wGetAdaptee(false);
            case 2 :
            return getInitializer().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setType(value.wGetAdapter(JavaEntityDescriptorEnum.ArrayType));
            break;
            case 1 :
            setDimensions(value.wGetAdapter(JavaEntityDescriptorEnum.Expressions));
            break;
            case 2 :
            setInitializer(value.wGetAdapter(JavaEntityDescriptorEnum.ArrayInitializer));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
