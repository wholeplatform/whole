package org.whole.lang.scheme.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.scheme.model.*;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IdExpressionImpl extends AbstractDataEntity implements
		IdExpression {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ISchemeVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.IdExpression_ord;
	}

	public EntityDescriptor<IdExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.IdExpression;
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
