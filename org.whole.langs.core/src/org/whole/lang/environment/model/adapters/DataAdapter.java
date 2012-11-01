package org.whole.lang.environment.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DataAdapter extends AbstractEntityAdapter implements Data {
	private static final long serialVersionUID = 1;

	public DataAdapter(IEntity implementor) {
		super(implementor);
	}

	public DataAdapter() {
	}

	public void accept(IEnvironmentVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Data> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.Data;
	}
}
