package org.whole.lang.modules.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.modules.model.*;
import org.whole.lang.modules.visitors.IModulesVisitor;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class ClassPathURIImpl extends AbstractDataEntity implements ClassPathURI {
    private static final long serialVersionUID = 1;
    private String value;

    public String getValue() {
        return notifyRequested(value);
    }

    public void setValue(String value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IModulesVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return ModulesEntityDescriptorEnum.ClassPathURI_ord;
    }

    public EntityDescriptor<ClassPathURI> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.ClassPathURI;
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
