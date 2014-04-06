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
public class SynchImpl extends AbstractSimpleEntity implements Synch {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Synch> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Synch;
    }

    public int wGetEntityOrd() {
        return ReusablesEntityDescriptorEnum.Synch_ord;
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
    private Reusable original;

    public Reusable getOriginal() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.original, original);
    }

    public void setOriginal(Reusable original) {
        notifyChanged(ReusablesFeatureDescriptorEnum.original, this.original, this.original = original);
    }
    private PathExpression adapter;

    public PathExpression getAdapter() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.adapter, adapter);
    }

    public void setAdapter(PathExpression adapter) {
        notifyChanged(ReusablesFeatureDescriptorEnum.adapter, this.adapter, this.adapter = adapter);
    }
    private Reusable adapted;

    public Reusable getAdapted() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.adapted, adapted);
    }

    public void setAdapted(Reusable adapted) {
        notifyChanged(ReusablesFeatureDescriptorEnum.adapted, this.adapted, this.adapted = adapted);
    }
    private Revision adaptedRevision;

    public Revision getAdaptedRevision() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.adaptedRevision, adaptedRevision);
    }

    public void setAdaptedRevision(Revision adaptedRevision) {
        notifyChanged(ReusablesFeatureDescriptorEnum.adaptedRevision, this.adaptedRevision, this.adaptedRevision = adaptedRevision);
    }
    private Reusable variant;

    public Reusable getVariant() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.variant, variant);
    }

    public void setVariant(Reusable variant) {
        notifyChanged(ReusablesFeatureDescriptorEnum.variant, this.variant, this.variant = variant);
    }
    private Revision variantRevision;

    public Revision getVariantRevision() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.variantRevision, variantRevision);
    }

    public void setVariantRevision(Revision variantRevision) {
        notifyChanged(ReusablesFeatureDescriptorEnum.variantRevision, this.variantRevision, this.variantRevision = variantRevision);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSource().wGetAdaptee(false);
            case 1 :
            return getOriginal().wGetAdaptee(false);
            case 2 :
            return getAdapter().wGetAdaptee(false);
            case 3 :
            return getAdapted().wGetAdaptee(false);
            case 4 :
            return getAdaptedRevision().wGetAdaptee(false);
            case 5 :
            return getVariant().wGetAdaptee(false);
            case 6 :
            return getVariantRevision().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSource(value.wGetAdapter(ReusablesEntityDescriptorEnum.Source));
            break;
            case 1 :
            setOriginal(value.wGetAdapter(ReusablesEntityDescriptorEnum.Reusable));
            break;
            case 2 :
            setAdapter(value.wGetAdapter(ReusablesEntityDescriptorEnum.PathExpression));
            break;
            case 3 :
            setAdapted(value.wGetAdapter(ReusablesEntityDescriptorEnum.Reusable));
            break;
            case 4 :
            setAdaptedRevision(value.wGetAdapter(ReusablesEntityDescriptorEnum.Revision));
            break;
            case 5 :
            setVariant(value.wGetAdapter(ReusablesEntityDescriptorEnum.Reusable));
            break;
            case 6 :
            setVariantRevision(value.wGetAdapter(ReusablesEntityDescriptorEnum.Revision));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 7;
    }
}
