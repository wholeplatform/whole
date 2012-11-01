package org.whole.lang.environment.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.environment.model.*;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CharDataImpl extends AbstractDataEntity implements CharData {
	private static final long serialVersionUID = 1;
	private char value;

	public char getValue() {
		return notifyRequested(value);
	}

	public void setValue(char value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IEnvironmentVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return EnvironmentEntityDescriptorEnum.CharData_ord;
	}

	public EntityDescriptor<CharData> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.CharData;
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
