package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ArrayTypeImpl extends AbstractSimpleEntity implements ArrayType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ArrayType> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.ArrayType;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.ArrayType_ord;
	}

	public void accept(IPojoVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Type elementType;

	public Type getElementType() {
		return notifyRequested(PojoFeatureDescriptorEnum.elementType,
				elementType);
	}

	public void setElementType(Type elementType) {
		notifyChanged(PojoFeatureDescriptorEnum.elementType, this.elementType,
				this.elementType = elementType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getElementType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setElementType(value.wGetAdapter(PojoEntityDescriptorEnum.Type));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
