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
public class DifferenceImpl extends AbstractSimpleEntity implements Difference {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Difference> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Difference;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Difference_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private CollectionExpression collection1;

	public CollectionExpression getCollection1() {
		return notifyRequested(MathFeatureDescriptorEnum.collection1,
				collection1);
	}

	public void setCollection1(CollectionExpression collection1) {
		notifyChanged(MathFeatureDescriptorEnum.collection1, this.collection1,
				this.collection1 = collection1);
	}

	private CollectionExpression collection2;

	public CollectionExpression getCollection2() {
		return notifyRequested(MathFeatureDescriptorEnum.collection2,
				collection2);
	}

	public void setCollection2(CollectionExpression collection2) {
		notifyChanged(MathFeatureDescriptorEnum.collection2, this.collection2,
				this.collection2 = collection2);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getCollection1().wGetAdaptee(false);
		case 1:
			return getCollection2().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setCollection1(value
					.wGetAdapter(MathEntityDescriptorEnum.CollectionExpression));
			break;
		case 1:
			setCollection2(value
					.wGetAdapter(MathEntityDescriptorEnum.CollectionExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
