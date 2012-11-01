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
public class QualifyImpl extends AbstractDataEntity implements Qualify {
	private static final long serialVersionUID = 1;
	private org.whole.lang.xsd.model.QualifyEnum.Value value;

	public org.whole.lang.xsd.model.QualifyEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.xsd.model.QualifyEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.Qualify_ord;
	}

	public EntityDescriptor<Qualify> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Qualify;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.xsd.model.QualifyEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(QualifyEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.xsd.model.QualifyEnum.Value) value);
	}
}
