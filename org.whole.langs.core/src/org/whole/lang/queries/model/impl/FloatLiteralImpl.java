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
package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.FloatLiteral;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class FloatLiteralImpl extends AbstractDataEntity implements FloatLiteral {
    private static final long serialVersionUID = 1;
    private float value;

    public float getValue() {
        return notifyRequested(value);
    }

    public void setValue(float value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.FloatLiteral_ord;
    }

    public EntityDescriptor<FloatLiteral> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.FloatLiteral;
    }

    public Object wGetValue() {
        return new Float(getValue());
    }

    public void wSetValue(Object value) {
        setValue(((Float) value).floatValue());
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue(Float.valueOf(value).floatValue());
        } catch (NumberFormatException e) {
        }
    }

    public float wFloatValue() {
        return getValue();
    }

    public void wSetValue(float value) {
        setValue(value);
    }
}
