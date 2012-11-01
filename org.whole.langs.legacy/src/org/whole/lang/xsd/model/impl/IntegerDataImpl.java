package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IntegerDataImpl extends AbstractDataEntity implements IntegerData {
	private static final long serialVersionUID = 1;
	private java.math.BigInteger value;

	public java.math.BigInteger getValue() {
		return notifyRequested(value);
	}

	public void setValue(java.math.BigInteger value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.IntegerData_ord;
	}

	public EntityDescriptor<IntegerData> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.IntegerData;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((java.math.BigInteger) value);
	}
}
