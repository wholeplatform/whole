package org.whole.lang.types.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.types.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.visitors.ITypesVisitor;

/** 
 * @generator Whole
 */
public class AnyTypeImpl extends AbstractSimpleEntity implements AnyType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AnyType> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.AnyType;
	}

	public int wGetEntityOrd() {
		return TypesEntityDescriptorEnum.AnyType_ord;
	}

	public void accept(ITypesVisitor visitor) {
		visitor.visit(this);
	}
}
