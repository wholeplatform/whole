package org.whole.lang.xsd.mapping.model.impl;

import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DataTypesStrictImpl extends AbstractBagCompositeEntity<DataType>
		implements DataTypes {
	private static final long serialVersionUID = 1;

	public void accept(IMappingVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.DataTypes_ord;
	}

	public EntityDescriptor<DataTypes> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.DataTypes;
	}
}
