package org.whole.examples.datatypes.redblacktree.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.examples.datatypes.redblacktree.visitors.IRedBlackTreeVisitor;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class ColorImpl extends AbstractDataEntity implements Color {
	private static final long serialVersionUID = 1;
	private org.whole.examples.datatypes.redblacktree.model.ColorEnum.Value value;

	public org.whole.examples.datatypes.redblacktree.model.ColorEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.examples.datatypes.redblacktree.model.ColorEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IRedBlackTreeVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return RedBlackTreeEntityDescriptorEnum.Color_ord;
	}

	public EntityDescriptor<Color> wGetEntityDescriptor() {
		return RedBlackTreeEntityDescriptorEnum.Color;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.examples.datatypes.redblacktree.model.ColorEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(ColorEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.examples.datatypes.redblacktree.model.ColorEnum.Value) value);
	}
}
