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
package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.json.model.*;
import org.whole.lang.json.model.String;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class StringImpl extends AbstractDataEntity implements String {
    private static final long serialVersionUID = 1;
    private java.lang.String value;

    public java.lang.String getValue() {
        return notifyRequested(value);
    }

    public void setValue(java.lang.String value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IJSONVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wGetEntityOrd() {
        return JSONEntityDescriptorEnum.String_ord;
    }

    public EntityDescriptor<String> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.String;
    }

    public java.lang.Object wGetValue() {
        return getValue();
    }

    public void wSetValue(java.lang.Object value) {
        setValue((java.lang.String) value);
    }

    public java.lang.String wStringValue() {
        return getValue();
    }

    public void wSetValue(java.lang.String value) {
        setValue(value);
    }
}
