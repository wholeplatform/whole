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
package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.ByteLiteral;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class ByteLiteralImpl extends AbstractDataEntity implements ByteLiteral {
    private static final long serialVersionUID = 1;
    private byte value;

    public byte getValue() {
        return notifyRequested(value);
    }

    public void setValue(byte value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.ByteLiteral_ord;
    }

    public EntityDescriptor<ByteLiteral> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.ByteLiteral;
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
