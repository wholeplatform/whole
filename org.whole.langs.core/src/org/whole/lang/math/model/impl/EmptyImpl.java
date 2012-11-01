package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.visitors.IMathVisitor;

/** 
 * @generator Whole
 */
public class EmptyImpl extends AbstractSimpleEntity implements Empty {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Empty> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Empty;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Empty_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}
}
