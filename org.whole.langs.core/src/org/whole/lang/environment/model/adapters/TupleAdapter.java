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
public class TupleAdapter extends AbstractListEntityAdapter<Data> implements
		Tuple {
	private static final long serialVersionUID = 1;

	public TupleAdapter(IEntity implementor) {
		super(implementor);
	}

	public TupleAdapter() {
	}

	public void accept(IEnvironmentVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Tuple> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.Tuple;
	}
}
