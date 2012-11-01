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
public class CardinalityImpl extends AbstractSimpleEntity implements
		Cardinality {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Cardinality> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Cardinality;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Cardinality_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
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
			return getCollection().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setCollection(value
					.wGetAdapter(MathEntityDescriptorEnum.CollectionExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
