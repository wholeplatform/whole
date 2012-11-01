package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ShortIntegerImpl extends AbstractDataEntity implements
		ShortInteger {
	private static final long serialVersionUID = 1;
	private short value;

	public short getValue() {
		return notifyRequested(value);
	}

	public void setValue(short value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.ShortInteger_ord;
	}

	public EntityDescriptor<ShortInteger> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.ShortInteger;
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
