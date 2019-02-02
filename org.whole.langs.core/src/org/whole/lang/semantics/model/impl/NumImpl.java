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
package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.semantics.model.Num;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class NumImpl extends AbstractDataEntity implements Num {
    private static final long serialVersionUID = 1;
    private int value;

    public int getValue() {
        return notifyRequested(value);
    }

    public void setValue(int value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(ISemanticsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wGetEntityOrd() {
        return SemanticsEntityDescriptorEnum.Num_ord;
    }

    public EntityDescriptor<Num> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.Num;
    }

    public Object wGetValue() {
        return new Integer(getValue());
    }

    public void wSetValue(Object value) {
        setValue(((Integer) value).intValue());
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue(Integer.valueOf(value).intValue());
        } catch (NumberFormatException e) {
        }
    }

    public int wIntValue() {
        return getValue();
    }

    public void wSetValue(int value) {
        setValue(value);
    }
}
