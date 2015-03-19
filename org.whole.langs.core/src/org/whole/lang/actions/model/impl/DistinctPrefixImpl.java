package org.whole.lang.actions.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.actions.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.visitors.IActionsVisitor;

/** 
 * @generator Whole
 */
public class DistinctPrefixImpl extends AbstractSimpleEntity implements
		DistinctPrefix {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DistinctPrefix> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.DistinctPrefix;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.DistinctPrefix_ord;
	}

	public void accept(IActionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
