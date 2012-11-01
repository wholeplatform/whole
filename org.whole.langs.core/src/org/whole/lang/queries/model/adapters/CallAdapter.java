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
public class CallAdapter extends AbstractEntityAdapter implements Call {
	private static final long serialVersionUID = 1;

	public CallAdapter(IEntity implementor) {
		super(implementor);
	}

	public CallAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Call> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.Call;
	}

	public Name getName() {
		return wGet(QueriesFeatureDescriptorEnum.name).wGetAdapter(
				QueriesEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(QueriesFeatureDescriptorEnum.name, name);
	}

	public Expressions getArguments() {
		return wGet(QueriesFeatureDescriptorEnum.arguments).wGetAdapter(
				QueriesEntityDescriptorEnum.Expressions);
	}

	public void setArguments(Expressions arguments) {
		wSet(QueriesFeatureDescriptorEnum.arguments, arguments);
	}
}
