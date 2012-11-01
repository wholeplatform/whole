package org.whole.lang.xsd.mapping.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class MappingsImpl extends AbstractCollectionCompositeEntity<Mapping>
		implements Mappings {
	private static final long serialVersionUID = 1;

	public void accept(IMappingVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.Mappings_ord;
	}

	public EntityDescriptor<Mappings> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.Mappings;
	}
}
