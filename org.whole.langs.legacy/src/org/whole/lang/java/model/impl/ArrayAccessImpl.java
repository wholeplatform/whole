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
public class ArrayAccessImpl extends AbstractSimpleEntity implements
		ArrayAccess {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ArrayAccess> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ArrayAccess;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.ArrayAccess_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Expression array;

	public Expression getArray() {
		return notifyRequested(JavaFeatureDescriptorEnum.array, array);
	}

	public void setArray(Expression array) {
		notifyChanged(JavaFeatureDescriptorEnum.array, this.array,
				this.array = array);
	}

	private Expression index;

	public Expression getIndex() {
		return notifyRequested(JavaFeatureDescriptorEnum.index, index);
	}

	public void setIndex(Expression index) {
		notifyChanged(JavaFeatureDescriptorEnum.index, this.index,
				this.index = index);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getArray().wGetAdaptee(false);
		case 1:
			return getIndex().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setArray(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 1:
			setIndex(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
