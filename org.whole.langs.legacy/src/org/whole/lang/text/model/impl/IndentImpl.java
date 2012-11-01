package org.whole.lang.text.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.text.model.*;
import org.whole.lang.text.visitors.ITextVisitor;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IndentImpl extends AbstractDataEntity implements Indent {
	private static final long serialVersionUID = 1;
	private int value;

	public int getValue() {
		return notifyRequested(value);
	}

	public void setValue(int value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITextVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TextEntityDescriptorEnum.Indent_ord;
	}

	public EntityDescriptor<Indent> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.Indent;
	}

	public Object wGetValue() {
		return new Integer(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Integer) value).intValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Integer.valueOf(value).intValue());
		} catch (NumberFormatException e) {
		}
	}

	public int wIntValue() {
		return getValue();
	}

	public void wSetValue(int value) {
		setValue(value);
	}
}
