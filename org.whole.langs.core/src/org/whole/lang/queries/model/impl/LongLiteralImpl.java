package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class LongLiteralImpl extends AbstractDataEntity implements LongLiteral {
    private static final long serialVersionUID = 1;
    private long value;

    public long getValue() {
        return notifyRequested(value);
    }

    public void setValue(long value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.LongLiteral_ord;
    }

    public EntityDescriptor<LongLiteral> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.LongLiteral;
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
