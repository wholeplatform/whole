package org.whole.lang.text.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.text.model.*;
import org.whole.lang.text.visitors.ITextVisitor;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TextImpl extends AbstractDataEntity implements Text {
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
		return TextEntityDescriptorEnum.Text_ord;
	}

	public EntityDescriptor<Text> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.Text;
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
