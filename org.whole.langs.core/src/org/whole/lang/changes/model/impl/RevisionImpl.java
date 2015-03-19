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
public class RevisionImpl extends AbstractSimpleEntity implements Revision {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Revision> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Revision;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.Revision_ord;
    }

    public void accept(IChangesVisitor visitor) {
		try {
	        visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}    }
    private Revisor revisor;

    public Revisor getRevisor() {
        return notifyRequested(ChangesFeatureDescriptorEnum.revisor, revisor);
    }

    public void setRevisor(Revisor revisor) {
        notifyChanged(ChangesFeatureDescriptorEnum.revisor, this.revisor, this.revisor = revisor);
    }
    private RevisionChanges changes;

    public RevisionChanges getChanges() {
        return notifyRequested(ChangesFeatureDescriptorEnum.changes, changes);
    }

    public void setChanges(RevisionChanges changes) {
        notifyChanged(ChangesFeatureDescriptorEnum.changes, this.changes, this.changes = changes);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getRevisor().wGetAdaptee(false);
            case 1 :
            return getChanges().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setRevisor(value.wGetAdapter(ChangesEntityDescriptorEnum.Revisor));
            break;
            case 1 :
            setChanges(value.wGetAdapter(ChangesEntityDescriptorEnum.RevisionChanges));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
