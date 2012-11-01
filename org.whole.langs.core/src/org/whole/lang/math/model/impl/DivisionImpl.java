package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class DivisionImpl extends AbstractSimpleEntity implements Division {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Division> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Division;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Division_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Expression dividend;

	public Expression getDividend() {
		return notifyRequested(MathFeatureDescriptorEnum.dividend, dividend);
	}

	public void setDividend(Expression dividend) {
		notifyChanged(MathFeatureDescriptorEnum.dividend, this.dividend,
				this.dividend = dividend);
	}

	private Expression divisor;

	public Expression getDivisor() {
		return notifyRequested(MathFeatureDescriptorEnum.divisor, divisor);
	}

	public void setDivisor(Expression divisor) {
		notifyChanged(MathFeatureDescriptorEnum.divisor, this.divisor,
				this.divisor = divisor);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDividend().wGetAdaptee(false);
		case 1:
			return getDivisor().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDividend(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		case 1:
			setDivisor(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
