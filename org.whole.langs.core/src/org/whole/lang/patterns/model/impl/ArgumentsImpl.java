package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class ArgumentsImpl extends AbstractListCompositeEntity<Argument> implements Arguments {
    private static final long serialVersionUID = 1;

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.Arguments_ord;
    }

    public EntityDescriptor<Arguments> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Arguments;
    }
}
