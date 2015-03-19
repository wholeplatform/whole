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
public class ObjectLiteralImpl extends AbstractSimpleEntity implements
		ObjectLiteral {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ObjectLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ObjectLiteral;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ObjectLiteral_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private BooleanData destructuring;

	public BooleanData getDestructuring() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.destructuring,
				destructuring);
	}

	public void setDestructuring(BooleanData destructuring) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.destructuring,
				this.destructuring, this.destructuring = destructuring);
	}

	private ObjectProperties properties;

	public ObjectProperties getProperties() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.properties,
				properties);
	}

	public void setProperties(ObjectProperties properties) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.properties,
				this.properties, this.properties = properties);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDestructuring().wGetAdaptee(false);
		case 1:
			return getProperties().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDestructuring(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.BooleanData));
			break;
		case 1:
			setProperties(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.ObjectProperties));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
