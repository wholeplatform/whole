package org.whole.lang.templates.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.templates.model.*;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SimpleNameImpl extends AbstractDataEntity implements SimpleName {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITemplatesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TemplatesEntityDescriptorEnum.SimpleName_ord;
	}

	public EntityDescriptor<SimpleName> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.SimpleName;
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
