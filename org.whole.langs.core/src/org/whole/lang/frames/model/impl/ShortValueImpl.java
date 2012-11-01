package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ShortValueImpl extends AbstractDataEntity implements ShortValue {
	private static final long serialVersionUID = 1;
	private short value;

	public short getValue() {
		return notifyRequested(value);
	}

	public void setValue(short value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.ShortValue_ord;
	}

	public EntityDescriptor<ShortValue> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.ShortValue;
	}

	public Object wGetValue() {
		return new Short(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Short) value).shortValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Short.valueOf(value).shortValue());
		} catch (NumberFormatException e) {
		}
	}

	public short wShortValue() {
		return getValue();
	}

	public void wSetValue(short value) {
		setValue(value);
	}
}
