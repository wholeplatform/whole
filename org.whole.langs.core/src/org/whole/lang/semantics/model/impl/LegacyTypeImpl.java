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
import org.whole.lang.semantics.model.LegacyType;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.model.LegacyTypeEnum;
import org.whole.lang.model.EnumValue;

/**
 *  @generator Whole
 */
public class LegacyTypeImpl extends AbstractDataEntity implements LegacyType {
    private static final long serialVersionUID = 1;
    private org.whole.lang.semantics.model.LegacyTypeEnum.Value value;

    public org.whole.lang.semantics.model.LegacyTypeEnum.Value getValue() {
        return notifyRequested(value);
    }

    public void setValue(org.whole.lang.semantics.model.LegacyTypeEnum.Value value) {
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
        return SemanticsEntityDescriptorEnum.LegacyType_ord;
    }

    public EntityDescriptor<LegacyType> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.LegacyType;
    }

    public Object wGetValue() {
        return getValue();
    }

    public void wSetValue(Object value) {
        setValue((org.whole.lang.semantics.model.LegacyTypeEnum.Value) value);
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue(LegacyTypeEnum.instance.valueOf(value));
        } catch (NumberFormatException e) {
        }
    }

    public EnumValue wEnumValue() {
        return value;
    }

    public void wSetValue(EnumValue value) {
        setValue((org.whole.lang.semantics.model.LegacyTypeEnum.Value) value);
    }
}
