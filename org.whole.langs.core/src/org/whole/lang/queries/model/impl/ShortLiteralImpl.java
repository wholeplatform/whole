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
import org.whole.lang.queries.model.ShortLiteral;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class ShortLiteralImpl extends AbstractDataEntity implements ShortLiteral {
    private static final long serialVersionUID = 1;
    private short value;

    public short getValue() {
        return notifyRequested(value);
    }

    public void setValue(short value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.ShortLiteral_ord;
    }

    public EntityDescriptor<ShortLiteral> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.ShortLiteral;
    }

    public Object wGetValue() {
        return new Short(getValue());
    }

    public void wSetValue(Object value) {
        setValue(((Short) value).shortValue());
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue(Short.valueOf(value).shortValue());
        } catch (NumberFormatException e) {
        }
    }

    public short wShortValue() {
        return getValue();
    }

    public void wSetValue(short value) {
        setValue(value);
    }
}
