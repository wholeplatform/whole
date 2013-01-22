package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ByteLiteralImpl extends AbstractDataEntity implements ByteLiteral {
	private static final long serialVersionUID = 1;
	private byte value;

	public byte getValue() {
		return notifyRequested(value);
	}

	public void setValue(byte value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.ByteLiteral_ord;
	}

	public EntityDescriptor<ByteLiteral> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.ByteLiteral;
	}

	public Object wGetValue() {
		return new Byte(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Byte) value).byteValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Byte.valueOf(value).byteValue());
		} catch (NumberFormatException e) {
		}
	}

	public byte wByteValue() {
		return getValue();
	}

	public void wSetValue(byte value) {
		setValue(value);
	}
}
