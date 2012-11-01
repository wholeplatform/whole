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
public class LessOrEqualsImpl extends AbstractSimpleEntity implements
		LessOrEquals {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LessOrEquals> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.LessOrEquals;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.LessOrEquals_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	private Expression exp1;

	public Expression getExp1() {
		return notifyRequested(QueriesFeatureDescriptorEnum.exp1, exp1);
	}

	public void setExp1(Expression exp1) {
		notifyChanged(QueriesFeatureDescriptorEnum.exp1, this.exp1,
				this.exp1 = exp1);
	}

	private Expression exp2;

	public Expression getExp2() {
		return notifyRequested(QueriesFeatureDescriptorEnum.exp2, exp2);
	}

	public void setExp2(Expression exp2) {
		notifyChanged(QueriesFeatureDescriptorEnum.exp2, this.exp2,
				this.exp2 = exp2);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExp1().wGetAdaptee(false);
		case 1:
			return getExp2().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExp1(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
			break;
		case 1:
			setExp2(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
