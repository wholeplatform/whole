package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BigIntegerImpl extends AbstractDataEntity implements BigInteger {
	private static final long serialVersionUID = 1;
	private java.math.BigInteger value;

	public java.math.BigInteger getValue() {
		return notifyRequested(value);
	}

	public void setValue(java.math.BigInteger value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.BigInteger_ord;
	}

	public EntityDescriptor<BigInteger> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.BigInteger;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((java.math.BigInteger) value);
	}
}
