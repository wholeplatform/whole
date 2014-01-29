package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.json.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.reflect.JSONFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class PairImpl extends AbstractSimpleEntity implements Pair {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Pair> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Pair;
    }

    public int wGetEntityOrd() {
        return JSONEntityDescriptorEnum.Pair_ord;
    }

    public void accept(IJSONVisitor visitor) {
        visitor.visit(this);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(JSONFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(JSONFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Value value;

    public Value getValue() {
        return notifyRequested(JSONFeatureDescriptorEnum.value, value);
    }

    public void setValue(Value value) {
        notifyChanged(JSONFeatureDescriptorEnum.value, this.value, this.value = value);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getValue().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(JSONEntityDescriptorEnum.Name));
            break;
            case 1 :
            setValue(value.wGetAdapter(JSONEntityDescriptorEnum.Value));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
