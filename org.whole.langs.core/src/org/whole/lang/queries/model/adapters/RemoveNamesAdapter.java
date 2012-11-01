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
public class RemoveNamesAdapter extends AbstractEntityAdapter implements
		RemoveNames {
	private static final long serialVersionUID = 1;

	public RemoveNamesAdapter(IEntity implementor) {
		super(implementor);
	}

	public RemoveNamesAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<RemoveNames> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.RemoveNames;
	}

	public NamesExpression getExpression() {
		return wGet(QueriesFeatureDescriptorEnum.expression).wGetAdapter(
				QueriesEntityDescriptorEnum.NamesExpression);
	}

	public void setExpression(NamesExpression expression) {
		wSet(QueriesFeatureDescriptorEnum.expression, expression);
	}

	public Names getNames() {
		return wGet(QueriesFeatureDescriptorEnum.names).wGetAdapter(
				QueriesEntityDescriptorEnum.Names);
	}

	public void setNames(Names names) {
		wSet(QueriesFeatureDescriptorEnum.names, names);
	}
}
