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
import org.whole.lang.swift.model.Attribute;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.AbstractArgument;

/**
 *  @generator Whole
 */
public class AttributeImpl extends AbstractSimpleEntity implements Attribute {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Attribute> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.Attribute;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.Attribute_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Identifier attributeName;

    public Identifier getAttributeName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.attributeName, attributeName);
    }

    public void setAttributeName(Identifier attributeName) {
        notifyChanged(SwiftFeatureDescriptorEnum.attributeName, this.attributeName, this.attributeName = attributeName);
    }
    private AbstractArgument argument;

    public AbstractArgument getArgument() {
        return notifyRequested(SwiftFeatureDescriptorEnum.argument, argument);
    }

    public void setArgument(AbstractArgument argument) {
        notifyChanged(SwiftFeatureDescriptorEnum.argument, this.argument, this.argument = argument);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributeName().wGetAdaptee(false);
            case 1 :
            return getArgument().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setAttributeName(value.wGetAdapter(SwiftEntityDescriptorEnum.Identifier));
            break;
            case 1 :
            setArgument(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractArgument));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
