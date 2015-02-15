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
package org.whole.lang.environment.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.environment.model.ByteData;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class ByteDataImpl extends AbstractDataEntity implements ByteData {
    private static final long serialVersionUID = 1;
    private byte value;

    public byte getValue() {
        return notifyRequested(value);
    }

    public void setValue(byte value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IEnvironmentVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return EnvironmentEntityDescriptorEnum.ByteData_ord;
    }

    public EntityDescriptor<ByteData> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.ByteData;
    }

    public Object wGetValue() {
        return new Byte(getValue());
    }

    public void wSetValue(Object value) {
        setValue(((Byte) value).byteValue());
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue(Byte.valueOf(value).byteValue());
        } catch (NumberFormatException e) {
        }
    }

    public byte wByteValue() {
        return getValue();
    }

    public void wSetValue(byte value) {
        setValue(value);
    }
}
