package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class OperationsAdapter extends AbstractEntityAdapter implements
		Operations {
	private static final long serialVersionUID = 1;

	public OperationsAdapter(IEntity implementor) {
		super(implementor);
	}

	public OperationsAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Operations> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.Operations;
	}
}
