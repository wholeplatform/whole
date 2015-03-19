package org.whole.lang.changes.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.changes.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class RevisionTrackImpl extends AbstractSimpleEntity implements RevisionTrack {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<RevisionTrack> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.RevisionTrack;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.RevisionTrack_ord;
    }

    public void accept(IChangesVisitor visitor) {
		try {
	        visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}    }
    private Revisions revisions;

    public Revisions getRevisions() {
        return notifyRequested(ChangesFeatureDescriptorEnum.revisions, revisions);
    }

    public void setRevisions(Revisions revisions) {
        notifyChanged(ChangesFeatureDescriptorEnum.revisions, this.revisions, this.revisions = revisions);
    }
    private ContentCompare compare;

    public ContentCompare getCompare() {
        return notifyRequested(ChangesFeatureDescriptorEnum.compare, compare);
    }

    public void setCompare(ContentCompare compare) {
        notifyChanged(ChangesFeatureDescriptorEnum.compare, this.compare, this.compare = compare);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getRevisions().wGetAdaptee(false);
            case 1 :
            return getCompare().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setRevisions(value.wGetAdapter(ChangesEntityDescriptorEnum.Revisions));
            break;
            case 1 :
            setCompare(value.wGetAdapter(ChangesEntityDescriptorEnum.ContentCompare));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
