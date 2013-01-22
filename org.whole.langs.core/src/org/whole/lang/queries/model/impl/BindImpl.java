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
public class BindImpl extends AbstractSimpleEntity implements Bind {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Bind> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.Bind;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.Bind_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(QueriesFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(QueriesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private PathExpressionOrPredicate expression;

	public PathExpressionOrPredicate getExpression() {
		return notifyRequested(QueriesFeatureDescriptorEnum.expression,
				expression);
	}

	public void setExpression(PathExpressionOrPredicate expression) {
		notifyChanged(QueriesFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getExpression().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(QueriesEntityDescriptorEnum.Name));
			break;
		case 1:
			setExpression(value
					.wGetAdapter(QueriesEntityDescriptorEnum.PathExpressionOrPredicate));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
