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
public class QueryDeclarationAdapter extends AbstractEntityAdapter implements
		QueryDeclaration {
	private static final long serialVersionUID = 1;

	public QueryDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public QueryDeclarationAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<QueryDeclaration> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.QueryDeclaration;
	}

	public Name getName() {
		return wGet(QueriesFeatureDescriptorEnum.name).wGetAdapter(
				QueriesEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(QueriesFeatureDescriptorEnum.name, name);
	}

	public Names getParameters() {
		return wGet(QueriesFeatureDescriptorEnum.parameters).wGetAdapter(
				QueriesEntityDescriptorEnum.Names);
	}

	public void setParameters(Names parameters) {
		wSet(QueriesFeatureDescriptorEnum.parameters, parameters);
	}

	public PathExpression getBody() {
		return wGet(QueriesFeatureDescriptorEnum.body).wGetAdapter(
				QueriesEntityDescriptorEnum.PathExpression);
	}

	public void setBody(PathExpression body) {
		wSet(QueriesFeatureDescriptorEnum.body, body);
	}
}
