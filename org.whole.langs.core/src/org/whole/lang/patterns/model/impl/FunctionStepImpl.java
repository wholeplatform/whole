package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class FunctionStepImpl extends AbstractDataEntity implements FunctionStep {
    private static final long serialVersionUID = 1;
    private String value;

    public String getValue() {
        return notifyRequested(value);
    }

    public void setValue(String value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.FunctionStep_ord;
    }

    public EntityDescriptor<FunctionStep> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.FunctionStep;
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