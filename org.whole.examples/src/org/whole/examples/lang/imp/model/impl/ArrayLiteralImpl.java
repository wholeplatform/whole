package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.examples.lang.imp.model.*;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ArrayLiteralImpl extends AbstractListCompositeEntity<Literal>
		implements ArrayLiteral {
	private static final long serialVersionUID = 1;

	public void accept(IImpVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.ArrayLiteral_ord;
	}

	public EntityDescriptor<ArrayLiteral> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ArrayLiteral;
	}
}
