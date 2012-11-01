package org.whole.lang.artifacts.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class AttributeImpl extends AbstractDataEntity implements Attribute {
	private static final long serialVersionUID = 1;
	private org.whole.lang.artifacts.model.AttributeEnum.Value value;

	public org.whole.lang.artifacts.model.AttributeEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.artifacts.model.AttributeEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IArtifactsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ArtifactsEntityDescriptorEnum.Attribute_ord;
	}

	public EntityDescriptor<Attribute> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Attribute;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.artifacts.model.AttributeEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(AttributeEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.artifacts.model.AttributeEnum.Value) value);
	}
}
