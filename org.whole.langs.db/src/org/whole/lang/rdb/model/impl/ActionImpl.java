package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class ActionImpl extends AbstractDataEntity implements Action {
	private static final long serialVersionUID = 1;
	private org.whole.lang.rdb.model.ActionEnum.Value value;

	public org.whole.lang.rdb.model.ActionEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.rdb.model.ActionEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IRDBVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Action_ord;
	}

	public EntityDescriptor<Action> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Action;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.rdb.model.ActionEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(ActionEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.rdb.model.ActionEnum.Value) value);
	}
}
