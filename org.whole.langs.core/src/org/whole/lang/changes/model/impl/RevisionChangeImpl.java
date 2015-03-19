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
public class RevisionChangeImpl extends AbstractSimpleEntity implements RevisionChange {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<RevisionChange> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.RevisionChange;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.RevisionChange_ord;
    }

    public void accept(IChangesVisitor visitor) {
		try {
	        visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}    }
    private ChangeSides sides;

    public ChangeSides getSides() {
        return notifyRequested(ChangesFeatureDescriptorEnum.sides, sides);
    }

    public void setSides(ChangeSides sides) {
        notifyChanged(ChangesFeatureDescriptorEnum.sides, this.sides, this.sides = sides, false);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSides().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSides(value.wGetAdapter(ChangesEntityDescriptorEnum.ChangeSides));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wAdjacentSize() {
        return 1;
    }
}
