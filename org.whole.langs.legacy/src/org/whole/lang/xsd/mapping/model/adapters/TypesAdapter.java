package org.whole.lang.xsd.mapping.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TypesAdapter extends AbstractSetEntityAdapter<URI> implements
		Types {
	private static final long serialVersionUID = 1;

	public TypesAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypesAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Types> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.Types;
	}
}
