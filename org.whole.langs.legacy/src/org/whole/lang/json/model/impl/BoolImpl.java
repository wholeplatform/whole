package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.json.model.Bool;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class BoolImpl extends AbstractDataEntity implements Bool {
    private static final long serialVersionUID = 1;
    private boolean value;

    public boolean isValue() {
        return notifyRequested(value);
    }

    public void setValue(boolean value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IJSONVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return JSONEntityDescriptorEnum.Bool_ord;
    }

    public EntityDescriptor<Bool> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Bool;
    }

    public Object wGetValue() {
        return new Boolean(isValue());
    }

    public void wSetValue(Object value) {
        setValue(((Boolean) value).booleanValue());
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue(Boolean.valueOf(value).booleanValue());
        } catch (NumberFormatException e) {
        }
    }

    public boolean wBooleanValue() {
        return isValue();
    }

    public void wSetValue(boolean value) {
        setValue(value);
    }
}
