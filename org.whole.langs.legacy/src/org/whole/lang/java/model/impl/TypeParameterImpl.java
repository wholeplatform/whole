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
public class TypeParameterImpl extends AbstractSimpleEntity implements
		TypeParameter {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TypeParameter> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TypeParameter;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.TypeParameter_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(JavaFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(JavaFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Types typeBounds;

	public Types getTypeBounds() {
		return notifyRequested(JavaFeatureDescriptorEnum.typeBounds, typeBounds);
	}

	public void setTypeBounds(Types typeBounds) {
		notifyChanged(JavaFeatureDescriptorEnum.typeBounds, this.typeBounds,
				this.typeBounds = typeBounds);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getTypeBounds().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		case 1:
			setTypeBounds(value.wGetAdapter(JavaEntityDescriptorEnum.Types));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
