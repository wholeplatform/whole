package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.ArrayAccess;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.Expression;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ArrayAccessImpl extends AbstractSimpleEntity implements ArrayAccess {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ArrayAccess> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ArrayAccess;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.ArrayAccess_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Expression array;

	public Expression getArray() {
		return notifyRequested(ImpFeatureDescriptorEnum.array, array);
	}

	public void setArray(Expression array) {
		notifyChanged(ImpFeatureDescriptorEnum.array, this.array, this.array = array);
	}

	private Expression index;

	public Expression getIndex() {
		return notifyRequested(ImpFeatureDescriptorEnum.index, index);
	}

	public void setIndex(Expression index) {
		notifyChanged(ImpFeatureDescriptorEnum.index, this.index, this.index = index);
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
			setArray(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		case 1:
			setIndex(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
