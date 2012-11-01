package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class NullOrderTypeImpl extends AbstractDataEntity implements
		NullOrderType {
	private static final long serialVersionUID = 1;
	private org.whole.lang.sql.model.NullOrderTypeEnum.Value value;

	public org.whole.lang.sql.model.NullOrderTypeEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.sql.model.NullOrderTypeEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.NullOrderType_ord;
	}

	public EntityDescriptor<NullOrderType> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.NullOrderType;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.sql.model.NullOrderTypeEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(NullOrderTypeEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.sql.model.NullOrderTypeEnum.Value) value);
	}
}
