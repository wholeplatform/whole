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
public class DeleteAdapter extends AbstractEntityAdapter implements Delete {
	private static final long serialVersionUID = 1;

	public DeleteAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeleteAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Delete> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.Delete;
	}

	public PathExpression getFromClause() {
		return wGet(QueriesFeatureDescriptorEnum.fromClause).wGetAdapter(
				QueriesEntityDescriptorEnum.PathExpression);
	}

	public void setFromClause(PathExpression fromClause) {
		wSet(QueriesFeatureDescriptorEnum.fromClause, fromClause);
	}
}
