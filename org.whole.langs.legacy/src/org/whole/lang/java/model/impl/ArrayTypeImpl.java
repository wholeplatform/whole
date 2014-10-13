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
public class ArrayTypeImpl extends AbstractSimpleEntity implements ArrayType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ArrayType> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ArrayType;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.ArrayType_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Type componentType;

	public Type getComponentType() {
		return notifyRequested(JavaFeatureDescriptorEnum.componentType,
				componentType);
	}

	public void setComponentType(Type componentType) {
		notifyChanged(JavaFeatureDescriptorEnum.componentType,
				this.componentType, this.componentType = componentType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getComponentType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setComponentType(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
