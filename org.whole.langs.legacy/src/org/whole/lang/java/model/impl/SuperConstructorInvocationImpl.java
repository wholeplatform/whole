package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SuperConstructorInvocationImpl extends AbstractSimpleEntity
		implements SuperConstructorInvocation {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SuperConstructorInvocation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SuperConstructorInvocation;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.SuperConstructorInvocation_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(JavaFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(JavaFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	private Types typeArguments;

	public Types getTypeArguments() {
		return notifyRequested(JavaFeatureDescriptorEnum.typeArguments,
				typeArguments);
	}

	public void setTypeArguments(Types typeArguments) {
		notifyChanged(JavaFeatureDescriptorEnum.typeArguments,
				this.typeArguments, this.typeArguments = typeArguments);
	}

	private Arguments arguments;

	public Arguments getArguments() {
		return notifyRequested(JavaFeatureDescriptorEnum.arguments, arguments);
	}

	public void setArguments(Arguments arguments) {
		notifyChanged(JavaFeatureDescriptorEnum.arguments, this.arguments,
				this.arguments = arguments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getTypeArguments().wGetAdaptee(false);
		case 2:
			return getArguments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 1:
			setTypeArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Types));
			break;
		case 2:
			setArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Arguments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
