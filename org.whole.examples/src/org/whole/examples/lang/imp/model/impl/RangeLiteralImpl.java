package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.RangeLiteral;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.IntLiteral;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RangeLiteralImpl extends AbstractSimpleEntity implements RangeLiteral {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<RangeLiteral> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.RangeLiteral;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.RangeLiteral_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private IntLiteral lowerBound;

	public IntLiteral getLowerBound() {
		return notifyRequested(ImpFeatureDescriptorEnum.lowerBound, lowerBound);
	}

	public void setLowerBound(IntLiteral lowerBound) {
		notifyChanged(ImpFeatureDescriptorEnum.lowerBound, this.lowerBound, this.lowerBound = lowerBound);
	}

	private IntLiteral upperBound;

	public IntLiteral getUpperBound() {
		return notifyRequested(ImpFeatureDescriptorEnum.upperBound, upperBound);
	}

	public void setUpperBound(IntLiteral upperBound) {
		notifyChanged(ImpFeatureDescriptorEnum.upperBound, this.upperBound, this.upperBound = upperBound);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLowerBound().wGetAdaptee(false);
		case 1:
			return getUpperBound().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLowerBound(value.wGetAdapter(ImpEntityDescriptorEnum.IntLiteral));
			break;
		case 1:
			setUpperBound(value.wGetAdapter(ImpEntityDescriptorEnum.IntLiteral));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
