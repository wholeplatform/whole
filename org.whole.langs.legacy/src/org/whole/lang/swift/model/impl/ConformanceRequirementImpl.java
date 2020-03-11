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
package org.whole.lang.swift.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swift.model.ConformanceRequirement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Type;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ConformanceRequirementImpl extends AbstractSimpleEntity implements ConformanceRequirement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ConformanceRequirement> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ConformanceRequirement;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.ConformanceRequirement_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Type leftTypeIdentifier;

    public Type getLeftTypeIdentifier() {
        return notifyRequested(SwiftFeatureDescriptorEnum.leftTypeIdentifier, leftTypeIdentifier);
    }

    public void setLeftTypeIdentifier(Type leftTypeIdentifier) {
        notifyChanged(SwiftFeatureDescriptorEnum.leftTypeIdentifier, this.leftTypeIdentifier, this.leftTypeIdentifier = leftTypeIdentifier);
    }
    private Type rightTypeIdentifier;

    public Type getRightTypeIdentifier() {
        return notifyRequested(SwiftFeatureDescriptorEnum.rightTypeIdentifier, rightTypeIdentifier);
    }

    public void setRightTypeIdentifier(Type rightTypeIdentifier) {
        notifyChanged(SwiftFeatureDescriptorEnum.rightTypeIdentifier, this.rightTypeIdentifier, this.rightTypeIdentifier = rightTypeIdentifier);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLeftTypeIdentifier().wGetAdaptee(false);
            case 1 :
            return getRightTypeIdentifier().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLeftTypeIdentifier(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            case 1 :
            setRightTypeIdentifier(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
