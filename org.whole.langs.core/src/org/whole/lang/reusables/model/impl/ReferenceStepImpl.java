package org.whole.lang.reusables.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.reusables.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ReferenceStepImpl extends AbstractSimpleEntity implements ReferenceStep {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ReferenceStep> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.ReferenceStep;
    }

    public int wGetEntityOrd() {
        return ReusablesEntityDescriptorEnum.ReferenceStep_ord;
    }

    public void accept(IReusablesVisitor visitor) {
        visitor.visit(this);
    }
    private Source source;

    public Source getSource() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.source, source);
    }

    public void setSource(Source source) {
        notifyChanged(ReusablesFeatureDescriptorEnum.source, this.source, this.source = source);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSource().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSource(value.wGetAdapter(ReusablesEntityDescriptorEnum.Source));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
