package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class EnumValuesImpl extends AbstractListCompositeEntity<EnumValue> implements EnumValues {
    private static final long serialVersionUID = 1;

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.EnumValues_ord;
    }

    public EntityDescriptor<EnumValues> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.EnumValues;
    }
}
