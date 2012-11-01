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
public class OrderedPairImpl extends AbstractSimpleEntity implements
		OrderedPair {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<OrderedPair> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.OrderedPair;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.OrderedPair_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Expression first;

	public Expression getFirst() {
		return notifyRequested(MathFeatureDescriptorEnum.first, first);
	}

	public void setFirst(Expression first) {
		notifyChanged(MathFeatureDescriptorEnum.first, this.first,
				this.first = first);
	}

	private Expression second;

	public Expression getSecond() {
		return notifyRequested(MathFeatureDescriptorEnum.second, second);
	}

	public void setSecond(Expression second) {
		notifyChanged(MathFeatureDescriptorEnum.second, this.second,
				this.second = second);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFirst().wGetAdaptee(false);
		case 1:
			return getSecond().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFirst(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		case 1:
			setSecond(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
