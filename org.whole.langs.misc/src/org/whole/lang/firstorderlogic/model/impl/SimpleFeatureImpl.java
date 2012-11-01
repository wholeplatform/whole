package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SimpleFeatureImpl extends AbstractDataEntity implements
		SimpleFeature {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.SimpleFeature_ord;
	}

	public EntityDescriptor<SimpleFeature> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.SimpleFeature;
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
