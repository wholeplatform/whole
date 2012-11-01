package org.whole.lang.xsd.mapping.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MappingAdapter extends AbstractEntityAdapter implements Mapping {
	private static final long serialVersionUID = 1;

	public MappingAdapter(IEntity implementor) {
		super(implementor);
	}

	public MappingAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Mapping> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.Mapping;
	}
}
