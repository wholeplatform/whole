package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.json.model.Name;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class NameImpl extends AbstractDataEntity implements Name {
    private static final long serialVersionUID = 1;
    private String value;

    public String getValue() {
        return notifyRequested(value);
    }

    public void setValue(String value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IJSONVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return JSONEntityDescriptorEnum.Name_ord;
    }

    public EntityDescriptor<Name> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Name;
    }

    public Object wGetValue() {
        return getValue();
    }

    public void wSetValue(Object value) {
        setValue((String) value);
    }

    public String wStringValue() {
        return getValue();
    }

    public void wSetValue(String value) {
        setValue(value);
    }
}