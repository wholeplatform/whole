package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BooleanValueImpl extends AbstractDataEntity implements
		BooleanValue {
	private static final long serialVersionUID = 1;
	private boolean value;

	public boolean isValue() {
		return notifyRequested(value);
	}

	public void setValue(boolean value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IPatternsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return PatternsEntityDescriptorEnum.BooleanValue_ord;
	}

	public EntityDescriptor<BooleanValue> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.BooleanValue;
	}

	public Object wGetValue() {
		return new Boolean(isValue());
	}

	public void wSetValue(Object value) {
		setValue(((Boolean) value).booleanValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Boolean.valueOf(value).booleanValue());
		} catch (NumberFormatException e) {
		}
	}

	public boolean wBooleanValue() {
		return isValue();
	}

	public void wSetValue(boolean value) {
		setValue(value);
	}
}
