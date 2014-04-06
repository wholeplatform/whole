package org.whole.lang.reusables.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ReferenceStepAdapter extends AbstractEntityAdapter implements ReferenceStep {
    private static final long serialVersionUID = 1;

    public ReferenceStepAdapter(IEntity implementor) {
        super(implementor);
    }

    public ReferenceStepAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ReferenceStep> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.ReferenceStep;
    }

    public Source getSource() {
        return wGet(ReusablesFeatureDescriptorEnum.source).wGetAdapter(ReusablesEntityDescriptorEnum.Source);
    }

    public void setSource(Source source) {
        wSet(ReusablesFeatureDescriptorEnum.source, source);
    }
}
