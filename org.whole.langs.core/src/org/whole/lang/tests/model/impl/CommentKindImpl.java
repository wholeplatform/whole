package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class CommentKindImpl extends AbstractDataEntity implements CommentKind {
	private static final long serialVersionUID = 1;
	private org.whole.lang.tests.model.CommentKindEnum.Value value;

	public org.whole.lang.tests.model.CommentKindEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.tests.model.CommentKindEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.CommentKind_ord;
	}

	public EntityDescriptor<CommentKind> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.CommentKind;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.tests.model.CommentKindEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(CommentKindEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.tests.model.CommentKindEnum.Value) value);
	}
}
