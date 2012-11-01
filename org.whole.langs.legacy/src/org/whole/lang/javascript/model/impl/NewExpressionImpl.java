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
public class NewExpressionImpl extends AbstractSimpleEntity implements
		NewExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NewExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.NewExpression;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.NewExpression_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Expression constructor;

	public Expression getConstructor() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.constructor,
				constructor);
	}

	public void setConstructor(Expression constructor) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.constructor,
				this.constructor, this.constructor = constructor);
	}

	private Expressions arguments;

	public Expressions getArguments() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.arguments,
				arguments);
	}

	public void setArguments(Expressions arguments) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.arguments,
				this.arguments, this.arguments = arguments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getConstructor().wGetAdaptee(false);
		case 1:
			return getArguments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setConstructor(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setArguments(value
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
