package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.visitors.IXsdVisitor;

/** 
 * @generator Whole
 */
public class OtherNamespaceSpecsImpl extends AbstractSimpleEntity implements
		OtherNamespaceSpecs {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<OtherNamespaceSpecs> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.OtherNamespaceSpecs;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.OtherNamespaceSpecs_ord;
	}

	public void accept(IXsdVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
