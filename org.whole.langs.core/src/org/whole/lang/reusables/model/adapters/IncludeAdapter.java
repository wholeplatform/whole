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
public class IncludeAdapter extends AbstractEntityAdapter implements Include {
    private static final long serialVersionUID = 1;

    public IncludeAdapter(IEntity implementor) {
        super(implementor);
    }

    public IncludeAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Include> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Include;
    }

    public Source getSource() {
        return wGet(ReusablesFeatureDescriptorEnum.source).wGetAdapter(ReusablesEntityDescriptorEnum.Source);
    }

    public void setSource(Source source) {
        wSet(ReusablesFeatureDescriptorEnum.source, source);
    }
}
