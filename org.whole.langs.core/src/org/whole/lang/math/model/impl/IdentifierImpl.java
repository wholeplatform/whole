package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IdentifierImpl extends AbstractDataEntity implements Identifier {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Identifier_ord;
	}

	public EntityDescriptor<Identifier> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Identifier;
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
