package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class LowestCommonMultipleImpl extends
		AbstractListCompositeEntity<Expression> implements LowestCommonMultiple {
	private static final long serialVersionUID = 1;

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.LowestCommonMultiple_ord;
	}

	public EntityDescriptor<LowestCommonMultiple> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.LowestCommonMultiple;
	}
}
