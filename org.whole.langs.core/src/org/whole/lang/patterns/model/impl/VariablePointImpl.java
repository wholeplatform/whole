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
public class VariablePointImpl extends AbstractSimpleEntity implements VariablePoint {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VariablePoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.VariablePoint;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.VariablePoint_ord;
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
    private ResultType resultType;

    public ResultType getResultType() {
        return notifyRequested(PatternsFeatureDescriptorEnum.resultType, resultType);
    }

    public void setResultType(ResultType resultType) {
        notifyChanged(PatternsFeatureDescriptorEnum.resultType, this.resultType, this.resultType = resultType);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getResultType().wGetAdaptee(false);
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
            setResultType(value.wGetAdapter(PatternsEntityDescriptorEnum.ResultType));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
