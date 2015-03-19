package org.whole.lang.changes.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.changes.model.*;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class RevisionChangesImpl extends AbstractListCompositeEntity<RevisionChange> implements RevisionChanges {
    private static final long serialVersionUID = 1;

    public void accept(IChangesVisitor visitor) {
		try {
	        visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.RevisionChanges_ord;
    }

    public EntityDescriptor<RevisionChanges> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.RevisionChanges;
    }
}
