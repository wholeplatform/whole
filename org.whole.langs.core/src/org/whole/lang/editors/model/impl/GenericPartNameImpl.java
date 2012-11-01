package org.whole.lang.editors.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.editors.model.*;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class GenericPartNameImpl extends AbstractDataEntity implements
		GenericPartName {
	private static final long serialVersionUID = 1;
	private org.whole.lang.editors.model.GenericPartNameEnum.Value value;

	public org.whole.lang.editors.model.GenericPartNameEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.editors.model.GenericPartNameEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IEditorsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.GenericPartName_ord;
	}

	public EntityDescriptor<GenericPartName> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.GenericPartName;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.editors.model.GenericPartNameEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(GenericPartNameEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.editors.model.GenericPartNameEnum.Value) value);
	}
}
