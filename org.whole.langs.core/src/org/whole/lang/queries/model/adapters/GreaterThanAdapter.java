package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class GreaterThanAdapter extends AbstractEntityAdapter implements
		GreaterThan {
	private static final long serialVersionUID = 1;

	public GreaterThanAdapter(IEntity implementor) {
		super(implementor);
	}

	public GreaterThanAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<GreaterThan> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.GreaterThan;
	}

	public Expression getExp1() {
		return wGet(QueriesFeatureDescriptorEnum.exp1).wGetAdapter(
				QueriesEntityDescriptorEnum.Expression);
	}

	public void setExp1(Expression exp1) {
		wSet(QueriesFeatureDescriptorEnum.exp1, exp1);
	}

	public Expression getExp2() {
		return wGet(QueriesFeatureDescriptorEnum.exp2).wGetAdapter(
				QueriesEntityDescriptorEnum.Expression);
	}

	public void setExp2(Expression exp2) {
		wSet(QueriesFeatureDescriptorEnum.exp2, exp2);
	}
}
