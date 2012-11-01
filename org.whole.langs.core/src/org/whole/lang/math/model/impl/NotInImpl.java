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
public class NotInImpl extends AbstractSimpleEntity implements NotIn {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NotIn> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.NotIn;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.NotIn_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Expression element;

	public Expression getElement() {
		return notifyRequested(MathFeatureDescriptorEnum.element, element);
	}

	public void setElement(Expression element) {
		notifyChanged(MathFeatureDescriptorEnum.element, this.element,
				this.element = element);
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
			return getElement().wGetAdaptee(false);
		case 1:
			return getCollection().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setElement(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
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
