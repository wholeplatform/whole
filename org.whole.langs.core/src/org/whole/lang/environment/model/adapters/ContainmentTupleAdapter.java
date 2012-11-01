package org.whole.lang.environment.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ContainmentTupleAdapter extends AbstractListEntityAdapter<Data>
		implements ContainmentTuple {
	private static final long serialVersionUID = 1;

	public ContainmentTupleAdapter(IEntity implementor) {
		super(implementor);
	}

	public ContainmentTupleAdapter() {
	}

	public void accept(IEnvironmentVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ContainmentTuple> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.ContainmentTuple;
	}
}
