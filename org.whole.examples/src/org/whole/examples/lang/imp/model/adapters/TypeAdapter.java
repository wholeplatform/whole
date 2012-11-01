package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TypeAdapter extends AbstractEntityAdapter implements Type {
	private static final long serialVersionUID = 1;

	public TypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypeAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Type> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.Type;
	}
}
