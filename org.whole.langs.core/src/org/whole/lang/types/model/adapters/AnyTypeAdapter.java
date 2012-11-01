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
public class AnyTypeAdapter extends AbstractEntityAdapter implements AnyType {
	private static final long serialVersionUID = 1;

	public AnyTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnyTypeAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AnyType> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.AnyType;
	}
}
