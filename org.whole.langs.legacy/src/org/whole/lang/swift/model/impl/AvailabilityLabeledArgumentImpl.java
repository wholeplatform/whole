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
import org.whole.lang.swift.model.AvailabilityLabeledArgument;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.AbstractValue;

/**
 *  @generator Whole
 */
public class AvailabilityLabeledArgumentImpl extends AbstractSimpleEntity implements AvailabilityLabeledArgument {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<AvailabilityLabeledArgument> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.AvailabilityLabeledArgument;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.AvailabilityLabeledArgument_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Identifier label;

    public Identifier getLabel() {
        return notifyRequested(SwiftFeatureDescriptorEnum.label, label);
    }

    public void setLabel(Identifier label) {
        notifyChanged(SwiftFeatureDescriptorEnum.label, this.label, this.label = label);
    }
    private AbstractValue value;

    public AbstractValue getValue() {
        return notifyRequested(SwiftFeatureDescriptorEnum.value, value);
    }

    public void setValue(AbstractValue value) {
        notifyChanged(SwiftFeatureDescriptorEnum.value, this.value, this.value = value);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getValue().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLabel(value.wGetAdapter(SwiftEntityDescriptorEnum.Identifier));
            break;
            case 1 :
            setValue(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractValue));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
