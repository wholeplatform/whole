package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class LongLiteralImpl extends AbstractDataEntity implements LongLiteral {
	private static final long serialVersionUID = 1;
	private long value;

	public long getValue() {
		return notifyRequested(value);
	}

	public void setValue(long value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.LongLiteral_ord;
	}

	public EntityDescriptor<LongLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.LongLiteral;
	}

	public Object wGetValue() {
		return new Long(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Long) value).longValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Long.valueOf(value).longValue());
		} catch (NumberFormatException e) {
		}
	}

	public long wLongValue() {
		return getValue();
	}

	public void wSetValue(long value) {
		setValue(value);
	}
}
