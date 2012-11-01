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
public class IdMethodImpl extends AbstractDataEntity implements IdMethod {
	private static final long serialVersionUID = 1;
	private org.whole.lang.rdb.model.IdMethodEnum.Value value;

	public org.whole.lang.rdb.model.IdMethodEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.rdb.model.IdMethodEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.IdMethod_ord;
	}

	public EntityDescriptor<IdMethod> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.IdMethod;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.rdb.model.IdMethodEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(IdMethodEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.rdb.model.IdMethodEnum.Value) value);
	}
}
