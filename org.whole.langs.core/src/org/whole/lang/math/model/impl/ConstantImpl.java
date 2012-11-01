package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class ConstantImpl extends AbstractDataEntity implements Constant {
	private static final long serialVersionUID = 1;
	private org.whole.lang.math.model.ConstantEnum.Value value;

	public org.whole.lang.math.model.ConstantEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.math.model.ConstantEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Constant_ord;
	}

	public EntityDescriptor<Constant> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Constant;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.math.model.ConstantEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(ConstantEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.math.model.ConstantEnum.Value) value);
	}
}
