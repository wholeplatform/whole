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
public class RationalImpl extends AbstractSimpleEntity implements Rational {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Rational> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Rational;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Rational_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private IntegerNumber numerator;

	public IntegerNumber getNumerator() {
		return notifyRequested(MathFeatureDescriptorEnum.numerator, numerator);
	}

	public void setNumerator(IntegerNumber numerator) {
		notifyChanged(MathFeatureDescriptorEnum.numerator, this.numerator,
				this.numerator = numerator);
	}

	private IntegerNumber denominator;

	public IntegerNumber getDenominator() {
		return notifyRequested(MathFeatureDescriptorEnum.denominator,
				denominator);
	}

	public void setDenominator(IntegerNumber denominator) {
		notifyChanged(MathFeatureDescriptorEnum.denominator, this.denominator,
				this.denominator = denominator);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getNumerator().wGetAdaptee(false);
		case 1:
			return getDenominator().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setNumerator(value
					.wGetAdapter(MathEntityDescriptorEnum.IntegerNumber));
			break;
		case 1:
			setDenominator(value
					.wGetAdapter(MathEntityDescriptorEnum.IntegerNumber));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
