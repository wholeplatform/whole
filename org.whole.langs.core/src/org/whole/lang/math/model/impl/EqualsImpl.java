package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class EqualsImpl extends AbstractListCompositeEntity<Expression>
		implements Equals {
	private static final long serialVersionUID = 1;

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Equals_ord;
	}

	public EntityDescriptor<Equals> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Equals;
	}
}
