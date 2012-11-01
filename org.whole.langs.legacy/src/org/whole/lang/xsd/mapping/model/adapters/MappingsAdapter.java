package org.whole.lang.xsd.mapping.model.adapters;

import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MappingsAdapter extends AbstractCollectionEntityAdapter<Mapping>
		implements Mappings {
	private static final long serialVersionUID = 1;

	public MappingsAdapter(IEntity implementor) {
		super(implementor);
	}

	public MappingsAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Mappings> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.Mappings;
	}
}
