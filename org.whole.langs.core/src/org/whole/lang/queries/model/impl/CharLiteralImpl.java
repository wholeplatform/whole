package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CharLiteralImpl extends AbstractDataEntity implements CharLiteral {
	private static final long serialVersionUID = 1;
	private char value;

	public char getValue() {
		return notifyRequested(value);
	}

	public void setValue(char value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.CharLiteral_ord;
	}

	public EntityDescriptor<CharLiteral> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.CharLiteral;
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
