package org.whole.lang.changes.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.changes.model.*;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class ChangeSidesStrictImpl extends AbstractSetCompositeEntity<ChangeSide> implements ChangeSides {
    private static final long serialVersionUID = 1;

    public void accept(IChangesVisitor visitor) {
		try {
	        visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}    }

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
