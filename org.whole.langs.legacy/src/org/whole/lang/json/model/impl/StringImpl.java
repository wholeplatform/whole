package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.json.model.*;
import org.whole.lang.json.model.String;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
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
        visitor.visit(this);
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
