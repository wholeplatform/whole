package org.whole.lang.changes.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.changes.model.*;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class ChangeRevisionsStrictImpl extends AbstractSetCompositeEntity<RevisionChange> implements ChangeRevisions {
    private static final long serialVersionUID = 1;

    public void accept(IChangesVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.ChangeRevisions_ord;
    }

    public EntityDescriptor<ChangeRevisions> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.ChangeRevisions;
    }

    public boolean isContainment() {
        return false;
    }
}
