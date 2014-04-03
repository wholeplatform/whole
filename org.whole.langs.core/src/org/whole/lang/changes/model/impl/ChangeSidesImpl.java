package org.whole.lang.changes.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.changes.model.*;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class ChangeSidesImpl extends AbstractCollectionCompositeEntity<ChangeSide> implements ChangeSides {
    private static final long serialVersionUID = 1;

    public void accept(IChangesVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.ChangeSides_ord;
    }

    public EntityDescriptor<ChangeSides> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.ChangeSides;
    }

    public boolean isContainment() {
        return false;
    }
}
