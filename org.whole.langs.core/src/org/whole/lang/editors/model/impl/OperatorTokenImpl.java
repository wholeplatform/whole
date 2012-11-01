package org.whole.lang.editors.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.editors.model.*;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class OperatorTokenImpl extends AbstractDataEntity implements
		OperatorToken {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IEditorsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.OperatorToken_ord;
	}

	public EntityDescriptor<OperatorToken> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.OperatorToken;
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
