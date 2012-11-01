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
public class SelectorImpl extends AbstractSimpleEntity implements Selector {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Selector> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Selector;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Selector_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Expression index;

	public Expression getIndex() {
		return notifyRequested(MathFeatureDescriptorEnum.index, index);
	}

	public void setIndex(Expression index) {
		notifyChanged(MathFeatureDescriptorEnum.index, this.index,
				this.index = index);
	}

	private CollectionExpression collection;

	public CollectionExpression getCollection() {
		return notifyRequested(MathFeatureDescriptorEnum.collection, collection);
	}

	public void setCollection(CollectionExpression collection) {
		notifyChanged(MathFeatureDescriptorEnum.collection, this.collection,
				this.collection = collection);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIndex().wGetAdaptee(false);
		case 1:
			return getCollection().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIndex(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		case 1:
			setCollection(value
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
