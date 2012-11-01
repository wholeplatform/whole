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
public class ExponentiationImpl extends AbstractSimpleEntity implements
		Exponentiation {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Exponentiation> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Exponentiation;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Exponentiation_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Expression base;

	public Expression getBase() {
		return notifyRequested(MathFeatureDescriptorEnum.base, base);
	}

	public void setBase(Expression base) {
		notifyChanged(MathFeatureDescriptorEnum.base, this.base,
				this.base = base);
	}

	private Expression exponent;

	public Expression getExponent() {
		return notifyRequested(MathFeatureDescriptorEnum.exponent, exponent);
	}

	public void setExponent(Expression exponent) {
		notifyChanged(MathFeatureDescriptorEnum.exponent, this.exponent,
				this.exponent = exponent);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getBase().wGetAdaptee(false);
		case 1:
			return getExponent().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setBase(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		case 1:
			setExponent(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
