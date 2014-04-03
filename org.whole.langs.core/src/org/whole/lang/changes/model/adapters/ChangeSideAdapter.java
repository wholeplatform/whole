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
public class ChangeSideAdapter extends AbstractEntityAdapter implements ChangeSide {
    private static final long serialVersionUID = 1;

    public ChangeSideAdapter(IEntity implementor) {
        super(implementor);
    }

    public ChangeSideAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ChangeSide> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.ChangeSide;
    }

    public ChangeRevisions getRevisions() {
        return wGet(ChangesFeatureDescriptorEnum.revisions).wGetAdapter(ChangesEntityDescriptorEnum.ChangeRevisions);
    }

    public void setRevisions(ChangeRevisions revisions) {
        wSet(ChangesFeatureDescriptorEnum.revisions, revisions);
    }
}
