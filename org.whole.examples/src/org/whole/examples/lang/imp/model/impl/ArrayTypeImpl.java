package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.ArrayType;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.Type;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.model.PrimitiveType;

/** 
 * @generator Whole
 */
public class ArrayTypeImpl extends AbstractSimpleEntity implements ArrayType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ArrayType> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ArrayType;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.ArrayType_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Type contentType;

	public Type getContentType() {
		return notifyRequested(ImpFeatureDescriptorEnum.contentType, contentType);
	}

	public void setContentType(Type contentType) {
		notifyChanged(ImpFeatureDescriptorEnum.contentType, this.contentType, this.contentType = contentType);
	}

	private PrimitiveType indexType;

	public PrimitiveType getIndexType() {
		return notifyRequested(ImpFeatureDescriptorEnum.indexType, indexType);
	}

	public void setIndexType(PrimitiveType indexType) {
		notifyChanged(ImpFeatureDescriptorEnum.indexType, this.indexType, this.indexType = indexType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getContentType().wGetAdaptee(false);
		case 1:
			return getIndexType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setContentType(value.wGetAdapter(ImpEntityDescriptorEnum.Type));
			break;
		case 1:
			setIndexType(value.wGetAdapter(ImpEntityDescriptorEnum.PrimitiveType));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
