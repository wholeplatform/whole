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
public class SomeImpl extends AbstractSimpleEntity implements Some {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Some> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.Some;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.Some_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	private PathExpression fromClause;

	public PathExpression getFromClause() {
		return notifyRequested(QueriesFeatureDescriptorEnum.fromClause,
				fromClause);
	}

	public void setFromClause(PathExpression fromClause) {
		notifyChanged(QueriesFeatureDescriptorEnum.fromClause, this.fromClause,
				this.fromClause = fromClause);
	}

	private Predicate whereClause;

	public Predicate getWhereClause() {
		return notifyRequested(QueriesFeatureDescriptorEnum.whereClause,
				whereClause);
	}

	public void setWhereClause(Predicate whereClause) {
		notifyChanged(QueriesFeatureDescriptorEnum.whereClause,
				this.whereClause, this.whereClause = whereClause);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFromClause().wGetAdaptee(false);
		case 1:
			return getWhereClause().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFromClause(value
					.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
			break;
		case 1:
			setWhereClause(value
					.wGetAdapter(QueriesEntityDescriptorEnum.Predicate));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
