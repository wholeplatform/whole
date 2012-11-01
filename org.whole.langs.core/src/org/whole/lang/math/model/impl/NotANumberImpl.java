package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.visitors.IMathVisitor;

/** 
 * @generator Whole
 */
public class NotANumberImpl extends AbstractSimpleEntity implements NotANumber {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NotANumber> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.NotANumber;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.NotANumber_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}
}
