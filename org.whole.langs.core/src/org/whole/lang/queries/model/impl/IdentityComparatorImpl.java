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
public class IdentityComparatorImpl extends AbstractSimpleEntity implements
		IdentityComparator {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IdentityComparator> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.IdentityComparator;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.IdentityComparator_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	private StepExpression identity;

	public StepExpression getIdentity() {
		return notifyRequested(QueriesFeatureDescriptorEnum.identity, identity);
	}

	public void setIdentity(StepExpression identity) {
		notifyChanged(QueriesFeatureDescriptorEnum.identity, this.identity,
				this.identity = identity);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIdentity().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIdentity(value
					.wGetAdapter(QueriesEntityDescriptorEnum.StepExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
