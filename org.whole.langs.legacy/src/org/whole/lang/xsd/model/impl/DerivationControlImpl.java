package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class DerivationControlImpl extends AbstractDataEntity implements
		DerivationControl {
	private static final long serialVersionUID = 1;
	private org.whole.lang.xsd.model.DerivationControlEnum.Value value;

	public org.whole.lang.xsd.model.DerivationControlEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.xsd.model.DerivationControlEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.DerivationControl_ord;
	}

	public EntityDescriptor<DerivationControl> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.DerivationControl;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.xsd.model.DerivationControlEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(DerivationControlEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.xsd.model.DerivationControlEnum.Value) value);
	}
}
