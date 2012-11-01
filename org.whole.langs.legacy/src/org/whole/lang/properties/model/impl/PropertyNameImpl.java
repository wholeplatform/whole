package org.whole.lang.properties.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.properties.model.*;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class PropertyNameImpl extends AbstractDataEntity implements
		PropertyName {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IPropertiesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return PropertiesEntityDescriptorEnum.PropertyName_ord;
	}

	public EntityDescriptor<PropertyName> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.PropertyName;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((String) value);
	}

	public String wStringValue() {
		return getValue();
	}

	public void wSetValue(String value) {
		setValue(value);
	}
}
