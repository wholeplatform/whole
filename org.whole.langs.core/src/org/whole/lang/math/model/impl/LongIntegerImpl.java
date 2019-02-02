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
package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.LongInteger;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class LongIntegerImpl extends AbstractDataEntity implements LongInteger {
    private static final long serialVersionUID = 1;
    private long value;

    public long getValue() {
        return notifyRequested(value);
    }

    public void setValue(long value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IMathVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wGetEntityOrd() {
        return MathEntityDescriptorEnum.LongInteger_ord;
    }

    public EntityDescriptor<LongInteger> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.LongInteger;
    }

    public Object wGetValue() {
        return new Long(getValue());
    }

    public void wSetValue(Object value) {
        setValue(((Long) value).longValue());
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue(Long.valueOf(value).longValue());
        } catch (NumberFormatException e) {
        }
    }

    public long wLongValue() {
        return getValue();
    }

    public void wSetValue(long value) {
        setValue(value);
    }
}
