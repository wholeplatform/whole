package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;

/**
 *  @generator  Whole
 */
public class SlotsDefinedImpl extends AbstractSimpleEntity implements SlotsDefined {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SlotsDefined> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.SlotsDefined;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.SlotsDefined_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
}
