package org.whole.lang.models.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.models.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.visitors.IModelsVisitor;

/** 
 * @generator Whole
 */
public class AnyTypeImpl extends AbstractSimpleEntity implements AnyType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AnyType> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.AnyType;
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.AnyType_ord;
	}

	public void accept(IModelsVisitor visitor) {
		visitor.visit(this);
	}
}
