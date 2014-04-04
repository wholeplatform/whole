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
public class ReuseAdapter extends AbstractEntityAdapter implements Reuse {
    private static final long serialVersionUID = 1;

    public ReuseAdapter(IEntity implementor) {
        super(implementor);
    }

    public ReuseAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Reuse> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Reuse;
    }

    public Source getSource() {
        return wGet(ReusablesFeatureDescriptorEnum.source).wGetAdapter(ReusablesEntityDescriptorEnum.Source);
    }

    public void setSource(Source source) {
        wSet(ReusablesFeatureDescriptorEnum.source, source);
    }

    public Reusable getOriginal() {
        return wGet(ReusablesFeatureDescriptorEnum.original).wGetAdapter(ReusablesEntityDescriptorEnum.Reusable);
    }

    public void setOriginal(Reusable original) {
        wSet(ReusablesFeatureDescriptorEnum.original, original);
    }

    public PathExpression getAdapter() {
        return wGet(ReusablesFeatureDescriptorEnum.adapter).wGetAdapter(ReusablesEntityDescriptorEnum.PathExpression);
    }

    public void setAdapter(PathExpression adapter) {
        wSet(ReusablesFeatureDescriptorEnum.adapter, adapter);
    }

    public Reusable getAdapted() {
        return wGet(ReusablesFeatureDescriptorEnum.adapted).wGetAdapter(ReusablesEntityDescriptorEnum.Reusable);
    }

    public void setAdapted(Reusable adapted) {
        wSet(ReusablesFeatureDescriptorEnum.adapted, adapted);
    }

    public Reusable getVariant() {
        return wGet(ReusablesFeatureDescriptorEnum.variant).wGetAdapter(ReusablesEntityDescriptorEnum.Reusable);
    }

    public void setVariant(Reusable variant) {
        wSet(ReusablesFeatureDescriptorEnum.variant, variant);
    }
}
