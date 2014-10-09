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
public class PatternInstanceImpl extends AbstractSimpleEntity implements PatternInstance {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PatternInstance> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.PatternInstance;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.PatternInstance_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(PatternsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Arguments arguments;

    public Arguments getArguments() {
        return notifyRequested(PatternsFeatureDescriptorEnum.arguments, arguments);
    }

    public void setArguments(Arguments arguments) {
        notifyChanged(PatternsFeatureDescriptorEnum.arguments, this.arguments, this.arguments = arguments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getArguments().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setArguments(value.wGetAdapter(PatternsEntityDescriptorEnum.Arguments));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}