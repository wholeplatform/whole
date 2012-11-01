package org.whole.lang.actions.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.actions.model.*;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CustomActionImpl extends AbstractDataEntity implements
		CustomAction {
	private static final long serialVersionUID = 1;
	private Object value;

	public Object getValue() {
		return notifyRequested(value);
	}

	public void setValue(Object value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IActionsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.CustomAction_ord;
	}

	public EntityDescriptor<CustomAction> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.CustomAction;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue(value);
	}
}
