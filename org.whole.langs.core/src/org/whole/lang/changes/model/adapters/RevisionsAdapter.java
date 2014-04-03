package org.whole.lang.changes.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class RevisionsAdapter extends AbstractListEntityAdapter<Revision> implements Revisions {
    private static final long serialVersionUID = 1;

    public RevisionsAdapter(IEntity implementor) {
        super(implementor);
    }

    public RevisionsAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Revisions> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Revisions;
    }
}
