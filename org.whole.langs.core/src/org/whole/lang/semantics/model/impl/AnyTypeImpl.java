package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;

/** 
 * @generator Whole
 */
public class AnyTypeImpl extends AbstractSimpleEntity implements AnyType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AnyType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.AnyType;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.AnyType_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}
}
