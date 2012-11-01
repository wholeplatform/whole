package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArgumentsAdapter extends AbstractListEntityAdapter<ArgumentType>
		implements Arguments {
	private static final long serialVersionUID = 1;

	public ArgumentsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArgumentsAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Arguments> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.Arguments;
	}
}
