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
import org.whole.lang.java.model.WildcardType;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.Type;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.UpperBound;

/**
 *  @generator Whole
 */
public class WildcardTypeImpl extends AbstractSimpleEntity implements WildcardType {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<WildcardType> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.WildcardType;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.WildcardType_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Type bound;

    public Type getBound() {
        return notifyRequested(JavaFeatureDescriptorEnum.bound, bound);
    }

    public void setBound(Type bound) {
        notifyChanged(JavaFeatureDescriptorEnum.bound, this.bound, this.bound = bound);
    }
    private UpperBound upperBound;

    public UpperBound getUpperBound() {
        return notifyRequested(JavaFeatureDescriptorEnum.upperBound, upperBound);
    }

    public void setUpperBound(UpperBound upperBound) {
        notifyChanged(JavaFeatureDescriptorEnum.upperBound, this.upperBound, this.upperBound = upperBound);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getBound().wGetAdaptee(false);
            case 1 :
            return getUpperBound().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setBound(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
            break;
            case 1 :
            setUpperBound(value.wGetAdapter(JavaEntityDescriptorEnum.UpperBound));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
