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
public class UnionAllImpl extends AbstractSimpleEntity implements UnionAll {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<UnionAll> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.UnionAll;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.UnionAll_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	private Expressions expressions;

	public Expressions getExpressions() {
		return notifyRequested(QueriesFeatureDescriptorEnum.expressions,
				expressions);
	}

	public void setExpressions(Expressions expressions) {
		notifyChanged(QueriesFeatureDescriptorEnum.expressions,
				this.expressions, this.expressions = expressions);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpressions().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpressions(value
					.wGetAdapter(QueriesEntityDescriptorEnum.Expressions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
