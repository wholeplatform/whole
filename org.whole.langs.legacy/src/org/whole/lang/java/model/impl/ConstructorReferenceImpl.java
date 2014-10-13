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
public class ConstructorReferenceImpl extends AbstractSimpleEntity implements
		ConstructorReference {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ConstructorReference> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ConstructorReference;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.ConstructorReference_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Type type;

	public Type getType() {
		return notifyRequested(JavaFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(JavaFeatureDescriptorEnum.type, this.type,
				this.type = type);
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

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getType().wGetAdaptee(false);
		case 1:
			return getTypeArguments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setType(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
			break;
		case 1:
			setTypeArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Types));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
