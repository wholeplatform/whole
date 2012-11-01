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
public class FilterAdapter extends AbstractEntityAdapter implements Filter {
	private static final long serialVersionUID = 1;

	public FilterAdapter(IEntity implementor) {
		super(implementor);
	}

	public FilterAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Filter> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.Filter;
	}

	public StepExpression getExpression() {
		return wGet(QueriesFeatureDescriptorEnum.expression).wGetAdapter(
				QueriesEntityDescriptorEnum.StepExpression);
	}

	public void setExpression(StepExpression expression) {
		wSet(QueriesFeatureDescriptorEnum.expression, expression);
	}

	public PruneOrPredicate getPredicate() {
		return wGet(QueriesFeatureDescriptorEnum.predicate).wGetAdapter(
				QueriesEntityDescriptorEnum.PruneOrPredicate);
	}

	public void setPredicate(PruneOrPredicate predicate) {
		wSet(QueriesFeatureDescriptorEnum.predicate, predicate);
	}
}
