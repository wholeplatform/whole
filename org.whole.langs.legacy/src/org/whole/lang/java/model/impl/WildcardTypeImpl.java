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
public class WildcardTypeImpl extends AbstractSimpleEntity implements
		WildcardType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<WildcardType> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.WildcardType;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.WildcardType_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Type bound;

	public Type getBound() {
		return notifyRequested(JavaFeatureDescriptorEnum.bound, bound);
	}

	public void setBound(Type bound) {
		notifyChanged(JavaFeatureDescriptorEnum.bound, this.bound,
				this.bound = bound);
	}

	private UpperBound upperBound;

	public UpperBound getUpperBound() {
		return notifyRequested(JavaFeatureDescriptorEnum.upperBound, upperBound);
	}

	public void setUpperBound(UpperBound upperBound) {
		notifyChanged(JavaFeatureDescriptorEnum.upperBound, this.upperBound,
				this.upperBound = upperBound);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getBound().wGetAdaptee(false);
		case 1:
			return getUpperBound().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setBound(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
			break;
		case 1:
			setUpperBound(value
					.wGetAdapter(JavaEntityDescriptorEnum.UpperBound));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
