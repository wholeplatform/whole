package org.whole.lang.changes.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class RevisionAdapter extends AbstractEntityAdapter implements Revision {
    private static final long serialVersionUID = 1;

    public RevisionAdapter(IEntity implementor) {
        super(implementor);
    }

    public RevisionAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Revision> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Revision;
    }

    public Revisor getRevisor() {
        return wGet(ChangesFeatureDescriptorEnum.revisor).wGetAdapter(ChangesEntityDescriptorEnum.Revisor);
    }

    public void setRevisor(Revisor revisor) {
        wSet(ChangesFeatureDescriptorEnum.revisor, revisor);
    }

    public RevisionChanges getChanges() {
        return wGet(ChangesFeatureDescriptorEnum.changes).wGetAdapter(ChangesEntityDescriptorEnum.RevisionChanges);
    }

    public void setChanges(RevisionChanges changes) {
        wSet(ChangesFeatureDescriptorEnum.changes, changes);
    }
}
