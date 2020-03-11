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
import org.whole.lang.swift.model.MetatypeType;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Type;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.TypeOrProtocolValue;

/**
 *  @generator Whole
 */
public class MetatypeTypeImpl extends AbstractSimpleEntity implements MetatypeType {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<MetatypeType> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.MetatypeType;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.MetatypeType_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Type baseType;

    public Type getBaseType() {
        return notifyRequested(SwiftFeatureDescriptorEnum.baseType, baseType);
    }

    public void setBaseType(Type baseType) {
        notifyChanged(SwiftFeatureDescriptorEnum.baseType, this.baseType, this.baseType = baseType);
    }
    private TypeOrProtocolValue typeOrProtocol;

    public TypeOrProtocolValue getTypeOrProtocol() {
        return notifyRequested(SwiftFeatureDescriptorEnum.typeOrProtocol, typeOrProtocol);
    }

    public void setTypeOrProtocol(TypeOrProtocolValue typeOrProtocol) {
        notifyChanged(SwiftFeatureDescriptorEnum.typeOrProtocol, this.typeOrProtocol, this.typeOrProtocol = typeOrProtocol);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getBaseType().wGetAdaptee(false);
            case 1 :
            return getTypeOrProtocol().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setBaseType(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            case 1 :
            setTypeOrProtocol(value.wGetAdapter(SwiftEntityDescriptorEnum.TypeOrProtocolValue));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
