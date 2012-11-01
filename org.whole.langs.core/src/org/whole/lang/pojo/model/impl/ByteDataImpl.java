package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ByteDataImpl extends AbstractDataEntity implements ByteData {
	private static final long serialVersionUID = 1;
	private byte value;

	public byte getValue() {
		return notifyRequested(value);
	}

	public void setValue(byte value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.ByteData_ord;
	}

	public EntityDescriptor<ByteData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.ByteData;
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
