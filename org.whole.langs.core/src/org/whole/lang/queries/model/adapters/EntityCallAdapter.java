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
public class EntityCallAdapter extends AbstractEntityAdapter implements
		EntityCall {
	private static final long serialVersionUID = 1;

	public EntityCallAdapter(IEntity implementor) {
		super(implementor);
	}

	public EntityCallAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EntityCall> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.EntityCall;
	}

	public EntityType getName() {
		return wGet(QueriesFeatureDescriptorEnum.name).wGetAdapter(
				QueriesEntityDescriptorEnum.EntityType);
	}

	public void setName(EntityType name) {
		wSet(QueriesFeatureDescriptorEnum.name, name);
	}

	public Bindings getBindings() {
		return wGet(QueriesFeatureDescriptorEnum.bindings).wGetAdapter(
				QueriesEntityDescriptorEnum.Bindings);
	}

	public void setBindings(Bindings bindings) {
		wSet(QueriesFeatureDescriptorEnum.bindings, bindings);
	}
}
