package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ParenthesizedPredicateImpl extends AbstractSimpleEntity implements
		ParenthesizedPredicate {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ParenthesizedPredicate> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.ParenthesizedPredicate;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.ParenthesizedPredicate_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	private Predicate predicate;

	public Predicate getPredicate() {
		return notifyRequested(QueriesFeatureDescriptorEnum.predicate,
				predicate);
	}

	public void setPredicate(Predicate predicate) {
		notifyChanged(QueriesFeatureDescriptorEnum.predicate, this.predicate,
				this.predicate = predicate);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPredicate().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPredicate(value
					.wGetAdapter(QueriesEntityDescriptorEnum.Predicate));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
