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
public class IndexTypeImpl extends AbstractDataEntity implements IndexType {
	private static final long serialVersionUID = 1;
	private org.whole.lang.rdb.model.IndexTypeEnum.Value value;

	public org.whole.lang.rdb.model.IndexTypeEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.rdb.model.IndexTypeEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.IndexType_ord;
	}

	public EntityDescriptor<IndexType> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.IndexType;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.rdb.model.IndexTypeEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(IndexTypeEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.rdb.model.IndexTypeEnum.Value) value);
	}
}
