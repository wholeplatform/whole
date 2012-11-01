package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.visitors.IXsdVisitor;

/** 
 * @generator Whole
 */
public class TargetNamespaceSpecImpl extends AbstractSimpleEntity implements
		TargetNamespaceSpec {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TargetNamespaceSpec> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.TargetNamespaceSpec;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.TargetNamespaceSpec_ord;
	}

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}
}
