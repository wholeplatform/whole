package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class PostfixOperatorImpl extends AbstractDataEntity implements
		PostfixOperator {
	private static final long serialVersionUID = 1;
	private org.whole.lang.java.model.PostfixOperatorEnum.Value value;

	public org.whole.lang.java.model.PostfixOperatorEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.java.model.PostfixOperatorEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.PostfixOperator_ord;
	}

	public EntityDescriptor<PostfixOperator> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.PostfixOperator;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.java.model.PostfixOperatorEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(PostfixOperatorEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.java.model.PostfixOperatorEnum.Value) value);
	}
}
