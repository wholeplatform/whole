package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class DataTypeImpl extends AbstractDataEntity implements DataType {
	private static final long serialVersionUID = 1;
	private org.whole.lang.grammars.model.DataTypeEnum.Value value;

	public org.whole.lang.grammars.model.DataTypeEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.grammars.model.DataTypeEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.DataType_ord;
	}

	public EntityDescriptor<DataType> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.DataType;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.grammars.model.DataTypeEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(DataTypeEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.grammars.model.DataTypeEnum.Value) value);
	}
}
