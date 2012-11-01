package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CharTestEntityImpl extends AbstractDataEntity implements
		CharTestEntity {
	private static final long serialVersionUID = 1;
	private char value;

	public char getValue() {
		return notifyRequested(value);
	}

	public void setValue(char value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITestEntitiesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestEntitiesEntityDescriptorEnum.CharTestEntity_ord;
	}

	public EntityDescriptor<CharTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.CharTestEntity;
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
