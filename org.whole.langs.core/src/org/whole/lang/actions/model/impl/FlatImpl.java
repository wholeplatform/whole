package org.whole.lang.actions.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.actions.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.visitors.IActionsVisitor;

/** 
 * @generator Whole
 */
public class FlatImpl extends AbstractSimpleEntity implements Flat {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Flat> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.Flat;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.Flat_ord;
	}

	public void accept(IActionsVisitor visitor) {
		visitor.visit(this);
	}
}
