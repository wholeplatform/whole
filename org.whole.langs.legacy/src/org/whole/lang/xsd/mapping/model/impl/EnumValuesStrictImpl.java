package org.whole.lang.xsd.mapping.model.impl;

import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class EnumValuesStrictImpl extends AbstractBagCompositeEntity<EnumValue>
		implements EnumValues {
	private static final long serialVersionUID = 1;

	public void accept(IMappingVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.EnumValues_ord;
	}

	public EntityDescriptor<EnumValues> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.EnumValues;
	}
}
