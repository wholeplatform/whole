package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BigDecimalImpl extends AbstractDataEntity implements BigDecimal {
	private static final long serialVersionUID = 1;
	private java.math.BigDecimal value;

	public java.math.BigDecimal getValue() {
		return notifyRequested(value);
	}

	public void setValue(java.math.BigDecimal value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.BigDecimal_ord;
	}

	public EntityDescriptor<BigDecimal> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.BigDecimal;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((java.math.BigDecimal) value);
	}
}
