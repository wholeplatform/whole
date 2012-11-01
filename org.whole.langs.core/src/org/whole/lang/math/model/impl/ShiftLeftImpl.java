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
public class ShiftLeftImpl extends AbstractSimpleEntity implements ShiftLeft {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ShiftLeft> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.ShiftLeft;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.ShiftLeft_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(MathFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(MathFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	private Expression bits;

	public Expression getBits() {
		return notifyRequested(MathFeatureDescriptorEnum.bits, bits);
	}

	public void setBits(Expression bits) {
		notifyChanged(MathFeatureDescriptorEnum.bits, this.bits,
				this.bits = bits);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getBits().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		case 1:
			setBits(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
