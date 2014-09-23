package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
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
