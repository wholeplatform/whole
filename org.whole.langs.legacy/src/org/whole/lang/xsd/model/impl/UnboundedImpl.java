package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.visitors.IXsdVisitor;

/** 
 * @generator Whole
 */
public class UnboundedImpl extends AbstractSimpleEntity implements Unbounded {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Unbounded> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Unbounded;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.Unbounded_ord;
	}

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}
}
