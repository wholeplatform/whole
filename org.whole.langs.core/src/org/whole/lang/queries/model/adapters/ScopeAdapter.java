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
public class ScopeAdapter extends AbstractEntityAdapter implements Scope {
	private static final long serialVersionUID = 1;

	public ScopeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ScopeAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Scope> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.Scope;
	}

	public Names getLocalNames() {
		return wGet(QueriesFeatureDescriptorEnum.localNames).wGetAdapter(
				QueriesEntityDescriptorEnum.Names);
	}

	public void setLocalNames(Names localNames) {
		wSet(QueriesFeatureDescriptorEnum.localNames, localNames);
	}

	public PathExpression getExpression() {
		return wGet(QueriesFeatureDescriptorEnum.expression).wGetAdapter(
				QueriesEntityDescriptorEnum.PathExpression);
	}

	public void setExpression(PathExpression expression) {
		wSet(QueriesFeatureDescriptorEnum.expression, expression);
	}
}
