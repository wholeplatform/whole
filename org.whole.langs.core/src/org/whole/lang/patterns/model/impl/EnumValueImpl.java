package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class EnumValueImpl extends AbstractSimpleEntity implements EnumValue {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<EnumValue> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.EnumValue;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.EnumValue_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private Name value;

    public Name getValue() {
        return notifyRequested(PatternsFeatureDescriptorEnum.value, value);
    }

    public void setValue(Name value) {
        notifyChanged(PatternsFeatureDescriptorEnum.value, this.value, this.value = value);
    }
    private Name result;

    public Name getResult() {
        return notifyRequested(PatternsFeatureDescriptorEnum.result, result);
    }

    public void setResult(Name result) {
        notifyChanged(PatternsFeatureDescriptorEnum.result, this.result, this.result = result);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getValue().wGetAdaptee(false);
            case 1 :
            return getResult().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setValue(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setResult(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
