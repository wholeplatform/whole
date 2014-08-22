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
public class VariantSelectionPointImpl extends AbstractSimpleEntity implements VariantSelectionPoint {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VariantSelectionPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.VariantSelectionPoint;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.VariantSelectionPoint_ord;
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
    private Variants variants;

    public Variants getVariants() {
        return notifyRequested(PatternsFeatureDescriptorEnum.variants, variants);
    }

    public void setVariants(Variants variants) {
        notifyChanged(PatternsFeatureDescriptorEnum.variants, this.variants, this.variants = variants);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getVariability().wGetAdaptee(false);
            case 1 :
            return getVariants().wGetAdaptee(false);
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
            setVariants(value.wGetAdapter(PatternsEntityDescriptorEnum.Variants));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
