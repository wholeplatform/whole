package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.json.model.Decimal;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class DecimalImpl extends AbstractDataEntity implements Decimal {
    private static final long serialVersionUID = 1;
    private double value;

    public double getValue() {
        return notifyRequested(value);
    }

    public void setValue(double value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IJSONVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return JSONEntityDescriptorEnum.Decimal_ord;
    }

    public EntityDescriptor<Decimal> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Decimal;
    }

    public Object wGetValue() {
        return new Double(getValue());
    }

    public void wSetValue(Object value) {
        setValue(((Double) value).doubleValue());
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue(Double.valueOf(value).doubleValue());
        } catch (NumberFormatException e) {
        }
    }

    public double wDoubleValue() {
        return getValue();
    }

    public void wSetValue(double value) {
        setValue(value);
    }
}
