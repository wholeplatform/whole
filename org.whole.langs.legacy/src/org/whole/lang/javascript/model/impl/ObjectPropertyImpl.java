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
public class ObjectPropertyImpl extends AbstractSimpleEntity implements
		ObjectProperty {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ObjectProperty> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ObjectProperty;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ObjectProperty_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private LiteralOrIdentifier key;

	public LiteralOrIdentifier getKey() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.key, key);
	}

	public void setKey(LiteralOrIdentifier key) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.key, this.key,
				this.key = key);
	}

	private Expression value;

	public Expression getValue() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.value, value);
	}

	public void setValue(Expression value) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.value, this.value,
				this.value = value);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getKey().wGetAdaptee(false);
		case 1:
			return getValue().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setKey(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.LiteralOrIdentifier));
			break;
		case 1:
			setValue(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
