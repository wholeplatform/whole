package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RegExpLiteralImpl extends AbstractSimpleEntity implements
		RegExpLiteral {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<RegExpLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.RegExpLiteral;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.RegExpLiteral_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private StringData value;

	public StringData getValue() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.value, value);
	}

	public void setValue(StringData value) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.value, this.value,
				this.value = value);
	}

	private StringData flags;

	public StringData getFlags() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.flags, flags);
	}

	public void setFlags(StringData flags) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.flags, this.flags,
				this.flags = flags);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getValue().wGetAdaptee(false);
		case 1:
			return getFlags().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setValue(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.StringData));
			break;
		case 1:
			setFlags(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.StringData));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
