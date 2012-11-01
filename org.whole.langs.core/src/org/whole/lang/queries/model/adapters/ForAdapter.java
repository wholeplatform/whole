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
public class ForAdapter extends AbstractEntityAdapter implements For {
	private static final long serialVersionUID = 1;

	public ForAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<For> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.For;
	}

	public PathExpression getFromClause() {
		return wGet(QueriesFeatureDescriptorEnum.fromClause).wGetAdapter(
				QueriesEntityDescriptorEnum.PathExpression);
	}

	public void setFromClause(PathExpression fromClause) {
		wSet(QueriesFeatureDescriptorEnum.fromClause, fromClause);
	}

	public PathExpression getExpression() {
		return wGet(QueriesFeatureDescriptorEnum.expression).wGetAdapter(
				QueriesEntityDescriptorEnum.PathExpression);
	}

	public void setExpression(PathExpression expression) {
		wSet(QueriesFeatureDescriptorEnum.expression, expression);
	}
}
