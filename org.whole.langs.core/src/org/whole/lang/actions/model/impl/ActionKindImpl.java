package org.whole.lang.actions.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.actions.model.*;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class ActionKindImpl extends AbstractDataEntity implements ActionKind {
	private static final long serialVersionUID = 1;
	private org.whole.lang.actions.model.ActionKindEnum.Value value;

	public org.whole.lang.actions.model.ActionKindEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.actions.model.ActionKindEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IActionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.ActionKind_ord;
	}

	public EntityDescriptor<ActionKind> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.ActionKind;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.actions.model.ActionKindEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(ActionKindEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.actions.model.ActionKindEnum.Value) value);
	}
}
