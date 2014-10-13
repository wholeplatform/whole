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
public class ConstructorInvocationImpl extends AbstractSimpleEntity implements
		ConstructorInvocation {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ConstructorInvocation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ConstructorInvocation;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.ConstructorInvocation_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
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
			return getTypeArguments().wGetAdaptee(false);
		case 1:
			return getArguments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTypeArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Types));
			break;
		case 1:
			setArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Arguments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
