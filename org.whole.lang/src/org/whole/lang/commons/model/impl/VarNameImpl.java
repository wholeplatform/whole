package org.whole.lang.commons.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.commons.model.*;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class VarNameImpl extends AbstractDataEntity implements VarName {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ICommonsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.VarName_ord;
	}

	public EntityDescriptor<VarName> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.VarName;
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
