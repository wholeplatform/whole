package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ByteIntegerImpl extends AbstractDataEntity implements ByteInteger {
	private static final long serialVersionUID = 1;
	private byte value;

	public byte getValue() {
		return notifyRequested(value);
	}

	public void setValue(byte value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.ByteInteger_ord;
	}

	public EntityDescriptor<ByteInteger> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.ByteInteger;
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
