package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class AssignmentOperatorImpl extends AbstractDataEntity implements
		AssignmentOperator {
	private static final long serialVersionUID = 1;
	private org.whole.lang.javascript.model.AssignmentOperatorEnum.Value value;

	public org.whole.lang.javascript.model.AssignmentOperatorEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.javascript.model.AssignmentOperatorEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.AssignmentOperator_ord;
	}

	public EntityDescriptor<AssignmentOperator> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.AssignmentOperator;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.javascript.model.AssignmentOperatorEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(AssignmentOperatorEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.javascript.model.AssignmentOperatorEnum.Value) value);
	}
}
