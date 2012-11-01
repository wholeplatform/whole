package org.whole.lang.text.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.text.model.*;
import org.whole.lang.text.visitors.ITextVisitor;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TextSeparatorImpl extends AbstractDataEntity implements
		TextSeparator {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITextVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TextEntityDescriptorEnum.TextSeparator_ord;
	}

	public EntityDescriptor<TextSeparator> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.TextSeparator;
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
