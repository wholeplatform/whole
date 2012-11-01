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
public class ArrayLiteralImpl extends AbstractSimpleEntity implements
		ArrayLiteral {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ArrayLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ArrayLiteral;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ArrayLiteral_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
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

	private Expressions elements;

	public Expressions getElements() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.elements,
				elements);
	}

	public void setElements(Expressions elements) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.elements, this.elements,
				this.elements = elements);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDestructuring().wGetAdaptee(false);
		case 1:
			return getElements().wGetAdaptee(false);
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
			setElements(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expressions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
