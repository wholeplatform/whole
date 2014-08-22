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
public class VariantSelectorImpl extends AbstractSimpleEntity implements VariantSelector {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VariantSelector> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.VariantSelector;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.VariantSelector_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private Name variability;

    public Name getVariability() {
        return notifyRequested(PatternsFeatureDescriptorEnum.variability, variability);
    }

    public void setVariability(Name variability) {
        notifyChanged(PatternsFeatureDescriptorEnum.variability, this.variability, this.variability = variability);
    }
    private Expression variant;

    public Expression getVariant() {
        return notifyRequested(PatternsFeatureDescriptorEnum.variant, variant);
    }

    public void setVariant(Expression variant) {
        notifyChanged(PatternsFeatureDescriptorEnum.variant, this.variant, this.variant = variant);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getVariability().wGetAdaptee(false);
            case 1 :
            return getVariant().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setVariability(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setVariant(value.wGetAdapter(PatternsEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
