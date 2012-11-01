package org.whole.lang.actions.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.actions.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.visitors.IActionsVisitor;

/** 
 * @generator Whole
 */
public class FullNameImpl extends AbstractSimpleEntity implements FullName {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FullName> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.FullName;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.FullName_ord;
	}

	public void accept(IActionsVisitor visitor) {
		visitor.visit(this);
	}
}
