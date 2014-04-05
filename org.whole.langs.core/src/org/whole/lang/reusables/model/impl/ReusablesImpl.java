package org.whole.lang.reusables.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.reusables.model.*;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class ReusablesImpl extends AbstractListCompositeEntity<Reusable> implements Reusables {
    private static final long serialVersionUID = 1;

    public void accept(IReusablesVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return ReusablesEntityDescriptorEnum.Reusables_ord;
    }

    public EntityDescriptor<Reusables> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Reusables;
    }
}
