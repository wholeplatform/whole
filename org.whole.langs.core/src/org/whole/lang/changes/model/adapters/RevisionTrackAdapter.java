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
public class RevisionTrackAdapter extends AbstractEntityAdapter implements RevisionTrack {
    private static final long serialVersionUID = 1;

    public RevisionTrackAdapter(IEntity implementor) {
        super(implementor);
    }

    public RevisionTrackAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<RevisionTrack> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.RevisionTrack;
    }

    public Revisions getRevisions() {
        return wGet(ChangesFeatureDescriptorEnum.revisions).wGetAdapter(ChangesEntityDescriptorEnum.Revisions);
    }

    public void setRevisions(Revisions revisions) {
        wSet(ChangesFeatureDescriptorEnum.revisions, revisions);
    }

    public ContentCompare getCompare() {
        return wGet(ChangesFeatureDescriptorEnum.compare).wGetAdapter(ChangesEntityDescriptorEnum.ContentCompare);
    }

    public void setCompare(ContentCompare compare) {
        wSet(ChangesFeatureDescriptorEnum.compare, compare);
    }
}
