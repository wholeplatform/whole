package org.whole.lang.xsd.mapping.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TypesStrictImpl extends AbstractSetCompositeEntity<URI> implements
		Types {
	private static final long serialVersionUID = 1;

	public void accept(IMappingVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.Types_ord;
	}

	public EntityDescriptor<Types> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.Types;
	}
}
