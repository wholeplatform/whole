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
public class IdentityComparatorAdapter extends AbstractEntityAdapter implements
		IdentityComparator {
	private static final long serialVersionUID = 1;

	public IdentityComparatorAdapter(IEntity implementor) {
		super(implementor);
	}

	public IdentityComparatorAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IdentityComparator> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.IdentityComparator;
	}

	public StepExpression getIdentity() {
		return wGet(QueriesFeatureDescriptorEnum.identity).wGetAdapter(
				QueriesEntityDescriptorEnum.StepExpression);
	}

	public void setIdentity(StepExpression identity) {
		wSet(QueriesFeatureDescriptorEnum.identity, identity);
	}
}
