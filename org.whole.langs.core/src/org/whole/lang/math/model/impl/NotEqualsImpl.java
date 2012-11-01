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
public class NotEqualsImpl extends AbstractSimpleEntity implements NotEquals {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NotEquals> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.NotEquals;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.NotEquals_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Expression exp1;

	public Expression getExp1() {
		return notifyRequested(MathFeatureDescriptorEnum.exp1, exp1);
	}

	public void setExp1(Expression exp1) {
		notifyChanged(MathFeatureDescriptorEnum.exp1, this.exp1,
				this.exp1 = exp1);
	}

	private Expression exp2;

	public Expression getExp2() {
		return notifyRequested(MathFeatureDescriptorEnum.exp2, exp2);
	}

	public void setExp2(Expression exp2) {
		notifyChanged(MathFeatureDescriptorEnum.exp2, this.exp2,
				this.exp2 = exp2);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExp1().wGetAdaptee(false);
		case 1:
			return getExp2().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExp1(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		case 1:
			setExp2(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
