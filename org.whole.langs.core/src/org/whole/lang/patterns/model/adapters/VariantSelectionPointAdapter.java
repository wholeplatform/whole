package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class VariantSelectionPointAdapter extends AbstractEntityAdapter implements VariantSelectionPoint {
    private static final long serialVersionUID = 1;

    public VariantSelectionPointAdapter(IEntity implementor) {
        super(implementor);
    }

    public VariantSelectionPointAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<VariantSelectionPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.VariantSelectionPoint;
    }

    public Name getVariability() {
        return wGet(PatternsFeatureDescriptorEnum.variability).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setVariability(Name variability) {
        wSet(PatternsFeatureDescriptorEnum.variability, variability);
    }

    public Variants getVariants() {
        return wGet(PatternsFeatureDescriptorEnum.variants).wGetAdapter(PatternsEntityDescriptorEnum.Variants);
    }

    public void setVariants(Variants variants) {
        wSet(PatternsFeatureDescriptorEnum.variants, variants);
    }
}
