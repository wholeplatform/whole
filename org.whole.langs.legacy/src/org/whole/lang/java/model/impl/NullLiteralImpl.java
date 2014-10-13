package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;

/** 
 * @generator Whole
 */
public class NullLiteralImpl extends AbstractSimpleEntity implements
		NullLiteral {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NullLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.NullLiteral;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.NullLiteral_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}
}
