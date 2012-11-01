package org.whole.lang.models.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.models.model.*;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DataTypeImpl extends AbstractDataEntity implements DataType {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IModelsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.DataType_ord;
	}

	public EntityDescriptor<DataType> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.DataType;
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
