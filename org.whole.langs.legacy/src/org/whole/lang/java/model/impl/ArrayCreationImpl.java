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
public class ArrayCreationImpl extends AbstractSimpleEntity implements
		ArrayCreation {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ArrayCreation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ArrayCreation;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.ArrayCreation_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private ArrayType type;

	public ArrayType getType() {
		return notifyRequested(JavaFeatureDescriptorEnum.type, type);
	}

	public void setType(ArrayType type) {
		notifyChanged(JavaFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private Expressions dimensions;

	public Expressions getDimensions() {
		return notifyRequested(JavaFeatureDescriptorEnum.dimensions, dimensions);
	}

	public void setDimensions(Expressions dimensions) {
		notifyChanged(JavaFeatureDescriptorEnum.dimensions, this.dimensions,
				this.dimensions = dimensions);
	}

	private ArrayInitializer initializer;

	public ArrayInitializer getInitializer() {
		return notifyRequested(JavaFeatureDescriptorEnum.initializer,
				initializer);
	}

	public void setInitializer(ArrayInitializer initializer) {
		notifyChanged(JavaFeatureDescriptorEnum.initializer, this.initializer,
				this.initializer = initializer);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getType().wGetAdaptee(false);
		case 1:
			return getDimensions().wGetAdaptee(false);
		case 2:
			return getInitializer().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setType(value.wGetAdapter(JavaEntityDescriptorEnum.ArrayType));
			break;
		case 1:
			setDimensions(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expressions));
			break;
		case 2:
			setInitializer(value
					.wGetAdapter(JavaEntityDescriptorEnum.ArrayInitializer));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
