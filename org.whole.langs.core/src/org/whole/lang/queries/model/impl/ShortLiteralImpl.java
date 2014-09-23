package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
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
