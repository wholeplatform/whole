package org.whole.lang.types.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.types.model.*;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ArgumentsImpl extends AbstractListCompositeEntity<ArgumentType>
		implements Arguments {
	private static final long serialVersionUID = 1;

	public void accept(ITypesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TypesEntityDescriptorEnum.Arguments_ord;
	}

	public EntityDescriptor<Arguments> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.Arguments;
	}
}
