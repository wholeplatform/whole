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
public class SubtractionImpl extends AbstractSimpleEntity implements
		Subtraction {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Subtraction> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Subtraction;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Subtraction_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Expression minuend;

	public Expression getMinuend() {
		return notifyRequested(MathFeatureDescriptorEnum.minuend, minuend);
	}

	public void setMinuend(Expression minuend) {
		notifyChanged(MathFeatureDescriptorEnum.minuend, this.minuend,
				this.minuend = minuend);
	}

	private Expression subtrahend;

	public Expression getSubtrahend() {
		return notifyRequested(MathFeatureDescriptorEnum.subtrahend, subtrahend);
	}

	public void setSubtrahend(Expression subtrahend) {
		notifyChanged(MathFeatureDescriptorEnum.subtrahend, this.subtrahend,
				this.subtrahend = subtrahend);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getMinuend().wGetAdaptee(false);
		case 1:
			return getSubtrahend().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setMinuend(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		case 1:
			setSubtrahend(value
					.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
