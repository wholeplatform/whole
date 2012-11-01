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
public class StringLiteralImpl extends AbstractSimpleEntity implements
		StringLiteral {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<StringLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.StringLiteral;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.StringLiteral_ord;
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

	private StringData quote;

	public StringData getQuote() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.quote, quote);
	}

	public void setQuote(StringData quote) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.quote, this.quote,
				this.quote = quote);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getValue().wGetAdaptee(false);
		case 1:
			return getQuote().wGetAdaptee(false);
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
			setQuote(value
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
