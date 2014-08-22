package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class VariantsImpl extends AbstractListCompositeEntity<Variant> implements Variants {
    private static final long serialVersionUID = 1;

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.Variants_ord;
    }

    public EntityDescriptor<Variants> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Variants;
    }
}
