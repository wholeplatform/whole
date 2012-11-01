package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class BindingTimeImpl extends AbstractDataEntity implements BindingTime {
	private static final long serialVersionUID = 1;
	private org.whole.lang.frames.model.BindingTimeEnum.Value value;

	public org.whole.lang.frames.model.BindingTimeEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.frames.model.BindingTimeEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.BindingTime_ord;
	}

	public EntityDescriptor<BindingTime> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.BindingTime;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.frames.model.BindingTimeEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(BindingTimeEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.frames.model.BindingTimeEnum.Value) value);
	}
}
