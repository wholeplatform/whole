package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.examples.lang.imp.model.BooleanLiteral;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BooleanLiteralImpl extends AbstractDataEntity implements BooleanLiteral {
	private static final long serialVersionUID = 1;
	private boolean value;

	public boolean isValue() {
		return notifyRequested(value);
	}

	public void setValue(boolean value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.BooleanLiteral_ord;
	}

	public EntityDescriptor<BooleanLiteral> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.BooleanLiteral;
	}

	public Object wGetValue() {
		return new Boolean(isValue());
	}

	public void wSetValue(Object value) {
		setValue(((Boolean) value).booleanValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Boolean.valueOf(value).booleanValue());
		} catch (NumberFormatException e) {
		}
	}

	public boolean wBooleanValue() {
		return isValue();
	}

	public void wSetValue(boolean value) {
		setValue(value);
	}
}
