package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class GreaterOrEqualImpl extends AbstractListCompositeEntity<Expression>
		implements GreaterOrEqual {
	private static final long serialVersionUID = 1;

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.GreaterOrEqual_ord;
	}

	public EntityDescriptor<GreaterOrEqual> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.GreaterOrEqual;
	}
}
