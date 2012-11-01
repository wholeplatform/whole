package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CharValueImpl extends AbstractDataEntity implements CharValue {
	private static final long serialVersionUID = 1;
	private char value;

	public char getValue() {
		return notifyRequested(value);
	}

	public void setValue(char value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.CharValue_ord;
	}

	public EntityDescriptor<CharValue> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.CharValue;
	}

	public Object wGetValue() {
		return new Character(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Character) value).charValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue((value).charAt(0));
		} catch (NumberFormatException e) {
		}
	}

	public char wCharValue() {
		return getValue();
	}

	public void wSetValue(char value) {
		setValue(value);
	}
}
