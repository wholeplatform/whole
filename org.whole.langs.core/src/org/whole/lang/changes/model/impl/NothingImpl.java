package org.whole.lang.changes.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.changes.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.changes.visitors.IChangesVisitor;

/**
 *  @generator  Whole
 */
public class NothingImpl extends AbstractSimpleEntity implements Nothing {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Nothing> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Nothing;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.Nothing_ord;
    }

    public void accept(IChangesVisitor visitor) {
        visitor.visit(this);
    }
}
