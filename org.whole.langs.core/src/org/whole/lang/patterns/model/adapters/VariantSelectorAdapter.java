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
public class VariantSelectorAdapter extends AbstractEntityAdapter implements VariantSelector {
    private static final long serialVersionUID = 1;

    public VariantSelectorAdapter(IEntity implementor) {
        super(implementor);
    }

    public VariantSelectorAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<VariantSelector> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.VariantSelector;
    }

    public Name getVariability() {
        return wGet(PatternsFeatureDescriptorEnum.variability).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setVariability(Name variability) {
        wSet(PatternsFeatureDescriptorEnum.variability, variability);
    }

    public Expression getVariant() {
        return wGet(PatternsFeatureDescriptorEnum.variant).wGetAdapter(PatternsEntityDescriptorEnum.Expression);
    }

    public void setVariant(Expression variant) {
        wSet(PatternsFeatureDescriptorEnum.variant, variant);
    }
}
