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
package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.patterns.model.Name;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class EnumValueImpl extends AbstractSimpleEntity implements EnumValue {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<EnumValue> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.EnumValue;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.EnumValue_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name value;

    public Name getValue() {
        return notifyRequested(PatternsFeatureDescriptorEnum.value, value);
    }

    public void setValue(Name value) {
        notifyChanged(PatternsFeatureDescriptorEnum.value, this.value, this.value = value);
    }
    private Name result;

    public Name getResult() {
        return notifyRequested(PatternsFeatureDescriptorEnum.result, result);
    }

    public void setResult(Name result) {
        notifyChanged(PatternsFeatureDescriptorEnum.result, this.result, this.result = result);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getValue().wGetAdaptee(false);
            case 1 :
            return getResult().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setValue(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setResult(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
