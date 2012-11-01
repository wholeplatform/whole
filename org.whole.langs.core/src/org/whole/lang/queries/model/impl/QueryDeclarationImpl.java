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
public class QueryDeclarationImpl extends AbstractSimpleEntity implements
		QueryDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<QueryDeclaration> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.QueryDeclaration;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.QueryDeclaration_ord;
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

	private Names parameters;

	public Names getParameters() {
		return notifyRequested(QueriesFeatureDescriptorEnum.parameters,
				parameters);
	}

	public void setParameters(Names parameters) {
		notifyChanged(QueriesFeatureDescriptorEnum.parameters, this.parameters,
				this.parameters = parameters);
	}

	private PathExpression body;

	public PathExpression getBody() {
		return notifyRequested(QueriesFeatureDescriptorEnum.body, body);
	}

	public void setBody(PathExpression body) {
		notifyChanged(QueriesFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getParameters().wGetAdaptee(false);
		case 2:
			return getBody().wGetAdaptee(false);
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
			setParameters(value.wGetAdapter(QueriesEntityDescriptorEnum.Names));
			break;
		case 2:
			setBody(value
					.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
